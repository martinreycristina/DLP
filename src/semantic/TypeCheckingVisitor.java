package semantic;

import java.util.ArrayList;
import java.util.List;

import ast.Expression;
import ast.Statement;
import ast.Type;
import ast.definitions.FuncDefinition;
import ast.definitions.VariableDefinition;
import ast.errors.ErrorType;
import ast.expressions.ArrayAccess;
import ast.expressions.ArtihmeticExpression;
import ast.expressions.Brackets;
import ast.expressions.Cast;
import ast.expressions.CharLiteral;
import ast.expressions.ComparisonExpression;
import ast.expressions.Dot;
import ast.expressions.IntLiteral;
import ast.expressions.LogicalExpression;
import ast.expressions.RealLiteral;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNegation;
import ast.expressions.Variable;
import ast.statements.Assignment;
import ast.statements.Conditional;
import ast.statements.Function;
import ast.statements.Input;
import ast.statements.Print;
import ast.statements.Return;
import ast.statements.WhileLoop;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;

public class TypeCheckingVisitor extends AbstractVisitor {

	@Override
	public Object visit(FuncDefinition def, Object params) {
		def.getType().accept(this, params);
		
		for(VariableDefinition varDef : def.getVariableDefinitions()) {
			varDef.accept(this, params);
		}
		
		List<Type> returnType = new ArrayList<Type>();
		
		for(Statement stmnt : def.getStatements()) {
			stmnt.accept(this, params);
			if(stmnt instanceof Return) {
				((Return) stmnt).setFunction(def);
				returnType.add(((Return) stmnt).getExpression().getType());
			}
		}
		
		if(def.getType().checkReturn(returnType) == null)
			new ErrorType(def.getLine(),def.getColumn(),
					"Existe algún problema con la sentencia de retorno de la función "
					+ def.getName());
		
		
		return null;
	}
	
	@Override
	public Object visit(Function expr, Object params) {
		List<Type> paramTypes = new ArrayList<Type>();
		
		for(Expression e : expr.getParams()) {
			e.accept(this, params);
			paramTypes.add(e.getType());
		}
		
		expr.setType(expr.getDefinition().getType().parenthesis(paramTypes));
		if(expr.getType() == null) {
			String errMsg = "No se puede realizar una invocación a "
					+ expr.getVar().getName() + " con parámetros: \n";
			
			for(Type t : paramTypes) 
				errMsg += "\t" + t + "\n";
			
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),errMsg));
		}
		 
		return null;
	}

	@Override
	public Object visit(Assignment stmnt, Object params) {
		stmnt.getLeft().accept(this, params);
		stmnt.getRight().accept(this, params);

		if(stmnt.getLeft().getType().promotesTo(stmnt.getRight().getType()) == null)
			new ErrorType(stmnt.getLine(),stmnt.getColumn(),
				"No se puede realizar una asignación de "
					+ stmnt.getRight().getType() + " a " + stmnt.getLeft().getType());
		
		return null;
	}
	
	@Override
	public Object visit(Input stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		if(!stmnt.getExpression().getType().isBuiltInType()){
			stmnt.getExpression().setType(new ErrorType(stmnt.getLine(),stmnt.getColumn(),
					"La expresión de la sentencia input no es de tipo simple"));
		}
		
		return null;
	}

	@Override
	public Object visit(Print stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		if(!stmnt.getExpression().getType().isBuiltInType()){
			stmnt.getExpression().setType(new ErrorType(stmnt.getLine(),stmnt.getColumn(),
					"La expresión de la sentencia print no es de tipo simple"));
		}
		
		return null;
	}

	@Override
	public Object visit(Conditional stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		if(!stmnt.getExpression().getType().isLogical()){
			stmnt.getExpression().setType(new ErrorType(stmnt.getLine(),stmnt.getColumn(),
					"La expresión de la condición if no es una expresión lógica.")); 
		}
		
		for(Statement s : stmnt.getIf_body()) {
			s.accept(this, params);
		}
		
		for(Statement s : stmnt.getElse_body()) {
			s.accept(this, params);
		}
		
		return null;
	}

	@Override
	public Object visit(WhileLoop w, Object params) {
		w.getExpression().accept(this, params);
		
		if(!w.getExpression().getType().isLogical()){
			w.getExpression().setType(new ErrorType(w.getLine(),w.getColumn(),
					"La expresión del bucle while no es una expresión lógica.")); //En la condición
		}
		
		for(Statement s : w.getBody()) {
			s.accept(this, params);
		}
		
		return null;
	}
	
	@Override
	public Object visit(Return r, Object params) {
		r.getExpression().accept(this, params);
		
		if(!r.getExpression().getType().isBuiltInType()){
			r.getExpression().setType(new ErrorType(r.getLine(),r.getColumn(),
					"La expresión de la sentencia de retorno no devuelve un tipo simple"));
		}
		
		return null;
	}

	@Override
	public Object visit(IntLiteral expr, Object params) {
		expr.setType(IntType.getInstance());
		return null;
	}

	@Override
	public Object visit(CharLiteral expr, Object params) {
		expr.setType(CharType.getInstance());
		return null;
	}

	@Override
	public Object visit(RealLiteral expr, Object params) {
		expr.setType(DoubleType.getInstance());
		return null;
	}

	@Override
	public Object visit(Variable v, Object params) {
		v.setType(v.getDefinition().getType());
		return null;
	}

	@Override
	public Object visit(Brackets expr, Object params) {
		expr.getExpression().accept(this, params);
		expr.setType(expr.getExpression().getType());
		return null;
	}

	@Override
	public Object visit(ArrayAccess expr, Object params) {
		expr.getOut().accept(this, params);
		expr.getInside().accept(this, params);
				
		expr.setType(expr.getOut().getType().squareBrackets(expr.getInside().getType()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar un acceso al tipo "
					+ expr.getOut().getType() + " con índice de tipo " + expr.getInside().getType()));
		
		return null;
	}

	@Override
	public Object visit(Dot expr, Object params) {
		expr.getExpression().accept(this, params);
		
		expr.setType(expr.getExpression().getType().dot(expr.getField()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar un acceso al campo " + expr.getField() + " en el tipo " +
						expr.getExpression().getType()));
		
		return null;
	}

	@Override
	public Object visit(Cast expr, Object params) {
		expr.getExpression().accept(this, params);
		expr.getCast().accept(this, params);
		
		expr.setType(expr.getExpression().getType().cast(expr.getCast()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar un cast de " +
						expr.getExpression().getType() + " a " +
						expr.getCast()));
		
		return null;
	}

	@Override
	public Object visit(UnaryMinus expr, Object params) {
		expr.getExpression().accept(this, params);
		
		expr.setType(expr.getExpression().getType().arithmetic());
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar la operación aritmética unaria de " +
						expr.getExpression().getType()));
		
		return null;
	}

	@Override
	public Object visit(UnaryNegation expr, Object params) {
		expr.getExpression().accept(this, params);
		
		expr.setType(expr.getExpression().getType().logical());
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar la operación lógica unaria de " +
						expr.getExpression().getType()));
		
		return null;
	}

	@Override
	public Object visit(ArtihmeticExpression expr, Object params) {
		expr.getLeft().accept(this, params);
		expr.getRight().accept(this, params);
		
		expr.setType(expr.getLeft().getType().arithmetic(expr.getRight().getType()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar la operación aritmética entre " +
						expr.getLeft().getType() + " y " + expr.getRight().getType()));
		
		return null;
	}

	@Override
	public Object visit(ComparisonExpression expr, Object params) {
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		expr.setType(expr.getLeft().getType().comparison(expr.getRight().getType()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar la operación de comparación entre " +
						expr.getLeft().getType() + " y " + expr.getRight().getType()));
		
		return null;
	}

	@Override
	public Object visit(LogicalExpression expr, Object params) {
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		expr.setType(expr.getLeft().getType().logical(expr.getRight().getType()));
		if(expr.getType() == null)
			expr.setType(new ErrorType(expr.getLine(),expr.getColumn(),
				"No se puede realizar la operación lógica entre " +
						expr.getLeft().getType() + " y " + expr.getRight().getType()));
		
		return null;
	}
}
