package semantico;

import parser.Token;



public class Simbolo {
	private Token token;
	
	private String nome;
	// nome do identificador

	private TipoDado tipo;
	// � uma enumera��o que deve ser criada para 
	// representar os tipos usados na linguagem

   private int referencia;
   // � uma refer�ncia usada na gera��o do
   // c�digo destino
   
   public Simbolo(Token token, TipoDado tipo, int referencia) {
	   this.token = token;
	   this.tipo = tipo;
	   this.referencia = referencia;
   }
   
   public String toString() {
      return "\t"+"Nome:"+this.getNome() + "\t" + "Tipo:"+this.getTipo()+ "\t" + "Refer�ncia:"+this.getReferencia()+"\n";
   }
   
   public String getLexema() {
	   return this.token.image;
   }

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoDado getTipo() {
		return this.tipo;
	}
	
	public void setTipo(TipoDado tipo) {
		this.tipo = tipo;
	}
	
	public int getReferencia() {
		return this.referencia;
	}
	
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
}
