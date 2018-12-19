.source prog_destino.java 
.class public teste25
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

; Procedimento
.method public static metodo()V
.limit stack 42 
.limit locals 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Executando bloco de comandos do procedimento\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 


;Funcao principal
.method public static main([Ljava/lang/String;)V 
.limit stack 42 
.limit locals 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite um valor numerico para x:\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 

invokestatic teste25.metodo()V

;Chamando metodo de outro 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc2_w 10.0
invokestatic teste25.dobro(D)D
invokevirtual java/io/PrintStream/println(D)V

return 
.end method 

; Funcao dobro de um double passado
.method public static dobro(D)D
.limit stack 10 
.limit locals 5
dload_0
ldc2_w 2.0
dmul
dreturn 
.end method 



