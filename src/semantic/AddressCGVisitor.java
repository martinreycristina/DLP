package semantic;

import ast.definitions.FieldDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.Dot;
import ast.expressions.Variable;
import ast.types.Array;
import ast.types.IntType;
import ast.types.Struct;

public class AddressCGVisitor extends AbstractCGVisitor {

	private ValueCGVisitor vcg;
	
	public AddressCGVisitor(CodeGenerator codeGenerator, ValueCGVisitor vcg) {
		super(codeGenerator);
		this.vcg = vcg;
	}

	public Object visit(Variable v, Object param) {
		if(v.getDefinition().getScope() == 0) {
			cg.pusha(v.getDefinition().getOffset());
		}else {
			cg.pushBP();
			cg.push(v.getDefinition().getOffset());
			cg.add(IntType.getInstance());
		}
		return null;
	}
	
	public Object visit(ArrayAccess a, Object param) {
		a.getOut().accept(this, null);
		a.getInside().accept(vcg, null);
		cg.push(((Array)a.getOut().getType()).getType().size());
		
		cg.mul(IntType.getInstance());
		cg.add(IntType.getInstance());
		return null;
	}
	
	public Object visit(Dot d, Object param) {
		//Nos ponemos al principio del struct
		d.getExpression().accept(this, null);
		//Nos ponemos en la variable que corresponde con el campo al que estamos accediendo
		for (FieldDefinition fd : ((Struct) d.getExpression().getType()).getDefs()) {
			if(fd.getName().equals(d.getField())) {
				cg.push(fd.getOffset());
				break;
			}
		}
		//Sumamos el offset
		cg.add(IntType.getInstance());
		return null;
	}
}
