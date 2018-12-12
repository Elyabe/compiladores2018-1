.source prog_destino.java 
.class public teste22
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 42 
.limit locals 6
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Teste "
ldc " de "
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
ldc " Concatenacao"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc "Hello "
astore_1
ldc "World"
astore_2
ldc ":)"
astore_3
aload_1
aload_2
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
ldc "Hello World"
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
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Concatenacao boa, hein!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_0:
return 
.end method 
