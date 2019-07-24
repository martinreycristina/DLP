package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import symboltable.SymbolTable;
import ast.errors.*;

public class IdentificationVisitor extends AbstractVisitor {
	
	SymbolTable table = new SymbolTable();

	@Override
	public Object visit(VariableDefinition def, Object params) {
		def.getType().accept(this, params);
		
		if(!table.insert(def)) {
			new ErrorType(def.getLine(), def.getColumn(),
					"La variable '"+ def.getName() + "' ya está definida.");
		}
		
		return null;
	}

	@Override
	public Object visit(FuncDefinition def, Object params) {
		if(!table.insert(def)) 
			new ErrorType(def.getLine(), def.getColumn(),
					"La función '"+def.getName()+"' ya está definida.");
			
		table.set();
		
		def.getType().accept(this, params);
		
		for(VariableDefinition varDef : def.getVariableDefinitions()) {
			varDef.accept(this, params);
		}
		for(Statement stmnt : def.getStatements()) {
			stmnt.accept(this, params);
		}
		table.reset();
			
		return null;
	}
	
	@Override
	public Object visit(Variable expr, Object params) {
		VariableDefinition def = (VariableDefinition) table.find(expr.getName());
		
		if(def != null) {
			expr.setDefinition(def);
		}else {
			expr.setDefinition(new VariableDefinition(expr.getLine(),expr.getColumn(),expr.getName(),
				new ErrorType(expr.getLine(), expr.getColumn(), 
						"La variable '"+ expr.getName() + "' no está definida.")));
		}
		
		return null;
	}
	
	@Override
	public Object visit(Function stmnt, Object params) {			
		for(Expression expr : stmnt.getParams()) {
			expr.accept(this, params);
		}
		
		FuncDefinition def = (FuncDefinition) table.find(stmnt.getVar().getName());
		
		if(def != null) {
			stmnt.setDefinition(def);
		}else {
			new ErrorType(stmnt.getLine(), stmnt.getColumn(),
					"La función '"+stmnt.getVar().getName()+"' no está definida.");
		}
		
		return null;
	}
}
