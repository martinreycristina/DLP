package ast.statements;

import java.util.List;

import ast.Expression;
import ast.Statement;
import semantic.Visitor;

public class Conditional extends AbstractStatement {

	private Expression expression;
	private List<Statement> if_body;
	private List<Statement> else_body;
	
	public Conditional(int line, int column, Expression expression, List<Statement> if_body,
			List<Statement> else_body) {
		super(line,column);
		this.expression = expression;
		this.if_body = if_body;
		this.else_body = else_body;
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Statement> getIf_body() {
		return if_body;
	}

	public List<Statement> getElse_body() {
		return else_body;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
