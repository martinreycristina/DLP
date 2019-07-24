package semantic;

import ast.Program;
import ast.definitions.FieldDefinition;
import ast.definitions.FuncDefinition;
import ast.definitions.VariableDefinition;
import ast.errors.ErrorType;
import ast.expressions.ArrayAccess;
import ast.expressions.ArtihmeticExpression;
import ast.expressions.Brackets;
import ast.expressions.Cast;
import ast.expressions.CharLiteral;
import ast.expressions.ComparisonExpression;
import ast.expressions.Dot;
import ast.expressions.IntLiteral;
import ast.expressions.LogicalExpression;
import ast.expressions.RealLiteral;
import ast.expressions.UnaryMinus;
import ast.expressions.UnaryNegation;
import ast.expressions.Variable;
import ast.statements.Assignment;
import ast.statements.Conditional;
import ast.statements.Function;
import ast.statements.Input;
import ast.statements.Print;
import ast.statements.Return;
import ast.statements.WhileLoop;
import ast.types.Array;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.Struct;
import ast.types.VoidType;

public abstract class AbstractCGVisitor implements Visitor{
	
	protected CodeGenerator cg;
	
	public AbstractCGVisitor(CodeGenerator codeGenerator) {
		this.cg = codeGenerator;
	}
	
	@Override
	public Object visit(Program program, Object params) {
		throw new IllegalStateException("Code generation template \"Program\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(FieldDefinition def, Object params) {
		throw new IllegalStateException("Code generation template \"FieldDefinition\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(VariableDefinition def, Object params) {
		throw new IllegalStateException("Code generation template \"VariableDefinition\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(FuncDefinition def, Object params) {
		throw new IllegalStateException("Code generation template \"FuncDefinition\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(IntType type, Object params) {
		throw new IllegalStateException("Code generation template \"IntType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(CharType type, Object params) {
		throw new IllegalStateException("Code generation template \"CharType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(DoubleType type, Object params) {
		throw new IllegalStateException("Code generation template \"DoubleType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(VoidType type, Object params) {
		throw new IllegalStateException("Code generation template \"VoidType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(FunctionType type, Object params) {
		throw new IllegalStateException("Code generation template \"FunctionType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Array type, Object params) {
		throw new IllegalStateException("Code generation template \"Array\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Struct type, Object params) {
		throw new IllegalStateException("Code generation template \"Struct\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(ErrorType type, Object params) {
		throw new IllegalStateException("Code generation template \"ErrorType\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Function stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Function\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Assignment stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Assignment\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Input stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Input\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Print stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Print\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Conditional stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Conditional\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(WhileLoop stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"WhileLoop\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Return stmnt, Object params) {
		throw new IllegalStateException("Code generation template \"Return\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(IntLiteral expr, Object params) {
		throw new IllegalStateException("Code generation template \"IntLiteral\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(CharLiteral expr, Object params) {
		throw new IllegalStateException("Code generation template \"CharLiteral\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(RealLiteral expr, Object params) {
		throw new IllegalStateException("Code generation template \"RealLiteral\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Variable expr, Object params) {
		throw new IllegalStateException("Code generation template \"Variable\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Brackets expr, Object params) {
		throw new IllegalStateException("Code generation template \"Brackets\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(ArrayAccess expr, Object params) {
		throw new IllegalStateException("Code generation template \"ArrayAccess\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Dot expr, Object params) {
		throw new IllegalStateException("Code generation template \"Dot\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(Cast expr, Object params) {
		throw new IllegalStateException("Code generation template \"Cast\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(UnaryMinus expr, Object params) {
		throw new IllegalStateException("Code generation template \"UnaryMinus\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(UnaryNegation expr, Object params) {
		throw new IllegalStateException("Code generation template \"UnaryNegation\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(ArtihmeticExpression expr, Object params) {
		throw new IllegalStateException("Code generation template \"ArtihmeticExpression\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(ComparisonExpression expr, Object params) {
		throw new IllegalStateException("Code generation template \"ComparisonExpression\""
				+ " not defined for the code function " + this.getClass().getName());
	}

	@Override
	public Object visit(LogicalExpression expr, Object params) {
		throw new IllegalStateException("Code generation template \"LogicalExpression\""
				+ " not defined for the code function " + this.getClass().getName());
	}
}
