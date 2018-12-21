package semantico;

import parser.Compilador;

public abstract class Namespace 
{
	public String nome;
	
	public abstract TipoDado getTipo();
	public abstract String getNome();
	public abstract int getReferencia(String lexema);
}
