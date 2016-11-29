.source prog_destino.java
.class public prog_destino
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 6
.limit locals 16

ldc2_w 5.0
dstore 110
ldc "linguagem"
astore 115
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()Double 
dstore_Tipo: VARIAVEL Valor: _a
dload 110
dconst_0
dcmpg
ifeq notDeZero
dconst_0
goto final
notDeZero:
dconst_1
final:
dstore 110
dload 110
dload 110
ldc2_w 2.0
dmul
dadd
dstore 110
dload 110
ldc2_w 10.0
dcmpg
ifeq LABEL_00
dconst_1
goto LABEL_01:
LABEL_00:
dconst_0
LABEL_01:
dconst_0 
dcmpg 
ifeq CONDICIONAL_0
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto CONDICIONALEND_0
CONDICIONAL_0:
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
CONDICIONALEND_0:

ldc2_w 1.0
dstore 110
RotuloInicio_Enquanto0: 
dload 110
ldc2_w 3.0
dcmpg
ifge LABEL_02
dconst_1
goto LABEL_03:
LABEL_02:
dconst_0
LABEL_03:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto0 
dload 110
ldc2_w 1.0
dadd
dstore 110
goto RotuloInicio_Enquanto0 
RotuloFim_Enquanto0: 

ldc2_w 2.0
dstore 110
RotuloInicio_Enquanto1: 
dload 110
ldc2_w 4.0
dcmpg
ifgt LABEL_04
dconst_1
goto LABEL_05:
LABEL_04:
dconst_0
LABEL_05:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto1 
ldc2_w 1.0
dload 110
dadd
dstore 110
goto RotuloInicio_Enquanto1 
RotuloFim_Enquanto1: 

ldc2_w 1.0
dload 110
dcmpg
ifeq LABEL_06
dconst_0
goto LABEL_07:
LABEL_06:
dconst_1
LABEL_07:
dconst_0 
dcmpg 
ifeq CONDICIONAL_1
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto CONDICIONALEND_1
CONDICIONAL_1:
ldc2_w 2.0
dload 110
dcmpg
ifeq LABEL_08
dconst_0
goto LABEL_09:
LABEL_08:
dconst_1
LABEL_09:
dconst_0 
dcmpg 
ifeq CONDICIONAL_2
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto CONDICIONALEND_1
CONDICIONAL_2:
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
CONDICIONALEND_1:

CONDICIONALEND_2:

ldc2_w 1.0
dstore 110
ldc2_w 1.0
dstore 110
ldc2_w 1.0
dstore 110
RotuloInicio_Enquanto2: 
dload 110
ldc2_w 3.0
dcmpg
ifgt LABEL_010
dconst_1
goto LABEL_011:
LABEL_010:
dconst_0
LABEL_011:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto2 
RotuloInicio_Enquanto3: 
dload 110
ldc2_w 3.0
dcmpg
ifgt LABEL_012
dconst_1
goto LABEL_013:
LABEL_012:
dconst_0
LABEL_013:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto3 
RotuloInicio_Enquanto4: 
dload 110
ldc2_w 3.0
dcmpg
ifgt LABEL_014
dconst_1
goto LABEL_015:
LABEL_014:
dconst_0
LABEL_015:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto4 
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ldc2_w 1.0
dload 110
dadd
dstore 110
goto RotuloInicio_Enquanto4 
RotuloFim_Enquanto4: 

ldc2_w 1.0
dload 110
dadd
dstore 110
goto RotuloInicio_Enquanto3 
RotuloFim_Enquanto3: 

ldc2_w 1.0
dload 110
dadd
dstore 110
goto RotuloInicio_Enquanto2 
RotuloFim_Enquanto2: 

ldc2_w 10.0
dstore 110
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
dload 110
ldc2_w 1.0
dadd
dstore 110
RotuloInicio_Enquanto5: 
ldc2_w 0.0
dconst_0
dcmpg
ifeq notDeZero
dconst_0
goto final
notDeZero:
dconst_1
final:
dconst_1 
dcmpg 
ifeq RotuloFim_Enquanto5 
astore 15
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
dload 110
ldc2_w 1.0
dadd
dstore 110
goto RotuloInicio_Enquanto5 
RotuloFim_Enquanto5: 

return
.end method
