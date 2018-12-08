.source prog_destino.java 
.class public teste19
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 102 
.limit locals 7
ldc2_w 0.0
dstore_1
ldc2_w 0.0
ldc2_w 0.0
dconst_0 
dcmpg 
ifeq SAIDAou_0
pop2 
dconst_1 
SAIDAou_0:
ldc2_w 3.0
dconst_0 
dcmpg 
ifeq ComparaSegundo0_2
goto ComparaSegundo1_3
ComparaSegundo0_2:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_5
goto COLOCATRUEXOR_4
ComparaSegundo1_3:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_4
COLOCAFALSEXOR_5:
dconst_0 
goto SAIDAouExclusivo_1
COLOCATRUEXOR_4:
dconst_1 
SAIDAouExclusivo_1:
dstore_3
ldc2_w 2.0
dstore_1
LABELINICIOENQUANTO_7:
dload_1
ldc2_w 5000.0
dcmpg 
iflt COLOCATRUEmenor_8
dconst_0 
goto SAIDAmenor_9
COLOCATRUEmenor_8:
dconst_1 
SAIDAmenor_9:
dload_3
dconst_0 
dcmpg 
ifne TestaSegundo1e_11
pop2 
dconst_0 
goto SAIDAe_10
TestaSegundo1e_11:
dconst_0 
dcmpg 
ifne ColocaTrueE_12
dconst_0 
goto SAIDAe_10
ColocaTrueE_12:
dconst_1 
SAIDAe_10:
dconst_0 
dcmpg 
ifeq LABELFALSE_6

getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_1
dload_3
ldc2_w 10.0
invokestatic java/lang/Math/log10(D)D 
dadd 
dmul 
dstore_1
goto LABELINICIOENQUANTO_7

LABELFALSE_6:
dload_1
ldc2_w 2.0
dsub 
dstore_1
dload_3
ldc2_w 3.0
ddiv 
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "
"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
