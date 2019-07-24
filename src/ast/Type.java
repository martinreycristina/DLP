package ast;

import java.util.List;

public interface Type extends ASTNode{

	public int size();
	
	public boolean isLogical();
	
	public Type logical(Type type);
	
	public Type logical();

	public Type arithmetic(Type type);
	
	public Type arithmetic();

	public Type comparison(Type type);

	public boolean isBuiltInType();
	
	public Type cast(Type cast);

	public Type dot(String field);

	public Type squareBrackets(Type type);

	public Type promotesTo(Type type);

	public Type parenthesis(List<Type> paramsType);

	public Type checkReturn(List<Type> returnType);

	public char suffix();
}
