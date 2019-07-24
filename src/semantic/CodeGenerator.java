package semantic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ast.Type;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;

public class CodeGenerator {

	private int labels = 0;
	private PrintWriter out;
	private String source;
	
	public CodeGenerator(String output, String input) throws FileNotFoundException {
		this.out = new PrintWriter(output);
		this.source = input;
	}
	
	public int getLabels() {
		labels++;
		return labels;
	}

	public void mainInvocation() {
		comment("Invocation to the main function");
		out.println("call main");
		out.println("halt");
		out.flush();
	}
	
	public void pushb(char c) {
		out.println("\tpushb\t"+(int)c);
		out.flush();
	}
	
	public void push(int i) {
		out.println("\tpushi\t"+i);
		out.flush();
	}
	
	public void pushf(double d) {
		out.println("\tpushf\t"+d);
		out.flush();
	}
	
	public void pusha(int address) {
		out.println("\tpusha\t"+address);
		out.flush();
	}
	
	public void pushBP() {
		out.println("\tpush\tbp");
		out.flush();
	}
	
	public void load(Type type) {
		out.println("\tload"+type.suffix());
		out.flush();
	}
	
	public void store(Type type) {
		out.println("\tstore"+type.suffix());
		out.flush();
	}
	
	public void pop(Type type) {
		out.println("\tpop"+type.suffix());
		out.flush();
	}
	
	public void dup(Type type) {
		out.println("\tdup"+type.suffix());
		out.flush();
	}
	
	public void add(Type type) {
		out.println("\tadd"+type.suffix());
		out.flush();
	}
	
	public void sub(Type type) {
		out.println("\tsub"+type.suffix());
		out.flush();
	}
	
	public void mul(Type type) {
		out.println("\tmul"+type.suffix());
		out.flush();
	}
	
	public void div(Type type) {
		out.println("\tdiv"+type.suffix());
		out.flush();
	}
	
	public void mod(Type type) {
		out.println("\tmod"+type.suffix());
		out.flush();
	}
	
	public void gt(Type type) {
		out.println("\tgt"+type.suffix());
		out.flush();
	}
	
	public void lt(Type type) {
		out.println("\tlt"+type.suffix());
		out.flush();
	}
	
	public void ge(Type type) {
		out.println("\tge"+type.suffix());
		out.flush();
	}
	
	public void le(Type type) {
		out.println("\tle"+type.suffix());
		out.flush();
	}
	
	public void eq(Type type) {
		out.println("\teq"+type.suffix());
		out.flush();
	}
	
	public void ne(Type type) {
		out.println("\tne"+type.suffix());
		out.flush();
	}
	
	public void and() {
		out.println("\tand");
		out.flush();
	}
	
	public void or() {
		out.println("\tor");
		out.flush();
	}
	
	public void not() {
		out.println("\tnot");
		out.flush();
	}
	
	public void out(Type type) {
		out.println("\tout"+type.suffix());
		out.flush();
	}
	
	public void in(Type type) {
		out.println("\tin"+type.suffix());
		out.flush();
	}
	
	public void label(String id) {
		out.println(" "+id+":");
		out.flush();
	}
	
	public void jmp(String label) {
		out.println("\tjmp\t" + label);
		out.flush();
	}
	
	public void jz(String label) {
		out.println("\tjz\t" + label);
		out.flush();
	}
	
	public void jnz(String label) {
		out.println("\tjnz\t" + label);
		out.flush();
	}
	
	public void functionName(String id) {
		out.println(" "+id+":");
		out.flush();
	}
	
	public void call(String id) {
		out.println("\tcall\t"+id);
		out.flush();
	}
	
	public void enter(int bytes) {
		out.println("\tenter\t"+bytes);
		out.flush();
	}
	
	public void ret(int bytesReturn, int bytesLocals, int bytesParams) {
		out.println("\tret\t"+bytesReturn+","+bytesLocals+","+bytesParams);
		out.flush();
	}
	
	public void convertTo(Type of, Type a ){
		if (of.equals(a)) return;
		
		if(of instanceof CharType)
			out.println("\tb2i");
		else if(of instanceof DoubleType)
			out.println("\tf2i");
		
		if (a instanceof IntType) return;
		else if(a instanceof CharType)
			out.println("\ti2b");
		else if(a instanceof DoubleType)
			out.println("\ti2f");
		
		out.flush();
	}
	
	public void arithmetic(String operator, Type type ){
		switch(operator) {
		case("+"):
			this.add(type);
			break;
		case("-"):
			this.sub(type);
			break;
		case("*"):
			this.mul(type);
			break;
		case("/"):
			this.div(type);
			break;
		case("%"):
			this.mod(type);
			break;
		}
	}
	
	public void comparison(String operator, Type type ){
		switch(operator) {
		case(">"):
			this.gt(type);
			break;
		case(">="):
			this.ge(type);
			break;
		case("<"):
			this.lt(type);
			break;
		case("<="):
			this.le(type);
			break;
		case("!="):
			this.ne(type);
			break;
		case("=="):
			this.eq(type);
			break;
		}
	}
	
	public void logical(String operator){
		switch(operator) {
		case("&&"):
			this.and();
			break;
		case("||"):
			this.or();
			break;
		}
	}

	public void comment(String string) {
		out.println("'\t* "+string);
		out.flush();
	}
	
	public void commentVar(Type tipo, String name, int offset) {
		this.comment(tipo.getClass().getName() + " " + name + " (offset " + offset + ")");
		out.flush();
	}
	
	public void metadata(String name, String param) {
		out.println("#"+name+"\t"+param);
		out.flush();
	}
	
	public void line(int n) {
		out.println();
		metadata("line",String.valueOf(n));
		out.flush();
	}

	public String getSource() {
		return source;
	}

}
