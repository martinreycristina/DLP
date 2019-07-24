import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ast.Program;
import ast.errors.ErrorHandler;
import parser.PmmLexer;
import parser.PmmParser;
import semantic.CodeGenerator;
import semantic.ExecuteCGVisitor;
import semantic.IdentificationVisitor;
import semantic.LValueVisitor;
import semantic.OffsetVisitor;
import semantic.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		PmmParser parser = new PmmParser(tokens);	
		Program ast = parser.program().ast;
		
		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new LValueVisitor(), null);
		ast.accept(new TypeCheckingVisitor(), null);
		
		// check if there is any error
		if (ErrorHandler.getInstance().AnyError())
			ErrorHandler.getInstance().ShowErrors(System.err);
		else {
			// * The AST is shown
			/*
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
			*/
			
			 ast.accept(new OffsetVisitor(),null);
			 ast.accept(new ExecuteCGVisitor(new CodeGenerator(args[1],args[0])),null);
		}
	}
}
