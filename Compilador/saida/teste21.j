.source prog_destino.java 
.class public teste21
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 122 
.limit locals 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite as duas palavras que desejas testar: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextLine()Ljava/lang/String; 
astore_1
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextLine()Ljava/lang/String; 
astore_2
aload_1
aload_2
invokevirtual java/lang/String/compareTo(Ljava/lang/String;)I 
iconst_0 
if_icmpeq COLOCATRUEigual_7
dconst_0 
goto SAIDAigual_8
COLOCATRUEigual_7:
dconst_1 
SAIDAigual_8:
dconst_0 
dcmpg 
ifeq LABELFALSE_5

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Palavras iguais!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_6

LABELFALSE_5:
aload_1
aload_2
invokevirtual java/lang/String/compareTo(Ljava/lang/String;)I 
iconst_0 
if_icmpeq COLOCATRUEigual_1
dconst_0 
goto SAIDAigual_2
COLOCATRUEigual_1:
dconst_1 
SAIDAigual_2:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_3
dconst_0 
goto SAIDAnegacao_4
COLOCATRUEnegacao_3:
dconst_1 
SAIDAnegacao_4:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Palavras diferentes!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_0:
LABELSAIDA_6:
ldc "Sensitive Case"
astore_1
ldc "sensitive Case"
astore_2
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_1
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_2
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_1
aload_2
invokevirtual java/lang/String/compareTo(Ljava/lang/String;)I 
iconst_0 
if_icmpeq COLOCATRUEigual_9
dconst_0 
goto SAIDAigual_10
COLOCATRUEigual_9:
dconst_1 
SAIDAigual_10:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 10.0
ldc2_w 1.0
invokestatic java/lang/Double/max(DD)D 
ldc2_w 0.0
ldc2_w 10.0
invokestatic java/lang/Double/min(DD)D 
dadd 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
