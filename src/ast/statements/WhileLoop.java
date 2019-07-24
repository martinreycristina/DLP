package ast.statements;

import java.util.List;

import ast.Expression;
import ast.Statement;
import semantic.Visitor;

public class WhileLoop extends AbstractStatement {

	private Expression expression;
	private List<Statement> body;
	
	public WhileLoop(int line, int column, Expression expression, List<Statement> body) {
		super(line,column);
		this.expression = expression;
		this.body = body;
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Statement> getBody() {
		return body;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
}
