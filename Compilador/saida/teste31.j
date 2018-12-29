.source prog_destino.java 
.class public teste31
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static dobro(D)D
.limit stack 10 
.limit locals 4 
dload_0
ldc2_w 2.0
dmul 
dstore_0
dload_0
dreturn 
return 
.end method 

.method public static qtdDigitos(D)V
.limit stack 8 
.limit locals 4 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "O numero "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_0
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " possui "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_0
invokestatic java/lang/Math/log10(D)D 
invokestatic java/lang/Math/floor(D)D 
ldc2_w 1.0
dadd 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc " digitos"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
return 
.end method 

.method public static determinarDigito(D)Ljava/lang/String;
.limit stack 18 
.limit locals 5 
ldc ""
astore_2
dload_0
ldc2_w 0.0
dcmpg 
ifeq COLOCATRUEigual_1
dconst_0 
goto SAIDAigual_2
COLOCATRUEigual_1:
dconst_1 
SAIDAigual_2:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_0

ldc "0"
astore_2
LABELFALSECASO_0:
dload_0
ldc2_w 1.0
dcmpg 
ifeq COLOCATRUEigual_4
dconst_0 
goto SAIDAigual_5
COLOCATRUEigual_4:
dconst_1 
SAIDAigual_5:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_3

ldc "1"
astore_2
LABELFALSECASO_3:
dload_0
ldc2_w 2.0
dcmpg 
ifeq COLOCATRUEigual_7
dconst_0 
goto SAIDAigual_8
COLOCATRUEigual_7:
dconst_1 
SAIDAigual_8:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_6

ldc "2"
astore_2
LABELFALSECASO_6:
dload_0
ldc2_w 3.0
dcmpg 
ifeq COLOCATRUEigual_10
dconst_0 
goto SAIDAigual_11
COLOCATRUEigual_10:
dconst_1 
SAIDAigual_11:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_9

ldc "3"
astore_2
LABELFALSECASO_9:
dload_0
ldc2_w 4.0
dcmpg 
ifeq COLOCATRUEigual_13
dconst_0 
goto SAIDAigual_14
COLOCATRUEigual_13:
dconst_1 
SAIDAigual_14:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_12

ldc "4"
astore_2
LABELFALSECASO_12:
dload_0
ldc2_w 5.0
dcmpg 
ifeq COLOCATRUEigual_16
dconst_0 
goto SAIDAigual_17
COLOCATRUEigual_16:
dconst_1 
SAIDAigual_17:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_15

ldc "5"
astore_2
LABELFALSECASO_15:
dload_0
ldc2_w 6.0
dcmpg 
ifeq COLOCATRUEigual_19
dconst_0 
goto SAIDAigual_20
COLOCATRUEigual_19:
dconst_1 
SAIDAigual_20:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_18

ldc "6"
astore_2
LABELFALSECASO_18:
dload_0
ldc2_w 7.0
dcmpg 
ifeq COLOCATRUEigual_22
dconst_0 
goto SAIDAigual_23
COLOCATRUEigual_22:
dconst_1 
SAIDAigual_23:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_21

ldc "7"
astore_2
LABELFALSECASO_21:
dload_0
ldc2_w 8.0
dcmpg 
ifeq COLOCATRUEigual_25
dconst_0 
goto SAIDAigual_26
COLOCATRUEigual_25:
dconst_1 
SAIDAigual_26:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_24

ldc "8"
astore_2
LABELFALSECASO_24:
dload_0
ldc2_w 9.0
dcmpg 
ifeq COLOCATRUEigual_28
dconst_0 
goto SAIDAigual_29
COLOCATRUEigual_28:
dconst_1 
SAIDAigual_29:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_27

ldc "9"
astore_2
LABELFALSECASO_27:
dload_0
ldc2_w 10.0
dcmpg 
ifeq COLOCATRUEigual_31
dconst_0 
goto SAIDAigual_32
COLOCATRUEigual_31:
dconst_1 
SAIDAigual_32:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_30

ldc "A"
astore_2
LABELFALSECASO_30:
dload_0
ldc2_w 11.0
dcmpg 
ifeq COLOCATRUEigual_34
dconst_0 
goto SAIDAigual_35
COLOCATRUEigual_34:
dconst_1 
SAIDAigual_35:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_33

ldc "B"
astore_2
LABELFALSECASO_33:
dload_0
ldc2_w 12.0
dcmpg 
ifeq COLOCATRUEigual_37
dconst_0 
goto SAIDAigual_38
COLOCATRUEigual_37:
dconst_1 
SAIDAigual_38:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_36

ldc "C"
astore_2
LABELFALSECASO_36:
dload_0
ldc2_w 13.0
dcmpg 
ifeq COLOCATRUEigual_40
dconst_0 
goto SAIDAigual_41
COLOCATRUEigual_40:
dconst_1 
SAIDAigual_41:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_39

ldc "D"
astore_2
LABELFALSECASO_39:
dload_0
ldc2_w 14.0
dcmpg 
ifeq COLOCATRUEigual_43
dconst_0 
goto SAIDAigual_44
COLOCATRUEigual_43:
dconst_1 
SAIDAigual_44:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_42

ldc "E"
astore_2
LABELFALSECASO_42:
dload_0
ldc2_w 15.0
dcmpg 
ifeq COLOCATRUEigual_46
dconst_0 
goto SAIDAigual_47
COLOCATRUEigual_46:
dconst_1 
SAIDAigual_47:
dconst_0 
dcmpg 
ifeq LABELFALSECASO_45

ldc "F"
astore_2
LABELFALSECASO_45:
aload_2
areturn 
return 
.end method 

.method public static converterDecimalHexadecimal(D)Ljava/lang/String;
.limit stack 50 
.limit locals 9 
ldc ""
astore_2
LABELINICIOENQUANTO_49:
dload_0
ldc2_w 16.0
dcmpg 
ifge COLOCATRUEmaiorIgual_50
dconst_0 
goto SAIDAmaiorIgual_51
COLOCATRUEmaiorIgual_50:
dconst_1 
SAIDAmaiorIgual_51:
dconst_0 
dcmpg 
ifeq LABELFALSE_48

dload_0
ldc2_w 16.0
ddiv 
invokestatic java/lang/Math/floor(D)D 
dstore_3
dload_0
dload_3
ldc2_w 16.0
dmul 
dsub 
dstore 5
dload 5
invokestatic teste31.determinarDigito(D)Ljava/lang/String;
aload_2
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore_2
dload_3
dstore_0
goto LABELINICIOENQUANTO_49

LABELFALSE_48:
dload_0
invokestatic teste31.determinarDigito(D)Ljava/lang/String;
aload_2
invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; 
astore_2
aload_2
areturn 
return 
.end method 

.method public static main([Ljava/lang/String;)V
.limit stack 47 
.limit locals 4 
ldc2_w 4.5
ldc2_w 2.0
ddiv 
invokestatic teste31.dobro(D)D
dstore_0
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_0
invokestatic teste31.dobro(D)D
ldc2_w 10.0
invokestatic java/lang/Math/log10(D)D 
dadd 
invokestatic java/lang/Math/log10(D)D 
invokevirtual java/io/PrintStream/print(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite o numero que deseja converter: "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_0
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_0
invokestatic teste31.converterDecimalHexadecimal(D)Ljava/lang/String;
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
dload_0
invokestatic teste31.qtdDigitos(D)V
return 
.end method 

