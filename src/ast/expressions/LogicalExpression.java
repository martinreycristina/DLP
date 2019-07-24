package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class LogicalExpression extends AbstractExpression{
	
	private Expression left;
	private Expression right;
	private String operator;
	
	public LogicalExpression(int line, int column,Expression left, Expression right, String operator) {
		super(line,column);
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public String getOperator() {
		return operator;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
