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

.method public static hello_world()V
.limit stack 62 
.limit locals 9 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "*** procedimento hello_word() *** "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Hello, Igor"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static teste_comandos_bloco()V
.limit stack 62 
.limit locals 20 
ldc ""
astore 9
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "*** procedimento teste_comandos_blocos() *** "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 1.0
dstore 10
LABELINICIOENQUANTO_13:
dload 10
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
dstore 12
LABELINICIOENQUANTO_5:
dload 12
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

dload_1
dload 12
dadd 
dload 10
dadd 
dstore_3
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_3
ldc2_w 2.0
ddiv 
dstore 5
dload 5
ldc2_w 2.0
dmul 
dload_3
dsub 
ldc2_w 0.0
dcmpg 
ifeq COLOCATRUEigual_2
dconst_0 
goto SAIDAigual_3
COLOCATRUEigual_2:
dconst_1 
SAIDAigual_3:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

aload 9
ldc "1"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 9
goto LABELSAIDA_1

LABELFALSE_0:
aload 9
ldc "0"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore 9
LABELSAIDA_1:
dload 12
ldc2_w 1.0
dadd 
dstore 12
goto LABELINICIOENQUANTO_5

LABELFALSE_4:
dload_1
ldc2_w 1.0
dadd 
dstore_1
goto LABELINICIOENQUANTO_9

LABELFALSE_8:
dload 10
ldc2_w 1.0
dadd 
dstore 10
goto LABELINICIOENQUANTO_13

LABELFALSE_12:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Resultado: "
aload 9
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "//Comando Para"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 0.0
dstore 14
LABELINICIOENQUANTO_17:
dload 14
ldc2_w 4.0
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

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 2.0
dload 14
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload 14
ldc2_w 1.0
dadd 
dstore 14
goto LABELINICIOENQUANTO_17

LABELFALSE_16:
ldc2_w 1.0
dstore_1
ldc2_w 1.0
dstore 12
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "x="
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " / y = "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 12
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_1
dload 12
dadd 
dconst_0 
dcmpg 
ifeq LABELFALSE_20

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "ok"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
goto LABELSAIDA_21

LABELFALSE_20:
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
dload 12
dadd 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "não ok"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELSAIDA_21:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "TRUE"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
ldc2_w 2.0
dload_1
dmul 
ldc2_w 2.0
dcmpg 
ifeq COLOCATRUEigual_23
dconst_0 
goto SAIDAigual_24
COLOCATRUEigual_23:
dconst_1 
SAIDAigual_24:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_22

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Dobro"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSECASO_22:
ldc2_w 2.0
dload_1
dmul 
ldc2_w 4.0
dcmpg 
ifeq COLOCATRUEigual_26
dconst_0 
goto SAIDAigual_27
COLOCATRUEigual_26:
dconst_1 
SAIDAigual_27:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_25

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Quatro"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSECASO_25:
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 62 
.limit locals 11 
ldc2_w 1.0
dstore_1
ldc2_w 1.0
dstore_3
ldc2_w 4.0
dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "***Procedimento"
ldc " principal***"
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 2.0
dload_1
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 3.0
dload_3
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc2_w 4.0
dload 5
dmul 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
invokestatic teste28.hello_world()V
invokestatic teste28.teste_comandos_bloco()V
return 
.end method 

