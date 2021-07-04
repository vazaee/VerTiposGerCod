//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "exemploSem.y"
  import java.io.*;
//#line 19 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short IDENT=257;
public final static short INT=258;
public final static short DOUBLE=259;
public final static short BOOL=260;
public final static short NUM=261;
public final static short STRING=262;
public final static short LITERAL=263;
public final static short AND=264;
public final static short VOID=265;
public final static short MAIN=266;
public final static short IF=267;
public final static short STRUCT=268;
public final static short FUNC=269;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    4,    0,    3,    3,    5,    5,    9,    6,    6,   11,
   12,   12,    7,    7,   13,   13,   14,   14,   14,   17,
    8,    8,   10,   10,   18,    1,    1,    1,    1,   16,
   19,   15,   15,   20,   21,   20,   20,   20,    2,    2,
    2,    2,    2,    2,    2,    2,    2,    2,    2,   22,
   22,
};
final static short yylen[] = {                            2,
    0,    4,    2,    0,    2,    0,    0,    5,    1,    6,
    2,    0,    9,    1,    1,    1,    3,    1,    0,    2,
    4,    0,    3,    1,    1,    1,    1,    1,    1,    6,
    3,    2,    0,    4,    0,    6,    4,    5,    3,    3,
    3,    3,    1,    3,    1,    3,    4,    3,    4,    3,
    1,
};
final static short yydefred[] = {                         1,
    0,    4,    0,   29,   26,   27,   28,    0,    6,    7,
    3,    9,    0,    0,    0,   12,    0,   15,    5,    0,
   14,    0,    0,    0,    0,    0,    0,   25,    0,   24,
    0,   11,    0,    0,    0,    8,    0,   10,    4,    0,
    0,    0,   21,   23,    0,   20,    4,    0,   33,   30,
    0,   17,    0,   33,    0,    0,   31,   32,    0,    0,
    0,    0,   13,    0,   43,    0,    0,    0,    0,    0,
    0,    0,    0,   37,    0,    0,    0,    0,    0,    0,
    0,    0,   34,   35,   46,    0,   44,    0,    0,    0,
    0,    0,   48,   38,    0,    0,   47,   49,   36,
};
final static short yydgoto[] = {                          1,
   10,   68,    3,    2,   14,   11,   19,   23,   15,   29,
   12,   24,   20,   41,   53,   21,   42,   30,   50,   58,
   96,   69,
};
final static short yysindex[] = {                         0,
    0,    0, -177,    0,    0,    0,    0, -171,    0,    0,
    0,    0,  -33, -150,    5,    0, -161,    0,    0, -151,
    0, -145, -132,  -91,   93,   95,   43,    0,   -8,    0,
   78,    0,   97, -138,    5,    0, -132,    0,    0, -118,
   99,   83,    0,    0, -110,    0,    0, -138,    0,    0,
 -103,    0,  -84,    0,   34,  101,    0,    0,  -82,    6,
  -36,  -36,    0,  103,    0,  -36,   85,   26,  -18,    2,
  -31,   15,  -13,    0,  -36,  -36,  -36,  -36,  -36,  -36,
   86,  -36,    0,    0,    0,   57,    0,   33,   -4,   21,
  -21,   11,    0,    0,   26, -173,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  146, -106,    0, -105,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  112, -106,    0,    0,    0,    0,    0,
    0,  118,    0,    0,    0,    0,    0,  112,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -41,    0,    0,    0,   59,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -22,   18,  -27,
  -35,    0,    0,    0,   82,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   51,   52,   50,    0,    0,  136,    0,  126,    0,    0,
    0,    0,    0,  114,  109,    0,    0,  127,    0,   74,
    0,  100,
};
final static int YYTABLESIZE=290;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         45,
   45,   45,   45,   66,   45,   40,   40,   40,   40,   84,
   78,   77,   49,   39,   80,   39,   39,   45,   42,   54,
   45,   42,   81,   40,   80,   82,   40,   87,   78,   77,
   76,   39,   80,   31,   39,   37,   42,   78,   77,   42,
   57,   80,   63,   78,   77,   66,   67,   80,   76,   45,
   36,   45,   78,   77,   66,   85,   80,   40,   41,   79,
   83,   41,   78,   76,   18,   39,   80,   78,   77,   79,
   42,   80,   76,   60,   78,   77,   41,   79,   80,    4,
    5,    6,    7,   55,   40,   13,   79,   76,   45,   16,
    8,    9,   79,   56,   61,   22,   51,   97,   40,   51,
   82,   79,   51,   98,   25,   26,    4,    5,    6,    7,
   41,   79,   70,   71,   17,   27,   79,   73,    4,    5,
    6,    7,   50,   79,   28,   50,   88,   89,   90,   91,
   92,   93,   33,   95,   34,   35,   38,   39,   46,   47,
   62,   48,   72,   74,   94,    2,    4,    5,    6,    7,
   22,   16,   19,    4,    5,    6,    7,    8,   18,   32,
   43,   52,   59,   44,    8,    4,    5,    6,    7,   99,
    0,   86,   55,    0,   55,    0,    8,    0,    0,    0,
    0,    0,   56,    0,   56,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   64,    0,   45,    0,   65,    0,    0,    0,   40,    0,
    0,    0,   75,    0,    0,    0,   39,    0,    0,    0,
    0,   42,    0,    0,    0,    0,    0,    0,    0,    0,
   75,    0,    0,    0,    0,    0,    0,    0,    0,   75,
    0,    0,   64,    0,    0,   75,   65,    0,    0,    0,
    0,   64,    0,    0,   75,   65,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   75,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   42,   43,   44,   40,   46,   41,   42,   43,   44,   41,
   42,   43,  123,   41,   46,   43,   44,   59,   41,  123,
   62,   44,   41,   59,   46,   44,   62,   41,   42,   43,
   62,   59,   46,  125,   62,   44,   59,   42,   43,   62,
  125,   46,  125,   42,   43,   40,   41,   46,   62,   91,
   59,   93,   42,   43,   40,   41,   46,   93,   41,   91,
   59,   44,   42,   62,   14,   93,   46,   42,   43,   91,
   93,   46,   62,   40,   42,   43,   59,   91,   46,  257,
  258,  259,  260,  257,   34,  257,   91,   62,   39,  123,
  268,  269,   91,  267,   61,   91,   47,   41,   48,   41,
   44,   91,   44,   93,  266,  257,  257,  258,  259,  260,
   93,   91,   61,   62,  265,  261,   91,   66,  257,  258,
  259,  260,   41,   91,  257,   44,   75,   76,   77,   78,
   79,   80,   40,   82,   40,   93,   59,   41,  257,   41,
   40,   59,   40,   59,   59,    0,  257,  258,  259,  260,
  257,  257,   41,  257,  258,  259,  260,  268,   41,   24,
   35,   48,   54,   37,  268,  257,  258,  259,  260,   96,
   -1,   72,  257,   -1,  257,   -1,  268,   -1,   -1,   -1,
   -1,   -1,  267,   -1,  267,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,   -1,  264,   -1,  261,   -1,   -1,   -1,  264,   -1,
   -1,   -1,  264,   -1,   -1,   -1,  264,   -1,   -1,   -1,
   -1,  264,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  264,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  264,
   -1,   -1,  257,   -1,   -1,  264,  261,   -1,   -1,   -1,
   -1,  257,   -1,   -1,  264,  261,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  264,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=269;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
null,"'.'",null,null,null,null,null,null,null,null,null,null,null,null,"';'",
null,"'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,"IDENT","INT","DOUBLE","BOOL","NUM",
"STRING","LITERAL","AND","VOID","MAIN","IF","STRUCT","FUNC",
};
final static String yyrule[] = {
"$accept : prog",
"$$1 :",
"prog : $$1 listaDeclaracoes FUNC listaFuncoes",
"listaDeclaracoes : listaDeclaracoes declaracao",
"listaDeclaracoes :",
"listaFuncoes : listaFuncoes funcao",
"listaFuncoes :",
"$$2 :",
"declaracao : type $$2 TArray Lid ';'",
"declaracao : declaracaoStruct",
"declaracaoStruct : STRUCT IDENT '{' listaCampos '}' ';'",
"listaCampos : listaCampos declaracao",
"listaCampos :",
"funcao : typeRet IDENT '(' listaParam ')' listaDeclaracoes '{' listacmd '}'",
"funcao : main",
"typeRet : type",
"typeRet : VOID",
"listaParam : param ';' listaParam",
"listaParam : param",
"listaParam :",
"param : type IDENT",
"TArray : '[' NUM ']' TArray",
"TArray :",
"Lid : Lid ',' id",
"Lid : id",
"id : IDENT",
"type : INT",
"type : DOUBLE",
"type : BOOL",
"type : IDENT",
"main : VOID MAIN '(' ')' listaDeclaracoes bloco",
"bloco : '{' listacmd '}'",
"listacmd : listacmd cmd",
"listacmd :",
"cmd : IDENT '=' exp ';'",
"$$3 :",
"cmd : IF '(' exp ')' $$3 cmd",
"cmd : IDENT '(' ')' ';'",
"cmd : IDENT '(' listaExp ')' ';'",
"exp : exp '+' exp",
"exp : exp '*' exp",
"exp : exp '>' exp",
"exp : exp AND exp",
"exp : NUM",
"exp : '(' exp ')'",
"exp : IDENT",
"exp : IDENT '(' ')'",
"exp : IDENT '(' listaExp ')'",
"exp : exp '.' exp",
"exp : exp '[' exp ']'",
"listaExp : listaExp ',' exp",
"listaExp : exp",
};

//#line 227 "exemploSem.y"

  private Yylex lexer;

  private TabSimb ts;

  public static TS_entry Tp_INT =  new TS_entry("int", null, ClasseID.TipoBase);
  public static TS_entry Tp_DOUBLE = new TS_entry("double", null,  ClasseID.TipoBase);
  public static TS_entry Tp_BOOL = new TS_entry("bool", null,  ClasseID.TipoBase);
  public static TS_entry Tp_ARRAY = new TS_entry("array", null,  ClasseID.TipoBase);
  public static TS_entry Tp_ERRO = new TS_entry("_erro_", null,  ClasseID.TipoBase);

  public static final int ARRAY = 1500;
  public static final int ATRIB = 1600;

  private String currEscopo;

  private ClasseID currClass;

  private TS_entry currentType;

  private int yylex () {
    int yyl_return = -1;
    try {
      yylval = new ParserVal(0);
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
  }


  public void yyerror (String error) {
    //System.err.println("Erro (linha: "+ lexer.getLine() + ")\tMensagem: "+error);
    System.err.printf("Erro (linha: %2d) \tMensagem: %s\n", lexer.getLine(), error);
  }


  public Parser(Reader r) {
    lexer = new Yylex(r, this);

    ts = new TabSimb();

    //
    // não me parece que necessitem estar na TS
    // já que criei todas como public static...
    //
    ts.insert(Tp_ERRO);
    ts.insert(Tp_INT);
    ts.insert(Tp_DOUBLE);
    ts.insert(Tp_BOOL);
    ts.insert(Tp_ARRAY);
    

  }  

  public void setDebug(boolean debug) {
    yydebug = debug;
  }

  public void listarTS() { ts.listar();}

  public static void main(String args[]) throws IOException {
    System.out.println("\n\nVerificador semantico simples\n");
    

    Parser yyparser;
    if ( args.length > 0 ) {
      // parse a file
      yyparser = new Parser(new FileReader(args[0]));
    }
    else {
      // interactive mode
      System.out.println("[Quit with CTRL-D]");
      System.out.print("Programa de entrada:\n");
        yyparser = new Parser(new InputStreamReader(System.in));
    }

    yyparser.yyparse();

      yyparser.listarTS();

      System.out.print("\n\nFeito!\n");
    
  }

  TS_entry validaTipo(int operador, TS_entry A, TS_entry B) {
       
        switch ( operador ) {
            case ATRIB:
                if ( (A == Tp_INT && B == Tp_INT)                        ||
                        ((A == Tp_DOUBLE && (B == Tp_INT || B == Tp_DOUBLE))) ||
                        (A == B) )
                        return A;
                    else
                        yyerror("(sem) tipos incomp. para atribuicao: "+ A.getTipoStr() + " = "+B.getTipoStr());
                  break;

            case '+' :
            case '*' :
                  if ( A == Tp_INT && B == Tp_INT)
                        return Tp_INT;
                  else if ( (A == Tp_DOUBLE && (B == Tp_INT || B == Tp_DOUBLE)) ||
                            (B == Tp_DOUBLE && (A == Tp_INT || A == Tp_DOUBLE)) ) 
                        return Tp_DOUBLE;     
                  else
                      yyerror("(sem) tipos incomp. para soma: "+ A.getTipoStr() + " + "+B.getTipoStr());
                  break;

            case '>' :
                    if ((A == Tp_INT || A == Tp_DOUBLE) && 
                        (B == Tp_INT || B == Tp_DOUBLE))
                        return Tp_BOOL;
                    else
                      yyerror("(sem) tipos incomp. para op relacional: "+ A.getTipoStr() + " > "+B.getTipoStr());
                    break;

            case AND:
                    if (A == Tp_BOOL && B == Tp_BOOL)
                        return Tp_BOOL;
                    else
                      yyerror("(sem) tipos incomp. para op lógica: "+ A.getTipoStr() + " && "+B.getTipoStr());
                break;
          }

          return Tp_ERRO;
           
    }
//#line 442 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 22 "exemploSem.y"
{ currClass = ClasseID.VarGlobal; }
break;
case 7:
//#line 34 "exemploSem.y"
{ currentType = (TS_entry)val_peek(0).obj; }
break;
case 10:
//#line 39 "exemploSem.y"
{ TS_entry Tp_New =  new TS_entry(val_peek(4).sval, null, ClasseID.NomeStruct);
                    ts.insert(Tp_New);
                  }
break;
case 13:
//#line 51 "exemploSem.y"
{
          /*Cria uma nova entrada na tabeka de uma funcao*/
          /*                             (IDENT funcao, tipo da funcao, classe dela)*/
          /*System.out.println("funcao: -> currentType: "+currentType);*/
          /*System.out.println("id atual: "+currentType.getId());*/
          TS_entry Tp_New =  new TS_entry(val_peek(7).sval, currentType, ClasseID.NomeFuncao);
          ts.insert(Tp_New);
        }
break;
case 15:
//#line 65 "exemploSem.y"
{ 
          /*System.out.println("Antes -> currentType: "+currentType);*/
          currentType = (TS_entry)val_peek(0).obj;
          /*System.out.println("Depois -> currentType: "+currentType);*/
        }
break;
case 16:
//#line 71 "exemploSem.y"
{ 
          /*System.out.println("Antes -> currentType: "+currentType);*/
          currentType = new TS_entry("void", null, ClasseID.TipoBase);
          /*System.out.println("Depois -> currentType: "+currentType);*/
        }
break;
case 21:
//#line 87 "exemploSem.y"
{ currentType = new TS_entry("?", Tp_ARRAY, currClass, val_peek(2).ival, currentType); }
break;
case 25:
//#line 98 "exemploSem.y"
{ 
      TS_entry nodo = ts.pesquisa(val_peek(0).sval);
      if (nodo != null) {
        yyerror("(sem) variavel >" + val_peek(0).sval + "< jah declarada");
      } else { 
        ts.insert(new TS_entry(val_peek(0).sval, currentType, currClass));
      } 
    }
break;
case 26:
//#line 108 "exemploSem.y"
{ yyval.obj = Tp_INT; }
break;
case 27:
//#line 109 "exemploSem.y"
{ yyval.obj = Tp_DOUBLE; }
break;
case 28:
//#line 110 "exemploSem.y"
{ yyval.obj = Tp_BOOL; }
break;
case 29:
//#line 112 "exemploSem.y"
{ 
        /*Pesquisa se esse IDENT ta na tabela e ele pode servir como tipo de variavel (soh STRUCT)*/
        TS_entry nodo = ts.pesquisa(val_peek(0).sval);
        /* if(nodo != null && nodo.getClasse().equals(ClasseID.NomeStruct))*/
        if(nodo != null)
          yyval.obj = nodo;
      }
break;
case 34:
//#line 130 "exemploSem.y"
{
        TS_entry nodo = ts.pesquisa(val_peek(3).sval);
        if (nodo == null) {
          yyerror("(sem) var <" + val_peek(3).sval + "> nao declarada"); 
          /*$$ = Tp_ERRO;  */
        } else{   
          validaTipo(ATRIB, nodo.getTipo(), (TS_entry)val_peek(1).obj);
        } 
      }
break;
case 35:
//#line 141 "exemploSem.y"
{  
        if ( ((TS_entry)val_peek(1).obj) != Tp_BOOL){
          yyerror("(sem) expressão (if) deve ser lógica "+((TS_entry)val_peek(1).obj).getTipo());
        }
      }
break;
case 37:
//#line 148 "exemploSem.y"
{
        TS_entry nodo = ts.pesquisa(val_peek(3).sval);
        if (nodo == null) {
          yyerror("(sem) funcao <" + val_peek(3).sval + "> nao declarada"); 
          /*$$ = Tp_ERRO;  //Nao precisa, ja que nao retorna nada*/
        }  
      }
break;
case 38:
//#line 157 "exemploSem.y"
{
        TS_entry nodo = ts.pesquisa(val_peek(4).sval);
        if (nodo == null) {
          yyerror("(sem) funcao <" + val_peek(4).sval + "> nao declarada"); 
          /*$$ = Tp_ERRO;  //Nao precisa, ja que nao retorna nada  */
        }  
      }
break;
case 39:
//#line 165 "exemploSem.y"
{ yyval.obj = validaTipo('+', (TS_entry)val_peek(2).obj, (TS_entry)val_peek(0).obj); }
break;
case 40:
//#line 166 "exemploSem.y"
{ yyval.obj = validaTipo('*', (TS_entry)val_peek(2).obj, (TS_entry)val_peek(0).obj); }
break;
case 41:
//#line 167 "exemploSem.y"
{ yyval.obj = validaTipo('>', (TS_entry)val_peek(2).obj, (TS_entry)val_peek(0).obj); }
break;
case 42:
//#line 168 "exemploSem.y"
{ yyval.obj = validaTipo(AND, (TS_entry)val_peek(2).obj, (TS_entry)val_peek(0).obj); }
break;
case 43:
//#line 169 "exemploSem.y"
{ yyval.obj = Tp_INT; }
break;
case 44:
//#line 170 "exemploSem.y"
{ yyval.obj = val_peek(1).obj; }
break;
case 45:
//#line 172 "exemploSem.y"
{ TS_entry nodo = ts.pesquisa(val_peek(0).sval); /* Pesquisa nome da VARIAVEL na tabela!*/
        if (nodo == null) {
          yyerror("(sem) variavel <" + val_peek(0).sval + "> nao declarada"); 
          yyval.obj = Tp_ERRO; /*Precisa disso      */
        } else {
          yyval.obj = nodo.getTipo();
        }
      }
break;
case 46:
//#line 182 "exemploSem.y"
{ TS_entry nodo = ts.pesquisa(val_peek(2).sval); /* Pesquisa nome da FUNCAO na tabela!*/
        if (nodo == null) {
          System.out.println("EXP: FUNCAO SEM PARAM");
          yyerror("(sem) funcao <" + val_peek(2).sval + "> nao declarada"); 
          yyval.obj = Tp_ERRO; /*Precisa disso     */
        } else {
          yyval.obj = nodo.getTipo();
        }
      }
break;
case 47:
//#line 193 "exemploSem.y"
{ TS_entry nodo = ts.pesquisa(val_peek(3).sval); /* Pesquisa nome da FUNCAO na tabela!*/
        if (nodo == null) {
          yyerror("(sem) funcao <" + val_peek(3).sval + "> nao declarada"); 
          yyval.obj = Tp_ERRO; /*Precisa disso  */
        } else {
          yyval.obj = nodo.getTipo();
        }
      }
break;
case 48:
//#line 203 "exemploSem.y"
{ 
        yyval.obj = null; 
      }
break;
case 49:
//#line 208 "exemploSem.y"
{  
        if ((TS_entry)val_peek(1).obj != Tp_INT) {
          yyerror("(sem) indexador não é numérico! ");
        } else {
          if (((TS_entry)val_peek(3).obj).getTipo() != Tp_ARRAY) {
            yyerror("(sem) elemento não pode ser indexado! ");
          } else {
            /*  Se o $1(exp) eh um array, e o $3 eh numerico, entao acessa o array e retorna o*/
            /* tipo dos elementos que estao neste array*/
            yyval.obj = ((TS_entry)val_peek(3).obj).getTipoBase(); 
          }                      
        }
      }
break;
//#line 789 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
