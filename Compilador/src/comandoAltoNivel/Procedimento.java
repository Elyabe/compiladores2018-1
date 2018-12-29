package comandoAltoNivel;

import java.util.LinkedList;

import apoio.*;
import codigoDestino.CodigoDestino;
import comandoPrimitivo.*;
import parser.*;
import semantico.TipoDado;
import semantico.TipoOperador;

public class Procedimento extends ComandoAltoNivel 
{
	protected Token identificador;
	protected LinkedList<Token> listaParametros;
	protected ListaComandosAltoNivel listaCorpoProcedimento;
	protected int tamanhoTotalPilha;
	protected int qtdVariaveisLocais;
	
	public Procedimento( Token token, Token nome, LinkedList<Token> listaParametros, ListaComandosAltoNivel listaCorpoProcedimento)
	{
		this.token = token;
		this.namespace = nome.image;
		this.identificador = nome;
		this.listaParametros = listaParametros;
		this.listaCorpoProcedimento = listaCorpoProcedimento;
		this.tamanhoTotalPilha = this.qtdVariaveisLocais = 0;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ComandoPrimitivo assinaturaFuncao = new PrimitivoCabecalhoMetodo( this.getIdentificador(), this.determinarTiposParametros(), 
																		TipoDado.getDescricao( TipoOperador.PROCEDIMENTO, null), 
																		CodigoDestino.tamanhoTotalPilha+4, 
																		Compilador.tabelaPrograma.pesquisarTabela( this.identificador.image ).getMarcador()+2);
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
		String tiposParametros = new String();
		// Se for a main e tiver parametro, o argumento deve ser vetor de  strings (ISSO ainda nao eh usado)
		if ( this.identificador.kind == Compilador.MAIN )
			tiposParametros = "[" + TipoDado.getDescricao(TipoDado.PALAVRA);
		else 
		{
			for (Token param : listaParametros) 
				 tiposParametros += TipoDado.getDescricao(Compilador.tabelaPrograma.pesquisarTabela(this.namespace).tipoVariavel( param.image ));	
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

	public int getTamanhoTotalPilha() 
	{
		return tamanhoTotalPilha;
	}

	public void setTamanhoTotalPilha(int tamanhoTotalPilha) 
	{
		this.tamanhoTotalPilha = tamanhoTotalPilha;
	}

	public int getQtdVariaveisLocais() {
		return qtdVariaveisLocais;
	}

	public void setQtdVariaveisLocais(int qtdVariaveisLocais) 
	{
		this.qtdVariaveisLocais = qtdVariaveisLocais;
	}
	
	
	
}
