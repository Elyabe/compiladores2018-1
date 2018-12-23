package comandoPrimitivo;

import apoio.*;
import semantico.*;

public class PrimitivoInvokeStatic extends ComandoPrimitivo 
{
	private String nomeMetodo;
	private TipoOperador tipoMetodo;
	private String expressaoParam;
	private String tiposParametros;
	
	
	public PrimitivoInvokeStatic( String metodo, TipoOperador tipoMetodo, String expressaoParam, String tiposParam ) 
	{
		this.nomeMetodo = metodo;
		this.tipoMetodo = tipoMetodo;
		this.expressaoParam = expressaoParam;
		this.tiposParametros = tiposParam;
	}
	
	public PrimitivoInvokeStatic( String metodo, String expressaoParam, String tiposParam  ) 
	{
		this.nomeMetodo = metodo;
		this.tipoMetodo = TipoOperador.PROCEDIMENTO;
		this.expressaoParam = expressaoParam;
		this.tiposParametros = tiposParam;
	}
	
	@Override
	public String geraCodigoDestino() 
	{
		return  this.expressaoParam
				+ "invokestatic " 
				+ Config.nomeArquivo + "." 
				+ this.nomeMetodo
				+ "(" +  this.tiposParametros   +")"
				+ TipoDado.getDescricao(this.tipoMetodo) + "\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}

}
