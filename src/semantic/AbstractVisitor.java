package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import ast.errors.*;

public abstract class AbstractVisitor implements Visitor {

	@Override
	public Object visit(Program program, Object params) {
		for(Definition definition : program.getDefinitions()) {
			definition.accept(this, params);
		}
		return null;
	}

	@Override
	public Object visit(FieldDefinition def, Object params) {
		def.getType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(VariableDefinition def, Object params) {
		def.getType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(FuncDefinition def, Object params) {
		def.getType().accept(this, params);
		for(VariableDefinition varDef : def.getVariableDefinitions()) {
			varDef.accept(this, params);
		}
		for(Statement stmnt : def.getStatements()) {
			stmnt.accept(this, params);
		}
		return null;
	}

	@Override
	public Object visit(IntType type, Object params) {
		return null;
	}

	@Override
	public Object visit(CharType type, Object params) {
		return null;
	}

	@Override
	public Object visit(DoubleType type, Object params) {
		return null;
	}

	@Override
	public Object visit(VoidType type, Object params) {
		return null;
	}

	@Override
	public Object visit(FunctionType type, Object params) {
		for(VariableDefinition varDef : type.getParameters()) {
			varDef.accept(this, params);
		}
		type.getReturnType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Array type, Object params) {
		type.getType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Struct type, Object params) {
		for(FieldDefinition fieldDef : type.getDefs()) {
			fieldDef.accept(this, params);
		}
		return null;
	}

	@Override
	public Object visit(ErrorType type, Object params) {
		return null;
	}

	@Override
	public Object visit(Function stmnt, Object params) {
		stmnt.getVar().accept(this, params);
		
		for(Expression expr : stmnt.getParams()) {
			expr.accept(this, params);
		}
		
		return null;
	}

	@Override
	public Object visit(Assignment stmnt, Object params) {
		stmnt.getLeft().accept(this, params);
		stmnt.getRight().accept(this, params);

		return null;
	}

	@Override
	public Object visit(Input stmnt, Object params) {
		stmnt.getExpression().accept(this, params);

		return null;
	}

	@Override
	public Object visit(Print stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(Conditional stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		for(Statement s : stmnt.getIf_body()) {
			s.accept(this, params);
		}
		
		for(Statement s : stmnt.getElse_body()) {
			s.accept(this, params);
		}
		
		return null;
	}

	@Override
	public Object visit(WhileLoop stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		for(Statement s : stmnt.getBody()) {
			s.accept(this, params);
		}
		
		return null;
	}

	@Override
	public Object visit(Return stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(IntLiteral expr, Object params) {
		return null;
	}

	@Override
	public Object visit(CharLiteral expr, Object params) {
		return null;
	}

	@Override
	public Object visit(RealLiteral expr, Object params) {
		return null;
	}

	@Override
	public Object visit(Variable expr, Object params) {
		return null;
	}

	@Override
	public Object visit(Brackets expr, Object params) {
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(ArrayAccess expr, Object params) {
		expr.getOut().accept(this, params);
		expr.getInside().accept(this, params);
				
		return null;
	}

	@Override
	public Object visit(Dot expr, Object params) {
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(Cast expr, Object params) {
		expr.getExpression().accept(this, params);
		expr.getCast().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(UnaryMinus expr, Object params) {
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(UnaryNegation expr, Object params) {
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(ArtihmeticExpression expr, Object params) {
		expr.getLeft().accept(this, params);
		expr.getRight().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(ComparisonExpression expr, Object params) {
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(LogicalExpression expr, Object params) {
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		return null;
	}

}
