.source teste04.java
.class public teste04
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
.limit locals 4

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Entre com um numero: "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
new java/util/Scanner 
dup 
getstatic java/lang/System/in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner/nextDouble()D 
dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "O numero lido foi: "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_1
invokevirtual java/io/PrintStream/println(D)V
return
.end method
