package comandoAltoNivel;

import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;
import comandoPrimitivo.PrimitivoInvokeStatic;
import parser.*;
import semantico.*;

public class ChamadaMetodo extends ComandoAltoNivel 
{
	private TipoOperador tipoMetodo;
	
	public ChamadaMetodo( Token token, TipoOperador tipoMetodo ) 
	{
		this.token = token;
		this.tipoMetodo = tipoMetodo;
	}
	
	public ChamadaMetodo( Token token ) 
	{
		this.token = token;
		this.tipoMetodo = TipoOperador.PROCEDIMENTO;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ListaComandosPrimitivos listaComandosPrimitivos = new ListaComandosPrimitivos();
		ComandoPrimitivo invocarMetodo = new PrimitivoInvokeStatic( this.getLexema() );
		
		listaComandosPrimitivos.addComando( invocarMetodo );
		
		return listaComandosPrimitivos;
	}

	@Override
	public String toString() 
	{
		return "[ CHAMADA METODO:" 
					+ this.getLexema() 
					+ "]\n";   
	}
	
}
