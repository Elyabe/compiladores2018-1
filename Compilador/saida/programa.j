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
.limit stack 92 
.limit locals 5
ldc2_w 10.0
ldc2_w 1.0
dconst_0 
dcmpg 
ifne SAIDAe_2
pop2 
dconst_0 
SAIDAe_2:
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
ldc2_w 1.0
ldc2_w 1.5
dconst_0 
dcmpg 
ifeq ComparaSegundo0_5
goto ComparaSegundo1_6
ComparaSegundo0_5:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_8
goto COLOCATRUEXOR_7
ComparaSegundo1_6:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_7
COLOCAFALSEXOR_8:
dconst_0 
goto SAIDAouExclusivo_4
COLOCATRUEXOR_7:
dconst_1 
SAIDAouExclusivo_4:
dconst_0 
dcmpg 
ifeq LABELFALSE_3

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Verdeiro\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_3:
return 
.end method 
