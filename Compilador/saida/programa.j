.source prog_destino.java 
.class public programa
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 62 
.limit locals 5
ldc2_w 10.0
ldc2_w 10.0
dcmpg 
ifeq COLOCATRUEdiferente_2
dconst_1 
goto SAIDAdiferente_3
COLOCATRUEdiferente_2:
dconst_0 
SAIDAdiferente_3:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Diferente\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_1

LABELFALSE_0:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Iguais\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_1:
return 
.end method 
