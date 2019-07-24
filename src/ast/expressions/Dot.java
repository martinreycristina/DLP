package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class Dot extends AbstractExpression {

	private Expression expression;
	private String field;

	public Dot(int line, int column,Expression expression, String field) {
		super(line,column);
		this.expression = expression;
		this.field = field;
	}

	public Expression getExpression() {
		return expression;
	}

	public String getField() {
		return field;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
