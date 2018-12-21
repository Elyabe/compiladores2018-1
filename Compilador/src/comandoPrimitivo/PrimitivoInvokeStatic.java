package comandoPrimitivo;

import apoio.Config;
import parser.Token;
import semantico.TipoDado;
import semantico.TipoOperador;

public class PrimitivoInvokeStatic extends ComandoPrimitivo 
{
	private String nomeMetodo;
	private TipoOperador tipoMetodo;
	
	
	public PrimitivoInvokeStatic( String metodo, TipoOperador tipoMetodo ) 
	{
		this.nomeMetodo = metodo;
		this.tipoMetodo = tipoMetodo;
	}
	
	public PrimitivoInvokeStatic( String metodo ) 
	{
		this.nomeMetodo = metodo;
		this.tipoMetodo = TipoOperador.PROCEDIMENTO;
	}
	
	@Override
	public String geraCodigoDestino() 
	{
		return "invokestatic " 
				+ Config.nomeArquivo + "." 
				+ this.nomeMetodo
				+ "()"
				+ TipoDado.getDescricao(this.tipoMetodo) + "\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}

}
