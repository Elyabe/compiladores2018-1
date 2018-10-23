package comandoPrimitivo;

import semantico.TipoDado;

public class PrimitivoEntrada extends ComandoPrimitivo{
	int referencia;
	TipoDado tipo;
	
	public PrimitivoEntrada(int referencia, TipoDado tipo){
		this.referencia = referencia;
		this.tipo = tipo;
	}
	
	public String geraCodigoDestino() { //terceira passagem gerar c�digo intermediario
		//sempre l� para alguma variavel ja declarada
		//a entrada vem da pilha? DUVIDA
		String codDestinoEntrada = "";
		
		codDestinoEntrada+=";begin entrada\n";
		codDestinoEntrada+="new java/util/Scanner\n"
				+ "dup\n" //necessario?
				+ "getstatic java/lang/System.in:Ljava/io/InputStream;\n"
				+ "invokespecial java/util/Scanner.\"<init>\":(Ljava/io/InputStream;)V\n"
				+ "astore_3\n" //carrega para a memoria
				+ "aload_3\n"; //empilha 
		if(tipo == TipoDado.NUM) { 
			codDestinoEntrada+="invokevirtual java/util/Scanner.nextDouble:()D\n";
		}else { //caso n�o seja um n�mero ser� uma STR
			codDestinoEntrada+="invokevirtual java/util/Scanner.next:()Ljava/lang/String;\n";	
		}
		codDestinoEntrada+= "dstore " + this.referencia + " \r\n"
				+ ";end entrada \n";
		return codDestinoEntrada;
	}

	public String toString() {
		return "Entrada: ref "+this.referencia+" tipo "+this.tipo+"\n";
	}

}
