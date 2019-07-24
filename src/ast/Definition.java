package ast;

public interface Definition extends ASTNode{

	public String getName();
	public int getScope();
	public void setScope(int scope);
	public Type getType();
}
