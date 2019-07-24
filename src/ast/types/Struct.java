package ast.types;

import java.util.List;

import ast.Type;
import ast.definitions.FieldDefinition;
import semantic.Visitor;

public class Struct extends AbstractType {

	private List<FieldDefinition> defs;

	public Struct(int line, int column,List<FieldDefinition> defs) {
		super(line,column);
		this.defs = defs;
	}

	public List<FieldDefinition> getDefs() {
		return defs;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public int size() {
		int size = 0;
		for(FieldDefinition fd : defs) {
			size += fd.getType().size();
		}
		return size;
	}
	
	@Override
	public Type dot(String field) {
		for(int i = 0; i < defs.size(); i++) {
			if(defs.get(i).getName().equals(field))
				return defs.get(i).getType();
		}
		return null;
	}
}
