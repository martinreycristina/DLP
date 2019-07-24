package ast;

import semantic.Visitor;

public interface ASTNode {

	public int getLine();
	public int getColumn();
	
	public void accept(Visitor v, Object params);
}
