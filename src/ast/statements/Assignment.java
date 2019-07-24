package ast.statements;

import ast.Expression;
import semantic.Visitor;

public class Assignment extends AbstractStatement {

	private Expression left;
	private Expression right;

	public Assignment(int line, int column, Expression left, Expression right) {
		super(line,column);
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
