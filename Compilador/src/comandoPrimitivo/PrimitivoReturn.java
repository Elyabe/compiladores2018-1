package comandoPrimitivo;

import semantico.TipoDado;

public class PrimitivoReturn extends ComandoPrimitivo
{
	private String tipoRetorno;
	
	public PrimitivoReturn( TipoDado tipoRetorno )
	{
		switch (tipoRetorno ) 
		{
			case NUMERO:
				this.tipoRetorno = "d";
				break;
			case PALAVRA:
				this.tipoRetorno = "a";
				break;
		}
	}
	
	public PrimitivoReturn() 
	{
		this.tipoRetorno = "";
	}

	@Override
	public String geraCodigoDestino() 
	{
		return this.tipoRetorno + "return \r\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}
	
	
}
