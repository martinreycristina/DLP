package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class UnaryMinus extends AbstractExpression {

	private Expression expression;
	
	public UnaryMinus(int line, int column,Expression expression) {
		super(line,column);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
