.source prog_destino.java 
.class public teste17
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 102 
.limit locals 7
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Insira dois numeros: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_1
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELINICIOFAZERENQUANTO_1:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite 1 para sair :"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_1
dload_1
ldc2_w 1.0
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

goto LABELINICIOFAZERENQUANTO_1

LABELFALSE_0:
ldc2_w 10.0
invokestatic java/lang/Math/log10(D)D 
ldc2_w 1.0
invokestatic java/lang/Math/log10(D)D 
dconst_0 
dcmpg 
ifeq ComparaSegundo0_7
goto ComparaSegundo1_8
ComparaSegundo0_7:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_10
goto COLOCATRUEXOR_9
ComparaSegundo1_8:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_9
COLOCAFALSEXOR_10:
dconst_0 
goto SAIDAouExclusivo_6
COLOCATRUEXOR_9:
dconst_1 
SAIDAouExclusivo_6:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_11
dconst_0 
goto SAIDAnegacao_12
COLOCATRUEnegacao_11:
dconst_1 
SAIDAnegacao_12:
ldc2_w 10.0
invokestatic java/lang/Math/log10(D)D 
invokestatic java/lang/Math/log10(D)D 
dconst_0 
dcmpg 
ifeq ComparaSegundo0_14
goto ComparaSegundo1_15
ComparaSegundo0_14:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_17
goto COLOCATRUEXOR_16
ComparaSegundo1_15:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_16
COLOCAFALSEXOR_17:
dconst_0 
goto SAIDAouExclusivo_13
COLOCATRUEXOR_16:
dconst_1 
SAIDAouExclusivo_13:
dconst_0 
dcmpg 
ifeq LABELFALSE_4

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Expressao verdadeira"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_5

LABELFALSE_4:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Expressao falsa"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_5:
return 
.end method 
