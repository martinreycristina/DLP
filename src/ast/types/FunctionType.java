package ast.types;

import java.util.List;

import ast.Type;
import ast.types.VoidType;
import ast.definitions.VariableDefinition;
import semantic.Visitor;

public class FunctionType extends AbstractType{

	private List<VariableDefinition> parameters;
	private Type returnType;
	
	public FunctionType(int line, int column,List<VariableDefinition> parameters, Type returnType) {
		super(line,column);
		this.parameters = parameters;
		this.returnType = returnType;
	}
	
	public List<VariableDefinition> getParameters() {
		return parameters;
	}

	public Type getReturnType() {
		return returnType;
	}
	
	@Override
	public void accept(Visitor v, Object params) {
		v.visit(this, params);
	}
	
	@Override
	public Type parenthesis(List<Type> paramTypes) {
		if(paramTypes.size() != this.parameters.size())
			return null;
		
		for(int i = 0; i < paramTypes.size(); i++) {
			if(paramTypes.get(i).promotesTo(this.parameters.get(i).getType()) == null)
				return null;
		}
		
		return this.returnType;
	}
	
	@Override
	public Type checkReturn(List<Type> returnType) {
		if(this.returnType.equals(VoidType.getInstance()) && returnType.size() == 0)
			return this.returnType;
		
		if(returnType.size() != 0 && returnType.get(0).promotesTo(this.returnType) != null)
			return this.returnType;
		
		return super.checkReturn(returnType);
	}
}
