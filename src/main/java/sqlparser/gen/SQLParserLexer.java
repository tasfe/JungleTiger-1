// Generated from /Volumes/udisk/Workshop/Java/JungleTiger/src/main/antlr4/SQLParser.g4 by ANTLR 4.2.2
package com.alex.jungletiger.sqlparser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParserLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, ID=21, NUM=22, STR=23, DSN=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'long'", "'not null'", "'on'", "')'", "'hash'", "','", "'node'", "':'", 
		"'('", "'create'", "'int'", "'split'", "'all'", "'range'", "'table'", 
		"'by'", "'key'", "'primary'", "'add'", "'char'", "ID", "NUM", "STR", "DSN", 
		"WS"
	};
	public static final String[] ruleNames = {
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "ID", "NUM", "STR", "DSN", "WS"
	};


	public SQLParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\7\26\u0094\n\26\f\26\16\26\u0097\13\26\3\27\6"+
		"\27\u009a\n\27\r\27\16\27\u009b\3\30\3\30\7\30\u00a0\n\30\f\30\16\30\u00a3"+
		"\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u00af\n"+
		"\31\f\31\16\31\u00b2\13\31\3\31\3\31\3\32\6\32\u00b7\n\32\r\32\16\32\u00b8"+
		"\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2"+
		"\b\3\2c|\4\2\62;c|\3\2\62;\7\2\60\60\62;^^aac|\t\2((\60<??A\\^^aac|\5"+
		"\2\13\f\17\17\"\"\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5:\3\2"+
		"\2\2\7C\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21T\3\2"+
		"\2\2\23V\3\2\2\2\25X\3\2\2\2\27_\3\2\2\2\31c\3\2\2\2\33i\3\2\2\2\35m\3"+
		"\2\2\2\37s\3\2\2\2!y\3\2\2\2#|\3\2\2\2%\u0080\3\2\2\2\'\u0088\3\2\2\2"+
		")\u008c\3\2\2\2+\u0091\3\2\2\2-\u0099\3\2\2\2/\u009d\3\2\2\2\61\u00a6"+
		"\3\2\2\2\63\u00b6\3\2\2\2\65\66\7n\2\2\66\67\7q\2\2\678\7p\2\289\7i\2"+
		"\29\4\3\2\2\2:;\7p\2\2;<\7q\2\2<=\7v\2\2=>\7\"\2\2>?\7p\2\2?@\7w\2\2@"+
		"A\7n\2\2AB\7n\2\2B\6\3\2\2\2CD\7q\2\2DE\7p\2\2E\b\3\2\2\2FG\7+\2\2G\n"+
		"\3\2\2\2HI\7j\2\2IJ\7c\2\2JK\7u\2\2KL\7j\2\2L\f\3\2\2\2MN\7.\2\2N\16\3"+
		"\2\2\2OP\7p\2\2PQ\7q\2\2QR\7f\2\2RS\7g\2\2S\20\3\2\2\2TU\7<\2\2U\22\3"+
		"\2\2\2VW\7*\2\2W\24\3\2\2\2XY\7e\2\2YZ\7t\2\2Z[\7g\2\2[\\\7c\2\2\\]\7"+
		"v\2\2]^\7g\2\2^\26\3\2\2\2_`\7k\2\2`a\7p\2\2ab\7v\2\2b\30\3\2\2\2cd\7"+
		"u\2\2de\7r\2\2ef\7n\2\2fg\7k\2\2gh\7v\2\2h\32\3\2\2\2ij\7c\2\2jk\7n\2"+
		"\2kl\7n\2\2l\34\3\2\2\2mn\7t\2\2no\7c\2\2op\7p\2\2pq\7i\2\2qr\7g\2\2r"+
		"\36\3\2\2\2st\7v\2\2tu\7c\2\2uv\7d\2\2vw\7n\2\2wx\7g\2\2x \3\2\2\2yz\7"+
		"d\2\2z{\7{\2\2{\"\3\2\2\2|}\7m\2\2}~\7g\2\2~\177\7{\2\2\177$\3\2\2\2\u0080"+
		"\u0081\7r\2\2\u0081\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083\u0084\7o\2\2"+
		"\u0084\u0085\7c\2\2\u0085\u0086\7t\2\2\u0086\u0087\7{\2\2\u0087&\3\2\2"+
		"\2\u0088\u0089\7c\2\2\u0089\u008a\7f\2\2\u008a\u008b\7f\2\2\u008b(\3\2"+
		"\2\2\u008c\u008d\7e\2\2\u008d\u008e\7j\2\2\u008e\u008f\7c\2\2\u008f\u0090"+
		"\7t\2\2\u0090*\3\2\2\2\u0091\u0095\t\2\2\2\u0092\u0094\t\3\2\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		",\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c.\3"+
		"\2\2\2\u009d\u00a1\7)\2\2\u009e\u00a0\t\5\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7)\2\2\u00a5\60\3\2\2\2\u00a6\u00a7"+
		"\7)\2\2\u00a7\u00a8\7l\2\2\u00a8\u00a9\7f\2\2\u00a9\u00aa\7d\2\2\u00aa"+
		"\u00ab\7e\2\2\u00ab\u00ac\7<\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af\t\6\2"+
		"\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7)\2\2\u00b4"+
		"\62\3\2\2\2\u00b5\u00b7\t\7\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb"+
		"\b\32\2\2\u00bb\64\3\2\2\2\b\2\u0095\u009b\u00a1\u00b0\u00b8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}