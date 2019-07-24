package semantic;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import ast.errors.*;

public interface Visitor {
	//Program
	public Object visit(Program program, Object params);
	
	//Definitions
	public Object visit(FieldDefinition def, Object params);
	public Object visit(VariableDefinition def, Object params);
	public Object visit(FuncDefinition def, Object params);
	
	//Types
	public Object visit(IntType type, Object params);
	public Object visit(CharType type, Object params);
	public Object visit(DoubleType type, Object params);
	public Object visit(VoidType type, Object params);
	public Object visit(FunctionType type, Object params);
	public Object visit(Array type, Object params);
	public Object visit(Struct type, Object params);
	
	public Object visit(ErrorType type, Object params);
	
	//Statements
	public Object visit(Function stmnt, Object params);
	public Object visit(Assignment stmnt, Object params);
	public Object visit(Input stmnt, Object params);
	public Object visit(Print stmnt, Object params);
	public Object visit(Conditional stmnt, Object params);
	public Object visit(WhileLoop stmnt, Object params);
	public Object visit(Return stmnt, Object params);
	
	//Expressions
	public Object visit(IntLiteral expr, Object params);
	public Object visit(CharLiteral expr, Object params);
	public Object visit(RealLiteral expr, Object params);
	public Object visit(Variable expr, Object params);
	public Object visit(Brackets expr, Object params);
	public Object visit(ArrayAccess expr, Object params);
	public Object visit(Dot expr, Object params);
	public Object visit(Cast expr, Object params);
	public Object visit(UnaryMinus expr, Object params);
	public Object visit(UnaryNegation expr, Object params);
	public Object visit(ArtihmeticExpression expr, Object params);
	public Object visit(ComparisonExpression expr, Object params);
	public Object visit(LogicalExpression expr, Object params);
}
