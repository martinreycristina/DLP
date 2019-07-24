package ast.expressions;

import semantic.Visitor;

public class IntLiteral extends AbstractExpression{
	
	public int value;
	
	public IntLiteral(int line, int column,int value) {
		super(line,column);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
