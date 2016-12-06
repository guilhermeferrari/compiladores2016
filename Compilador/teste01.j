.source teste01.java
.class public teste01
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
.limit locals 6


; expressao: 1 + 1 
ldc2_w 2.0

dstore_1

; expressao: _a + 3 
dload_1
ldc2_w 3.0
dadd

dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_3
invokevirtual java/io/PrintStream/println(D)V
return
.end method
