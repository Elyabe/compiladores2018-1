package semantico;

import java.util.HashMap;

import parser.Token;
import tratamentoErro.*;

import semantico.Simbolo;

public class Tabela extends Namespace 
{
	private TipoDado tipoRetornoNamespace;
	public HashMap<String, Namespace> tab;
	private int marcador = 1; // armazena a ultima referencia incluida na tabela
	
	public Tabela( String nome )
	{
		this.nome = nome;
		this.tab = new HashMap<String, Namespace>();
		this.marcador = 1;
	}
	
	
	public int getMarcador() {
		return marcador;
	}

	public void insereSimbolo(Simbolo simbolo) {
		this.tab.put(simbolo.getNome(), simbolo);
	}

	public boolean verificaSimbolo(String chave) {
		return this.tab.containsKey(chave);
	}

	public int tamanhoTabela() {
		return this.tab.size();
	}
	
	public Namespace pesquisaTabela(String chave) {
		return this.tab.get(chave);
	}
	
	public Simbolo pesquisaSimboloTabela(String chave )
	{
		return (Simbolo)pesquisaTabela(chave);
	}
	
	public void imprimeTabela(){
		System.out.println(tab);
	}
	
	public TipoDado tipoVariavel(String chave) {		
		return tab.get(chave).getTipo();
	}
	
	public void incrementaMarcador(TipoDado tipo) {
		if(tipo == TipoDado.NUMERO) {
			marcador+=2;
		}
		if(tipo == TipoDado.PALAVRA) {
			marcador+=1;
		}
	}
	
	public void insereNaTabela(Token variavel, TipoDado tipo) {
		 if(this.tab.containsKey(variavel.image) == false) {
			  Simbolo simbolo = new Simbolo(variavel, tipo, getMarcador());
			  simbolo.setToken(variavel);
		  	  simbolo.setTipo(tipo);
		  	  
		  	  simbolo.setReferencia(getMarcador());
		  	  incrementaMarcador(tipo);
		  	  insereSimbolo(simbolo);
	  	  }else {
	  		throw new ErroSemantico("Variavel "+ variavel + " Duplicada");
	  	  }
	 }
	
	public void verificaVariavelDeclarada(String variavel) {
		 if(tab.containsKey(variavel) == false) {
		  	  	throw new ErroSemantico ("Variavel "+ variavel + " nao declarada");
		 }
	}
	
	public TipoDado getTipo()
	{
		return this.tipoRetornoNamespace;
	}
	
	@Override
	public int getReferencia( String lexema )
	{
		return ((Simbolo)this.pesquisaTabela(lexema)).getReferencia();
	}
	
	public String toString() 
	{
		return this.tab.toString();
	}

	@Override
	public String getNome() 
	{
		return this.nome;
	}
}
