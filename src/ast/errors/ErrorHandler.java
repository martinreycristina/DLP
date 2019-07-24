package ast.errors;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class ErrorHandler {
	
	private Set<ErrorType> errors = new HashSet<ErrorType>();
	
	private static final ErrorHandler INSTANCE = new ErrorHandler();
	
	private ErrorHandler(){}
	
	public static ErrorHandler getInstance() {
		return INSTANCE;
	}

	public void addError(ErrorType error) {
		errors.add(error);
	}
	
	public boolean AnyError() {
		return errors.isEmpty() ? false : true;
	}
	
	public void ShowErrors(PrintStream printStream) {
		for (ErrorType error : errors)
			printStream.println(error.toString());
	}
}
