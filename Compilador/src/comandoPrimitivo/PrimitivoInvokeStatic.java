package comandoPrimitivo;

import apoio.*;
import parser.Compilador;
import semantico.*;

public class PrimitivoInvokeStatic extends ComandoPrimitivo 
{
	private String nomeMetodo;
	private TipoDado tipoRetorno;
	private String expressaoParam;
	private String tiposParametros;
	
	
	public PrimitivoInvokeStatic( String metodo, TipoDado tipoRetorno, String expressaoParam, String tiposParam ) 
	{
		this.nomeMetodo = metodo;
		this.tipoRetorno = tipoRetorno;
		this.expressaoParam = expressaoParam;
		this.tiposParametros = tiposParam;
	}
	
	public PrimitivoInvokeStatic( String metodo, String expressaoParam, String tiposParam  ) 
	{
		this.nomeMetodo = metodo;
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
				+ TipoDado.getDescricao( Compilador.tabelaPrograma.pesquisarTabela(this.nomeMetodo).getTipoMetodo(), this.tipoRetorno ) + "\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}

}
