.source prog_destino.java 
.class public teste30
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static boasVindas(Ljava/lang/String;)V
.limit stack 20 
.limit locals 5 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Bem vindo(a), "
aload_0
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
ldc "!"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static verificarPermissaoXVideos(DLjava/lang/String;)V
.limit stack 20 
.limit locals 7 
dload_0
ldc2_w 18.0
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
ldc "Permitido, safadão!"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
aload_2
invokestatic teste30.boasVindas(Ljava/lang/String;)V
goto LABELSAIDA_1

LABELFALSE_0:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Oh oh, volte e veja Dora Aventureira, "
aload_2
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
ldc "!"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_1:
return 
.end method 

.method public static testaMultiplosParametros(DDLjava/lang/String;Ljava/lang/String;)V
.limit stack 20 
.limit locals 10 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "A media aritmetica eh "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_0
dload_2
dadd 
ldc2_w 2.0
ddiv 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload 4
aload 5
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 20 
.limit locals 10 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Informe seu nome: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextLine()Ljava/lang/String; 
astore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Informe sua idade: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore 4
dload 4
aload_3
invokestatic teste30.verificarPermissaoXVideos(DLjava/lang/String;)V
ldc2_w 12.0
ldc2_w 8.0
ldc "Testa"
ldc " Parametros"
invokestatic teste30.testaMultiplosParametros(DDLjava/lang/String;Ljava/lang/String;)V
return 
.end method 

