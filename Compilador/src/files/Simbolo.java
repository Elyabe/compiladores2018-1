package files;

public class Simbolo {

	private String nome;      // nome do identificador
	
	private String tipo;        // representa os tipos usados na linguagem

	private int referencia;   //refer�ncia usada na gera��o do c�digo destino
		

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int marcador) {
		this.referencia = marcador;
	}
	
	
	public String toString() {

	      return "Nome:"+this.getNome() + "\t" + "Tipo:"+this.getTipo()
	             + "\t" + "Refer�ncia:"+this.getReferencia() + "\n";

	 }
	 
}
