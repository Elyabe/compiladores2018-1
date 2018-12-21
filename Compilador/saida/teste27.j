.source prog_destino.java 
.class public teste27
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static imprimir()V
.limit stack 12 
.limit locals 12 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Novo bloco de codigo aqui!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Esse codigo foi feito num outro procedimento"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static ler()V
.limit stack 12 
.limit locals 12 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Entre com valor de z: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static testar_junto()V
.limit stack 12 
.limit locals 12 
invokestatic teste27.imprimir()V
invokestatic teste27.ler()V
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 12 
.limit locals 12 
invokestatic teste27.imprimir()V
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n***Teste variados com procedimentos***"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 3.0
dstore 7
ldc "Entre com o valor "
astore 9
LABELINICIOENQUANTO_1:
dload 7
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

invokestatic teste27.testar_junto()V
dload 7
ldc2_w 1.0
dsub 
dstore 7
goto LABELINICIOENQUANTO_1

LABELFALSE_0:
return 
.end method 

