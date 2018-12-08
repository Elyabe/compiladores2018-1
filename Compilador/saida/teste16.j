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
.limit stack 132 
.limit locals 7
ldc2_w 10.0
dstore_1
ldc2_w 2.0
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "log("
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc ")="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "****Testando propriedades Matemáticas:****"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
dload_3
dmul 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokestatic java/lang/Math/log10(D)D 
dload_3
invokestatic java/lang/Math/log10(D)D 
dadd 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
dload_3
ddiv 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokestatic java/lang/Math/log10(D)D 
dload_3
invokestatic java/lang/Math/log10(D)D 
dsub 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 10.0
dload_1
invokestatic java/lang/Math/pow(DD)D 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokestatic java/lang/Math/log10(D)D 
ldc2_w 2.0
invokestatic java/lang/Math/log10(D)D 
ddiv 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "= lg(2)"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
