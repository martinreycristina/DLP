package ast.statements;

import ast.AbstractASTNode;
import ast.Statement;

public abstract class AbstractStatement extends AbstractASTNode implements Statement{

	protected AbstractStatement(int line, int column) {
		super(line, column);
	}

}
