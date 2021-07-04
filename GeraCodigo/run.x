#Alunos: Gabriel Vaz, Márcio Góes, Matheus Zanon
#Matriculas: 17111238, 16105078, 16105090
#Email: {Gabriel.vaz, Marcio.goes, Matheus.zanon}@edu.pucrs.br

#!/bin/bash

ARQ=`basename $1|sed "s/\.cmm//"`

java Parser $ARQ.cmm >$ARQ.s
# 32 bits
# as -o $ARQ.o $ARQ.s
#ld -o $ARQ   $ARQ.o

# 64 bits 
as --32 -o $ARQ.o $ARQ.s
ld -m elf_i386 -s -o $ARQ   $ARQ.o
