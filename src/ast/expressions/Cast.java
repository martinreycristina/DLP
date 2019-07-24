package ast.expressions;

import ast.Expression;
import ast.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

	private Expression expression;
	private Type cast;
	
	public Cast(int line, int column,Expression expression, Type cast) {
		super(line,column);
		this.expression = expression;
		this.cast = cast;
	}

	public Type getCast() {
		return cast;
	}

	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
