package ast.expressions;

import semantic.Visitor;

public class CharLiteral extends AbstractExpression {

	public char value;
	
	public CharLiteral(int line, int column,char value) {
		super(line,column);
		this.value = value;
	}

	public char getValue() {
		return value;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
