.source teste05.java
.class public teste05
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
.limit locals 4


; expressao: 1 
ldc2_w 1.0

dstore_1
RotuloInicio_Enquanto0: 

; expressao: _a <= 10 
dload_1
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
getstatic java/lang/System/out Ljava/io/PrintStream;
dload_1
invokevirtual java/io/PrintStream/println(D)V

; expressao: _a + 1 
dload_1
ldc2_w 1.0
dadd

dstore_1
goto RotuloInicio_Enquanto0 
RotuloFim_Enquanto0: 

return
.end method
