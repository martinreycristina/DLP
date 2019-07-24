package ast.statements;

import java.util.List;

import ast.Expression;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.expressions.AbstractExpression;
import ast.expressions.Variable;
import semantic.Visitor;

public class Function extends AbstractExpression implements Statement {

	private Variable var;
	private List<Expression> params;
	private FuncDefinition definition;
	
	public Function(int line, int column,Variable var, List<Expression> params) {
		super(line,column);
		this.var = var;
		this.params = params;
	}

	public Variable getVar() {
		return var;
	}

	public FuncDefinition getDefinition() {
		return definition;
	}

	public void setDefinition(FuncDefinition definition) {
		this.definition = definition;
	}

	public List<Expression> getParams() {
		return params;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
