package ast.types;

import ast.Type;
import semantic.Visitor;

public class DoubleType extends SimpleType {
	private static final DoubleType INSTANCE = new DoubleType(0,0);

	private DoubleType(int line, int column) {
		super(line, column);
	}
	
	public static DoubleType getInstance() {
		return INSTANCE;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public int size() {
		return 4;
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
		return 'f';
	}
}
