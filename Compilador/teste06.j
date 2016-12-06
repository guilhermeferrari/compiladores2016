.source teste06.java
.class public teste06
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 8

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Qual a tabuada?"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 1

; expressao: 1 
ldc2_w 1.0

dstore_3
RotuloInicio_Enquanto0: 

; expressao: _n <= 10 
dload_3
ldc2_w 10.0
dcmpg
ifgt LABEL_00
dconst_1
goto LABEL_01
LABEL_00:
dconst_0
LABEL_01:

 
dconst_0 
dcmpg 
ifeq RotuloFim_Enquanto0 

; expressao: _x * _n 
dload_1
dload_3
dmul

dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_1
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " x "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_3
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " = "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 5
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "\n"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

; expressao: 1 + _n 
ldc2_w 1.0
dload_3
dadd

dstore_3
goto RotuloInicio_Enquanto0 
RotuloFim_Enquanto0: 

return
.end method
