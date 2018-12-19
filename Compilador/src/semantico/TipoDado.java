package semantico;

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
			default:
				tiposParametros = " ";
		}
		
		return tiposParametros;
	}
}
