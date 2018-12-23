package comandoAltoNivel;

import java.util.LinkedList;

import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;
import comandoPrimitivo.PrimitivoInvokeStatic;
import parser.*;
import semantico.*;

public class ChamadaMetodo extends ComandoAltoNivel 
{
	private TipoOperador tipoMetodo;
	private LinkedList<Expressao> listaParametros;
	
	public ChamadaMetodo( Token token, TipoOperador tipoMetodo, LinkedList<Expressao> listaParametros) 
	{
		this.token = token;
		this.listaParametros = listaParametros;
		this.tipoMetodo = tipoMetodo;
	}
	
	public ChamadaMetodo( Token token, LinkedList<Expressao> listaParametros ) 
	{
		this.token = token;
		this.listaParametros = listaParametros;
		this.tipoMetodo = TipoOperador.PROCEDIMENTO;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ListaComandosPrimitivos listaComandosPrimitivos = new ListaComandosPrimitivos();
		String expressaoParametros = "";
		
		for (Expressao expressao : listaParametros){
			expressaoParametros += expressao.geraCodigoDestino();
		}
		
		ComandoPrimitivo invocarMetodo = new PrimitivoInvokeStatic( this.getLexema(), expressaoParametros, this.determinarTiposParametros() );
		
		listaComandosPrimitivos.addComando( invocarMetodo );
		
		return listaComandosPrimitivos;
	}
	
	public String determinarTiposParametros()
	{
		String tiposParametros = "";
		// Se for a main e tiver parametro, o argumento deve ser vetor de  strings (AINDA NAO USAMOS ISSO)
		if ( this.token.kind == Compilador.MAIN )
			tiposParametros = "[" + TipoDado.getDescricao(TipoDado.PALAVRA);
		else 
		{
			for (Expressao expressao : listaParametros) 
				 tiposParametros += TipoDado.getDescricao( expressao.getTipoResultado() );	
		}
		
		return tiposParametros;
	}

	@Override
	public String toString() 
	{
		return "[ CHAMADA METODO:" 
					+ this.getLexema() 
					+ "]\n";   
	}
	
}
