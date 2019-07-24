package ast.definitions;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

public class FieldDefinition extends AbstractASTNode {
	
	private String name;
	private Type type;
	
	private int offset;

	public FieldDefinition(int line, int column,String name, Type type) {
		super(line,column);
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldDefinition other = (FieldDefinition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
