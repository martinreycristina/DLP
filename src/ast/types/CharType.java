package ast.types;

import ast.Type;
import semantic.Visitor;

public class CharType extends SimpleType{
	
	private static final CharType INSTANCE = new CharType(0,0);

	private CharType(int line, int column) {
		super(line, column);
	}
	
	public static CharType getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public int size() {
		return 1;
	}
	
	@Override
	public Type arithmetic(Type type) {
		if(type.equals(this)) 
			return IntType.getInstance();
		return super.arithmetic(type);
	}
	
	@Override
	public Type arithmetic() {
		return IntType.getInstance();
	}
	
	@Override
	public Type promotesTo(Type type) {
		if(type.equals(this)) 
			return this;
		return super.promotesTo(type);
	}

	@Override
	public char suffix() {
		return 'b';
	}
}
