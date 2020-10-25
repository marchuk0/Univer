// Generated from /home/olexander/important/cyb/university/III/OOP/lab1/src/main/antrl4.com.marchuk0.lab1/SpreadSheet.g4 by ANTLR 4.8
package com.marchuk0.lab1.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpreadSheetParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, POW=2, MUL=3, DIV=4, ADD=5, SUB=6, LPAR=7, RPAR=8, INC=9, DEC=10, 
		MMIN=11, MMAX=12, ARGSEPARATOP=13, NUMBER=14, WHITESPACE=15;
	public static final int
		RULE_formula = 0, RULE_expression = 1, RULE_minargs = 2, RULE_maxargs = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "expression", "minargs", "maxargs"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'^'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'inc'", 
			"'dec'", "'mmin'", "'mmax'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "POW", "MUL", "DIV", "ADD", "SUB", "LPAR", "RPAR", "INC", 
			"DEC", "MMIN", "MMAX", "ARGSEPARATOP", "NUMBER", "WHITESPACE"
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
	public String getGrammarFileName() { return "SpreadSheet.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpreadSheetParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FormulaContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SpreadSheetParser.EOF, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(T__0);
			setState(9);
			expression(0);
			setState(10);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinimumContext extends ExpressionContext {
		public Token operator;
		public MinargsContext inner;
		public TerminalNode LPAR() { return getToken(SpreadSheetParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SpreadSheetParser.RPAR, 0); }
		public TerminalNode MMIN() { return getToken(SpreadSheetParser.MMIN, 0); }
		public MinargsContext minargs() {
			return getRuleContext(MinargsContext.class,0);
		}
		public MinimumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterMinimum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitMinimum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitMinimum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaximumContext extends ExpressionContext {
		public Token operator;
		public MaxargsContext inner;
		public TerminalNode LPAR() { return getToken(SpreadSheetParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SpreadSheetParser.RPAR, 0); }
		public TerminalNode MMAX() { return getToken(SpreadSheetParser.MMAX, 0); }
		public MaxargsContext maxargs() {
			return getRuleContext(MaxargsContext.class,0);
		}
		public MaximumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterMaximum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitMaximum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitMaximum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(SpreadSheetParser.MUL, 0); }
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SpreadSheetParser.ADD, 0); }
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SUB() { return getToken(SpreadSheetParser.SUB, 0); }
		public SubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(SpreadSheetParser.NUMBER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(SpreadSheetParser.DIV, 0); }
		public DivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesesContext extends ExpressionContext {
		public ExpressionContext inner;
		public TerminalNode LPAR() { return getToken(SpreadSheetParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SpreadSheetParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode POW() { return getToken(SpreadSheetParser.POW, 0); }
		public PowerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitPower(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(13);
				match(NUMBER);
				}
				break;
			case LPAR:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				match(LPAR);
				setState(15);
				((ParenthesesContext)_localctx).inner = expression(0);
				setState(16);
				match(RPAR);
				}
				break;
			case MMIN:
				{
				_localctx = new MinimumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				((MinimumContext)_localctx).operator = match(MMIN);
				setState(19);
				match(LPAR);
				setState(20);
				((MinimumContext)_localctx).inner = minargs();
				setState(21);
				match(RPAR);
				}
				break;
			case MMAX:
				{
				_localctx = new MaximumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				((MaximumContext)_localctx).operator = match(MMAX);
				setState(24);
				match(LPAR);
				setState(25);
				((MaximumContext)_localctx).inner = maxargs();
				setState(26);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(45);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExpressionContext(_parentctx, _parentState));
						((PowerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(30);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(31);
						((PowerContext)_localctx).operator = match(POW);
						setState(32);
						((PowerContext)_localctx).right = expression(6);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						((MultiplicationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						((MultiplicationContext)_localctx).operator = match(MUL);
						setState(35);
						((MultiplicationContext)_localctx).right = expression(5);
						}
						break;
					case 3:
						{
						_localctx = new DivisionContext(new ExpressionContext(_parentctx, _parentState));
						((DivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(36);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(37);
						((DivisionContext)_localctx).operator = match(DIV);
						setState(38);
						((DivisionContext)_localctx).right = expression(4);
						}
						break;
					case 4:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						((AdditionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(39);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(40);
						((AdditionContext)_localctx).operator = match(ADD);
						setState(41);
						((AdditionContext)_localctx).right = expression(3);
						}
						break;
					case 5:
						{
						_localctx = new SubtractionContext(new ExpressionContext(_parentctx, _parentState));
						((SubtractionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(42);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(43);
						((SubtractionContext)_localctx).operator = match(SUB);
						setState(44);
						((SubtractionContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(49);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MinargsContext extends ParserRuleContext {
		public MinargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minargs; }
	 
		public MinargsContext() { }
		public void copyFrom(MinargsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleMinArgsContext extends MinargsContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleMinArgsContext(MinargsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterSimpleMinArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitSimpleMinArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitSimpleMinArgs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecursiveMinArgsContext extends MinargsContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ARGSEPARATOP() { return getToken(SpreadSheetParser.ARGSEPARATOP, 0); }
		public MinargsContext minargs() {
			return getRuleContext(MinargsContext.class,0);
		}
		public RecursiveMinArgsContext(MinargsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterRecursiveMinArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitRecursiveMinArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitRecursiveMinArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinargsContext minargs() throws RecognitionException {
		MinargsContext _localctx = new MinargsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_minargs);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new SimpleMinArgsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				expression(0);
				}
				break;
			case 2:
				_localctx = new RecursiveMinArgsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				expression(0);
				setState(52);
				match(ARGSEPARATOP);
				setState(53);
				minargs();
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

	public static class MaxargsContext extends ParserRuleContext {
		public MaxargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxargs; }
	 
		public MaxargsContext() { }
		public void copyFrom(MaxargsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleMaxArgsContext extends MaxargsContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleMaxArgsContext(MaxargsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterSimpleMaxArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitSimpleMaxArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitSimpleMaxArgs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecursiveMAxArgsContext extends MaxargsContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ARGSEPARATOP() { return getToken(SpreadSheetParser.ARGSEPARATOP, 0); }
		public MaxargsContext maxargs() {
			return getRuleContext(MaxargsContext.class,0);
		}
		public RecursiveMAxArgsContext(MaxargsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).enterRecursiveMAxArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpreadSheetListener ) ((SpreadSheetListener)listener).exitRecursiveMAxArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpreadSheetVisitor ) return ((SpreadSheetVisitor<? extends T>)visitor).visitRecursiveMAxArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxargsContext maxargs() throws RecognitionException {
		MaxargsContext _localctx = new MaxargsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_maxargs);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SimpleMaxArgsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				expression(0);
				}
				break;
			case 2:
				_localctx = new RecursiveMAxArgsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				expression(0);
				setState(59);
				match(ARGSEPARATOP);
				setState(60);
				maxargs();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
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
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3\3\4\3\4\3\4"+
		"\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\5\2\3\4\6\2\4\6\b\2\2"+
		"\2H\2\n\3\2\2\2\4\36\3\2\2\2\69\3\2\2\2\b@\3\2\2\2\n\13\7\3\2\2\13\f\5"+
		"\4\3\2\f\r\7\2\2\3\r\3\3\2\2\2\16\17\b\3\1\2\17\37\7\20\2\2\20\21\7\t"+
		"\2\2\21\22\5\4\3\2\22\23\7\n\2\2\23\37\3\2\2\2\24\25\7\r\2\2\25\26\7\t"+
		"\2\2\26\27\5\6\4\2\27\30\7\n\2\2\30\37\3\2\2\2\31\32\7\16\2\2\32\33\7"+
		"\t\2\2\33\34\5\b\5\2\34\35\7\n\2\2\35\37\3\2\2\2\36\16\3\2\2\2\36\20\3"+
		"\2\2\2\36\24\3\2\2\2\36\31\3\2\2\2\37\61\3\2\2\2 !\f\7\2\2!\"\7\4\2\2"+
		"\"\60\5\4\3\b#$\f\6\2\2$%\7\5\2\2%\60\5\4\3\7&\'\f\5\2\2\'(\7\6\2\2(\60"+
		"\5\4\3\6)*\f\4\2\2*+\7\7\2\2+\60\5\4\3\5,-\f\3\2\2-.\7\b\2\2.\60\5\4\3"+
		"\4/ \3\2\2\2/#\3\2\2\2/&\3\2\2\2/)\3\2\2\2/,\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\61\3\2\2\2\64:\5\4\3\2\65\66\5"+
		"\4\3\2\66\67\7\17\2\2\678\5\6\4\28:\3\2\2\29\64\3\2\2\29\65\3\2\2\2:\7"+
		"\3\2\2\2;A\5\4\3\2<=\5\4\3\2=>\7\17\2\2>?\5\b\5\2?A\3\2\2\2@;\3\2\2\2"+
		"@<\3\2\2\2A\t\3\2\2\2\7\36/\619@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}