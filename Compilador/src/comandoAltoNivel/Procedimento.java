package comandoAltoNivel;

import java.util.LinkedList;

import apoio.*;
import codigoDestino.CodigoDestino;
import comandoPrimitivo.*;
import parser.*;
import semantico.TipoDado;

public class Procedimento extends ComandoAltoNivel 
{
	private Token identificador;
	private LinkedList<Token> listaParametros;
	private ListaComandosAltoNivel listaCorpoProcedimento;
	
	public Procedimento( Token token, Token nome, LinkedList<Token> listaParametros, ListaComandosAltoNivel listaCorpoProcedimento)
	{
		this.token = token;
		this.identificador = nome;
		this.listaParametros = listaParametros;
		this.listaCorpoProcedimento = listaCorpoProcedimento;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ComandoPrimitivo assinaturaFuncao = new PrimitivoCabecalhoMetodo( this.getIdentificador(), this.determinarTiposParametros(), 
																		"V", CodigoDestino.tamanhoTotalPilha, Compilador.tabela.getMarcador()+2);
		ComandoPrimitivo retornoVazio = new PrimitivoReturn();
		ComandoPrimitivo fimProcedimento = new PrimitivoFimMetodo();
		
		ListaComandosPrimitivos listaComandosPrimitivos = this.listaCorpoProcedimento.geraListaComandoPrimitivosCompleta(); 
		
		listaComandosPrimitivos.addComandoInicio( assinaturaFuncao );
		listaComandosPrimitivos.addComando( retornoVazio );
		listaComandosPrimitivos.addComando( fimProcedimento );
		return listaComandosPrimitivos;
	}

	@Override
	public String toString() 
	{
		return "[ PROCEDIMENTO: " 
				+ this.getIdentificador() 
				+ "/ PARAMETROS : " + this.determinarTiposParametros() 
				+ "/ CORPO: " + this.listaCorpoProcedimento.toString() + "\n";
	}
	
	public String determinarTiposParametros()
	{
		String tiposParametros = "";
		// Se for a main e tiver parametro, o argumento deve ser vetor de  strings (AINDA NAO USAMOS ISSO)
		if ( this.identificador.kind == Compilador.MAIN )
			tiposParametros = "[" + TipoDado.getDescricao(TipoDado.PALAVRA);
		else 
		{
			for (Token param : listaParametros) 
				 tiposParametros += TipoDado.getDescricao(Compilador.tabela.tipoVariavel( param.image ));	
		}
		
		return tiposParametros;
	}
	
	// Converte o identificador do token para o main JAVA 
	public String getIdentificador()
	{
		if ( this.identificador.kind == Compilador.MAIN )
			return "main";
		return this.identificador.image;
	}
	
}
