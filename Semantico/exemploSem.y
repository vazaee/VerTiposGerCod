%{
  import java.io.*;
%}

%token IDENT, INT, DOUBLE, BOOL, NUM, STRING
%token LITERAL, AND, VOID, MAIN, IF
%token STRUCT, FUNC

%nonassoc '>'
%left AND
%left '+'
%left '*'
%left '[' '.'        

%type <sval> IDENT
%type <ival> NUM
%type <obj> type
%type <obj> exp

%%

prog: { currClass = ClasseID.VarGlobal; } listaDeclaracoes FUNC listaFuncoes 
    ;

listaDeclaracoes: listaDeclaracoes declaracao
                |                      
                ;

listaFuncoes: listaFuncoes funcao   
            |                      
            ;   

//Ou declaracao de Structs ou declaracao de Arrays
declaracao: type { currentType = (TS_entry)$1; } TArray Lid ';' 
          | declaracaoStruct 
          ;

declaracaoStruct: STRUCT IDENT '{' listaCampos '}' ';'
                  { TS_entry Tp_New =  new TS_entry($2, null, ClasseID.NomeStruct);
                    ts.insert(Tp_New);
                  }
                ;

listaCampos: listaCampos declaracao
          |
          ;

/*Declaracao de funcoes
  $$       $1    $2   $3      $4     $5     $6    $7    $8     $9 */
funcao: typeRet IDENT '(' listaParam ')' listaDeclaracoes '{' listacmd '}'
        {
          //Cria uma nova entrada na tabeka de uma funcao
          //                             (IDENT funcao, tipo da funcao, classe dela)
          //System.out.println("funcao: -> currentType: "+currentType);
          //System.out.println("id atual: "+currentType.getId());
          TS_entry Tp_New =  new TS_entry($2, currentType, ClasseID.NomeFuncao);
          ts.insert(Tp_New);
        }
      | main
      ;

/* Tipo de retorno das funcoes
  $$       $1    */
typeRet: type 
        { 
          //System.out.println("Antes -> currentType: "+currentType);
          currentType = (TS_entry)$1;
          //System.out.println("Depois -> currentType: "+currentType);
        }
      | VOID 
        { 
          //System.out.println("Antes -> currentType: "+currentType);
          currentType = new TS_entry("void", null, ClasseID.TipoBase);
          //System.out.println("Depois -> currentType: "+currentType);
        }
      ;

listaParam: param ';' listaParam
          | param
          |
          ;

param: type IDENT 
    ;

TArray: '[' NUM ']' TArray 
        { currentType = new TS_entry("?", Tp_ARRAY, currClass, $2, currentType); }
      |   
      ;     

//Lista de identificadores para o array
Lid : Lid  ',' id 
    | id  
    ;

//O que eh cada identificador do array
id: IDENT
    { 
      TS_entry nodo = ts.pesquisa($1);
      if (nodo != null) {
        yyerror("(sem) variavel >" + $1 + "< jah declarada");
      } else { 
        ts.insert(new TS_entry($1, currentType, currClass));
      } 
    }
  ;

type: INT    { $$ = Tp_INT; }
    | DOUBLE { $$ = Tp_DOUBLE; }
    | BOOL   { $$ = Tp_BOOL; }   
    | IDENT  
      { 
        //Pesquisa se esse IDENT ta na tabela e ele pode servir como tipo de variavel (soh STRUCT)
        TS_entry nodo = ts.pesquisa($1);
        // if(nodo != null && nodo.getClasse().equals(ClasseID.NomeStruct))
        if(nodo != null)
          $$ = nodo;
      }
    ;

main :  VOID MAIN '(' ')' listaDeclaracoes bloco ;

bloco : '{' listacmd '}';

listacmd : listacmd cmd
        |
         ;
//$$    $1    $2  $3
cmd : IDENT '=' exp ';' 
      {
        TS_entry nodo = ts.pesquisa($1);
        if (nodo == null) {
          yyerror("(sem) var <" + $1 + "> nao declarada"); 
          //$$ = Tp_ERRO;  
        } else{   
          validaTipo(ATRIB, nodo.getTipo(), (TS_entry)$3);
        } 
      }
    
    | IF '(' exp ')' 
      {  
        if ( ((TS_entry)$3) != Tp_BOOL){
          yyerror("(sem) expressão (if) deve ser lógica "+((TS_entry)$3).getTipo());
        }
      } cmd
    
    | IDENT '(' ')' ';' 
      {
        TS_entry nodo = ts.pesquisa($1);
        if (nodo == null) {
          yyerror("(sem) funcao <" + $1 + "> nao declarada"); 
          //$$ = Tp_ERRO;  //Nao precisa, ja que nao retorna nada
        }  
      }
    
    | IDENT '(' listaExp ')' ';' 
      {
        TS_entry nodo = ts.pesquisa($1);
        if (nodo == null) {
          yyerror("(sem) funcao <" + $1 + "> nao declarada"); 
          //$$ = Tp_ERRO;  //Nao precisa, ja que nao retorna nada  
        }  
      }

exp : exp '+' exp { $$ = validaTipo('+', (TS_entry)$1, (TS_entry)$3); }
    | exp '*' exp { $$ = validaTipo('*', (TS_entry)$1, (TS_entry)$3); }  
    | exp '>' exp { $$ = validaTipo('>', (TS_entry)$1, (TS_entry)$3); }
    | exp AND exp { $$ = validaTipo(AND, (TS_entry)$1, (TS_entry)$3); } 
    | NUM         { $$ = Tp_INT; }      
    | '(' exp ')' { $$ = $2; }
    | IDENT // VARIAVEL
      { TS_entry nodo = ts.pesquisa($1); // Pesquisa nome da VARIAVEL na tabela!
        if (nodo == null) {
          yyerror("(sem) variavel <" + $1 + "> nao declarada"); 
          $$ = Tp_ERRO; //Precisa disso      
        } else {
          $$ = nodo.getTipo();
        }
      } 

    | IDENT '(' ')'  //FUNCAO sem parametros
      { TS_entry nodo = ts.pesquisa($1); // Pesquisa nome da FUNCAO na tabela!
        if (nodo == null) {
          System.out.println("EXP: FUNCAO SEM PARAM");
          yyerror("(sem) funcao <" + $1 + "> nao declarada"); 
          $$ = Tp_ERRO; //Precisa disso     
        } else {
          $$ = nodo.getTipo();
        }
      }

    | IDENT '(' listaExp ')' //FUNCAO com parametros
      { TS_entry nodo = ts.pesquisa($1); // Pesquisa nome da FUNCAO na tabela!
        if (nodo == null) {
          yyerror("(sem) funcao <" + $1 + "> nao declarada"); 
          $$ = Tp_ERRO; //Precisa disso  
        } else {
          $$ = nodo.getTipo();
        }
      } 

    | exp '.' exp 
      { 
        $$ = null; 
      }
    // $1 $2  $3
    | exp '[' exp ']' 
      {  
        if ((TS_entry)$3 != Tp_INT) {
          yyerror("(sem) indexador não é numérico! ");
        } else {
          if (((TS_entry)$1).getTipo() != Tp_ARRAY) {
            yyerror("(sem) elemento não pode ser indexado! ");
          } else {
            //  Se o $1(exp) eh um array, e o $3 eh numerico, entao acessa o array e retorna o
            // tipo dos elementos que estao neste array
            $$ = ((TS_entry)$1).getTipoBase(); 
          }                      
        }
      }
    ;

listaExp : listaExp ',' exp
         | exp
         ;
%%

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