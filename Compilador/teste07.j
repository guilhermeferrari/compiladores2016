.source teste07.java
.class public teste07
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
.limit locals 16


; expressao: 4 
ldc2_w 4.0

dstore_1

; expressao: 3 
ldc2_w 3.0

dstore_3

; expressao: _a + _b 
dload_1
dload_3
dadd

dstore 5

; expressao: _a - _b 
dload_1
dload_3
dsub

dstore 7

; expressao: _a * _b 
dload_1
dload_3
dmul

dstore 9

; expressao: _a / _b 
dload_1
dload_3
ddiv

dstore 11

; expressao: _a ^ _b 
dload_1
dload_3
invokestatic    java/lang/Math.pow(DD)D

dstore 13
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a = 4, _b = 3"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a + _b:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 5
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a - _b:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 7
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a * _b:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 9
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a / _b:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 11
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "_a ^ _b:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 13
invokevirtual java/io/PrintStream/println(D)V
return
.end method
