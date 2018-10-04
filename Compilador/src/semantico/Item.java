package semantico;
public class Item {

   private Tipo tipo; // � uma enumera��o que cont�m os tipos usados na linguagem, tais como: n�mero, vari�vel, operador etc.

   private String descricao;
   
   private String valor;

public Tipo getTipo() {
	return tipo;
}

public void setTipo(Tipo tipo) {
	this.tipo = tipo;
} 

public String getDescricao() {
	return descricao;
}
  
public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getValor() {
	return valor;
}

public void setValor(String valor) {
	this.valor = valor;
}

// criar aqui os m�todos de interface para os campos
	public String toString() {
    return "\n"+"Valor:"+this.getValor() + " - " + "Tipo:"+this.getTipo()+ " - " + "descricao:"+this.getDescricao()+"\n";
 }
}