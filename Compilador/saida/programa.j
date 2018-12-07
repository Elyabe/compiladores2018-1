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
.limit stack 162 
.limit locals 11
ldc2_w 2.0
ldc2_w 2.0
invokestatic java/lang/Math/pow(DD)D 
dstore_3
ldc2_w 0.0
dstore 5
ldc2_w 8.0
dstore 7
ldc2_w 10.0
ldc2_w 1.0
dconst_0 
dcmpg 
ifne TestaSegundo1e_3
pop2 
dconst_0 
goto SAIDAe_2
TestaSegundo1e_3:
dconst_0 
dcmpg 
ifne ColocaTrueE_4
dconst_0 
goto SAIDAe_2
ColocaTrueE_4:
dconst_1 
SAIDAe_2:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Diferente\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_1

LABELFALSE_0:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Iguais\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_1:
ldc2_w 1.0
ldc2_w 1.5
dconst_0 
dcmpg 
ifeq ComparaSegundo0_7
goto ComparaSegundo1_8
ComparaSegundo0_7:
dconst_0 
dcmpg 
ifeq COLOCAFALSEXOR_10
goto COLOCATRUEXOR_9
ComparaSegundo1_8:
dconst_0 
dcmpg 
ifeq COLOCATRUEXOR_9
COLOCAFALSEXOR_10:
dconst_0 
goto SAIDAouExclusivo_6
COLOCATRUEXOR_9:
dconst_1 
SAIDAouExclusivo_6:
dconst_0 
dcmpg 
ifeq LABELFALSE_5

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Verdeiro\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_5:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n\n******Teste do negação **********\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_11
dconst_0 
goto SAIDAnegacao_12
COLOCATRUEnegacao_11:
dconst_1 
SAIDAnegacao_12:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_13
dconst_0 
goto SAIDAnegacao_14
COLOCATRUEnegacao_13:
dconst_1 
SAIDAnegacao_14:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_3
dload 5
dconst_0 
dcmpg 
ifeq SAIDAou_17
pop2 
dconst_1 
SAIDAou_17:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_18
dconst_0 
goto SAIDAnegacao_19
COLOCATRUEnegacao_18:
dconst_1 
SAIDAnegacao_19:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_20
dconst_0 
goto SAIDAnegacao_21
COLOCATRUEnegacao_20:
dconst_1 
SAIDAnegacao_21:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_22
dconst_0 
goto SAIDAnegacao_23
COLOCATRUEnegacao_22:
dconst_1 
SAIDAnegacao_23:
dconst_0 
dcmpg 
ifeq LABELFALSE_15

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Primeiro bloco\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_16

LABELFALSE_15:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Bloco do senão\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_16:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n\n******Teste de otimizacao**********\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "NAO NAO NAO NAO  23\n "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 23.0
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_24
dconst_0 
goto SAIDAnegacao_25
COLOCATRUEnegacao_24:
dconst_1 
SAIDAnegacao_25:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_26
dconst_0 
goto SAIDAnegacao_27
COLOCATRUEnegacao_26:
dconst_1 
SAIDAnegacao_27:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_28
dconst_0 
goto SAIDAnegacao_29
COLOCATRUEnegacao_28:
dconst_1 
SAIDAnegacao_29:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_30
dconst_0 
goto SAIDAnegacao_31
COLOCATRUEnegacao_30:
dconst_1 
SAIDAnegacao_31:
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
ifeq COLOCATRUEnegacao_32
dconst_0 
goto SAIDAnegacao_33
COLOCATRUEnegacao_32:
dconst_1 
SAIDAnegacao_33:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_34
dconst_0 
goto SAIDAnegacao_35
COLOCATRUEnegacao_34:
dconst_1 
SAIDAnegacao_35:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_36
dconst_0 
goto SAIDAnegacao_37
COLOCATRUEnegacao_36:
dconst_1 
SAIDAnegacao_37:
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
ifeq COLOCATRUEnegacao_38
dconst_0 
goto SAIDAnegacao_39
COLOCATRUEnegacao_38:
dconst_1 
SAIDAnegacao_39:
dload 7
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_40
dconst_0 
goto SAIDAnegacao_41
COLOCATRUEnegacao_40:
dconst_1 
SAIDAnegacao_41:
dconst_0 
dcmpg 
ifeq SAIDAou_42
pop2 
dconst_1 
SAIDAou_42:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_43
dconst_0 
goto SAIDAnegacao_44
COLOCATRUEnegacao_43:
dconst_1 
SAIDAnegacao_44:
dload_3
dload 7
dconst_0 
dcmpg 
ifne TestaSegundo1e_46
pop2 
dconst_0 
goto SAIDAe_45
TestaSegundo1e_46:
dconst_0 
dcmpg 
ifne ColocaTrueE_47
dconst_0 
goto SAIDAe_45
ColocaTrueE_47:
dconst_1 
SAIDAe_45:
dcmpg 
ifeq COLOCATRUEigual_48
dconst_0 
goto SAIDAigual_49
COLOCATRUEigual_48:
dconst_1 
SAIDAigual_49:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\nCancelamento\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_50
dconst_0 
goto SAIDAnegacao_51
COLOCATRUEnegacao_50:
dconst_1 
SAIDAnegacao_51:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_52
dconst_0 
goto SAIDAnegacao_53
COLOCATRUEnegacao_52:
dconst_1 
SAIDAnegacao_53:
dload 7
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_54
dconst_0 
goto SAIDAnegacao_55
COLOCATRUEnegacao_54:
dconst_1 
SAIDAnegacao_55:
dconst_0 
dcmpg 
ifeq COLOCATRUEnegacao_56
dconst_0 
goto SAIDAnegacao_57
COLOCATRUEnegacao_56:
dconst_1 
SAIDAnegacao_57:
dconst_0 
dcmpg 
ifeq SAIDAou_58
pop2 
dconst_1 
SAIDAou_58:
dload_3
dload 7
dconst_0 
dcmpg 
ifeq SAIDAou_59
pop2 
dconst_1 
SAIDAou_59:
dcmpg 
ifeq COLOCATRUEigual_60
dconst_0 
goto SAIDAigual_61
COLOCATRUEigual_60:
dconst_1 
SAIDAigual_61:
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
ifne TestaSegundo1e_63
pop2 
dconst_0 
goto SAIDAe_62
TestaSegundo1e_63:
dconst_0 
dcmpg 
ifne ColocaTrueE_64
dconst_0 
goto SAIDAe_62
ColocaTrueE_64:
dconst_1 
SAIDAe_62:
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 
