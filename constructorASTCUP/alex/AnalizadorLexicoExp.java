// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: AnalizadorLexicoExp.l

package alex;

import errors.GestionErroresExp;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class AnalizadorLexicoExp implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\10\0\2\1\1\2\2\0\1\1\22\0\1\1\1\3"+
    "\2\0\1\4\1\5\1\6\1\0\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\11\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\0\1\26\1\27\1\30"+
    "\3\27\1\31\2\27\1\32\4\27\1\33\3\27\1\34"+
    "\10\27\1\35\1\0\1\36\3\0\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\2\27\1\50"+
    "\1\51\1\52\1\53\1\54\1\27\1\55\1\56\1\57"+
    "\1\60\1\61\1\62\1\27\1\63\1\27\1\64\1\0"+
    "\1\65\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\2\16\1\17"+
    "\1\20\1\21\1\1\1\22\1\23\1\24\1\25\1\26"+
    "\16\24\1\27\1\30\1\31\1\0\1\2\3\0\1\32"+
    "\2\0\1\33\1\0\1\34\1\35\1\36\1\37\6\24"+
    "\1\40\16\24\1\41\1\42\1\43\1\44\1\0\1\45"+
    "\1\0\1\46\4\24\1\47\1\50\4\24\1\51\1\52"+
    "\2\24\1\53\1\54\10\24\1\0\1\55\1\56\1\24"+
    "\1\57\1\60\1\24\1\61\1\62\1\63\3\24\1\64"+
    "\3\24\1\65\2\24\1\0\10\24\1\66\1\24\1\67"+
    "\1\24\1\70\1\71\4\24\1\72\5\24\1\73\1\24"+
    "\1\74\1\24\1\75\1\76\3\24\1\77\1\100\1\24"+
    "\1\101\1\24\1\102\1\103";

  private static int [] zzUnpackAction() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\66\0\154\0\66\0\242\0\66\0\66"+
    "\0\66\0\330\0\u010e\0\u0144\0\66\0\u017a\0\u01b0\0\u01e6"+
    "\0\66\0\66\0\u021c\0\u0252\0\u0288\0\66\0\u02be\0\66"+
    "\0\66\0\u02f4\0\u032a\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438"+
    "\0\u046e\0\u04a4\0\u04da\0\u0510\0\u0546\0\u057c\0\u05b2\0\66"+
    "\0\66\0\66\0\u05e8\0\u061e\0\u0654\0\u068a\0\u06c0\0\66"+
    "\0\u06f6\0\u072c\0\u0762\0\u0798\0\66\0\66\0\66\0\u02be"+
    "\0\u07ce\0\u0804\0\u083a\0\u0870\0\u08a6\0\u08dc\0\u02be\0\u0912"+
    "\0\u0948\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u0a56\0\u0a8c\0\u0ac2"+
    "\0\u0af8\0\u0b2e\0\u0b64\0\u0b9a\0\u0bd0\0\66\0\66\0\66"+
    "\0\66\0\u0c06\0\66\0\u0c3c\0\u0798\0\u0c72\0\u0ca8\0\u0cde"+
    "\0\u0d14\0\u02be\0\u02be\0\u0d4a\0\u0d80\0\u0db6\0\u0dec\0\u02be"+
    "\0\u02be\0\u0e22\0\u0e58\0\u02be\0\u02be\0\u0e8e\0\u0ec4\0\u0efa"+
    "\0\u0f30\0\u0f66\0\u0f9c\0\u0fd2\0\u1008\0\u103e\0\66\0\u02be"+
    "\0\u1074\0\u02be\0\u02be\0\u10aa\0\u02be\0\u02be\0\u02be\0\u10e0"+
    "\0\u1116\0\u114c\0\u02be\0\u1182\0\u11b8\0\u11ee\0\u02be\0\u1224"+
    "\0\u125a\0\u1290\0\u12c6\0\u12fc\0\u1332\0\u1368\0\u139e\0\u13d4"+
    "\0\u140a\0\u1440\0\u02be\0\u1476\0\u02be\0\u14ac\0\u02be\0\u02be"+
    "\0\u14e2\0\u1518\0\u154e\0\u1584\0\u02be\0\u15ba\0\u15f0\0\u1626"+
    "\0\u165c\0\u1692\0\u02be\0\u16c8\0\u02be\0\u16fe\0\u02be\0\u02be"+
    "\0\u1734\0\u176a\0\u17a0\0\u02be\0\u02be\0\u17d6\0\u02be\0\u180c"+
    "\0\u02be\0\u02be";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\2\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\6\27\1\30"+
    "\1\31\1\32\1\33\1\27\1\34\1\35\1\36\2\27"+
    "\1\37\1\40\1\41\1\42\1\27\1\43\1\44\1\27"+
    "\1\45\1\27\1\46\1\47\1\27\1\50\1\51\112\0"+
    "\1\52\55\0\1\53\62\0\1\54\2\0\1\55\65\0"+
    "\1\56\65\0\1\57\3\0\1\20\4\0\1\60\51\0"+
    "\1\61\2\0\1\62\1\0\1\63\62\0\1\64\65\0"+
    "\1\64\3\0\2\20\71\0\1\65\65\0\1\66\65\0"+
    "\1\67\60\0\2\27\6\0\6\27\2\0\25\27\21\0"+
    "\2\27\6\0\6\27\2\0\17\27\1\70\5\27\21\0"+
    "\2\27\6\0\6\27\2\0\14\27\1\71\10\27\21\0"+
    "\2\27\6\0\6\27\2\0\4\27\1\72\20\27\21\0"+
    "\2\27\6\0\6\27\2\0\11\27\1\73\13\27\21\0"+
    "\2\27\6\0\6\27\2\0\1\74\13\27\1\75\4\27"+
    "\1\76\3\27\21\0\2\27\6\0\6\27\2\0\5\27"+
    "\1\77\5\27\1\100\11\27\21\0\2\27\6\0\6\27"+
    "\2\0\10\27\1\101\3\27\1\102\10\27\21\0\2\27"+
    "\6\0\6\27\2\0\1\103\24\27\21\0\2\27\6\0"+
    "\6\27\2\0\4\27\1\104\14\27\1\105\3\27\21\0"+
    "\2\27\6\0\6\27\2\0\14\27\1\106\10\27\21\0"+
    "\2\27\6\0\6\27\2\0\4\27\1\107\3\27\1\110"+
    "\14\27\21\0\2\27\6\0\6\27\2\0\14\27\1\111"+
    "\7\27\1\112\21\0\2\27\6\0\6\27\2\0\14\27"+
    "\1\113\10\27\21\0\2\27\6\0\6\27\2\0\7\27"+
    "\1\114\6\27\1\115\6\27\27\0\1\116\40\0\2\54"+
    "\1\0\63\54\25\0\1\117\65\0\1\120\65\0\1\121"+
    "\51\0\1\122\101\0\1\123\54\0\1\124\70\0\1\64"+
    "\1\125\64\0\2\27\6\0\6\27\2\0\14\27\1\126"+
    "\10\27\21\0\2\27\6\0\6\27\2\0\11\27\1\127"+
    "\13\27\21\0\2\27\6\0\6\27\2\0\17\27\1\130"+
    "\5\27\21\0\2\27\6\0\6\27\2\0\2\27\1\131"+
    "\22\27\21\0\2\27\6\0\6\27\2\0\16\27\1\132"+
    "\6\27\21\0\2\27\6\0\6\27\2\0\13\27\1\133"+
    "\11\27\21\0\2\27\6\0\6\27\2\0\5\27\1\134"+
    "\17\27\21\0\2\27\6\0\6\27\2\0\17\27\1\135"+
    "\5\27\21\0\2\27\6\0\6\27\2\0\14\27\1\136"+
    "\10\27\21\0\2\27\6\0\6\27\2\0\10\27\1\137"+
    "\14\27\21\0\2\27\6\0\6\27\2\0\23\27\1\140"+
    "\1\27\21\0\2\27\6\0\6\27\2\0\12\27\1\141"+
    "\12\27\21\0\2\27\6\0\6\27\2\0\10\27\1\142"+
    "\14\27\21\0\2\27\6\0\6\27\2\0\1\143\4\27"+
    "\1\144\1\145\11\27\1\146\4\27\21\0\2\27\6\0"+
    "\6\27\2\0\1\147\24\27\21\0\2\27\6\0\2\27"+
    "\1\150\1\151\2\27\2\0\25\27\21\0\2\27\6\0"+
    "\6\27\2\0\15\27\1\152\7\27\21\0\2\27\6\0"+
    "\6\27\2\0\10\27\1\153\14\27\21\0\2\27\6\0"+
    "\6\27\2\0\10\27\1\154\14\27\21\0\2\27\6\0"+
    "\6\27\2\0\10\27\1\155\14\27\2\0\11\122\1\156"+
    "\54\122\25\0\1\157\57\0\2\27\6\0\6\27\2\0"+
    "\11\27\1\160\13\27\21\0\2\27\6\0\6\27\2\0"+
    "\4\27\1\161\20\27\21\0\2\27\6\0\6\27\2\0"+
    "\4\27\1\162\20\27\21\0\2\27\6\0\6\27\2\0"+
    "\20\27\1\163\4\27\21\0\2\27\6\0\6\27\2\0"+
    "\1\164\24\27\21\0\2\27\6\0\6\27\2\0\20\27"+
    "\1\165\4\27\21\0\2\27\6\0\6\27\2\0\15\27"+
    "\1\166\7\27\21\0\2\27\6\0\6\27\2\0\13\27"+
    "\1\167\11\27\21\0\2\27\6\0\6\27\2\0\13\27"+
    "\1\170\11\27\21\0\2\27\6\0\6\27\2\0\3\27"+
    "\1\171\21\27\21\0\2\27\6\0\6\27\2\0\21\27"+
    "\1\172\3\27\21\0\2\27\6\0\6\27\2\0\11\27"+
    "\1\173\13\27\21\0\2\27\6\0\6\27\2\0\11\27"+
    "\1\174\13\27\21\0\2\27\6\0\6\27\2\0\13\27"+
    "\1\175\11\27\21\0\2\27\6\0\6\27\2\0\4\27"+
    "\1\176\20\27\21\0\2\27\6\0\6\27\2\0\3\27"+
    "\1\177\21\27\21\0\2\27\6\0\6\27\2\0\11\27"+
    "\1\200\13\27\21\0\2\27\6\0\6\27\2\0\20\27"+
    "\1\201\4\27\13\0\1\202\73\0\2\27\6\0\6\27"+
    "\2\0\20\27\1\203\4\27\21\0\2\27\6\0\6\27"+
    "\2\0\2\27\1\204\22\27\21\0\2\27\6\0\6\27"+
    "\2\0\20\27\1\205\4\27\21\0\2\27\6\0\1\27"+
    "\1\206\2\27\1\207\1\210\2\0\25\27\21\0\2\27"+
    "\6\0\6\27\2\0\16\27\1\211\6\27\21\0\2\27"+
    "\6\0\6\27\2\0\14\27\1\212\10\27\21\0\2\27"+
    "\6\0\6\27\2\0\20\27\1\213\4\27\21\0\2\27"+
    "\6\0\6\27\2\0\3\27\1\214\21\27\21\0\2\27"+
    "\6\0\6\27\2\0\4\27\1\215\20\27\21\0\2\27"+
    "\6\0\6\27\2\0\4\27\1\216\20\27\20\0\1\3"+
    "\66\0\2\27\6\0\6\27\2\0\4\27\1\217\20\27"+
    "\21\0\2\27\6\0\6\27\2\0\20\27\1\220\4\27"+
    "\21\0\2\27\6\0\6\27\2\0\4\27\1\221\20\27"+
    "\21\0\2\27\6\0\6\27\2\0\14\27\1\222\10\27"+
    "\21\0\2\27\6\0\6\27\2\0\21\27\1\223\3\27"+
    "\21\0\2\27\6\0\6\27\2\0\10\27\1\224\14\27"+
    "\21\0\2\27\6\0\6\27\2\0\13\27\1\225\11\27"+
    "\21\0\2\27\6\0\6\27\2\0\1\226\24\27\21\0"+
    "\2\27\6\0\6\27\2\0\4\27\1\227\20\27\21\0"+
    "\2\27\6\0\1\27\1\230\2\27\1\231\1\232\2\0"+
    "\25\27\21\0\2\27\6\0\6\27\2\0\16\27\1\233"+
    "\6\27\21\0\2\27\6\0\6\27\2\0\14\27\1\234"+
    "\10\27\21\0\2\27\6\0\6\27\2\0\12\27\1\235"+
    "\12\27\21\0\2\27\6\0\6\27\2\0\1\236\24\27"+
    "\21\0\2\27\6\0\6\27\2\0\20\27\1\237\4\27"+
    "\21\0\2\27\6\0\6\27\2\0\5\27\1\240\17\27"+
    "\21\0\2\27\6\0\6\27\2\0\14\27\1\241\10\27"+
    "\21\0\2\27\6\0\6\27\2\0\21\27\1\242\3\27"+
    "\21\0\2\27\6\0\6\27\2\0\10\27\1\243\14\27"+
    "\21\0\2\27\6\0\6\27\2\0\11\27\1\244\13\27"+
    "\21\0\2\27\6\0\6\27\2\0\11\27\1\245\13\27"+
    "\21\0\2\27\6\0\6\27\2\0\14\27\1\246\10\27"+
    "\21\0\2\27\6\0\6\27\2\0\12\27\1\247\12\27"+
    "\21\0\2\27\6\0\6\27\2\0\1\250\24\27\21\0"+
    "\2\27\6\0\6\27\2\0\11\27\1\251\13\27\21\0"+
    "\2\27\6\0\6\27\2\0\11\27\1\252\13\27\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6210];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\1\1\3\11\3\1\1\11"+
    "\3\1\2\11\3\1\1\11\1\1\2\11\16\1\3\11"+
    "\1\0\1\1\3\0\1\11\2\0\1\1\1\0\3\11"+
    "\26\1\4\11\1\0\1\11\1\0\31\1\1\0\1\11"+
    "\22\1\1\0\50\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[170];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
  private ALexOperations ops;
  private GestionErroresExp errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresExp errores) {
   this.errores = errores;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexicoExp(java.io.Reader in) {
    ops = new ALexOperations(this);
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {   return ops.unidadEof();
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { errores.errorLexico(fila(),columna(),lexema());
            }
            // fall through
          case 68: break;
          case 2:
            { 
            }
            // fall through
          case 69: break;
          case 3:
            { return ops.unidadExclamacion();
            }
            // fall through
          case 70: break;
          case 4:
            { return ops.unidadDollar();
            }
            // fall through
          case 71: break;
          case 5:
            { return ops.unidadModulo();
            }
            // fall through
          case 72: break;
          case 6:
            { return ops.unidadAnd();
            }
            // fall through
          case 73: break;
          case 7:
            { return ops.unidadPAp();
            }
            // fall through
          case 74: break;
          case 8:
            { return ops.unidadPCierre();
            }
            // fall through
          case 75: break;
          case 9:
            { return ops.unidadMul();
            }
            // fall through
          case 76: break;
          case 10:
            { return ops.unidadSuma();
            }
            // fall through
          case 77: break;
          case 11:
            { return ops.unidadResta();
            }
            // fall through
          case 78: break;
          case 12:
            { return ops.unidadAcceso();
            }
            // fall through
          case 79: break;
          case 13:
            { return ops.unidadDiv();
            }
            // fall through
          case 80: break;
          case 14:
            { return ops.unidadEntero();
            }
            // fall through
          case 81: break;
          case 15:
            { return ops.unidadDosPuntos();
            }
            // fall through
          case 82: break;
          case 16:
            { return ops.unidadPuntoComa();
            }
            // fall through
          case 83: break;
          case 17:
            { return ops.unidadMenor();
            }
            // fall through
          case 84: break;
          case 18:
            { return ops.unidadMayor();
            }
            // fall through
          case 85: break;
          case 19:
            { return ops.unidadOr();
            }
            // fall through
          case 86: break;
          case 20:
            { return ops.unidadId();
            }
            // fall through
          case 87: break;
          case 21:
            { return ops.unidadCorcheteAp();
            }
            // fall through
          case 88: break;
          case 22:
            { return ops.unidadCorcheteCierre();
            }
            // fall through
          case 89: break;
          case 23:
            { return ops.unidadLlaveAp();
            }
            // fall through
          case 90: break;
          case 24:
            { return ops.unidadLlaveCierre();
            }
            // fall through
          case 91: break;
          case 25:
            { return ops.unidadDistinto();
            }
            // fall through
          case 92: break;
          case 26:
            { return ops.unidadAsignacion();
            }
            // fall through
          case 93: break;
          case 27:
            { return ops.unidadDivEnt();
            }
            // fall through
          case 94: break;
          case 28:
            { return ops.unidadMenorIg();
            }
            // fall through
          case 95: break;
          case 29:
            { return ops.unidadIgualIgual();
            }
            // fall through
          case 96: break;
          case 30:
            { return ops.unidadMayorIg();
            }
            // fall through
          case 97: break;
          case 31:
            { return ops.unidadAs();
            }
            // fall through
          case 98: break;
          case 32:
            { return ops.unidadIf();
            }
            // fall through
          case 99: break;
          case 33:
            { return ops.unidadModPrefijo();
            }
            // fall through
          case 100: break;
          case 34:
            { return ops.unidadMultiPrefijo();
            }
            // fall through
          case 101: break;
          case 35:
            { return ops.unidadSumaPrefijo();
            }
            // fall through
          case 102: break;
          case 36:
            { return ops.unidadRestaPrefijo();
            }
            // fall through
          case 103: break;
          case 37:
            { return ops.unidadDiviPrefijo();
            }
            // fall through
          case 104: break;
          case 38:
            { return ops.unidadReal();
            }
            // fall through
          case 105: break;
          case 39:
            { return ops.unidadFor();
            }
            // fall through
          case 106: break;
          case 40:
            { return ops.unidadFun();
            }
            // fall through
          case 107: break;
          case 41:
            { return ops.unidadNew();
            }
            // fall through
          case 108: break;
          case 42:
            { return ops.unidadNum();
            }
            // fall through
          case 109: break;
          case 43:
            { return ops.unidadRef();
            }
            // fall through
          case 110: break;
          case 44:
            { return ops.unidadReg();
            }
            // fall through
          case 111: break;
          case 45:
            { return ops.unidadDivEnteraPrefijo();
            }
            // fall through
          case 112: break;
          case 46:
            { return ops.unidadBool();
            }
            // fall through
          case 113: break;
          case 47:
            { return ops.unidadElse();
            }
            // fall through
          case 114: break;
          case 48:
            { return ops.unidadFact();
            }
            // fall through
          case 115: break;
          case 49:
            { return ops.unidadList();
            }
            // fall through
          case 116: break;
          case 50:
            { return ops.unidadLoop();
            }
            // fall through
          case 117: break;
          case 51:
            { return ops.unidadMain();
            }
            // fall through
          case 118: break;
          case 52:
            { return ops.unidadRial();
            }
            // fall through
          case 119: break;
          case 53:
            { return ops.unidadVoid();
            }
            // fall through
          case 120: break;
          case 54:
            { return ops.unidadToInt();
            }
            // fall through
          case 121: break;
          case 55:
            { return ops.unidadWhile();
            }
            // fall through
          case 122: break;
          case 56:
            { return ops.unidadDelete();
            }
            // fall through
          case 123: break;
          case 57:
            { return ops.unidadInFact();
            }
            // fall through
          case 124: break;
          case 58:
            { return ops.unidadReturn();
            }
            // fall through
          case 125: break;
          case 59:
            { return ops.unidadPointer();
            }
            // fall through
          case 126: break;
          case 60:
            { return ops.unidadReadNum();
            }
            // fall through
          case 127: break;
          case 61:
            { return ops.unidadToFloat();
            }
            // fall through
          case 128: break;
          case 62:
            { return ops.unidadTypedef();
            }
            // fall through
          case 129: break;
          case 63:
            { return ops.unidadReadBool();
            }
            // fall through
          case 130: break;
          case 64:
            { return ops.unidadReadRial();
            }
            // fall through
          case 131: break;
          case 65:
            { return ops.unidadWriteNum();
            }
            // fall through
          case 132: break;
          case 66:
            { return ops.unidadWriteBool();
            }
            // fall through
          case 133: break;
          case 67:
            { return ops.unidadWriteRial();
            }
            // fall through
          case 134: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}