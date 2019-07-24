package ast.errors;

import java.util.List;

import ast.Type;
import ast.types.AbstractType;
import semantic.Visitor;

public class ErrorType extends AbstractType {
	
	private String message;
	
	public ErrorType(int line, int column, String message) {
		super(line, column);
		this.message = message;
		
		ErrorHandler.getInstance().addError(this);
	}

	@Override
	public String toString() {
		return "Error in line "+getLine()+" at column "+getColumn()+":"+message;
	}

	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public boolean isLogical() {
		return true;
	}
	
	@Override
	public Type logical(Type type) {
		return this;
	}
	
	@Override
	public Type logical() {
		return this;
	}
	
	@Override
	public Type arithmetic(Type type) {
		return this;
	}
	
	@Override
	public Type arithmetic() {
		return this;
	}
	
	@Override
	public Type comparison(Type type) {
		return this;
	}
	
	@Override
	public boolean isBuiltInType() {
		return true;
	}
	
	@Override
	public Type cast(Type cast) {
		return this;
	}
	
	@Override
	public Type dot(String field) {
		return this;
	}
	
	@Override
	public Type squareBrackets(Type type) {
		return this;
	}
	
	@Override
	public Type promotesTo(Type type) {
		return this;
	}
	
	@Override
	public Type parenthesis(List<Type> paramTypes) {
		return this;
	}
	
	@Override
	public Type checkReturn(List<Type> returnType) {
		return this;
	}
}
