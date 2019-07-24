package ast;

import java.util.List;

import semantic.Visitor;

public class Program extends AbstractASTNode{
	
	private List<Definition> definitions;

	public Program(int line, int column,List<Definition> defs) {
		super(line, column);
		this.definitions = defs;
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
