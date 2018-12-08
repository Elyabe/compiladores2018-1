.source prog_destino.java 
.class public teste18
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 172 
.limit locals 15
ldc2_w -5.0
dstore_3
dload_3
ldc2_w -1.0 
dmul 
dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 3.0
ldc2_w 2.0
invokestatic java/lang/Math/pow(DD)D 
ldc2_w -1.0
dload_3
dmul 
dload_3
ldc2_w -1.0 
dmul 
ddiv 
invokestatic java/lang/Math/log10(D)D 
dadd 
dload_3
dload_3
ldc2_w -1.0 
dmul 
ddiv 
dsub 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 3.0
ldc2_w 2.0
invokestatic java/lang/Math/pow(DD)D 
ldc2_w -1.0
dload_3
dmul 
dload_3
ldc2_w -1.0 
dmul 
ddiv 
invokestatic java/lang/Math/log10(D)D 
dadd 
dload_3
dload_3
ddiv 
dadd 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Entre com os coeficientes da equacao de 2o grau:"
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
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore 5
dload_3
ldc2_w 2.0
invokestatic java/lang/Math/pow(DD)D 
ldc2_w 4.0
dload_1
dmul 
dload 5
dmul 
dsub 
dstore 7
dload_1
ldc2_w 0.0
dcmpg 
ifeq COLOCATRUEdiferente_6
dconst_1 
goto SAIDAdiferente_7
COLOCATRUEdiferente_6:
dconst_0 
SAIDAdiferente_7:
dconst_0 
dcmpg 
ifeq LABELFALSE_4

dload 7
ldc2_w 0.0
dcmpg 
iflt COLOCATRUEmenor_2
dconst_0 
goto SAIDAmenor_3
COLOCATRUEmenor_2:
dconst_1 
SAIDAmenor_3:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Não existem raizes reais."
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_1

LABELFALSE_0:
dload_3
ldc2_w -1.0 
dmul 
dload 7
ldc2_w 1.0
ldc2_w 2.0
ddiv 
invokestatic java/lang/Math/pow(DD)D 
dadd 
ldc2_w 2.0
dload_1
dmul 
ddiv 
dstore 9
dload_3
ldc2_w -1.0 
dmul 
dload 7
ldc2_w 1.0
ldc2_w 2.0
ddiv 
invokestatic java/lang/Math/pow(DD)D 
dsub 
ldc2_w 2.0
dload_1
dmul 
ddiv 
dstore 11
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x_1 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 9
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x_2 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 11
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_1:
goto LABELSAIDA_5

LABELFALSE_4:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Nao eh equacao do 2o grau!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_5:
return 
.end method 
