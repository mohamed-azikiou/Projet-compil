// Generated from C:/Users/pc/IdeaProjects/TinyCompiler\Small_Java.g4 by ANTLR 4.7.2
package Antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Small_JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FLOAT_NUMBER=1, INT_NUMBER=2, IMPORT=3, MODIF=4, LIB=5, CLASS=6, MAIN=7, 
		COMMA=8, TYPE=9, MOV=10, LPAREN=11, RPAREN=12, PLUS=13, MINUS=14, TIMES=15, 
		DIV=16, GT=17, GTE=18, LT=19, LTE=20, EQ=21, NEQ=22, NOT=23, AND=24, OR=25, 
		POINT=26, SC=27, LCB=28, RCB=29, IF=30, ELSE=31, THEN=32, READ=33, WRITE=34, 
		FORMAT=35, STRING=36, ID=37, WS=38;
	public static final int
		RULE_file = 0, RULE_imports = 1, RULE_single_import = 2, RULE_code_bloc = 3, 
		RULE_dec_class = 4, RULE_func = 5, RULE_condition = 6, RULE_instructions = 7, 
		RULE_cond = 8, RULE_comp = 9, RULE_instruction = 10, RULE_read = 11, RULE_write = 12, 
		RULE_read_expression = 13, RULE_write_expression = 14, RULE_dec = 15, 
		RULE_mov = 16, RULE_expression = 17, RULE_atom = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "imports", "single_import", "code_bloc", "dec_class", "func", 
			"condition", "instructions", "cond", "comp", "instruction", "read", "write", 
			"read_expression", "write_expression", "dec", "mov", "expression", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'import'", null, null, "'class_SJ'", "'main_SJ'", 
			"','", null, "':='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'>'", 
			"'>='", "'<'", "'<='", "'='", "'!='", "'!'", "'&'", "'|'", "'.'", "';'", 
			"'{'", "'}'", "'Si'", "'Sinon'", "'Alors'", "'In_SJ'", "'Out_SJ'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FLOAT_NUMBER", "INT_NUMBER", "IMPORT", "MODIF", "LIB", "CLASS", 
			"MAIN", "COMMA", "TYPE", "MOV", "LPAREN", "RPAREN", "PLUS", "MINUS", 
			"TIMES", "DIV", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "NOT", "AND", 
			"OR", "POINT", "SC", "LCB", "RCB", "IF", "ELSE", "THEN", "READ", "WRITE", 
			"FORMAT", "STRING", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Small_Java.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Small_JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public Code_blocContext code_bloc() {
			return getRuleContext(Code_blocContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Small_JavaParser.EOF, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			imports();
			setState(39);
			code_bloc();
			setState(40);
			match(EOF);
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

	public static class ImportsContext extends ParserRuleContext {
		public List<Single_importContext> single_import() {
			return getRuleContexts(Single_importContext.class);
		}
		public Single_importContext single_import(int i) {
			return getRuleContext(Single_importContext.class,i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(42);
				single_import();
				}
				}
				setState(47);
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

	public static class Single_importContext extends ParserRuleContext {
		public Token lib;
		public TerminalNode IMPORT() { return getToken(Small_JavaParser.IMPORT, 0); }
		public TerminalNode SC() { return getToken(Small_JavaParser.SC, 0); }
		public TerminalNode LIB() { return getToken(Small_JavaParser.LIB, 0); }
		public Single_importContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_import; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitSingle_import(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_importContext single_import() throws RecognitionException {
		Single_importContext _localctx = new Single_importContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_single_import);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(IMPORT);
			setState(49);
			((Single_importContext)_localctx).lib = match(LIB);
			setState(50);
			match(SC);
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

	public static class Code_blocContext extends ParserRuleContext {
		public Dec_classContext dec_class() {
			return getRuleContext(Dec_classContext.class,0);
		}
		public Code_blocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_bloc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitCode_bloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_blocContext code_bloc() throws RecognitionException {
		Code_blocContext _localctx = new Code_blocContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_code_bloc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			dec_class();
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

	public static class Dec_classContext extends ParserRuleContext {
		public TerminalNode MODIF() { return getToken(Small_JavaParser.MODIF, 0); }
		public TerminalNode CLASS() { return getToken(Small_JavaParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(Small_JavaParser.ID, 0); }
		public TerminalNode LCB() { return getToken(Small_JavaParser.LCB, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode RCB() { return getToken(Small_JavaParser.RCB, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public Dec_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_class; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitDec_class(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dec_classContext dec_class() throws RecognitionException {
		Dec_classContext _localctx = new Dec_classContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dec_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(MODIF);
			setState(55);
			match(CLASS);
			setState(56);
			match(ID);
			setState(57);
			match(LCB);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(58);
				dec();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			func();
			setState(65);
			match(RCB);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(Small_JavaParser.MAIN, 0); }
		public TerminalNode LCB() { return getToken(Small_JavaParser.LCB, 0); }
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public TerminalNode RCB() { return getToken(Small_JavaParser.RCB, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(MAIN);
			setState(68);
			match(LCB);
			setState(69);
			instructions();
			setState(70);
			match(RCB);
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

	public static class ConditionContext extends ParserRuleContext {
		public InstructionsContext then;
		public InstructionsContext els;
		public TerminalNode IF() { return getToken(Small_JavaParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Small_JavaParser.LPAREN, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Small_JavaParser.RPAREN, 0); }
		public TerminalNode THEN() { return getToken(Small_JavaParser.THEN, 0); }
		public List<TerminalNode> LCB() { return getTokens(Small_JavaParser.LCB); }
		public TerminalNode LCB(int i) {
			return getToken(Small_JavaParser.LCB, i);
		}
		public List<TerminalNode> RCB() { return getTokens(Small_JavaParser.RCB); }
		public TerminalNode RCB(int i) {
			return getToken(Small_JavaParser.RCB, i);
		}
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Small_JavaParser.ELSE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(IF);
			setState(73);
			match(LPAREN);
			setState(74);
			cond(0);
			setState(75);
			match(RPAREN);
			setState(76);
			match(THEN);
			setState(77);
			match(LCB);
			setState(78);
			((ConditionContext)_localctx).then = instructions();
			setState(79);
			match(RCB);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(80);
				match(ELSE);
				setState(81);
				match(LCB);
				setState(82);
				((ConditionContext)_localctx).els = instructions();
				setState(83);
				match(RCB);
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

	public static class InstructionsContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instructions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << READ) | (1L << WRITE) | (1L << ID))) != 0)) {
				{
				{
				setState(87);
				instruction();
				}
				}
				setState(92);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext left;
		public Token not;
		public CondContext notval;
		public CondContext compval;
		public Token op;
		public CondContext right;
		public TerminalNode NOT() { return getToken(Small_JavaParser.NOT, 0); }
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(Small_JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Small_JavaParser.RPAREN, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode AND() { return getToken(Small_JavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(Small_JavaParser.OR, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(94);
				((CondContext)_localctx).not = match(NOT);
				setState(95);
				((CondContext)_localctx).notval = cond(5);
				}
				break;
			case 2:
				{
				setState(96);
				match(LPAREN);
				setState(97);
				((CondContext)_localctx).compval = cond(0);
				setState(98);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(100);
				comp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						((CondContext)_localctx).op = match(AND);
						setState(105);
						((CondContext)_localctx).right = cond(5);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						((CondContext)_localctx).op = match(OR);
						setState(108);
						((CondContext)_localctx).right = cond(4);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class CompContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(Small_JavaParser.GT, 0); }
		public TerminalNode LT() { return getToken(Small_JavaParser.LT, 0); }
		public TerminalNode GTE() { return getToken(Small_JavaParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(Small_JavaParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(Small_JavaParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(Small_JavaParser.NEQ, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			((CompContext)_localctx).left = expression(0);
			setState(115);
			((CompContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
				((CompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			((CompContext)_localctx).right = expression(0);
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

	public static class InstructionContext extends ParserRuleContext {
		public MovContext mov() {
			return getRuleContext(MovContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instruction);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				mov();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				condition();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				read();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				write();
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(Small_JavaParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(Small_JavaParser.LPAREN, 0); }
		public Read_expressionContext read_expression() {
			return getRuleContext(Read_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Small_JavaParser.RPAREN, 0); }
		public TerminalNode SC() { return getToken(Small_JavaParser.SC, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(READ);
			setState(125);
			match(LPAREN);
			setState(126);
			read_expression();
			setState(127);
			match(RPAREN);
			setState(128);
			match(SC);
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

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(Small_JavaParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(Small_JavaParser.LPAREN, 0); }
		public Write_expressionContext write_expression() {
			return getRuleContext(Write_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Small_JavaParser.RPAREN, 0); }
		public TerminalNode SC() { return getToken(Small_JavaParser.SC, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(WRITE);
			setState(131);
			match(LPAREN);
			setState(132);
			write_expression();
			setState(133);
			match(RPAREN);
			setState(134);
			match(SC);
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

	public static class Read_expressionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Small_JavaParser.STRING, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Small_JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Small_JavaParser.COMMA, i);
		}
		public List<TerminalNode> ID() { return getTokens(Small_JavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Small_JavaParser.ID, i);
		}
		public Read_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitRead_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_expressionContext read_expression() throws RecognitionException {
		Read_expressionContext _localctx = new Read_expressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_read_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(STRING);
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(137);
				match(COMMA);
				setState(138);
				match(ID);
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
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

	public static class Write_expressionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Small_JavaParser.STRING, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Small_JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Small_JavaParser.COMMA, i);
		}
		public List<TerminalNode> ID() { return getTokens(Small_JavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Small_JavaParser.ID, i);
		}
		public Write_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitWrite_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_expressionContext write_expression() throws RecognitionException {
		Write_expressionContext _localctx = new Write_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_write_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(STRING);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(144);
				match(COMMA);
				setState(145);
				match(ID);
				}
				}
				setState(150);
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

	public static class DecContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(Small_JavaParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(Small_JavaParser.ID, 0); }
		public TerminalNode SC() { return getToken(Small_JavaParser.SC, 0); }
		public TerminalNode MOV() { return getToken(Small_JavaParser.MOV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(Small_JavaParser.STRING, 0); }
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dec);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(TYPE);
				setState(152);
				match(ID);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MOV) {
					{
					setState(153);
					match(MOV);
					setState(154);
					expression(0);
					}
				}

				setState(157);
				match(SC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(TYPE);
				setState(159);
				match(ID);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MOV) {
					{
					setState(160);
					match(MOV);
					setState(161);
					match(STRING);
					}
				}

				setState(164);
				match(SC);
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

	public static class MovContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Small_JavaParser.ID, 0); }
		public TerminalNode MOV() { return getToken(Small_JavaParser.MOV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SC() { return getToken(Small_JavaParser.SC, 0); }
		public TerminalNode STRING() { return getToken(Small_JavaParser.STRING, 0); }
		public MovContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mov; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitMov(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovContext mov() throws RecognitionException {
		MovContext _localctx = new MovContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mov);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(ID);
				setState(168);
				match(MOV);
				setState(169);
				expression(0);
				setState(170);
				match(SC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(ID);
				setState(173);
				match(MOV);
				setState(174);
				match(STRING);
				setState(175);
				match(SC);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext evalue;
		public Token op;
		public AtomContext avalue;
		public ExpressionContext right;
		public TerminalNode LPAREN() { return getToken(Small_JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Small_JavaParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TerminalNode> PLUS() { return getTokens(Small_JavaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Small_JavaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Small_JavaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Small_JavaParser.MINUS, i);
		}
		public TerminalNode TIMES() { return getToken(Small_JavaParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(Small_JavaParser.DIV, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(179);
				match(LPAREN);
				setState(180);
				((ExpressionContext)_localctx).evalue = expression(0);
				setState(181);
				match(RPAREN);
				}
				break;
			case FLOAT_NUMBER:
			case INT_NUMBER:
			case PLUS:
			case MINUS:
			case ID:
				{
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS || _la==MINUS) {
					{
					{
					setState(183);
					((ExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				((ExpressionContext)_localctx).avalue = atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(193);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(196);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						((ExpressionContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public Token content;
		public TerminalNode ID() { return getToken(Small_JavaParser.ID, 0); }
		public TerminalNode INT_NUMBER() { return getToken(Small_JavaParser.INT_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(Small_JavaParser.FLOAT_NUMBER, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Small_JavaVisitor ) return ((Small_JavaVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atom);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((AtomContext)_localctx).content = match(ID);
				}
				break;
			case INT_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				((AtomContext)_localctx).content = match(INT_NUMBER);
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				((AtomContext)_localctx).content = match(FLOAT_NUMBER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 17:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00d3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\bX\n\b\3\t\7\t[\n\t\f\t\16\t^\13\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\nh\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f}\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\6\17\u008e\n\17\r\17\16\17\u008f"+
		"\3\20\3\20\3\20\7\20\u0095\n\20\f\20\16\20\u0098\13\20\3\21\3\21\3\21"+
		"\3\21\5\21\u009e\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a5\n\21\3\21\5"+
		"\21\u00a8\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b3"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00bb\n\23\f\23\16\23\u00be\13"+
		"\23\3\23\5\23\u00c1\n\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c9\n\23"+
		"\f\23\16\23\u00cc\13\23\3\24\3\24\3\24\5\24\u00d1\n\24\3\24\2\4\22$\25"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3\2\23\30\3\2\17\20\3"+
		"\2\21\22\2\u00d6\2(\3\2\2\2\4/\3\2\2\2\6\62\3\2\2\2\b\66\3\2\2\2\n8\3"+
		"\2\2\2\fE\3\2\2\2\16J\3\2\2\2\20\\\3\2\2\2\22g\3\2\2\2\24t\3\2\2\2\26"+
		"|\3\2\2\2\30~\3\2\2\2\32\u0084\3\2\2\2\34\u008a\3\2\2\2\36\u0091\3\2\2"+
		"\2 \u00a7\3\2\2\2\"\u00b2\3\2\2\2$\u00c0\3\2\2\2&\u00d0\3\2\2\2()\5\4"+
		"\3\2)*\5\b\5\2*+\7\2\2\3+\3\3\2\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2/-"+
		"\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\7\5\2\2\63\64\7\7"+
		"\2\2\64\65\7\35\2\2\65\7\3\2\2\2\66\67\5\n\6\2\67\t\3\2\2\289\7\6\2\2"+
		"9:\7\b\2\2:;\7\'\2\2;?\7\36\2\2<>\5 \21\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\5\f\7\2CD\7\37\2\2D\13\3\2\2\2EF\7"+
		"\t\2\2FG\7\36\2\2GH\5\20\t\2HI\7\37\2\2I\r\3\2\2\2JK\7 \2\2KL\7\r\2\2"+
		"LM\5\22\n\2MN\7\16\2\2NO\7\"\2\2OP\7\36\2\2PQ\5\20\t\2QW\7\37\2\2RS\7"+
		"!\2\2ST\7\36\2\2TU\5\20\t\2UV\7\37\2\2VX\3\2\2\2WR\3\2\2\2WX\3\2\2\2X"+
		"\17\3\2\2\2Y[\5\26\f\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\21\3"+
		"\2\2\2^\\\3\2\2\2_`\b\n\1\2`a\7\31\2\2ah\5\22\n\7bc\7\r\2\2cd\5\22\n\2"+
		"de\7\16\2\2eh\3\2\2\2fh\5\24\13\2g_\3\2\2\2gb\3\2\2\2gf\3\2\2\2hq\3\2"+
		"\2\2ij\f\6\2\2jk\7\32\2\2kp\5\22\n\7lm\f\5\2\2mn\7\33\2\2np\5\22\n\6o"+
		"i\3\2\2\2ol\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\23\3\2\2\2sq\3\2\2"+
		"\2tu\5$\23\2uv\t\2\2\2vw\5$\23\2w\25\3\2\2\2x}\5\"\22\2y}\5\16\b\2z}\5"+
		"\30\r\2{}\5\32\16\2|x\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\27\3\2\2"+
		"\2~\177\7#\2\2\177\u0080\7\r\2\2\u0080\u0081\5\34\17\2\u0081\u0082\7\16"+
		"\2\2\u0082\u0083\7\35\2\2\u0083\31\3\2\2\2\u0084\u0085\7$\2\2\u0085\u0086"+
		"\7\r\2\2\u0086\u0087\5\36\20\2\u0087\u0088\7\16\2\2\u0088\u0089\7\35\2"+
		"\2\u0089\33\3\2\2\2\u008a\u008d\7&\2\2\u008b\u008c\7\n\2\2\u008c\u008e"+
		"\7\'\2\2\u008d\u008b\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\35\3\2\2\2\u0091\u0096\7&\2\2\u0092\u0093\7\n\2\2"+
		"\u0093\u0095\7\'\2\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\37\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009a\7\13\2\2\u009a\u009d\7\'\2\2\u009b\u009c\7\f\2\2\u009c\u009e\5"+
		"$\23\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a8\7\35\2\2\u00a0\u00a1\7\13\2\2\u00a1\u00a4\7\'\2\2\u00a2\u00a3\7"+
		"\f\2\2\u00a3\u00a5\7&\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a8\7\35\2\2\u00a7\u0099\3\2\2\2\u00a7\u00a0\3"+
		"\2\2\2\u00a8!\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\u00ab\7\f\2\2\u00ab\u00ac"+
		"\5$\23\2\u00ac\u00ad\7\35\2\2\u00ad\u00b3\3\2\2\2\u00ae\u00af\7\'\2\2"+
		"\u00af\u00b0\7\f\2\2\u00b0\u00b1\7&\2\2\u00b1\u00b3\7\35\2\2\u00b2\u00a9"+
		"\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3#\3\2\2\2\u00b4\u00b5\b\23\1\2\u00b5"+
		"\u00b6\7\r\2\2\u00b6\u00b7\5$\23\2\u00b7\u00b8\7\16\2\2\u00b8\u00c1\3"+
		"\2\2\2\u00b9\u00bb\t\3\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00c1\5&\24\2\u00c0\u00b4\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c1"+
		"\u00ca\3\2\2\2\u00c2\u00c3\f\6\2\2\u00c3\u00c4\t\4\2\2\u00c4\u00c9\5$"+
		"\23\7\u00c5\u00c6\f\5\2\2\u00c6\u00c7\t\3\2\2\u00c7\u00c9\5$\23\6\u00c8"+
		"\u00c2\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb%\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00d1"+
		"\7\'\2\2\u00ce\u00d1\7\4\2\2\u00cf\u00d1\7\3\2\2\u00d0\u00cd\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\'\3\2\2\2\25/?W\\goq|\u008f\u0096"+
		"\u009d\u00a4\u00a7\u00b2\u00bc\u00c0\u00c8\u00ca\u00d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}