# VerTiposGerCod

O objetivo do projeto deste semestre será a consolidação dos conceitos de verificação de tipos e geração de código vistos ao longo da disciplina.

## Parte 1 - Verificação de tipos.
A partir do exemplo de verificação semântica trabalhada em aula, acrescentar regras semânticas que construam
um sistema de tipos capaz de permitir a declaração de funções e structs. Realizar as verificações semânticas
básicas segundo as regras da linguagem ANSI C. Minimamente as seguintes verificações devem ser
realizadas:

- todo identificador deve ser declarado antes do seu uso (dentro do escopo corrente)
- não é possível re-declarar um identificador (dentro de um mesmo escopo)
- os tipos válidos da linguagem são inteiro (“integer”), ponto flutuante (“double”) e lógico
(“boolean”). Como tipo de retorno de funções acrescenta-se o tipo “void”;
- na ativação de subprogramas (funções) os tipos devem ser compatíveis aos tipos da declaração
do subprograma e o tipo de retorno compatível com a expressão/atribuição onde estiver sendo
utilizada.
- Não é possível declarar structs “aninhadas” mas deve ser possível definir variáveis do tipo
struct como campos de outra struct, bem como realizar a validação de tipos desses casos.

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
