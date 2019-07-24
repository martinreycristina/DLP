package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

	private String name;
	private int scope;
	protected Type type;
	
	protected AbstractDefinition(int line, int column,String name, Type type) {
		super(line,column);
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getScope() {
		return scope;
	}

	@Override
	public void setScope(int scope) {
		this.scope = scope;
	}

	@Override
	public Type getType() {
		return type;
	}

}
