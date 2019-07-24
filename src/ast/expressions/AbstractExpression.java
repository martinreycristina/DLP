package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

	private boolean lValue;
	private Type type;
	
	protected AbstractExpression(int line, int column) {
		super(line, column);
	}

	public boolean getLValue() {
		return lValue;
	}

	public void setLValue(boolean lValue) {
		this.lValue = lValue;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
