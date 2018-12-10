.source prog_destino.java 
.class public teste20
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
.limit locals 15
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 2.0
ldc2_w -20.0
invokestatic java/lang/Double/max(DD)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 20.0
dstore_1
ldc2_w 45.0
invokestatic java/lang/Math/log10(D)D 
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite a quantidade de numeros que deseja testar: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore 9
ldc2_w -1.0
ldc2_w 2.0
ldc2_w 10.0
invokestatic java/lang/Math/pow(DD)D 
dmul 
dstore 5
ldc2_w 2.0
ldc2_w 10.0
invokestatic java/lang/Math/pow(DD)D 
dstore 7
LABELINICIOENQUANTO_1:
dload 9
ldc2_w 0.0
dcmpg 
ifge COLOCATRUEmaiorIgual_2
dconst_0 
goto SAIDAmaiorIgual_3
COLOCATRUEmaiorIgual_2:
dconst_1 
SAIDAmaiorIgual_3:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite um numero:"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore 11
dload 5
dload 11
invokestatic java/lang/Double/max(DD)D 
dstore 5
dload 9
ldc2_w 1.0
dsub 
dstore 9
goto LABELINICIOENQUANTO_1

LABELFALSE_0:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Maior: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
