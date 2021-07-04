//Alunos: Gabriel Vaz, Márcio Góes, Matheus Zanon
//Matriculas: 17111238, 16105078, 16105090
//Email: {Gabriel.vaz, Marcio.goes, Matheus.zanon}@edu.pucrs.br


/* The following code was generated by JFlex 1.4.3 on 5/27/21, 8:31 AM */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/27/21, 8:31 AM from the specification file
 * <tt>exemploSem.flex</tt>
 */
class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
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
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\47\1\2\2\0\1\3\22\0\1\47\1\0\1\46\1\0"+
    "\1\4\1\0\1\21\1\0\1\20\1\20\1\20\1\20\1\20\3\0"+
    "\12\1\1\44\1\20\1\0\1\20\1\20\1\0\1\43\1\7\1\45"+
    "\1\10\1\45\1\11\1\15\6\45\1\16\1\14\1\13\2\45\1\6"+
    "\1\17\1\5\6\45\1\20\1\0\1\20\1\0\1\12\1\0\1\40"+
    "\1\30\1\42\1\25\1\32\1\41\1\35\1\45\1\22\2\45\1\31"+
    "\1\37\1\23\1\26\2\45\1\34\1\33\1\24\1\27\1\36\4\45"+
    "\1\20\1\0\1\20\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\1\1\4\1\5\1\1"+
    "\6\4\2\1\1\6\2\0\1\7\1\4\1\10\5\4"+
    "\2\0\1\11\2\0\1\12\5\4\3\0\1\4\1\13"+
    "\2\4\1\14\1\15\3\0\3\4\3\0\1\16\1\17"+
    "\1\20\7\0\1\21\3\0\1\22\1\23\1\0\1\24";

  private static int [] zzUnpackAction() {
    int [] result = new int[75];
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
    "\0\0\0\50\0\120\0\50\0\170\0\240\0\310\0\50"+
    "\0\360\0\u0118\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208"+
    "\0\u0230\0\u0258\0\u0280\0\u02a8\0\50\0\u02d0\0\310\0\u02f8"+
    "\0\u0320\0\u0348\0\u0370\0\u0398\0\u03c0\0\u0230\0\50\0\u03e8"+
    "\0\u0410\0\310\0\u0438\0\u0460\0\u0488\0\u04b0\0\u04d8\0\u0500"+
    "\0\u0528\0\u0550\0\u0578\0\310\0\u05a0\0\u05c8\0\310\0\310"+
    "\0\u05f0\0\u0618\0\u0640\0\u0668\0\u0690\0\u06b8\0\u06e0\0\u0708"+
    "\0\u0730\0\310\0\310\0\310\0\u0758\0\u0780\0\u07a8\0\u07d0"+
    "\0\u07f8\0\u0820\0\u0848\0\50\0\u0870\0\u0898\0\u08c0\0\50"+
    "\0\50\0\u08e8\0\50";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[75];
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
    "\1\2\1\3\1\4\1\5\1\6\5\7\1\2\5\7"+
    "\1\10\1\11\1\12\2\7\1\13\2\7\1\14\2\7"+
    "\1\15\2\7\1\16\1\17\3\7\1\20\1\2\1\7"+
    "\1\21\1\22\51\0\1\3\50\0\1\4\52\0\1\23"+
    "\10\0\1\24\32\0\1\7\3\0\13\7\2\0\21\7"+
    "\2\0\1\7\23\0\1\25\27\0\1\7\3\0\13\7"+
    "\2\0\1\7\1\26\15\7\1\27\1\7\2\0\1\7"+
    "\3\0\1\7\3\0\13\7\2\0\4\7\1\30\14\7"+
    "\2\0\1\7\3\0\1\7\3\0\13\7\2\0\4\7"+
    "\1\31\14\7\2\0\1\7\3\0\1\7\3\0\13\7"+
    "\2\0\2\7\1\32\16\7\2\0\1\7\3\0\1\7"+
    "\3\0\13\7\2\0\4\7\1\33\14\7\2\0\1\7"+
    "\3\0\1\7\3\0\13\7\2\0\16\7\1\34\2\7"+
    "\2\0\1\7\43\0\1\35\6\0\46\36\1\37\1\36"+
    "\47\0\1\22\6\0\1\40\54\0\1\41\35\0\1\7"+
    "\3\0\13\7\2\0\2\7\1\42\16\7\2\0\1\7"+
    "\3\0\1\7\3\0\13\7\2\0\5\7\1\43\13\7"+
    "\2\0\1\7\3\0\1\7\3\0\13\7\2\0\4\7"+
    "\1\44\14\7\2\0\1\7\3\0\1\7\3\0\13\7"+
    "\2\0\12\7\1\45\6\7\2\0\1\7\3\0\1\7"+
    "\3\0\13\7\2\0\1\46\20\7\2\0\1\7\3\0"+
    "\1\7\3\0\13\7\2\0\1\47\20\7\2\0\1\7"+
    "\31\0\1\50\27\0\1\51\57\0\1\52\31\0\1\7"+
    "\3\0\13\7\2\0\6\7\1\53\12\7\2\0\1\7"+
    "\3\0\1\7\3\0\13\7\2\0\7\7\1\54\11\7"+
    "\2\0\1\7\3\0\1\7\3\0\13\7\2\0\1\55"+
    "\4\7\1\56\13\7\2\0\1\7\3\0\1\7\3\0"+
    "\13\7\2\0\3\7\1\57\15\7\2\0\1\7\3\0"+
    "\1\7\3\0\13\7\2\0\1\7\1\60\17\7\2\0"+
    "\1\7\25\0\1\61\34\0\1\62\44\0\1\63\43\0"+
    "\1\7\3\0\13\7\2\0\7\7\1\64\11\7\2\0"+
    "\1\7\3\0\1\7\3\0\13\7\2\0\1\7\1\65"+
    "\17\7\2\0\1\7\3\0\1\7\3\0\13\7\2\0"+
    "\20\7\1\66\2\0\1\7\44\0\1\67\16\0\1\70"+
    "\44\0\1\71\42\0\1\7\3\0\13\7\2\0\10\7"+
    "\1\72\10\7\2\0\1\7\3\0\1\7\3\0\13\7"+
    "\2\0\13\7\1\73\5\7\2\0\1\7\3\0\1\7"+
    "\3\0\13\7\2\0\2\7\1\74\16\7\2\0\1\7"+
    "\26\0\1\75\35\0\1\76\44\0\1\77\62\0\1\100"+
    "\40\0\1\101\46\0\1\102\63\0\1\103\35\0\1\104"+
    "\1\105\37\0\1\106\65\0\1\107\41\0\1\110\51\0"+
    "\1\111\63\0\1\112\60\0\1\113\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2320];
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\3\1\1\11\12\1\2\0"+
    "\1\11\7\1\2\0\1\11\2\0\6\1\3\0\6\1"+
    "\3\0\3\1\3\0\3\1\7\0\1\11\3\0\2\11"+
    "\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[75];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
    yyline = 1;
  }


  public int getLine() {
      return yyline;
  }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 148) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 15: 
          { return Parser.STRING;
          }
        case 21: break;
        case 8: 
          { return Parser.IF;
          }
        case 22: break;
        case 3: 
          { yyline++;
          }
        case 23: break;
        case 4: 
          { yyparser.yylval = new ParserVal(yytext());
                     return Parser.IDENT;
          }
        case 24: break;
        case 17: 
          { yyparser.setDebug(true);
          }
        case 25: break;
        case 16: 
          { return Parser.STRUCT;
          }
        case 26: break;
        case 11: 
          { return Parser.BOOL;
          }
        case 27: break;
        case 13: 
          { return Parser.MAIN;
          }
        case 28: break;
        case 7: 
          { return Parser.AND;
          }
        case 29: break;
        case 5: 
          { return (int) yycharat(0);
          }
        case 30: break;
        case 18: 
          { yyparser.setDebug(false);
          }
        case 31: break;
        case 19: 
          { yyparser.listarTS();
          }
        case 32: break;
        case 14: 
          { return Parser.DOUBLE;
          }
        case 33: break;
        case 12: 
          { return Parser.VOID;
          }
        case 34: break;
        case 9: 
          { yyparser.yylval = new ParserVal(yytext());
             return Parser.LITERAL;
          }
        case 35: break;
        case 10: 
          { return Parser.INT;
          }
        case 36: break;
        case 20: 
          { return Parser.FUNC;
          }
        case 37: break;
        case 1: 
          { System.err.println("Error: unexpected character '"+yytext()+"' na linha "+yyline); return YYEOF;
          }
        case 38: break;
        case 2: 
          { yyparser.yylval = new ParserVal(Integer.parseInt(yytext())); 
         return Parser.NUM;
          }
        case 39: break;
        case 6: 
          { 
          }
        case 40: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
