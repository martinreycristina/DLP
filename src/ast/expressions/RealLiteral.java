package ast.expressions;

import semantic.Visitor;

public class RealLiteral  extends AbstractExpression{

	public double value;

	public RealLiteral(int line, int column,double value) {
		super(line,column);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
