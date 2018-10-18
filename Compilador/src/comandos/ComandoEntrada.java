package comandos;
import semantico.*;
import java.util.LinkedList;
import parser.*;
import primitivo.ListaComandosPrimitivos;

public class ComandoEntrada extends ComandoAltoNivel{
	Simbolo simbolo;
	
	public ComandoEntrada(Simbolo simbolo, Token token){
		super(token);  		
		this.simbolo = simbolo;
	}
	
	public String toString() {
		return this.token + "/" + this.simbolo.getNome();
	}
	
	public ListaComandosPrimitivos geraListaComandosPrimitivos() {
		return null;//TO-DO
	}	
}
