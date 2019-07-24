grammar Pmm;	

@header{
 import ast.*;
 import ast.definitions.*;
 import ast.expressions.*;
 import ast.statements.*;
 import ast.types.*;
 import ast.errors.*;
 import java.util.*;
}

program returns [Program ast]: 
			definitions def='def' main='main' ft='('')' ':' '{' vars_definition statements '}' EOF
			{$definitions.list.add(new FuncDefinition(
										$def.getLine(),
										$def.getCharPositionInLine()+1,
										$main.text,
										new FunctionType($ft.getLine(),
														$def.getCharPositionInLine()+1,
														new ArrayList<VariableDefinition>(),
														VoidType.getInstance()),
										$vars_definition.list,
										$statements.list));
			$ast = new Program(
				$definitions.list.get(0).getLine(),
				$definitions.list.get(0).getColumn(),
				$definitions.list);}
       ;
       
definitions returns [List<Definition> list = new ArrayList<Definition>();]:
            (definition {for (Definition def: $definition.ast) $list.add(def);})*
			;
       
definition returns [List<Definition> ast = new ArrayList<Definition>();]: 
			variable_definition ';' {for (Definition def : $variable_definition.ast)
										$ast.add(def);}
		  | function_definition {$ast.add($function_definition.ast);}
		  ;
		  
variable_definition returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>();]: 
		   ids {for (Variable id : $ids.list)
				$ast.add(new VariableDefinition(
					id.getLine(),
					id.getColumn(),
					id.getName(),
					null));}
		   ':' type 
		   {for (VariableDefinition var : $ast){
		   		var.setType($type.ast);}}
		  ;
		  
vars_definition returns [List<VariableDefinition> list = new ArrayList<VariableDefinition>();]:
			(variable_definition';' {for (VariableDefinition var : $variable_definition.ast)
										$list.add(var);})*
			;
		  
function_definition returns [FuncDefinition ast]: 
		def='def' ID function_type '{'vars_definition statements'}' {$ast = new FuncDefinition(
																$def.getLine(),
																$def.getCharPositionInLine()+1,
																$ID.text,
																$function_type.ast,
																$vars_definition.list,
																$statements.list);}
	    ;
	    
simple_type returns [SimpleType ast]:
		    'int' {$ast = IntType.getInstance();}
		  | 'double' {$ast = DoubleType.getInstance();}
		  | 'char' {$ast = CharType.getInstance();}
		  ;
	    
function_type returns [FunctionType ast]:
		first='(' params ')'':' simple_type?
				{if($simple_type.ctx == null) 
					$ast = new FunctionType(
								$first.getLine(),
								$first.getCharPositionInLine()+1,
								$params.list,
								VoidType.getInstance());
				else
					$ast = new FunctionType(
								$first.getLine(),
								$first.getCharPositionInLine()+1,
								$params.list,
								$simple_type.ast);}
		;
		
params returns [List<VariableDefinition> list = new ArrayList<VariableDefinition>();]:
		(id1=ID ':' s1=simple_type)?  
		{if($id1 != null)
			$list.add(new VariableDefinition($id1.getLine(),
										$id1.getCharPositionInLine()+1,
										$id1.text,
										$s1.ast));}
		(',' id2=ID ':' s2=simple_type
		{if($id2 != null)
			$list.add(new VariableDefinition($id2.getLine(),
										$id2.getCharPositionInLine()+1,
										$id2.text,
										$s2.ast));})*
		;
			
ids returns [List<Variable> list = new ArrayList<Variable>();]:
			id1=ID {$list.add(new Variable($id1.getLine(),
										   $id1.getCharPositionInLine()+1,
										   $id1.text));}
			(',' id2=ID {$list.add(new Variable($id2.getLine(),
										   $id2.getCharPositionInLine()+1,
										   $id2.text));})* 
			;
		  
type returns [Type ast]: 		
			simple_type {$ast = $simple_type.ast;}
		  | first='['INT_CONSTANT']' type  {$ast = new Array(
										$first.getLine(),
										$first.getCharPositionInLine()+1,
										LexerHelper.lexemeToInt($INT_CONSTANT.text),
										$type.ast);}
		  | {List<FieldDefinition> list = new ArrayList<FieldDefinition>();}
		    struct='struct' '{' (field_definition ';' 
		    			{for (FieldDefinition fd : $field_definition.ast){
							if (list.contains(fd))
								new ErrorType(fd.getLine(),
											  fd.getColumn(),
											  "There is already a field named \'"+fd.getName()+"\' in the struct.");
					    }}
		    			{for (FieldDefinition fd : $field_definition.ast)
					     	list.add(fd);} )* '}'  
						{$ast = new Struct(
						$struct.getLine(),
						$struct.getCharPositionInLine()+1,
						list);}
		  | function_type {$ast = $function_type.ast;}
		  ;

field_definition returns [List<FieldDefinition> ast = new ArrayList<FieldDefinition>();]: 
			ids ':' type {List<Variable> checkRepeated = new ArrayList<Variable>();
						for (Variable id : $ids.list){
							if(checkRepeated.contains(id))
								new ErrorType(id.getLine(),
											  id.getColumn(),
											  "The variable \'"+id.getName()+"\' is already declared in the same field.");
							else
								checkRepeated.add(id);
							$ast.add(new FieldDefinition(
								id.getLine(),
								id.getColumn(),
								id.getName(),
								$type.ast));}}
			;
			
statements returns [List<Statement> list = new ArrayList<Statement>();]:
			(statement {for (Statement s : $statement.ast) $list.add(s);})* 
		  ;
       
statement returns [List<Statement> ast = new ArrayList<Statement>();]: 
			ID '('expressions')'';' {$ast.add(new Function(
												$ID.getLine(),
												$ID.getCharPositionInLine()+1,
												new Variable($ID.getLine(),
															 $ID.getCharPositionInLine()+1,
															 $ID.text),
												$expressions.list));}
		  | left=expression '=' right=expression ';' {$ast.add(new Assignment(
													$expression.ast.getLine(),
													$expression.ast.getColumn(),
													$left.ast,
													$right.ast));}
		  | input='input' ex1=expression {$ast.add(new Input(
									$input.getLine(),
									$input.getCharPositionInLine()+1,
									$ex1.ast));}
		    (',' ex2=expression {$ast.add(new Input(
									$input.getLine(),
									$input.getCharPositionInLine()+1,
									$ex2.ast));})* ';' 
		  | print='print' ex1=expression{$ast.add(new Print(
									$print.getLine(),
									$print.getCharPositionInLine()+1,
									$ex1.ast));}
			 (',' ex2=expression {$ast.add(new Print(
									$print.getLine(),
									$print.getCharPositionInLine()+1,
									$ex2.ast));})* ';'
		  | first='if' expression ':' 
		  	{List<Statement> ifBody = new ArrayList<Statement>();}
		  	(ifSt=statement | '{'ifSts=statements'}') 
		  	{if($ifSt.ctx == null)ifBody=$ifSts.list;
		  	else for(Statement s : $ifSt.ast) ifBody.add(s);}
		  	{List<Statement> elseBody = new ArrayList<Statement>();}
		  	('else' (elseSt=statement | '{'elseSts=statements'}')
		  	{if($elseSt.ctx == null)elseBody=$elseSts.list;
		  	else for(Statement s : $elseSt.ast) elseBody.add(s);})* 
		  		{$ast.add(new Conditional(
					$first.getLine(),
					$first.getCharPositionInLine()+1,
					$expression.ast,
					ifBody, elseBody));}
		  | first='while' expression ':'
		  	{List<Statement> list = new ArrayList<Statement>();}
		  	(statement | '{'statements'}')
		  	{if($statement.ctx == null)list=$statements.list;
		  	else for(Statement s : $statement.ast) list.add(s);}
		  	{$ast.add(new WhileLoop(
					$first.getLine(),
					$first.getCharPositionInLine()+1,
					$expression.ast,
					list));}
		  | first='return' expression ';' {$ast.add(new Return(
										$first.getLine(),
										$first.getCharPositionInLine()+1,
										$expression.ast));}
		  ;

expressions returns [List<Expression> list = new ArrayList<Expression>();]:
			(ex1=expression {$list.add($ex1.ast);} (',' ex2=expression {$list.add($ex2.ast);})*)?
		  ;

expression returns [Expression ast]: 
		    INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(),
		    									 $INT_CONSTANT.getCharPositionInLine()+1,
		    									 LexerHelper.lexemeToInt($INT_CONSTANT.text));}
		  | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(),
		    									 $CHAR_CONSTANT.getCharPositionInLine()+1,
		    									 LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
		  | REAL_CONSTANT { $ast = new RealLiteral($REAL_CONSTANT.getLine(),
		    									 $REAL_CONSTANT.getCharPositionInLine()+1,
		    									 LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
		  | ID { $ast =  new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text); }
		  | first='('e=expression')' {$ast = new Brackets(
		  										$first.getLine(),
		  										$first.getCharPositionInLine()+1,
		  										$e.ast);}
		  | out=expression '['inside=expression']' {$ast = new ArrayAccess(
		  										$out.ast.getLine(),
		  										$out.ast.getColumn(),
		  										$out.ast,
		  										$inside.ast);}
		  | e=expression'.'ID {$ast = new Dot(	$e.ast.getLine(),
		  										$e.ast.getColumn(),
		  										$e.ast,
		  										$ID.text);}
		  | first='('t=type')' e=expression {$ast = new Cast(	
		  										$first.getLine(),
		  										$first.getCharPositionInLine()+1,
		  										$e.ast,
		  										$t.ast);}
		  | first='-'e=expression {$ast = new UnaryMinus(	
		  										$first.getLine(),
		  										$first.getCharPositionInLine()+1,
		  										$e.ast);}
		  | first='!'e=expression {$ast = new UnaryNegation(	
		  										$first.getLine(),
		  										$first.getCharPositionInLine()+1,
		  										$e.ast);}
		  | left=expression o=('*'|'/'|'%') right=expression {$ast = new ArtihmeticExpression(
		  														$left.ast.getLine(),
		  														$left.ast.getColumn(),
		  														$left.ast,
		  														$right.ast,
		  														$o.text);}
		  | left=expression o=('+'|'-') right=expression {$ast = new ArtihmeticExpression(
		  														$left.ast.getLine(),
		  														$left.ast.getColumn(),
		  														$left.ast,
		  														$right.ast,
		  														$o.text);}
		  | left=expression o=('>'|'>='|'<'|'<='|'!='|'==') right=expression 
		  												{$ast = new ComparisonExpression(
		  														$left.ast.getLine(),
		  														$left.ast.getColumn(),
		  														$left.ast,
		  														$right.ast,
		  														$o.text);}
		  | left=expression o=('&&'|'||') right=expression {$ast = new LogicalExpression(
		  														$left.ast.getLine(),
		  														$left.ast.getColumn(),
		  														$left.ast,
		  														$right.ast,
		  														$o.text);}
		  | ID '('expressions')' {$ast = new Function(
												$ID.getLine(),
												$ID.getCharPositionInLine()+1,
												new Variable($ID.getLine(),
															 $ID.getCharPositionInLine()+1,
															 $ID.text),
												$expressions.list);}
		  ;
		  

/***********************************Lexer**************************************/

TRASH: [ \r\n\t] -> skip;
       
COMMENT_ONE_LINE: '#'.*?'\r'?('\n'|EOF) -> skip
		;
  		 
COMMENT_IN_LINES: '"""'.*?'"""' -> skip
		;
            
ID: ([a-zA-Z]|'_')([a-zA-Z]|[0-9]|'_')*
		;
            
REAL_CONSTANT: (([0-9]+'.'[0-9]*)|([0-9]*'.'[0-9]+))([eE][+-][0-9]+)?
			 | [0-9]+[eE][+-]?[0-9]+
			 ;

CHAR_CONSTANT: '\'\\'[nt]'\''
			 | '\'\\'[0-9]+'\''
			 | '\''.'\''
 			 ;
 
INT_CONSTANT: [0-9]+ 
            ;