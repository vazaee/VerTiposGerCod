//Alunos: Gabriel Vaz, Márcio Góes, Matheus Zanon
//Matriculas: 17111238, 16105078, 16105090
//Email: {Gabriel.vaz, Marcio.goes, Matheus.zanon}@edu.pucrs.br

%%

%byaccj

%{
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
    yyline = 1;
  }


  public int getLine() {
      return yyline;
  }

%}

NUM = [0-9]+
NL  = \n | \r | \r\n

%%


"$TRACE_ON"  { yyparser.setDebug(true);  }
"$TRACE_OFF" { yyparser.setDebug(false); }
"$MOSTRA_TS" { yyparser.listarTS(); }


{NL}   {yyline++;}
[ \t]+ { }

/* operadores */

"+" |
"-" |
"*" | 
"/" | 
"%" | 
">" |
"<" |
"=" |
"!" |
";" |
"(" | 
")" |
"{" |
"}" |
"," |
"\[" | 
"\]"    { return (int) yycharat(0); }

{NUM}  { yyparser.yylval = new ParserVal(yytext()); 
         return Parser.NUM; }

"=="   {  return Parser.EQ; }
"<="   {  return Parser.LEQ; }
">="   {  return Parser.GEQ; }
"!="   {  return Parser.NEQ; }
"+="   {  return Parser.ATR; }
"++"   {  return Parser.INC; }

"&&"   { return Parser.AND; }
"||"   {  return Parser.OR; }

int    { return Parser.INT;     }
float  { return Parser.FLOAT;   }
bool   { return Parser.BOOL; }
void   { return Parser.VOID; }
main   { return Parser.MAIN; }
write   { return Parser.WRITE; }
read   { return Parser.READ; }
while   { return Parser.WHILE; }
if   { return Parser.IF; }
else   { return Parser.ELSE; }
true   { return Parser.TRUE; }
false   { return Parser.FALSE; }



[a-zA-Z]+([a-zA-Z0-9]+)? { yyparser.yylval = new ParserVal(yytext());
            return Parser.ID; }

\"[^\n]+\" { yyparser.yylval = new ParserVal(yytext().substring(1, yylength() -1));
	     return Parser.LIT; }

[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
