# Trabalho final da disciplina de Compiladores

### Alunos: Gabriel Vaz, Márcio Góes, Matheus Zanon
### Matriculas: 17111238, 16105078, 16105090
### Email: {Gabriel.vaz, Marcio.goes, Matheus.zanon}@edu.pucrs.br

O objetivo do projeto deste semestre será a consolidação dos conceitos de verificação de tipos e geração de código vistos ao longo da disciplina.

## Parte 1 - Verificação de tipos.
A partir do exemplo de verificação semântica trabalhada em aula, acrescentar regras semânticas que construam
um sistema de tipos capaz de permitir a declaração de funções e structs. Realizar as verificações semânticas
básicas segundo as regras da linguagem ANSI C. Minimamente as seguintes verificações devem ser
realizadas:

1. todo identificador deve ser declarado antes do seu uso (dentro do escopo corrente)
2. não é possível re-declarar um identificador (dentro de um mesmo escopo)
3. os tipos válidos da linguagem são inteiro (“integer”), ponto flutuante (“double”) e lógico
(“boolean”). Como tipo de retorno de funções acrescenta-se o tipo “void”;
4. na ativação de subprogramas (funções) os tipos devem ser compatíveis aos tipos da declaração
do subprograma e o tipo de retorno compatível com a expressão/atribuição onde estiver sendo
utilizada.
5. Não é possível declarar structs “aninhadas” mas deve ser possível definir variáveis do tipo
struct como campos de outra struct, bem como realizar a validação de tipos desses casos.

### Platoforma utiliza - Semantica
(A depender do Byacc especificado no Codigo Makefile)
- Windows 10    
- Linux Ubuntu

### Compilação - Semantica
Esses passos são necessários para compilação do projeto em sua máquina.
- Entrar na pasta do projeto na parte de semantica
```
cd ./Semantico
make
```

### Execução - Semantica
Para execução de um dos exemplos semnanticos deve se executar algum dos exemplos contidos na pasta "./exemplos". Por exemplo, para executar o programa 'correto1.txt' digite o comando abaixo:
```
java Parser ./exemplos/correto1.txt
```

### Detalhes da Implementação - Semantica
O item 1.4 'na ativação de subprogramas (funções)...' não foi implementado completamente devido a dificuldades encontradas para verificar a lista de parametros de cada função. Deveria ser verificado se os parametros da função equivalem aos parametros passados.
Ou então se a função tem parâmetros (ou não) e foram passados os parâmetros requisitados.

Os demais itens, 1.1, 1.2, 1.3 e 1.5 estão funcionando corretamente e estão cobertos pelos testes de erros encontrados na pasta 'exemplos'.

------------
## Parte 2 - Geração de código 
A partir do exemplo de geração de código (especificação ByaccJ) disponibilizado na página da disciplina,
complementar esta especificação com as seguintes estruturas (com a respectiva geração de código). Note
que os primeiros 3 item são obrigatórios (e relativamente triviais) e obrigatórios para poder testar os casos
disponibilizados para o comando “for”.
1. transformar o “comando” de atribuição em uma “expressão” de atribuição
2. acrescentar operadores de pré e pós-incremento e atribuição por adição (+=)
3. acrescentar os comandos “break” e “continue”
4. acrescentar o comando “for”
5. Acrescentar geração de código para “structs”
6. Acrescentar código para “arrays” e “array de structs”

### Platoforma utiliza - Geração de código
- Linux Ubuntu

### Compilação - Geração de código
Esses passos são necessários para compilação do projeto em sua máquina.
- Entrar na pasta do projeto na parte de semantica
```
cd ./GeraCodigo
make
```

### Execução - Geração de código
Para execução de um dos exemplos de geração de código deve se executar algum dos exemplos presentes no diretorio do programa. Por exemplo, para executar o programa 'geraCod1.txt' digite o comando abaixo:
```
./run.x geraCod1.cmm    (Compila o prog de exemplo)
./geraCod1                      (executa)
```

### Detalhes da Implementação - Geração de código
Na execução do trabalho conseguimos realizar os itens 2.1 e 2.2, sendo que os itens 2.5 e 2.6 não eram necessários para conclusão do trabalho. Desta forma ficou faltando a implementação dos itens 2.3 e 2.4

O item 2.3 nao foi possivel de ser implementado devido a dificuldades de entendermos como separar a lista de 'tags' de declarações comuns de de declarações de laços de repetição (dica dada em aula pelo professor), e como não conseguimos fazer isso nao foi possivel utilizar o comando de 'Break' e 'Continue' nos laços de repetições corretamente.

O item 2.4 não foi implementado por falta de conhecimento do grupo e dificuldades encontradas já no item 2.3