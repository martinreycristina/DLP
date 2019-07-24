package semantic;

import ast.Expression;
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
import ast.statements.Function;
import ast.types.IntType;

public class ValueCGVisitor extends AbstractCGVisitor {
	
	private AddressCGVisitor acg;
	
	public ValueCGVisitor(CodeGenerator codeGenerator) {
		super(codeGenerator);
	}

	public void setAcg(AddressCGVisitor acg) {
		this.acg = acg;
	}

	@Override
	public Object visit(IntLiteral expr, Object params) {
		cg.push(expr.getValue());
		return null;
	}
	
	@Override
	public Object visit(CharLiteral expr, Object params) {
		cg.pushb(expr.getValue());
		return null;
	}
	
	@Override
	public Object visit(RealLiteral expr, Object params) {
		cg.pushf(expr.getValue());
		return null;
	}
	
	@Override
	public Object visit(Variable expr, Object params) {
		expr.accept(acg, null);
		cg.load(expr.getType());
		return null;
	}
	
	@Override
	public Object visit(Brackets expr, Object params) {
		expr.getExpression().accept(this, null);
		return null;
	}
	
	@Override
	public Object visit(ArrayAccess expr, Object params) {
		expr.accept(acg, null);
		cg.load(expr.getType());
		return null;
	}
	
	@Override
	public Object visit(Dot expr, Object params) {
		expr.accept(acg, null);
		cg.load(expr.getType());
		return null;
	}
	
	@Override
	public Object visit(Cast expr, Object params) {
		expr.getExpression().accept(this, null);
		cg.convertTo(expr.getExpression().getType(), expr.getCast());
		return null;
	}
	
	@Override
	public Object visit(UnaryMinus expr, Object params) {
		expr.getExpression().accept(this, null);
		cg.push(-1);
		cg.mul(IntType.getInstance());
		return null;
	}
	
	@Override
	public Object visit(UnaryNegation expr, Object params) {
		expr.getExpression().accept(this, null);
		cg.not();
		return null;
	}
	
	@Override
	public Object visit(ArtihmeticExpression expr, Object params) {
		expr.getLeft().accept(this, null);
		cg.convertTo(expr.getLeft().getType(), expr.getType());
		expr.getRight().accept(this, null);
		cg.convertTo(expr.getRight().getType(), expr.getType());
		cg.arithmetic(expr.getOperator(), expr.getType());
		return null;
	}
	
	@Override
	public Object visit(ComparisonExpression expr, Object params) {
		expr.getLeft().accept(this, null);
		cg.convertTo(expr.getLeft().getType(), expr.getType());
		expr.getRight().accept(this, null);
		cg.convertTo(expr.getRight().getType(), expr.getType());
		cg.comparison(expr.getOperator(), expr.getType());
		return null;
	}
	
	@Override
	public Object visit(LogicalExpression expr, Object params) {
		expr.getLeft().accept(this, null);
		cg.convertTo(expr.getLeft().getType(), expr.getType());
		expr.getRight().accept(this, null);
		cg.convertTo(expr.getLeft().getType(), expr.getType());
		cg.logical(expr.getOperator());
		return null;
	}
	
	/*
	 * VALUE[[INVOCATION:Exp1 -> Var Exp2*]]:
		FOR (Exp e : Exp2*):
			VALUE[[e]]
		CALL Var.name
	 */
	@Override
	public Object visit(Function stmnt, Object params) {
		for(Expression expression : stmnt.getParams()) {
			expression.accept(this, null);
		}
		cg.call(stmnt.getVar().getName());
		return null;
	}
}
