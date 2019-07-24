package ast.statements;

import ast.Expression;
import ast.definitions.FuncDefinition;
import semantic.Visitor;

public class Return extends AbstractStatement{

	private FuncDefinition function;
	
	private Expression expression;
	
	public Return(int line, int column, Expression expression) {
		super(line,column);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	public FuncDefinition getFunction() {
		return function;
	}

	public void setFunction(FuncDefinition function) {
		this.function = function;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
