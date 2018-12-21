package semantico;

import tratamentoErro.ErroSintatico;

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
	
	public static String getDescricao( TipoOperador tipoMetodo )
	{
		String tiposParametros = null;
		if ( tipoMetodo == TipoOperador.PROCEDIMENTO )
		{
			tiposParametros = "V";
		} else
			throw new ErroSintatico( "Funcao nao implementado ainda :)" );
		
		return tiposParametros;
	}
}
