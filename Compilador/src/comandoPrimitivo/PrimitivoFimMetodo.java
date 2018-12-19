package comandoPrimitivo;

public class PrimitivoFimMetodo extends ComandoPrimitivo 
{
	

	@Override
	public String geraCodigoDestino() 
	{
		return ".end method \r\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}
	
}
