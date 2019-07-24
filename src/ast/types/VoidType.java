package ast.types;

import semantic.Visitor;

public class VoidType extends AbstractType {
	private static final VoidType INSTANCE = new VoidType(-1,-1);

	private VoidType(int line, int column) {
		super(line, column);
	}
	
	public static VoidType getInstance() {
		return INSTANCE;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
