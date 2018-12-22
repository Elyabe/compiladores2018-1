package comandoPrimitivo;

import codigoDestino.CodigoDestino;

public class PrimitivoCabecalhoMetodo extends ComandoPrimitivo 
{
	private String identificador;
	private String tipoParametros;
	private String tipoRetorno;
	private int tamanhoMaximoPilha;
	private int quantidadeVariaveisLocais;
	
	public PrimitivoCabecalhoMetodo( String identificador, String tipoParametros, 
			String tipoRetorno, int tamanhoMaximoPilha, int quantidadeVariaveisLocais ) 
	{
		this.identificador = identificador;
		this.tipoParametros = tipoParametros;
		this.tipoRetorno = tipoRetorno;
		this.quantidadeVariaveisLocais = quantidadeVariaveisLocais;
		this.tamanhoMaximoPilha = tamanhoMaximoPilha;
	}
	
	@Override
	public String geraCodigoDestino() 
	{
		return ".method public static "
				+ this.identificador 
				+ "(" + this.tipoParametros + ")"
				+ this.tipoRetorno + "\r\n"
				+ ".limit stack " + (CodigoDestino.tamanhoTotalPilha + 2) + " \r\n" 
				+ ".limit locals " + (this.quantidadeVariaveisLocais + 2) + " \r\n";
	}

	@Override
	public String toString() 
	{
		return this.geraCodigoDestino();
	}

}
