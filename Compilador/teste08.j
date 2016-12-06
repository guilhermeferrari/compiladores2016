.source teste08.java
.class public teste08
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 11
.limit locals 24


; expressao: 1 
ldc2_w 1.0

dstore_1

; expressao: 2 
ldc2_w 2.0

dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a = 1, _b = 2"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

; expressao: ( _a == 1 ) e ( _b == 2 ) 
dload_1
ldc2_w 1.0
dcmpg
ifeq LABEL_00
dconst_0
goto LABEL_01
LABEL_00:
dconst_1
LABEL_01:
dload_3
ldc2_w 2.0
dcmpg
ifeq LABEL_02
dconst_0
goto LABEL_03
LABEL_02:
dconst_1
LABEL_03:
dconst_0
dcmpg
ifne topoUm_1
pop2
dconst_0
goto final_1
topoUm_1:
dconst_0
dcmpg
ifne um_1
dconst_0
goto final_1
um_1:
dconst_1
final_1:

dstore 5

; expressao: ( _a == 3 ) e ( _b == 2 ) 
dload_1
ldc2_w 3.0
dcmpg
ifeq LABEL_04
dconst_0
goto LABEL_05
LABEL_04:
dconst_1
LABEL_05:
dload_3
ldc2_w 2.0
dcmpg
ifeq LABEL_06
dconst_0
goto LABEL_07
LABEL_06:
dconst_1
LABEL_07:
dconst_0
dcmpg
ifne topoUm_2
pop2
dconst_0
goto final_2
topoUm_2:
dconst_0
dcmpg
ifne um_2
dconst_0
goto final_2
um_2:
dconst_1
final_2:

dstore 7

; expressao: ( _a == 1 ) e ( _b == 3 ) 
dload_1
ldc2_w 1.0
dcmpg
ifeq LABEL_08
dconst_0
goto LABEL_09
LABEL_08:
dconst_1
LABEL_09:
dload_3
ldc2_w 3.0
dcmpg
ifeq LABEL_010
dconst_0
goto LABEL_011
LABEL_010:
dconst_1
LABEL_011:
dconst_0
dcmpg
ifne topoUm_3
pop2
dconst_0
goto final_3
topoUm_3:
dconst_0
dcmpg
ifne um_3
dconst_0
goto final_3
um_3:
dconst_1
final_3:

dstore 9

; expressao: ( _a == 3 ) e ( _b == 3 ) 
dload_1
ldc2_w 3.0
dcmpg
ifeq LABEL_012
dconst_0
goto LABEL_013
LABEL_012:
dconst_1
LABEL_013:
dload_3
ldc2_w 3.0
dcmpg
ifeq LABEL_014
dconst_0
goto LABEL_015
LABEL_014:
dconst_1
LABEL_015:
dconst_0
dcmpg
ifne topoUm_4
pop2
dconst_0
goto final_4
topoUm_4:
dconst_0
dcmpg
ifne um_4
dconst_0
goto final_4
um_4:
dconst_1
final_4:

dstore 11
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "(_a == 1) e (_b == 2):"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 5
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "(_a == 3) e (_b == 2):"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 7
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "(_a == 1) e (_b == 3):"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 9
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "(_a == 3) e (_b == 3):"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 11
invokevirtual java/io/PrintStream/println(D)V

; expressao: nao ( ( _a == 1 ) e ( _b == 2 ) ) 
dload_1
ldc2_w 1.0
dcmpg
ifeq LABEL_016
dconst_0
goto LABEL_017
LABEL_016:
dconst_1
LABEL_017:
dload_3
ldc2_w 2.0
dcmpg
ifeq LABEL_018
dconst_0
goto LABEL_019
LABEL_018:
dconst_1
LABEL_019:
dconst_0
dcmpg
ifne topoUm_5
pop2
dconst_0
goto final_5
topoUm_5:
dconst_0
dcmpg
ifne um_5
dconst_0
goto final_5
um_5:
dconst_1
final_5:
dconst_0
dcmpg
ifeq LABEL_020
dconst_0
goto LABEL_021
LABEL_020:
dconst_1
LABEL_021:

dstore 21
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "nao ( (_a == 1) e (_b == 2) ):"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 21
invokevirtual java/io/PrintStream/println(D)V
return
.end method
