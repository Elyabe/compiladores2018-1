package semantico;

import java.util.HashMap;

import parser.Compilador;
import parser.Token;
import tratamentoErro.*;

import semantico.Simbolo;

public class Tabela extends Namespace 
{
	private TipoOperador tipoMetodo;
	public HashMap<String, Namespace> tab;
	private int marcador = 1; // armazena a ultima referencia incluida na tabela
	
	public Tabela( String nome )
	{
		this.nome = nome;
		this.tab = new HashMap<String, Namespace>();
		this.marcador = ( this.nome == Compilador.imageMain ) ? 1:0 ;
	}
	
	public int getMarcador() {
		return marcador;
	}

	public void insereNamespace(Namespace namespace){
		this.tab.put(namespace.getNome(), namespace);
	}

	public boolean verificarNamespace(String chave) {
		return this.tab.containsKey(chave);
	}

	public int tamanhoTabela() {
		return this.tab.size();
	}
	
	public Namespace pesquisarNamespaceTabela(String chave) {
		return this.tab.get(chave);
	}
	
	public Simbolo pesquisarSimboloTabela(String chave )
	{
		return (Simbolo)this.tab.get(chave);
	}
	
	public Tabela pesquisarTabela(String chave )
	{
		return (Tabela)pesquisarNamespaceTabela(chave);
	}
	
	public void imprimeTabela(){
		System.out.println(tab);
	}
	
	public TipoDado tipoVariavel(String chave) {		
		return ((Simbolo)tab.get(chave)).getTipo();
	}
	
	public void incrementaMarcador(TipoDado tipo) {
		if(tipo == TipoDado.NUMERO) {
			marcador+=2;
		}
		if(tipo == TipoDado.PALAVRA) {
			marcador+=1;
		}
	}
	
	public void insereSimboloNaTabela(Token variavel, TipoDado tipo) 
	{
		 if(this.tab.containsKey(variavel.image) == false) {
			  Simbolo simbolo = new Simbolo(variavel, tipo, getMarcador());
			  simbolo.setToken(variavel);
		  	  simbolo.setTipo(tipo);
		  	  
		  	  simbolo.setReferencia(getMarcador());
		  	  incrementaMarcador(tipo);
		  	  insereNamespace(simbolo);
	  	  }else {
	  		throw new ErroSemantico("Variavel "+ variavel + " Duplicada");
	  	  }
	 }
	
	public void insereNamespaceNaTabela(Token variavel, TipoOperador tipo) 
	{
		 if(this.tab.containsKey(variavel.image) == false) {
			  Tabela tabela = new Tabela(variavel.image);

			  tabela.setTipoMetodo(tipo);
		  	  insereNamespace(tabela);
	  	  }else {
	  		throw new ErroSemantico("Variavel "+ variavel + " Duplicada");
	  	  }
	 }
	
	
	public void verificaVariavelDeclarada(String variavel) {
		 if(tab.containsKey(variavel) == false) {
		  	  	throw new ErroSemantico ("Variavel "+ variavel + " nao declarada");
		 }
	}
	
	public TipoOperador getTipoMetodo(){
		return this.tipoMetodo;
	}
	
	public void setTipoMetodo( TipoOperador tipoMetodo ){
		this.tipoMetodo = tipoMetodo;
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
