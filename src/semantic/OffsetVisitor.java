package semantic;

import ast.Statement;
import ast.definitions.FieldDefinition;
import ast.definitions.FuncDefinition;
import ast.definitions.VariableDefinition;
import ast.types.FunctionType;
import ast.types.Struct;

public class OffsetVisitor extends AbstractVisitor {

	private int globalVarOffset;
	private int localVarOffset;
	
	public OffsetVisitor() {
		super();
		this.globalVarOffset = 0;
		this.localVarOffset = 0;
	}
	
	@Override
	public Object visit(VariableDefinition def, Object params) {
		def.getType().accept(this, params);
		
		if(def.getScope() == 0) {
			def.setOffset(globalVarOffset);
			globalVarOffset += def.getType().size();
		} else if ( def.getScope() == 1){
			localVarOffset -= def.getType().size();
			def.setOffset(localVarOffset);
		}
		
		return null;
	}
	
	@Override
	public Object visit(FuncDefinition def, Object params) {
		localVarOffset = 0; //Guardarlo antes de salir en un atributo de FuncDefiniton
		def.getType().accept(this, params);
		for(VariableDefinition varDef : def.getVariableDefinitions()) {
			varDef.accept(this, params);
		}
		for(Statement stmnt : def.getStatements()) {
			stmnt.accept(this, params);
		}
		def.setBytesLocals(localVarOffset * -1);
		return null;
	}
	
	@Override
	public Object visit(FunctionType type, Object params) {
		int offset = 4;
		for(int i = type.getParameters().size()-1; i >= 0; i-- ) {
			type.getParameters().get(i).setOffset(offset);
			offset += type.getParameters().get(i).getType().size();
		}
		type.getReturnType().accept(this, params);
		return null;
	}
	
	@Override
	public Object visit(Struct type, Object params) {
		int offset = 0;
		for(FieldDefinition fieldDef : type.getDefs()) {
			fieldDef.accept(this, params);
			fieldDef.setOffset(offset);
			offset += fieldDef.getType().size();
		}
		return null;
	}
}
