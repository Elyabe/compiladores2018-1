package semantico;

import parser.Compilador;

public abstract class Namespace 
{
	public String nome;
	
	public abstract String getNome();
	public abstract int getReferencia(String lexema);
}
