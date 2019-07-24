package ast.expressions;

import ast.definitions.VariableDefinition;
import semantic.Visitor;

public class Variable extends AbstractExpression {

	private String name;
	private VariableDefinition definition;
	
	public Variable(int line, int column,String name) {
		super(line,column);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public VariableDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(VariableDefinition definition) {
		this.definition = definition;
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
		Variable other = (Variable) obj;
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
