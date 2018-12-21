.source prog_destino.java 
.class public teste28
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 10 
.limit locals 10 
ldc2_w 0.0
dstore_2
ldc2_w 0.0
dstore 4
ldc2_w 1.0
dstore 6
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 2.0
dload_2
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 3.0
dload 4
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 4.0
dload 6
dmul 
invokevirtual java/io/PrintStream/print(D)V 
return 
.end method 

