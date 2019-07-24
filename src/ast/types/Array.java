package ast.types;

import ast.Type;
import semantic.Visitor;

public class Array extends AbstractType {

	private int size;
	private Type type;
	
	public Array(int line, int column,int size, Type type) {
		super(line, column);
		this.size = size;
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public int size() {
		return this.type.size() * this.size;
	}
	
	@Override
	public Type squareBrackets(Type type) {
		if(type.equals(IntType.getInstance()))
			return this.getType();
		return null;
	}
}
