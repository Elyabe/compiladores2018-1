.source prog_destino.java 
.class public teste23
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 72 
.limit locals 9
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 50.0
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 1.0
dstore_3
ldc2_w 2.0
dload_3
invokestatic java/lang/Math/pow(DD)D 
dstore_1
dload_3
ldc2_w 1.0
dadd 
ldc2_w 6.0
dadd 
dstore 5
return 
.end method 
