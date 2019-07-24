package ast.types;

import ast.Type;
import semantic.Visitor;

public class IntType extends SimpleType{
	private static final IntType INSTANCE = new IntType(0,0);

	private IntType(int line, int column) {
		super(line, column);
	}
	
	public static IntType getInstance() {
		return INSTANCE;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public int size() {
		return 2;
	}

	@Override
	public boolean isLogical() {
		return true;
	}
	
	@Override
	public Type logical(Type type) {
		if(type.equals(this)) 
			return this;
		return super.logical(type);
	}
	
	@Override
	public Type logical() {
		return this;
	}

	@Override
	public Type arithmetic(Type type) {
		if(type.equals(this)) 
			return this;
		return super.arithmetic(type);
	}
	
	@Override
	public Type arithmetic() {
		return this;
	}
	
	@Override
	public Type promotesTo(Type type) {
		if(type.equals(this)) 
			return this;
		return super.promotesTo(type);
	}
	
	@Override
	public char suffix() {
		return 'i';
	}
}
