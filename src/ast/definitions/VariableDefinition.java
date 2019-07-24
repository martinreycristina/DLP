package ast.definitions;

import ast.Type;
import semantic.Visitor;

public class VariableDefinition extends AbstractDefinition{
	
	private int offset;
	
	public VariableDefinition(int line, int column, String name, Type type) {
		super(line, column, name, type);
	}
	
	public void setType(Type type) { 
		this.type = type;
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
