package semantic;

import java.util.List;

import ast.Definition;
import ast.Program;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor {

	private AddressCGVisitor acg;
	private ValueCGVisitor vcg;
	
	public ExecuteCGVisitor(CodeGenerator codeGenerator) {
		super(codeGenerator);
		
		this.vcg = new ValueCGVisitor(cg);
		this.acg = new AddressCGVisitor(cg, vcg);
		this.vcg.setAcg(this.acg);
	}

	// ----------------------------------------- PROGRAM -----------------------------------------
	public Object visit(Program p, Object param) {
		
		cg.metadata("source", "\""+cg.getSource()+"\"");
		
		for (Definition d : p.getDefinitions()) {
			if(d instanceof VariableDefinition)
				d.accept(this, null);
		}
		
		cg.mainInvocation();

		for (Definition d: p.getDefinitions()) {
			if(d instanceof FuncDefinition)
				d.accept(this, null);
		}
		
		return null;
	}
	
	// ----------------------------------------- DEFINICIONES -----------------------------------------
	public Object visit(VariableDefinition d, Object param) {
		
		cg.commentVar(d.getType(), d.getName(), d.getOffset());
		
		return null;
	}
	
	public Object visit(FuncDefinition d, Object param) {
		//#line n
		cg.line(d.getLine());
		
		//call name
		cg.functionName(d.getName());
		
		//Comentarios de los parámetros
		cg.comment("Parameters");
		List<VariableDefinition> parameters = ((FunctionType) d.getType()).getParameters();
		for(VariableDefinition def : parameters){
			cg.commentVar(def.getType(), def.getName(), def.getOffset());
		}
		//Comentarios de las variables locales
		cg.comment("Local variables");
		for(VariableDefinition def : d.getVariableDefinitions()){
			cg.commentVar(def.getType(), def.getName(), def.getOffset());
		}
		
		//enter
		cg.enter(d.getBytesLocals());
		
		//Aceptamos las sentencias de la función
		for(Statement s : d.getStatements()) {
			if(!(s instanceof VariableDefinition)) {
				s.accept(this, null);
			}
		}
		
		//Si la función devuelve VoidType debemos ponerle return
		if(((FunctionType) d.getType()).getReturnType() instanceof VoidType)
			if(parameters.size() == 0) {
				cg.ret(0, d.getBytesLocals(),0);
			}else {
				cg.ret(0, d.getBytesLocals(), 
						parameters.get(0).getOffset()-4+parameters.get(0).getType().size());
			}
		
		return null;
	}
	
	// ----------------------------------------- SENTENCIAS -----------------------------------------
	
	public Object visit(Assignment a, Object param) {
		cg.line(a.getLine());
		cg.comment("Assignment");
		a.getLeft().accept(acg, null);
		a.getRight().accept(vcg, null);
		cg.store(a.getLeft().getType());
		return null;
	}
	
	public Object visit(Input i, Object param) {
		cg.line(i.getLine());
		cg.comment("Input");
		i.getExpression().accept(acg,null);
		cg.in(i.getExpression().getType());
		cg.store(i.getExpression().getType());
		return null;
	}
	
	public Object visit(Print p, Object param) {
		cg.line(p.getLine());
		cg.comment("Print");
		p.getExpression().accept(vcg,null);
		cg.out(p.getExpression().getType());
		return null;
	}
	
	/**
	EXECUTE[[RETURN:Stmnt -> Exp]](FunDefinition) //Este parámetro se pasa en el visit de definición de función
		VALUE[[Exp]]
		<RET> Exp.Type.Size <,> 
			FuncDefinition.BytesLocals <,>
			FuncDefinition.Type.params.get(0).offset + FuncDefinition.Type.params.get(0).size
	 */
	public Object visit(Return r, Object param) {
		cg.line(r.getLine());
		cg.comment("Return");
		
		r.getExpression().accept(vcg, null);
		
		List<VariableDefinition> params = ((FunctionType) r.getFunction().getType()).getParameters();
		if(params.isEmpty()) {
			cg.ret(r.getExpression().getType().size(), r.getFunction().getBytesLocals(), 0);
		} else {
			VariableDefinition param1 = params.get(0);
			
			cg.ret(r.getExpression().getType().size(), r.getFunction().getBytesLocals(), 
					param1.getOffset()-4 + param1.getType().size());
		}
		return null;
	}
	
	
	/*
	 *EXECUTE[[IF:STM -> EXP STM1* STM2*]]:
		INT ELSE = CG.getLabel(); #Contador
		INT FIN = CG.GetLabel(); #Contador
		VALUE[[EXP]]
		<JZ LABEL> ELSE
		FOR (STM S : STM1*)
			EXECUTE[[S]]
		<JMP LABEL> END
		<LABEL> ELSE <:>
		FOR (STM S : STM2*)
			EXECUTE[[S]]
		<LABEL> END <:>
	 */
	public Object visit(Conditional stmnt, Object params) {
		cg.line(stmnt.getLine());
		cg.comment("If");
		
		String elseTag = "else" + cg.getLabels();
		String endTag = "end" + cg.getLabels();
		
		stmnt.getExpression().accept(vcg, null);
		cg.jz(elseTag);
		
		for(Statement s: stmnt.getIf_body())
			s.accept(this, null);
		
		cg.jmp(endTag);
		
		cg.label(elseTag);
		
		for(Statement s : stmnt.getElse_body())
			s.accept(this, null);
		
		cg.label(endTag);
		
		return null;
	}

	/*
	 * EXECUTE[[WHILE:STM -> EXP STMS*]]:
	  	INT CONDITION = CG.GetLabel(); #Contador
		INT END = CG.GetLabel(); #Contador
		<LABEL> CONDITION <:>
		VALUE[[EXP]]		#Con al instrucción DUP puedes optimizar este problema (hay que hacer despues un pop)
		<JZ LABEL> END 		#La instrucción JZ saca el valor de la pila (pop) y comprueba que es 0 
		FOR (STM S : STMS*)
			EXECUTE[[S]]
		<JMP LABEL> WHILE
		<LABEL> END <:>
	 */
	public Object visit(WhileLoop stmnt, Object params) {
		cg.line(stmnt.getLine());
		cg.comment("While");
		
		String conditionTag = "condition" + cg.getLabels();
		String endTag = "endTag" + cg.getLabels();
		
		cg.label(conditionTag);
		
		stmnt.getExpression().accept(vcg, null);
		
		cg.jz(endTag);
		
		for(Statement s : stmnt.getBody())
			s.accept(this, null);
		
		cg.jmp(conditionTag);
		
		cg.label(endTag);
		return null;
	}
	
	/**
	 * EXECUTE[[INVOCATION:Stmnt -> Var Exp*]]:
		VALUE[[(Expression)INVOCATION]]   //En el código aqui no tendremos que hacer nada
		IF(!((Expression) Stmnt).Type instanceof VOID):
			<POP> Stmnt.Type.Suffix()
	 */
	@Override
	public Object visit(Function stmnt, Object params) {
		cg.line(stmnt.getLine());
		cg.comment("Function Invocation");
		
		stmnt.accept(vcg, null);
		if(!(stmnt.getType().equals(VoidType.getInstance())))
			cg.pop(stmnt.getType());
		return null;
	}
}
