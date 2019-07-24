package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class ArrayAccess extends AbstractExpression {
	
	private Expression out;
	private Expression inside;

	public ArrayAccess(int line, int column, Expression out, Expression inside) {
		super(line,column);
		this.out = out;
		this.inside = inside;
	}

	public Expression getOut() {
		return out;
	}

	public Expression getInside() {
		return inside;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
