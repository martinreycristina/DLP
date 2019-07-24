// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;

 import ast.*;
 import ast.definitions.*;
 import ast.expressions.*;
 import ast.statements.*;
 import ast.types.*;
 import ast.errors.*;
 import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, TRASH=38, 
		COMMENT_ONE_LINE=39, COMMENT_IN_LINES=40, ID=41, REAL_CONSTANT=42, CHAR_CONSTANT=43, 
		INT_CONSTANT=44;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_definition = 2, RULE_variable_definition = 3, 
		RULE_vars_definition = 4, RULE_function_definition = 5, RULE_simple_type = 6, 
		RULE_function_type = 7, RULE_params = 8, RULE_ids = 9, RULE_type = 10, 
		RULE_field_definition = 11, RULE_statements = 12, RULE_statement = 13, 
		RULE_expressions = 14, RULE_expression = 15;
	public static final String[] ruleNames = {
		"program", "definitions", "definition", "variable_definition", "vars_definition", 
		"function_definition", "simple_type", "function_type", "params", "ids", 
		"type", "field_definition", "statements", "statement", "expressions", 
		"expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "';'", "'int'", 
		"'double'", "'char'", "','", "'['", "']'", "'struct'", "'='", "'input'", 
		"'print'", "'if'", "'else'", "'while'", "'return'", "'.'", "'-'", "'!'", 
		"'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", 
		"'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "TRASH", "COMMENT_ONE_LINE", "COMMENT_IN_LINES", "ID", "REAL_CONSTANT", 
		"CHAR_CONSTANT", "INT_CONSTANT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public Token def;
		public Token main;
		public Token ft;
		public Vars_definitionContext vars_definition;
		public StatementsContext statements;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public Vars_definitionContext vars_definition() {
			return getRuleContext(Vars_definitionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((ProgramContext)_localctx).definitions = definitions();
			setState(33);
			((ProgramContext)_localctx).def = match(T__0);
			setState(34);
			((ProgramContext)_localctx).main = match(T__1);
			setState(35);
			((ProgramContext)_localctx).ft = match(T__2);
			setState(36);
			match(T__3);
			setState(37);
			match(T__4);
			setState(38);
			match(T__5);
			setState(39);
			((ProgramContext)_localctx).vars_definition = vars_definition();
			setState(40);
			((ProgramContext)_localctx).statements = statements();
			setState(41);
			match(T__6);
			setState(42);
			match(EOF);
			((ProgramContext)_localctx).definitions.list.add(new FuncDefinition(
													((ProgramContext)_localctx).def.getLine(),
													((ProgramContext)_localctx).def.getCharPositionInLine()+1,
													(((ProgramContext)_localctx).main!=null?((ProgramContext)_localctx).main.getText():null),
													new FunctionType(((ProgramContext)_localctx).ft.getLine(),
																	((ProgramContext)_localctx).def.getCharPositionInLine()+1,
																	new ArrayList<VariableDefinition>(),
																	VoidType.getInstance()),
													((ProgramContext)_localctx).vars_definition.list,
													((ProgramContext)_localctx).statements.list));
						((ProgramContext)_localctx).ast =  new Program(
							((ProgramContext)_localctx).definitions.list.get(0).getLine(),
							((ProgramContext)_localctx).definitions.list.get(0).getColumn(),
							((ProgramContext)_localctx).definitions.list);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();;
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					((DefinitionsContext)_localctx).definition = definition();
					for (Definition def: ((DefinitionsContext)_localctx).definition.ast) _localctx.list.add(def);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();;
		public Variable_definitionContext variable_definition;
		public Function_definitionContext function_definition;
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				((DefinitionContext)_localctx).variable_definition = variable_definition();
				setState(54);
				match(T__7);
				for (Definition def : ((DefinitionContext)_localctx).variable_definition.ast)
														_localctx.ast.add(def);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				((DefinitionContext)_localctx).function_definition = function_definition();
				_localctx.ast.add(((DefinitionContext)_localctx).function_definition.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();;
		public IdsContext ids;
		public TypeContext type;
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((Variable_definitionContext)_localctx).ids = ids();
			for (Variable id : ((Variable_definitionContext)_localctx).ids.list)
							_localctx.ast.add(new VariableDefinition(
								id.getLine(),
								id.getColumn(),
								id.getName(),
								null));
			setState(64);
			match(T__4);
			setState(65);
			((Variable_definitionContext)_localctx).type = type();
			for (VariableDefinition var : _localctx.ast){
					   		var.setType(((Variable_definitionContext)_localctx).type.ast);}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vars_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> list = new ArrayList<VariableDefinition>();;
		public Variable_definitionContext variable_definition;
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public Vars_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars_definition; }
	}

	public final Vars_definitionContext vars_definition() throws RecognitionException {
		Vars_definitionContext _localctx = new Vars_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vars_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					((Vars_definitionContext)_localctx).variable_definition = variable_definition();
					setState(69);
					match(T__7);
					for (VariableDefinition var : ((Vars_definitionContext)_localctx).variable_definition.ast)
															_localctx.list.add(var);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token def;
		public Token ID;
		public Function_typeContext function_type;
		public Vars_definitionContext vars_definition;
		public StatementsContext statements;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public Vars_definitionContext vars_definition() {
			return getRuleContext(Vars_definitionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((Function_definitionContext)_localctx).def = match(T__0);
			setState(78);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(79);
			((Function_definitionContext)_localctx).function_type = function_type();
			setState(80);
			match(T__5);
			setState(81);
			((Function_definitionContext)_localctx).vars_definition = vars_definition();
			setState(82);
			((Function_definitionContext)_localctx).statements = statements();
			setState(83);
			match(T__6);
			((Function_definitionContext)_localctx).ast =  new FuncDefinition(
																			((Function_definitionContext)_localctx).def.getLine(),
																			((Function_definitionContext)_localctx).def.getCharPositionInLine()+1,
																			(((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null),
																			((Function_definitionContext)_localctx).function_type.ast,
																			((Function_definitionContext)_localctx).vars_definition.list,
																			((Function_definitionContext)_localctx).statements.list);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_typeContext extends ParserRuleContext {
		public SimpleType ast;
		public Simple_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_type; }
	}

	public final Simple_typeContext simple_type() throws RecognitionException {
		Simple_typeContext _localctx = new Simple_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simple_type);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__8);
				((Simple_typeContext)_localctx).ast =  IntType.getInstance();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(T__9);
				((Simple_typeContext)_localctx).ast =  DoubleType.getInstance();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__10);
				((Simple_typeContext)_localctx).ast =  CharType.getInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_typeContext extends ParserRuleContext {
		public FunctionType ast;
		public Token first;
		public ParamsContext params;
		public Simple_typeContext simple_type;
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Simple_typeContext simple_type() {
			return getRuleContext(Simple_typeContext.class,0);
		}
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			((Function_typeContext)_localctx).first = match(T__2);
			setState(95);
			((Function_typeContext)_localctx).params = params();
			setState(96);
			match(T__3);
			setState(97);
			match(T__4);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				setState(98);
				((Function_typeContext)_localctx).simple_type = simple_type();
				}
			}

			if(((Function_typeContext)_localctx).simple_type == null) 
								((Function_typeContext)_localctx).ast =  new FunctionType(
											((Function_typeContext)_localctx).first.getLine(),
											((Function_typeContext)_localctx).first.getCharPositionInLine()+1,
											((Function_typeContext)_localctx).params.list,
											VoidType.getInstance());
							else
								((Function_typeContext)_localctx).ast =  new FunctionType(
											((Function_typeContext)_localctx).first.getLine(),
											((Function_typeContext)_localctx).first.getCharPositionInLine()+1,
											((Function_typeContext)_localctx).params.list,
											((Function_typeContext)_localctx).simple_type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<VariableDefinition> list = new ArrayList<VariableDefinition>();;
		public Token id1;
		public Simple_typeContext s1;
		public Token id2;
		public Simple_typeContext s2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<Simple_typeContext> simple_type() {
			return getRuleContexts(Simple_typeContext.class);
		}
		public Simple_typeContext simple_type(int i) {
			return getRuleContext(Simple_typeContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(103);
				((ParamsContext)_localctx).id1 = match(ID);
				setState(104);
				match(T__4);
				setState(105);
				((ParamsContext)_localctx).s1 = simple_type();
				}
			}

			if(((ParamsContext)_localctx).id1 != null)
						_localctx.list.add(new VariableDefinition(((ParamsContext)_localctx).id1.getLine(),
													((ParamsContext)_localctx).id1.getCharPositionInLine()+1,
													(((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getText():null),
													((ParamsContext)_localctx).s1.ast));
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(109);
				match(T__11);
				setState(110);
				((ParamsContext)_localctx).id2 = match(ID);
				setState(111);
				match(T__4);
				setState(112);
				((ParamsContext)_localctx).s2 = simple_type();
				if(((ParamsContext)_localctx).id2 != null)
							_localctx.list.add(new VariableDefinition(((ParamsContext)_localctx).id2.getLine(),
														((ParamsContext)_localctx).id2.getCharPositionInLine()+1,
														(((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null),
														((ParamsContext)_localctx).s2.ast));
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdsContext extends ParserRuleContext {
		public List<Variable> list = new ArrayList<Variable>();;
		public Token id1;
		public Token id2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((IdsContext)_localctx).id1 = match(ID);
			_localctx.list.add(new Variable(((IdsContext)_localctx).id1.getLine(),
													   ((IdsContext)_localctx).id1.getCharPositionInLine()+1,
													   (((IdsContext)_localctx).id1!=null?((IdsContext)_localctx).id1.getText():null)));
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(122);
				match(T__11);
				setState(123);
				((IdsContext)_localctx).id2 = match(ID);
				_localctx.list.add(new Variable(((IdsContext)_localctx).id2.getLine(),
														   ((IdsContext)_localctx).id2.getCharPositionInLine()+1,
														   (((IdsContext)_localctx).id2!=null?((IdsContext)_localctx).id2.getText():null)));
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Simple_typeContext simple_type;
		public Token first;
		public Token INT_CONSTANT;
		public TypeContext type;
		public Token struct;
		public Field_definitionContext field_definition;
		public Function_typeContext function_type;
		public Simple_typeContext simple_type() {
			return getRuleContext(Simple_typeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Field_definitionContext> field_definition() {
			return getRuleContexts(Field_definitionContext.class);
		}
		public Field_definitionContext field_definition(int i) {
			return getRuleContext(Field_definitionContext.class,i);
		}
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((TypeContext)_localctx).simple_type = simple_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).simple_type.ast;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((TypeContext)_localctx).first = match(T__12);
				setState(134);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(135);
				match(T__13);
				setState(136);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast =  new Array(
														((TypeContext)_localctx).first.getLine(),
														((TypeContext)_localctx).first.getCharPositionInLine()+1,
														LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)),
														((TypeContext)_localctx).type.ast);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				List<FieldDefinition> list = new ArrayList<FieldDefinition>();
				setState(140);
				((TypeContext)_localctx).struct = match(T__14);
				setState(141);
				match(T__5);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(142);
					((TypeContext)_localctx).field_definition = field_definition();
					setState(143);
					match(T__7);
					for (FieldDefinition fd : ((TypeContext)_localctx).field_definition.ast){
												if (list.contains(fd))
													new ErrorType(fd.getLine(),
																  fd.getColumn(),
																  "There is already a field named \'"+fd.getName()+"\' in the struct.");
										    }
					for (FieldDefinition fd : ((TypeContext)_localctx).field_definition.ast)
										     	list.add(fd);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(T__6);
				((TypeContext)_localctx).ast =  new Struct(
										((TypeContext)_localctx).struct.getLine(),
										((TypeContext)_localctx).struct.getCharPositionInLine()+1,
										list);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				((TypeContext)_localctx).function_type = function_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).function_type.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_definitionContext extends ParserRuleContext {
		public List<FieldDefinition> ast = new ArrayList<FieldDefinition>();;
		public IdsContext ids;
		public TypeContext type;
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Field_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_definition; }
	}

	public final Field_definitionContext field_definition() throws RecognitionException {
		Field_definitionContext _localctx = new Field_definitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_field_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((Field_definitionContext)_localctx).ids = ids();
			setState(160);
			match(T__4);
			setState(161);
			((Field_definitionContext)_localctx).type = type();
			List<Variable> checkRepeated = new ArrayList<Variable>();
									for (Variable id : ((Field_definitionContext)_localctx).ids.list){
										if(checkRepeated.contains(id))
											new ErrorType(id.getLine(),
														  id.getColumn(),
														  "The variable \'"+id.getName()+"\' is already declared in the same field.");
										else
											checkRepeated.add(id);
										_localctx.ast.add(new FieldDefinition(
											id.getLine(),
											id.getColumn(),
											id.getName(),
											((Field_definitionContext)_localctx).type.ast));}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<Statement> list = new ArrayList<Statement>();;
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT))) != 0)) {
				{
				{
				setState(164);
				((StatementsContext)_localctx).statement = statement();
				for (Statement s : ((StatementsContext)_localctx).statement.ast) _localctx.list.add(s);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();;
		public Token ID;
		public ExpressionsContext expressions;
		public ExpressionContext left;
		public ExpressionContext expression;
		public ExpressionContext right;
		public Token input;
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public Token print;
		public Token first;
		public StatementContext ifSt;
		public StatementsContext ifSts;
		public StatementContext elseSt;
		public StatementsContext elseSts;
		public StatementContext statement;
		public StatementsContext statements;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				((StatementContext)_localctx).ID = match(ID);
				setState(173);
				match(T__2);
				setState(174);
				((StatementContext)_localctx).expressions = expressions();
				setState(175);
				match(T__3);
				setState(176);
				match(T__7);
				_localctx.ast.add(new Function(
																((StatementContext)_localctx).ID.getLine(),
																((StatementContext)_localctx).ID.getCharPositionInLine()+1,
																new Variable(((StatementContext)_localctx).ID.getLine(),
																			 ((StatementContext)_localctx).ID.getCharPositionInLine()+1,
																			 (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)),
																((StatementContext)_localctx).expressions.list));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				((StatementContext)_localctx).left = ((StatementContext)_localctx).expression = expression(0);
				setState(180);
				match(T__15);
				setState(181);
				((StatementContext)_localctx).right = ((StatementContext)_localctx).expression = expression(0);
				setState(182);
				match(T__7);
				_localctx.ast.add(new Assignment(
																	((StatementContext)_localctx).expression.ast.getLine(),
																	((StatementContext)_localctx).expression.ast.getColumn(),
																	((StatementContext)_localctx).left.ast,
																	((StatementContext)_localctx).right.ast));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				((StatementContext)_localctx).input = match(T__16);
				setState(186);
				((StatementContext)_localctx).ex1 = expression(0);
				_localctx.ast.add(new Input(
													((StatementContext)_localctx).input.getLine(),
													((StatementContext)_localctx).input.getCharPositionInLine()+1,
													((StatementContext)_localctx).ex1.ast));
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(188);
					match(T__11);
					setState(189);
					((StatementContext)_localctx).ex2 = expression(0);
					_localctx.ast.add(new Input(
														((StatementContext)_localctx).input.getLine(),
														((StatementContext)_localctx).input.getCharPositionInLine()+1,
														((StatementContext)_localctx).ex2.ast));
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
				match(T__7);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				((StatementContext)_localctx).print = match(T__17);
				setState(200);
				((StatementContext)_localctx).ex1 = expression(0);
				_localctx.ast.add(new Print(
													((StatementContext)_localctx).print.getLine(),
													((StatementContext)_localctx).print.getCharPositionInLine()+1,
													((StatementContext)_localctx).ex1.ast));
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(202);
					match(T__11);
					setState(203);
					((StatementContext)_localctx).ex2 = expression(0);
					_localctx.ast.add(new Print(
														((StatementContext)_localctx).print.getLine(),
														((StatementContext)_localctx).print.getCharPositionInLine()+1,
														((StatementContext)_localctx).ex2.ast));
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__7);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				((StatementContext)_localctx).first = match(T__18);
				setState(214);
				((StatementContext)_localctx).expression = expression(0);
				setState(215);
				match(T__4);
				List<Statement> ifBody = new ArrayList<Statement>();
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case T__16:
				case T__17:
				case T__18:
				case T__20:
				case T__21:
				case T__23:
				case T__24:
				case ID:
				case REAL_CONSTANT:
				case CHAR_CONSTANT:
				case INT_CONSTANT:
					{
					setState(217);
					((StatementContext)_localctx).ifSt = statement();
					}
					break;
				case T__5:
					{
					setState(218);
					match(T__5);
					setState(219);
					((StatementContext)_localctx).ifSts = statements();
					setState(220);
					match(T__6);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				if(((StatementContext)_localctx).ifSt == null)ifBody=((StatementContext)_localctx).ifSts.list;
						  	else for(Statement s : ((StatementContext)_localctx).ifSt.ast) ifBody.add(s);
				List<Statement> elseBody = new ArrayList<Statement>();
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(226);
						match(T__19);
						setState(232);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__2:
						case T__16:
						case T__17:
						case T__18:
						case T__20:
						case T__21:
						case T__23:
						case T__24:
						case ID:
						case REAL_CONSTANT:
						case CHAR_CONSTANT:
						case INT_CONSTANT:
							{
							setState(227);
							((StatementContext)_localctx).elseSt = statement();
							}
							break;
						case T__5:
							{
							setState(228);
							match(T__5);
							setState(229);
							((StatementContext)_localctx).elseSts = statements();
							setState(230);
							match(T__6);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						if(((StatementContext)_localctx).elseSt == null)elseBody=((StatementContext)_localctx).elseSts.list;
								  	else for(Statement s : ((StatementContext)_localctx).elseSt.ast) elseBody.add(s);
						}
						} 
					}
					setState(240);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				_localctx.ast.add(new Conditional(
									((StatementContext)_localctx).first.getLine(),
									((StatementContext)_localctx).first.getCharPositionInLine()+1,
									((StatementContext)_localctx).expression.ast,
									ifBody, elseBody));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				((StatementContext)_localctx).first = match(T__20);
				setState(244);
				((StatementContext)_localctx).expression = expression(0);
				setState(245);
				match(T__4);
				List<Statement> list = new ArrayList<Statement>();
				setState(252);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case T__16:
				case T__17:
				case T__18:
				case T__20:
				case T__21:
				case T__23:
				case T__24:
				case ID:
				case REAL_CONSTANT:
				case CHAR_CONSTANT:
				case INT_CONSTANT:
					{
					setState(247);
					((StatementContext)_localctx).statement = statement();
					}
					break;
				case T__5:
					{
					setState(248);
					match(T__5);
					setState(249);
					((StatementContext)_localctx).statements = statements();
					setState(250);
					match(T__6);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				if(((StatementContext)_localctx).statement == null)list=((StatementContext)_localctx).statements.list;
						  	else for(Statement s : ((StatementContext)_localctx).statement.ast) list.add(s);
				_localctx.ast.add(new WhileLoop(
									((StatementContext)_localctx).first.getLine(),
									((StatementContext)_localctx).first.getCharPositionInLine()+1,
									((StatementContext)_localctx).expression.ast,
									list));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(257);
				((StatementContext)_localctx).first = match(T__21);
				setState(258);
				((StatementContext)_localctx).expression = expression(0);
				setState(259);
				match(T__7);
				_localctx.ast.add(new Return(
														((StatementContext)_localctx).first.getLine(),
														((StatementContext)_localctx).first.getCharPositionInLine()+1,
														((StatementContext)_localctx).expression.ast));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();;
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__23) | (1L << T__24) | (1L << ID) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT))) != 0)) {
				{
				setState(264);
				((ExpressionsContext)_localctx).ex1 = expression(0);
				_localctx.list.add(((ExpressionsContext)_localctx).ex1.ast);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(266);
					match(T__11);
					setState(267);
					((ExpressionsContext)_localctx).ex2 = expression(0);
					_localctx.list.add(((ExpressionsContext)_localctx).ex2.ast);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext out;
		public ExpressionContext e;
		public ExpressionContext left;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Token ID;
		public Token first;
		public TypeContext t;
		public ExpressionsContext expressions;
		public Token o;
		public ExpressionContext right;
		public ExpressionContext inside;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(278);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
						    									 ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,
						    									 LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 2:
				{
				setState(280);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
						    									 ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,
						    									 LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			case 3:
				{
				setState(282);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
						    									 ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,
						    									 LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			case 4:
				{
				setState(284);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =   new Variable(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 5:
				{
				setState(286);
				((ExpressionContext)_localctx).first = match(T__2);
				setState(287);
				((ExpressionContext)_localctx).e = expression(0);
				setState(288);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new Brackets(
						  										((ExpressionContext)_localctx).first.getLine(),
						  										((ExpressionContext)_localctx).first.getCharPositionInLine()+1,
						  										((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 6:
				{
				setState(291);
				((ExpressionContext)_localctx).first = match(T__2);
				setState(292);
				((ExpressionContext)_localctx).t = type();
				setState(293);
				match(T__3);
				setState(294);
				((ExpressionContext)_localctx).e = expression(8);
				((ExpressionContext)_localctx).ast =  new Cast(	
						  										((ExpressionContext)_localctx).first.getLine(),
						  										((ExpressionContext)_localctx).first.getCharPositionInLine()+1,
						  										((ExpressionContext)_localctx).e.ast,
						  										((ExpressionContext)_localctx).t.ast);
				}
				break;
			case 7:
				{
				setState(297);
				((ExpressionContext)_localctx).first = match(T__23);
				setState(298);
				((ExpressionContext)_localctx).e = expression(7);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(	
						  										((ExpressionContext)_localctx).first.getLine(),
						  										((ExpressionContext)_localctx).first.getCharPositionInLine()+1,
						  										((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 8:
				{
				setState(301);
				((ExpressionContext)_localctx).first = match(T__24);
				setState(302);
				((ExpressionContext)_localctx).e = expression(6);
				((ExpressionContext)_localctx).ast =  new UnaryNegation(	
						  										((ExpressionContext)_localctx).first.getLine(),
						  										((ExpressionContext)_localctx).first.getCharPositionInLine()+1,
						  										((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 9:
				{
				setState(305);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(306);
				match(T__2);
				setState(307);
				((ExpressionContext)_localctx).expressions = expressions();
				setState(308);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new Function(
																((ExpressionContext)_localctx).ID.getLine(),
																((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,
																new Variable(((ExpressionContext)_localctx).ID.getLine(),
																			 ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,
																			 (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)),
																((ExpressionContext)_localctx).expressions.list);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(343);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(313);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(314);
						((ExpressionContext)_localctx).o = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((ExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						((ExpressionContext)_localctx).right = expression(6);
						((ExpressionContext)_localctx).ast =  new ArtihmeticExpression(
						          		  														((ExpressionContext)_localctx).left.ast.getLine(),
						          		  														((ExpressionContext)_localctx).left.ast.getColumn(),
						          		  														((ExpressionContext)_localctx).left.ast,
						          		  														((ExpressionContext)_localctx).right.ast,
						          		  														(((ExpressionContext)_localctx).o!=null?((ExpressionContext)_localctx).o.getText():null));
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(319);
						((ExpressionContext)_localctx).o = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__28) ) {
							((ExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						((ExpressionContext)_localctx).right = expression(5);
						((ExpressionContext)_localctx).ast =  new ArtihmeticExpression(
						          		  														((ExpressionContext)_localctx).left.ast.getLine(),
						          		  														((ExpressionContext)_localctx).left.ast.getColumn(),
						          		  														((ExpressionContext)_localctx).left.ast,
						          		  														((ExpressionContext)_localctx).right.ast,
						          		  														(((ExpressionContext)_localctx).o!=null?((ExpressionContext)_localctx).o.getText():null));
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(324);
						((ExpressionContext)_localctx).o = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
							((ExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(325);
						((ExpressionContext)_localctx).right = expression(4);
						((ExpressionContext)_localctx).ast =  new ComparisonExpression(
						          		  														((ExpressionContext)_localctx).left.ast.getLine(),
						          		  														((ExpressionContext)_localctx).left.ast.getColumn(),
						          		  														((ExpressionContext)_localctx).left.ast,
						          		  														((ExpressionContext)_localctx).right.ast,
						          		  														(((ExpressionContext)_localctx).o!=null?((ExpressionContext)_localctx).o.getText():null));
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(329);
						((ExpressionContext)_localctx).o = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((ExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(330);
						((ExpressionContext)_localctx).right = expression(3);
						((ExpressionContext)_localctx).ast =  new LogicalExpression(
						          		  														((ExpressionContext)_localctx).left.ast.getLine(),
						          		  														((ExpressionContext)_localctx).left.ast.getColumn(),
						          		  														((ExpressionContext)_localctx).left.ast,
						          		  														((ExpressionContext)_localctx).right.ast,
						          		  														(((ExpressionContext)_localctx).o!=null?((ExpressionContext)_localctx).o.getText():null));
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.out = _prevctx;
						_localctx.out = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(334);
						match(T__12);
						setState(335);
						((ExpressionContext)_localctx).inside = expression(0);
						setState(336);
						match(T__13);
						((ExpressionContext)_localctx).ast =  new ArrayAccess(
						          		  										((ExpressionContext)_localctx).out.ast.getLine(),
						          		  										((ExpressionContext)_localctx).out.ast.getColumn(),
						          		  										((ExpressionContext)_localctx).out.ast,
						          		  										((ExpressionContext)_localctx).inside.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(340);
						match(T__22);
						setState(341);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new Dot(	((ExpressionContext)_localctx).e.ast.getLine(),
						          		  										((ExpressionContext)_localctx).e.ast.getColumn(),
						          		  										((ExpressionContext)_localctx).e.ast,
						          		  										(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u015f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\63\n\3\f\3"+
		"\16\3\66\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\t\3\t\5\tf\n"+
		"\t\3\t\3\t\3\n\3\n\3\n\5\nm\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nv\n\n\f"+
		"\n\16\ny\13\n\3\13\3\13\3\13\3\13\3\13\7\13\u0080\n\13\f\13\16\13\u0083"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u0096\n\f\f\f\16\f\u0099\13\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a0\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u00aa\n\16\f\16\16\16\u00ad"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00c3\n\17\f\17\16\17\u00c6\13"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d1\n\17\f\17"+
		"\16\17\u00d4\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00e1\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00eb"+
		"\n\17\3\17\3\17\7\17\u00ef\n\17\f\17\16\17\u00f2\13\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ff\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u0109\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u0111\n\20\f\20\16\20\u0114\13\20\5\20\u0116\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u013a\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u015a\n\21\f\21\16\21\u015d"+
		"\13\21\3\21\2\3 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\3\2\34"+
		"\36\4\2\32\32\37\37\3\2 %\3\2&\'\2\u0178\2\"\3\2\2\2\4\64\3\2\2\2\6>\3"+
		"\2\2\2\b@\3\2\2\2\nL\3\2\2\2\fO\3\2\2\2\16^\3\2\2\2\20`\3\2\2\2\22l\3"+
		"\2\2\2\24z\3\2\2\2\26\u009f\3\2\2\2\30\u00a1\3\2\2\2\32\u00ab\3\2\2\2"+
		"\34\u0108\3\2\2\2\36\u0115\3\2\2\2 \u0139\3\2\2\2\"#\5\4\3\2#$\7\3\2\2"+
		"$%\7\4\2\2%&\7\5\2\2&\'\7\6\2\2\'(\7\7\2\2()\7\b\2\2)*\5\n\6\2*+\5\32"+
		"\16\2+,\7\t\2\2,-\7\2\2\3-.\b\2\1\2.\3\3\2\2\2/\60\5\6\4\2\60\61\b\3\1"+
		"\2\61\63\3\2\2\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\5\3\2\2\2\66\64\3\2\2\2\678\5\b\5\289\7\n\2\29:\b\4\1\2:?\3\2\2\2"+
		";<\5\f\7\2<=\b\4\1\2=?\3\2\2\2>\67\3\2\2\2>;\3\2\2\2?\7\3\2\2\2@A\5\24"+
		"\13\2AB\b\5\1\2BC\7\7\2\2CD\5\26\f\2DE\b\5\1\2E\t\3\2\2\2FG\5\b\5\2GH"+
		"\7\n\2\2HI\b\6\1\2IK\3\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M"+
		"\13\3\2\2\2NL\3\2\2\2OP\7\3\2\2PQ\7+\2\2QR\5\20\t\2RS\7\b\2\2ST\5\n\6"+
		"\2TU\5\32\16\2UV\7\t\2\2VW\b\7\1\2W\r\3\2\2\2XY\7\13\2\2Y_\b\b\1\2Z[\7"+
		"\f\2\2[_\b\b\1\2\\]\7\r\2\2]_\b\b\1\2^X\3\2\2\2^Z\3\2\2\2^\\\3\2\2\2_"+
		"\17\3\2\2\2`a\7\5\2\2ab\5\22\n\2bc\7\6\2\2ce\7\7\2\2df\5\16\b\2ed\3\2"+
		"\2\2ef\3\2\2\2fg\3\2\2\2gh\b\t\1\2h\21\3\2\2\2ij\7+\2\2jk\7\7\2\2km\5"+
		"\16\b\2li\3\2\2\2lm\3\2\2\2mn\3\2\2\2nw\b\n\1\2op\7\16\2\2pq\7+\2\2qr"+
		"\7\7\2\2rs\5\16\b\2st\b\n\1\2tv\3\2\2\2uo\3\2\2\2vy\3\2\2\2wu\3\2\2\2"+
		"wx\3\2\2\2x\23\3\2\2\2yw\3\2\2\2z{\7+\2\2{\u0081\b\13\1\2|}\7\16\2\2}"+
		"~\7+\2\2~\u0080\b\13\1\2\177|\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0085\5\16\b\2\u0085\u0086\b\f\1\2\u0086\u00a0\3\2\2\2\u0087\u0088\7"+
		"\17\2\2\u0088\u0089\7.\2\2\u0089\u008a\7\20\2\2\u008a\u008b\5\26\f\2\u008b"+
		"\u008c\b\f\1\2\u008c\u00a0\3\2\2\2\u008d\u008e\b\f\1\2\u008e\u008f\7\21"+
		"\2\2\u008f\u0097\7\b\2\2\u0090\u0091\5\30\r\2\u0091\u0092\7\n\2\2\u0092"+
		"\u0093\b\f\1\2\u0093\u0094\b\f\1\2\u0094\u0096\3\2\2\2\u0095\u0090\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u00a0\b\f"+
		"\1\2\u009c\u009d\5\20\t\2\u009d\u009e\b\f\1\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u0084\3\2\2\2\u009f\u0087\3\2\2\2\u009f\u008d\3\2\2\2\u009f\u009c\3\2"+
		"\2\2\u00a0\27\3\2\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a3\7\7\2\2\u00a3"+
		"\u00a4\5\26\f\2\u00a4\u00a5\b\r\1\2\u00a5\31\3\2\2\2\u00a6\u00a7\5\34"+
		"\17\2\u00a7\u00a8\b\16\1\2\u00a8\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\33\3\2\2"+
		"\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7+\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b1"+
		"\5\36\20\2\u00b1\u00b2\7\6\2\2\u00b2\u00b3\7\n\2\2\u00b3\u00b4\b\17\1"+
		"\2\u00b4\u0109\3\2\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b7\7\22\2\2\u00b7"+
		"\u00b8\5 \21\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba\b\17\1\2\u00ba\u0109\3"+
		"\2\2\2\u00bb\u00bc\7\23\2\2\u00bc\u00bd\5 \21\2\u00bd\u00c4\b\17\1\2\u00be"+
		"\u00bf\7\16\2\2\u00bf\u00c0\5 \21\2\u00c0\u00c1\b\17\1\2\u00c1\u00c3\3"+
		"\2\2\2\u00c2\u00be\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\n"+
		"\2\2\u00c8\u0109\3\2\2\2\u00c9\u00ca\7\24\2\2\u00ca\u00cb\5 \21\2\u00cb"+
		"\u00d2\b\17\1\2\u00cc\u00cd\7\16\2\2\u00cd\u00ce\5 \21\2\u00ce\u00cf\b"+
		"\17\1\2\u00cf\u00d1\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\u00d6\7\n\2\2\u00d6\u0109\3\2\2\2\u00d7\u00d8\7\25\2\2\u00d8"+
		"\u00d9\5 \21\2\u00d9\u00da\7\7\2\2\u00da\u00e0\b\17\1\2\u00db\u00e1\5"+
		"\34\17\2\u00dc\u00dd\7\b\2\2\u00dd\u00de\5\32\16\2\u00de\u00df\7\t\2\2"+
		"\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e3\b\17\1\2\u00e3\u00f0\b\17\1\2\u00e4\u00ea\7\26\2"+
		"\2\u00e5\u00eb\5\34\17\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\5\32\16\2\u00e8"+
		"\u00e9\7\t\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\b\17\1\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00e4\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\b\17\1\2\u00f4"+
		"\u0109\3\2\2\2\u00f5\u00f6\7\27\2\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\7"+
		"\7\2\2\u00f8\u00fe\b\17\1\2\u00f9\u00ff\5\34\17\2\u00fa\u00fb\7\b\2\2"+
		"\u00fb\u00fc\5\32\16\2\u00fc\u00fd\7\t\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00f9"+
		"\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\b\17\1\2"+
		"\u0101\u0102\b\17\1\2\u0102\u0109\3\2\2\2\u0103\u0104\7\30\2\2\u0104\u0105"+
		"\5 \21\2\u0105\u0106\7\n\2\2\u0106\u0107\b\17\1\2\u0107\u0109\3\2\2\2"+
		"\u0108\u00ae\3\2\2\2\u0108\u00b5\3\2\2\2\u0108\u00bb\3\2\2\2\u0108\u00c9"+
		"\3\2\2\2\u0108\u00d7\3\2\2\2\u0108\u00f5\3\2\2\2\u0108\u0103\3\2\2\2\u0109"+
		"\35\3\2\2\2\u010a\u010b\5 \21\2\u010b\u0112\b\20\1\2\u010c\u010d\7\16"+
		"\2\2\u010d\u010e\5 \21\2\u010e\u010f\b\20\1\2\u010f\u0111\3\2\2\2\u0110"+
		"\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u010a\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\37\3\2\2\2\u0117\u0118\b\21\1\2\u0118\u0119\7.\2"+
		"\2\u0119\u013a\b\21\1\2\u011a\u011b\7-\2\2\u011b\u013a\b\21\1\2\u011c"+
		"\u011d\7,\2\2\u011d\u013a\b\21\1\2\u011e\u011f\7+\2\2\u011f\u013a\b\21"+
		"\1\2\u0120\u0121\7\5\2\2\u0121\u0122\5 \21\2\u0122\u0123\7\6\2\2\u0123"+
		"\u0124\b\21\1\2\u0124\u013a\3\2\2\2\u0125\u0126\7\5\2\2\u0126\u0127\5"+
		"\26\f\2\u0127\u0128\7\6\2\2\u0128\u0129\5 \21\n\u0129\u012a\b\21\1\2\u012a"+
		"\u013a\3\2\2\2\u012b\u012c\7\32\2\2\u012c\u012d\5 \21\t\u012d\u012e\b"+
		"\21\1\2\u012e\u013a\3\2\2\2\u012f\u0130\7\33\2\2\u0130\u0131\5 \21\b\u0131"+
		"\u0132\b\21\1\2\u0132\u013a\3\2\2\2\u0133\u0134\7+\2\2\u0134\u0135\7\5"+
		"\2\2\u0135\u0136\5\36\20\2\u0136\u0137\7\6\2\2\u0137\u0138\b\21\1\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0117\3\2\2\2\u0139\u011a\3\2\2\2\u0139\u011c\3\2"+
		"\2\2\u0139\u011e\3\2\2\2\u0139\u0120\3\2\2\2\u0139\u0125\3\2\2\2\u0139"+
		"\u012b\3\2\2\2\u0139\u012f\3\2\2\2\u0139\u0133\3\2\2\2\u013a\u015b\3\2"+
		"\2\2\u013b\u013c\f\7\2\2\u013c\u013d\t\2\2\2\u013d\u013e\5 \21\b\u013e"+
		"\u013f\b\21\1\2\u013f\u015a\3\2\2\2\u0140\u0141\f\6\2\2\u0141\u0142\t"+
		"\3\2\2\u0142\u0143\5 \21\7\u0143\u0144\b\21\1\2\u0144\u015a\3\2\2\2\u0145"+
		"\u0146\f\5\2\2\u0146\u0147\t\4\2\2\u0147\u0148\5 \21\6\u0148\u0149\b\21"+
		"\1\2\u0149\u015a\3\2\2\2\u014a\u014b\f\4\2\2\u014b\u014c\t\5\2\2\u014c"+
		"\u014d\5 \21\5\u014d\u014e\b\21\1\2\u014e\u015a\3\2\2\2\u014f\u0150\f"+
		"\f\2\2\u0150\u0151\7\17\2\2\u0151\u0152\5 \21\2\u0152\u0153\7\20\2\2\u0153"+
		"\u0154\b\21\1\2\u0154\u015a\3\2\2\2\u0155\u0156\f\13\2\2\u0156\u0157\7"+
		"\31\2\2\u0157\u0158\7+\2\2\u0158\u015a\b\21\1\2\u0159\u013b\3\2\2\2\u0159"+
		"\u0140\3\2\2\2\u0159\u0145\3\2\2\2\u0159\u014a\3\2\2\2\u0159\u014f\3\2"+
		"\2\2\u0159\u0155\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c!\3\2\2\2\u015d\u015b\3\2\2\2\31\64>L^elw\u0081\u0097"+
		"\u009f\u00ab\u00c4\u00d2\u00e0\u00ea\u00f0\u00fe\u0108\u0112\u0115\u0139"+
		"\u0159\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}