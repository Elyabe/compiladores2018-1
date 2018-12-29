package comandoAltoNivel;

import java.util.LinkedList;

import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;
import comandoPrimitivo.PrimitivoInvokeStatic;
import parser.*;
import semantico.*;

public class ChamadaMetodo extends ComandoAltoNivel 
{
	private LinkedList<Expressao> listaParametros;
	
	public ChamadaMetodo( Token token, LinkedList<Expressao> listaParametros ) 
	{
		this.token = token;
		this.listaParametros = listaParametros;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		TipoOperador tipoMetodo = Compilador.tabelaPrograma.pesquisarTabela(token.image).getTipoMetodo();
		TipoDado tipoRetorno = Compilador.tabelaPrograma.pesquisarTabela(token.image).getTipoRetorno();
		ListaComandosPrimitivos listaComandosPrimitivos = new ListaComandosPrimitivos();
		ComandoPrimitivo invocarMetodo = null ;
		String expressaoParametros = "";
		
		for (Expressao expressao : listaParametros){
			expressaoParametros += expressao.geraCodigoDestino();
		}
		
		if ( tipoMetodo == TipoOperador.FUNCAO )
			invocarMetodo = new PrimitivoInvokeStatic( this.getLexema(), tipoRetorno, expressaoParametros, this.determinarTiposParametros() );
		else if ( tipoMetodo == TipoOperador.PROCEDIMENTO )
			invocarMetodo = new PrimitivoInvokeStatic( this.getLexema(), expressaoParametros, this.determinarTiposParametros() );
		
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
