.source prog_destino.java 
.class public teste16
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 32 
.limit locals 5
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_1
ldc2_w 10.0
ldc2_w 1.0
dconst_0 
dcmpg 
ifne SAIDAe_1
pop2 
dconst_0 
SAIDAe_1:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Entrou\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_0:
return 
.end method 
