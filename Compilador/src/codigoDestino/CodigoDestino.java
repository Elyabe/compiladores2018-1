package codigoDestino;

import java.io.*;

import apoio.Config;
import comandoAltoNivel.ComandoAltoNivel;
import comandoAltoNivel.ComandoAtribuicao;
import comandoAltoNivel.ListaComandosAltoNivel;
import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;
import parser.Compilador;

public class CodigoDestino {
	/*Alocacao dinamica da pilha
	 * para cada instrucao no codigo destino:
	 * 	se for operacao de empilhar, soma 2 se for NUMERO, e 1 se for PALAVRA, na variavel aux
	 * 	se for operacao de desempilhar, subtrai 2 se for NUMERO, e 1 se for PALAVRA, na variavel aux
	 * a cada vez que aux for incrementado:
	 * 	se aux > tam, entao tam = aux, onde aux eh o tamanho atual da pilha
	 * 								, e tam eh o MAIOR tamanho que a pilha alcancou ate entao
	 * 
	 * a manipulacao de aux eh feita durante a geracao de codigo destino da expressao (classe Expressao)
	 * e apos a criacao do comando primitivo (classes ComandoAtribuicao e ComandoEntrada)
	 * 
	 * */
	public static int tamanhoTotalPilha = 0, tamanhoPilha = 0;
	StringBuilder codigo;
	
	public CodigoDestino(ListaComandosPrimitivos listaComandosPrimitivos) {
		this.codigo = new StringBuilder();
		this.codigo.append(".source prog_destino.java \r\n");
		this.codigo.append(".class public "+ Config.nomeArquivo + "\r\n");
		this.codigo.append(".super java/lang/Object \r\n");
		this.codigo.append(".method public <init>()V \r\n");
		this.codigo.append(".limit stack 1 \r\n");
		this.codigo.append(".limit locals 1 \r\n");
		this.codigo.append("aload_0 \r\n");
		this.codigo.append("invokespecial java/lang/Object/<init>()V \r\n");
		this.codigo.append("return \r\n");
		this.codigo.append(".end method \r\n\r\n");
		this.codigo.append(listaComandosPrimitivos.geraCodigoDestinoTotal());
	}
	
	public void geraArquivo(String nomeArquivo) throws IOException {
		File newFile = new File(nomeArquivo);
		newFile.createNewFile();
		
		BufferedWriter arqSaida = new BufferedWriter(new FileWriter(newFile));
		arqSaida.write(this.codigo.toString());
		arqSaida.flush();
	    arqSaida.close();    
	}	
	
	public String toString() {
		return this.codigo.toString();
	}
	
}

