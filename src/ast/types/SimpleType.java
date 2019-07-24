package ast.types;

import ast.Type;

public abstract class SimpleType extends AbstractType {

	protected SimpleType(int line, int column) {
		super(line, column);
	}

	@Override
	public Type comparison(Type type) {
		if(type.isBuiltInType())
			return IntType.getInstance();
		return super.comparison(type);
	}
	
	@Override
	public boolean isBuiltInType() {
		return true;
	}
	
	@Override
	public Type cast(Type cast) {
		if(cast.isBuiltInType())
			return cast;
		return super.cast(cast);
	}
}
