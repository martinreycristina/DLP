package semantic;

import ast.*;
import ast.expressions.*;
import ast.statements.*;
import ast.errors.*;

public class LValueVisitor extends AbstractVisitor {

	@Override
	public Object visit(Function stmnt, Object params) {
		stmnt.setLValue(false);
		
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
		
		if(!stmnt.getLeft().getLValue())
			new ErrorType(stmnt.getLeft().getLine(),stmnt.getLeft().getColumn(), 
				"No se puede asignar al objeto de la izquierda.");
		
		return null;
	}

	@Override
	public Object visit(Input stmnt, Object params) {
		stmnt.getExpression().accept(this, params);
		
		if(!stmnt.getExpression().getLValue())
			new ErrorType(stmnt.getExpression().getLine(),
					stmnt.getExpression().getColumn(),
					"No se puede hacer input de esa expresión.");
		
		return null;
	}

	@Override
	public Object visit(IntLiteral expr, Object params) {
		expr.setLValue(false);
		return null;
	}

	@Override
	public Object visit(CharLiteral expr, Object params) {
		expr.setLValue(false);
		return null;
	}

	@Override
	public Object visit(RealLiteral expr, Object params) {
		expr.setLValue(false);
		return null;
	}

	@Override
	public Object visit(Variable expr, Object params) {
		expr.setLValue(true); //No se puede continuar el recorrido porque no tiene hijos
		return null;
	}

	@Override
	public Object visit(Brackets expr, Object params) {
		expr.getExpression().accept(this, params);
		
		expr.setLValue(expr.getExpression().getLValue());
		
		return null;
	}

	@Override
	public Object visit(ArrayAccess expr, Object params) {
		expr.setLValue(true);
		
		expr.getOut().accept(this, params);
		expr.getInside().accept(this, params);
				
		return null;
	}

	@Override
	public Object visit(Dot expr, Object params) {
		expr.setLValue(true);
		
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(Cast expr, Object params) {
		expr.setLValue(false);
		
		expr.getExpression().accept(this, params);
		expr.getCast().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(UnaryMinus expr, Object params) {
		expr.setLValue(false);
		
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(UnaryNegation expr, Object params) {
		expr.setLValue(false);
		
		expr.getExpression().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(ArtihmeticExpression expr, Object params) {
		expr.setLValue(false);
		
		expr.getLeft().accept(this, params);  //Siempre propagar llamadas
		expr.getRight().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(ComparisonExpression expr, Object params) {
		expr.setLValue(false);
		
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		return null;
	}

	@Override
	public Object visit(LogicalExpression expr, Object params) {
		expr.setLValue(false);
		
		expr.getLeft().accept(this, params);  
		expr.getRight().accept(this, params);
		
		return null;
	}

}
