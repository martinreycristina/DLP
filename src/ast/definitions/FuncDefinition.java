package ast.definitions;

import java.util.List;

import ast.Statement;
import ast.Type;
import semantic.Visitor;

public class FuncDefinition extends AbstractDefinition{

	private List<VariableDefinition> variableDefinitions;
	private List<Statement> statements;
	
	private int bytesLocals;

	public FuncDefinition(int line, int column,String name, Type type,
			List<VariableDefinition> vardefs,List<Statement> statements) {
		super(line,column,name,type);
		this.variableDefinitions=vardefs;
		this.statements = statements;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public List<VariableDefinition> getVariableDefinitions() {
		return variableDefinitions;
	}

	public int getBytesLocals() {
		return bytesLocals;
	}

	public void setBytesLocals(int bytesLocals) {
		this.bytesLocals = bytesLocals;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
