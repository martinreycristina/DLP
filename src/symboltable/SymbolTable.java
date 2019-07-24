package symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;
	
	public int getScope() {
		return scope;
	}

	public SymbolTable()  {
		table = new LinkedList<Map<String,Definition>>();
		table.add(new HashMap<String,Definition>());
	}

	public void set() {
		table.add(new HashMap<String,Definition>());
		scope += 1;
	}
	
	public void reset() {
		table.remove(scope);
		scope -= 1;
	}
	
	public boolean insert(Definition definition) {
		if(findInCurrentScope(definition.getName()) == null) {
			definition.setScope(scope);
			table.get(scope).put(definition.getName(), definition);
			return true;
		}else {
			return false;
		}
	}
	
	public Definition find(String id) {
		for(int i = scope; i >= 0 ; i--) {
			Map<String,Definition> ambito = table.get(i);
			Definition def = ambito.get(id);
			if(def != null)
				return def;
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		if(table.get(scope).containsKey(id))
			return table.get(scope).get(id);
		else
			return null;
	}
}
