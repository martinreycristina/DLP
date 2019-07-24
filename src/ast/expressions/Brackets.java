package ast.expressions;

import ast.Expression;
import semantic.Visitor;

public class Brackets extends AbstractExpression {

	private Expression expression;
	
	public Brackets(int line, int column,Expression expression) {
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
