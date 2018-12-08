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
.limit stack 62 
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
return 
.end method 
