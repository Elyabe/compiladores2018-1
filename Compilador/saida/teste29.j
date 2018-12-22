.source prog_destino.java 
.class public teste29
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static conversaoDecimalBinario()V
.limit stack 6 
.limit locals 10 
ldc ""
astore 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Informe o numero que deseja converter para binario: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_1
LABELINICIOENQUANTO_3:
dload_1
ldc2_w 2.0
dcmpg 
ifge COLOCATRUEmaiorIgual_4
dconst_0 
goto SAIDAmaiorIgual_5
COLOCATRUEmaiorIgual_4:
dconst_1 
SAIDAmaiorIgual_5:
dconst_0 
dcmpg 
ifeq LABELFALSE_2

dload_1
ldc2_w 2.0
ddiv 
invokestatic java/lang/Math/floor(D)D 
dstore_3
dload_1
dload_3
ldc2_w 2.0
dmul 
dsub 
dconst_0 
dcmpg 
ifeq LABELFALSE_0

ldc "1"
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 5
goto LABELSAIDA_1

LABELFALSE_0:
ldc "0"
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 5
LABELSAIDA_1:
dload_3
dstore_1
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELINICIOENQUANTO_3

LABELFALSE_2:
dload_1
dconst_0 
dcmpg 
ifeq LABELFALSE_6

ldc "1"
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 5
goto LABELSAIDA_7

LABELFALSE_6:
ldc "0"
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 5
LABELSAIDA_7:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Numero em binario: "
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 6 
.limit locals 5 
invokestatic teste29.conversaoDecimalBinario()V
return 
.end method 

