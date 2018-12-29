package semantico;

import java.util.LinkedList;

public enum TipoDado {
	NUMERO,
	PALAVRA;
	
	public static String getDescricao( TipoDado tipoDado )
	{
		String tiposParametros = null;
		switch ( tipoDado )
		{
			case NUMERO:
				tiposParametros = "D";
				break;
			case PALAVRA:
				tiposParametros = "Ljava/lang/String;";
				break;
		}
		
		return tiposParametros;
	}
	
	public static String getDescricao( TipoOperador tipoMetodo, TipoDado tipoRetorno )
	{
		String tiposParametros = new String();
		if ( tipoMetodo == TipoOperador.PROCEDIMENTO )
		{
			tiposParametros = "V";
		} else if ( tipoMetodo == TipoOperador.FUNCAO )
		{
			tiposParametros = TipoDado.getDescricao(tipoRetorno);
		}
		
		return tiposParametros;
	}
	
	// Determina os indicadores de tipos dos parametros de um metodo (funcao/procedimento) 
	public static String getDescricao( LinkedList<Expressao> listaParam )
	{
		String tipoParametros = new String();
		for (Expressao expressao : listaParam) 
		{
			tipoParametros += TipoDado.getDescricao( expressao.getTipoResultado() );
		}
		return tipoParametros;
	}
	
	// Determina o prefixo para o primitivoRetorno
	public static String determinarPrefixoRetorno( TipoDado tipoRetorno )
	{
		String tpRetorno = new String();
		switch (tipoRetorno ) 
		{
			case NUMERO:
				tpRetorno = "d";
				break;
			case PALAVRA:
				tpRetorno = "a";
				break;
		}
		return tpRetorno;
	}
}
