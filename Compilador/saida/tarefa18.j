.source prog_destino.java 
.class public tarefa18
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 1062 
.limit locals 45
ldc2_w 0.0
dstore_1
dload_1
dstore_3
dload_3
dstore 5
ldc2_w 0.0
dstore 9
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "*****Primeiro Teste ******\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 1.0
dstore_1
LABELINICIOENQUANTO_9:
dload_1
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_10
dconst_0 
goto SAIDAmenor_11
COLOCATRUEmenor_10:
dconst_1 
SAIDAmenor_11:
dconst_0 
dcmpg 
ifeq LABELFALSE_8

ldc2_w 1.0
dstore_3
LABELINICIOENQUANTO_5:
dload_3
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_6
dconst_0 
goto SAIDAmenor_7
COLOCATRUEmenor_6:
dconst_1 
SAIDAmenor_7:
dconst_0 
dcmpg 
ifeq LABELFALSE_4

ldc2_w 1.0
dstore 5
LABELINICIOENQUANTO_1:
dload 5
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_2
dconst_0 
goto SAIDAmenor_3
COLOCATRUEmenor_2:
dconst_1 
SAIDAmenor_3:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "i = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ j = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ k = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload 9
ldc2_w 1.0
dadd 
dstore 9
dload 5
ldc2_w 1.0
dadd 
dstore 5
goto LABELINICIOENQUANTO_1

LABELFALSE_0:
dload_3
ldc2_w 1.0
dadd 
dstore_3
goto LABELINICIOENQUANTO_5

LABELFALSE_4:
dload_1
ldc2_w 1.0
dadd 
dstore_1
goto LABELINICIOENQUANTO_9

LABELFALSE_8:
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 9
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " possibilidades\n\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n*****Segundo Teste ******\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 2.0
dstore 11
LABELINICIOENQUANTO_21:
dload 11
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_22
dconst_0 
goto SAIDAmenor_23
COLOCATRUEmenor_22:
dconst_1 
SAIDAmenor_23:
dconst_0 
dcmpg 
ifeq LABELFALSE_20

ldc2_w 2.0
dstore 13
LABELINICIOENQUANTO_17:
dload 13
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_18
dconst_0 
goto SAIDAmenor_19
COLOCATRUEmenor_18:
dconst_1 
SAIDAmenor_19:
dconst_0 
dcmpg 
ifeq LABELFALSE_16

ldc2_w 2.0
dstore 15
LABELINICIOENQUANTO_13:
dload 15
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_14
dconst_0 
goto SAIDAmenor_15
COLOCATRUEmenor_14:
dconst_1 
SAIDAmenor_15:
dconst_0 
dcmpg 
ifeq LABELFALSE_12

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "var_1 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 11
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ var_2 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 13
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ var_3 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 15
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload 15
ldc2_w 1.0
dadd 
dstore 15
goto LABELINICIOENQUANTO_13

LABELFALSE_12:
dload 13
ldc2_w 1.0
dadd 
dstore 13
goto LABELINICIOENQUANTO_17

LABELFALSE_16:
dload 11
ldc2_w 1.0
dadd 
dstore 11
goto LABELINICIOENQUANTO_21

LABELFALSE_20:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n*****Terceiro Teste ******\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 2.0
dstore 17
LABELINICIOENQUANTO_43:
dload 17
ldc2_w 4.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_44
dconst_0 
goto SAIDAmenor_45
COLOCATRUEmenor_44:
dconst_1 
SAIDAmenor_45:
dconst_0 
dcmpg 
ifeq LABELFALSE_42

ldc2_w 2.0
dstore 19
LABELINICIOENQUANTO_39:
dload 19
ldc2_w 4.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_40
dconst_0 
goto SAIDAmenor_41
COLOCATRUEmenor_40:
dconst_1 
SAIDAmenor_41:
dconst_0 
dcmpg 
ifeq LABELFALSE_38

ldc2_w 2.0
dstore 21
LABELINICIOENQUANTO_35:
dload 21
ldc2_w 4.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_36
dconst_0 
goto SAIDAmenor_37
COLOCATRUEmenor_36:
dconst_1 
SAIDAmenor_37:
dconst_0 
dcmpg 
ifeq LABELFALSE_34

dload 17
dload 19
dcmpg 
ifeq COLOCATRUEigual_29
dconst_0 
goto SAIDAigual_30
COLOCATRUEigual_29:
dconst_1 
SAIDAigual_30:
dload 19
dload 21
dcmpg 
ifeq COLOCATRUEigual_31
dconst_0 
goto SAIDAigual_32
COLOCATRUEigual_31:
dconst_1 
SAIDAigual_32:
dconst_1 
dcmpg 
ifeq SAIDAe_33
pop2 
dconst_0 
SAIDAe_33:
dconst_0 
dcmpg 
ifeq LABELFALSE_28

ldc2_w 0.0
dstore 7
LABELINICIOENQUANTO_25:
dload 7
dload 17
ldc2_w 1.0
dsub 
dcmpg 
iflt COLOCATRUEmenor_26
dconst_0 
goto SAIDAmenor_27
COLOCATRUEmenor_26:
dconst_1 
SAIDAmenor_27:
dconst_0 
dcmpg 
ifeq LABELFALSE_24

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "indices iguais\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload 7
ldc2_w 1.0
dadd 
dstore 7
goto LABELINICIOENQUANTO_25

LABELFALSE_24:
LABELFALSE_28:
dload 21
ldc2_w 1.0
dadd 
dstore 21
goto LABELINICIOENQUANTO_35

LABELFALSE_34:
dload 19
ldc2_w 1.0
dadd 
dstore 19
goto LABELINICIOENQUANTO_39

LABELFALSE_38:
dload 17
ldc2_w 1.0
dadd 
dstore 17
goto LABELINICIOENQUANTO_43

LABELFALSE_42:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n*****Quarto Teste ******\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 1.0
dstore 23
ldc2_w 0.0
dstore 25
LABELINICIOENQUANTO_79:
dload 25
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_80
dconst_0 
goto SAIDAmenor_81
COLOCATRUEmenor_80:
dconst_1 
SAIDAmenor_81:
dconst_0 
dcmpg 
ifeq LABELFALSE_78

ldc2_w 0.0
dstore 27
LABELINICIOENQUANTO_75:
dload 27
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_76
dconst_0 
goto SAIDAmenor_77
COLOCATRUEmenor_76:
dconst_1 
SAIDAmenor_77:
dconst_0 
dcmpg 
ifeq LABELFALSE_74

ldc2_w 0.0
dstore 29
LABELINICIOENQUANTO_71:
dload 29
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_72
dconst_0 
goto SAIDAmenor_73
COLOCATRUEmenor_72:
dconst_1 
SAIDAmenor_73:
dconst_0 
dcmpg 
ifeq LABELFALSE_70

ldc2_w 0.0
dstore 31
LABELINICIOENQUANTO_67:
dload 31
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_68
dconst_0 
goto SAIDAmenor_69
COLOCATRUEmenor_68:
dconst_1 
SAIDAmenor_69:
dconst_0 
dcmpg 
ifeq LABELFALSE_66

ldc2_w 0.0
dstore 33
LABELINICIOENQUANTO_63:
dload 33
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_64
dconst_0 
goto SAIDAmenor_65
COLOCATRUEmenor_64:
dconst_1 
SAIDAmenor_65:
dconst_0 
dcmpg 
ifeq LABELFALSE_62

ldc2_w 0.0
dstore 35
LABELINICIOENQUANTO_59:
dload 35
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_60
dconst_0 
goto SAIDAmenor_61
COLOCATRUEmenor_60:
dconst_1 
SAIDAmenor_61:
dconst_0 
dcmpg 
ifeq LABELFALSE_58

ldc2_w 0.0
dstore 37
LABELINICIOENQUANTO_55:
dload 37
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_56
dconst_0 
goto SAIDAmenor_57
COLOCATRUEmenor_56:
dconst_1 
SAIDAmenor_57:
dconst_0 
dcmpg 
ifeq LABELFALSE_54

ldc2_w 0.0
dstore 39
LABELINICIOENQUANTO_51:
dload 39
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_52
dconst_0 
goto SAIDAmenor_53
COLOCATRUEmenor_52:
dconst_1 
SAIDAmenor_53:
dconst_0 
dcmpg 
ifeq LABELFALSE_50

ldc2_w 0.0
dstore 41
LABELINICIOENQUANTO_47:
dload 41
ldc2_w 2.0
ldc2_w 1.0
dadd 
dcmpg 
iflt COLOCATRUEmenor_48
dconst_0 
goto SAIDAmenor_49
COLOCATRUEmenor_48:
dconst_1 
SAIDAmenor_49:
dconst_0 
dcmpg 
ifeq LABELFALSE_46

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "n = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 23
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x1 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 25
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ y1 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 27
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ z1 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 29
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x2 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 31
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ y2 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 33
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ z2 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 35
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x3 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 31
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ y3 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 39
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "/ z3 = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 41
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload 23
ldc2_w 1.0
dadd 
dstore 23
dload 41
ldc2_w 1.0
dadd 
dstore 41
goto LABELINICIOENQUANTO_47

LABELFALSE_46:
dload 39
ldc2_w 1.0
dadd 
dstore 39
goto LABELINICIOENQUANTO_51

LABELFALSE_50:
dload 37
ldc2_w 1.0
dadd 
dstore 37
goto LABELINICIOENQUANTO_55

LABELFALSE_54:
dload 35
ldc2_w 1.0
dadd 
dstore 35
goto LABELINICIOENQUANTO_59

LABELFALSE_58:
dload 33
ldc2_w 1.0
dadd 
dstore 33
goto LABELINICIOENQUANTO_63

LABELFALSE_62:
dload 31
ldc2_w 1.0
dadd 
dstore 31
goto LABELINICIOENQUANTO_67

LABELFALSE_66:
dload 29
ldc2_w 1.0
dadd 
dstore 29
goto LABELINICIOENQUANTO_71

LABELFALSE_70:
dload 27
ldc2_w 1.0
dadd 
dstore 27
goto LABELINICIOENQUANTO_75

LABELFALSE_74:
dload 25
ldc2_w 1.0
dadd 
dstore 25
goto LABELINICIOENQUANTO_79

LABELFALSE_78:
return 
.end method 
