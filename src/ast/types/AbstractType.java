package ast.types;

import java.util.List;

import ast.AbstractASTNode;
import ast.Type;
import ast.errors.ErrorType;

public abstract class AbstractType extends AbstractASTNode implements Type {

	protected AbstractType(int line, int column) {
		super(line, column);
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isLogical() {
		return false;
	}
	
	@Override
	public Type logical(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public Type logical() {
		return null;
	}
	
	@Override
	public Type arithmetic(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public Type arithmetic() {
		return null;
	}
	
	@Override
	public Type comparison(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public boolean isBuiltInType() {
		return false;
	}
	
	@Override
	public Type cast(Type cast) {
		if(cast instanceof ErrorType)
			return cast;
		return null;
	}
	
	@Override
	public Type dot(String field) {
		return null;
	}
	
	@Override
	public Type squareBrackets(Type type) {
		return null;
	}
	
	@Override
	public Type promotesTo(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public Type parenthesis(List<Type> paramTypes) {
		return null;
	}
	
	@Override
	public Type checkReturn(List<Type> returnType) {
		if(returnType.get(0) instanceof ErrorType)
			return returnType.get(0);
		return null;
	}
	
	@Override
	public char suffix() {
		return '\0';
	}
}
