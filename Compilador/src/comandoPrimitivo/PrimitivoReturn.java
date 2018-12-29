package comandoPrimitivo;

import semantico.TipoDado;

public class PrimitivoReturn extends ComandoPrimitivo
{
	private String codigoDestinoExpressao;
	private String tipoRetorno;
	
	
	public PrimitivoReturn( TipoDado tipoRetorno )
	{
		this.tipoRetorno = TipoDado.determinarPrefixoRetorno( tipoRetorno );
		this.codigoDestinoExpressao = new String();
	}
	
	public PrimitivoReturn( TipoDado tipoRetorno, String codigoDestExpressao )
	{
		this.tipoRetorno = TipoDado.determinarPrefixoRetorno( tipoRetorno );
		this.codigoDestinoExpressao = codigoDestExpressao;
	}
	
	public PrimitivoReturn() 
	{
		this.tipoRetorno = new String();
		this.codigoDestinoExpressao = new String();
	}

	@Override
	public String geraCodigoDestino() 
	{
		return  this.codigoDestinoExpressao 
				+ this.tipoRetorno 
				+ "return \r\n";
	}

	@Override
	public String toString() 
	{
		return "[" 
				+ this.codigoDestinoExpressao 
				+ "/"
				+ this.tipoRetorno 
				+ "] \r\n";
	}
	
	
	
	
}
