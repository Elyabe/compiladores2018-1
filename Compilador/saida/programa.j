.source prog_destino.java 
.class public programa
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 422 
.limit locals 13
ldc2_w 0.0
dstore 5
ldc2_w 8.0
dstore 7
ldc2_w 2.0
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n******Teste de atribuicao multipla**********\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 1.0
dload_3
ldc2_w 2.0
invokestatic java/lang/Math/pow(DD)D 
dadd 
dstore_3
ldc2_w 1.0
dstore 7
ldc2_w 0.0
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_0
dconst_0 
goto SAIDAnegacao_1
COLOCATRUEnegacao_0:
dconst_1 
SAIDAnegacao_1:
ldc2_w 0.0
dconst_0 
dcmpg 
ifeq SAIDAou_2
pop2 
dconst_1 
SAIDAou_2:
dstore_1
dload 5
dstore 9
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " a "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n b "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 7
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n x "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n y "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 9
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n z "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 10.0
ldc2_w 1.0
dconst_0 
dcmpg 
ifne TestaSegundo1e_6
pop2 
dconst_0 
goto SAIDAe_5
TestaSegundo1e_6:
dconst_0 
dcmpg 
ifne ColocaTrueE_7
dconst_0 
goto SAIDAe_5
ColocaTrueE_7:
dconst_1 
SAIDAe_5:
dconst_0 
dcmpg 
ifeq LABELFALSE_3

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Diferente\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_4

LABELFALSE_3:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Iguais\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_4:
ldc2_w 1.0
ldc2_w 1.5
dconst_0 
dcmpg 
ifeq ComparaSegundo0_10
goto ComparaSegundo1_11
ComparaSegundo0_10:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_13
goto COLOCATRUEXOR_12
ComparaSegundo1_11:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_12
COLOCAFALSEXOR_13:
dconst_0 
goto SAIDAouExclusivo_9
COLOCATRUEXOR_12:
dconst_1 
SAIDAouExclusivo_9:
dconst_0 
dcmpg 
ifeq LABELFALSE_8

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Verdeiro\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_8:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n\n******Teste do negação **********\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_14
dconst_0 
goto SAIDAnegacao_15
COLOCATRUEnegacao_14:
dconst_1 
SAIDAnegacao_15:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_16
dconst_0 
goto SAIDAnegacao_17
COLOCATRUEnegacao_16:
dconst_1 
SAIDAnegacao_17:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_3
dload 5
dconst_0 
dcmpg 
ifeq SAIDAou_20
pop2 
dconst_1 
SAIDAou_20:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_21
dconst_0 
goto SAIDAnegacao_22
COLOCATRUEnegacao_21:
dconst_1 
SAIDAnegacao_22:
dconst_0 
dcmpg 
ifeq LABELFALSE_18

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Primeiro bloco\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_19

LABELFALSE_18:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Bloco do senão\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_19:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n\n******Teste de otimizacao**********\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "NAO NAO NAO NAO  23\n "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 23.0
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "NAO NAO NAO  23\n "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 23.0
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_23
dconst_0 
goto SAIDAnegacao_24
COLOCATRUEnegacao_23:
dconst_1 
SAIDAnegacao_24:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\nTestando Identidade DeMorgan\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "NAO ( NAO a OU NAO b ) = NAO NAO (a E b) \n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_25
dconst_0 
goto SAIDAnegacao_26
COLOCATRUEnegacao_25:
dconst_1 
SAIDAnegacao_26:
dload 7
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_27
dconst_0 
goto SAIDAnegacao_28
COLOCATRUEnegacao_27:
dconst_1 
SAIDAnegacao_28:
dconst_0 
dcmpg 
ifeq SAIDAou_29
pop2 
dconst_1 
SAIDAou_29:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_30
dconst_0 
goto SAIDAnegacao_31
COLOCATRUEnegacao_30:
dconst_1 
SAIDAnegacao_31:
dload_3
dload 7
dconst_0 
dcmpg 
ifne TestaSegundo1e_33
pop2 
dconst_0 
goto SAIDAe_32
TestaSegundo1e_33:
dconst_0 
dcmpg 
ifne ColocaTrueE_34
dconst_0 
goto SAIDAe_32
ColocaTrueE_34:
dconst_1 
SAIDAe_32:
dcmpg 
ifeq COLOCATRUEigual_35
dconst_0 
goto SAIDAigual_36
COLOCATRUEigual_35:
dconst_1 
SAIDAigual_36:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\nCancelamento\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dload 7
dconst_0 
dcmpg 
ifeq SAIDAou_37
pop2 
dconst_1 
SAIDAou_37:
dload_3
dload 7
dconst_0 
dcmpg 
ifeq SAIDAou_38
pop2 
dconst_1 
SAIDAou_38:
dcmpg 
ifeq COLOCATRUEigual_39
dconst_0 
goto SAIDAigual_40
COLOCATRUEigual_39:
dconst_1 
SAIDAigual_40:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dload 7
dconst_0 
dcmpg 
ifne TestaSegundo1e_42
pop2 
dconst_0 
goto SAIDAe_41
TestaSegundo1e_42:
dconst_0 
dcmpg 
ifne ColocaTrueE_43
dconst_0 
goto SAIDAe_41
ColocaTrueE_43:
dconst_1 
SAIDAe_41:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
