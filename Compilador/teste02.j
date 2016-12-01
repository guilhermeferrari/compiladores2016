.source teste02.java
.class public teste02
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 4
.limit locals 6

ldc2_w 1.0
dstore_1
ldc2_w 2.0
dstore_3
dload_1
ldc2_w 1.0
dcmpg
ifeq LABEL_00
dconst_0
goto LABEL_01
LABEL_00:
dconst_1
LABEL_01:
dconst_0 
dcmpg 
ifeq CONDICIONAL_0
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_1
invokevirtual java/io/PrintStream/println(D)V
goto CONDICIONALEND_0
CONDICIONAL_0:
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_3
invokevirtual java/io/PrintStream/println(D)V
CONDICIONALEND_0:

return
.end method
