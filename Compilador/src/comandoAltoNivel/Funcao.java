package comandoAltoNivel;

import java.util.LinkedList;

import codigoDestino.CodigoDestino;
import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;
import comandoPrimitivo.PrimitivoCabecalhoMetodo;
import comandoPrimitivo.PrimitivoFimMetodo;
import comandoPrimitivo.PrimitivoReturn;
import parser.*;
import semantico.*;

public class Funcao extends Procedimento 
{
	private TipoDado tipoRetorno;
	
	public Funcao(Token token, Token nome, LinkedList<Token> listaParametros, 
					ListaComandosAltoNivel listaCorpoProcedimento, TipoDado tipoRetorno ) 
	{
		super(token, nome, listaParametros, listaCorpoProcedimento);
		this.tipoRetorno = tipoRetorno;
	}

	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ComandoPrimitivo assinaturaFuncao = new PrimitivoCabecalhoMetodo( this.getIdentificador(), this.determinarTiposParametros(), 
																		TipoDado.getDescricao(this.tipoRetorno), CodigoDestino.tamanhoTotalPilha+10, 
																		Compilador.tabelaPrograma.pesquisarTabela( this.identificador.image ).getMarcador()+2 );
		ComandoPrimitivo fimProcedimento = new PrimitivoFimMetodo();
		ListaComandosPrimitivos listaComandosPrimitivos = this.listaCorpoProcedimento.geraListaComandoPrimitivosCompleta(); 
		listaComandosPrimitivos.addComandoInicio( assinaturaFuncao );
		
		// Verificar se de fato isso é necessário
		// Sem esse ultimo return o java retorna um erro chamado "Illegal jump or d..."
		ComandoPrimitivo returnDefaultProcedimento = new PrimitivoReturn();
		listaComandosPrimitivos.addComando(returnDefaultProcedimento);
		
		listaComandosPrimitivos.addComando( fimProcedimento );
		return listaComandosPrimitivos;
	}

	@Override
	public String toString() 
	{
		return "[ FUNCAO: " 
				+ this.getIdentificador() 
				+ "/ PARAMETROS : " + this.determinarTiposParametros() 
				+ "/ RETORNO " + this.tipoRetorno
				+ "/ CORPO: " + this.listaCorpoProcedimento.toString() + "\n";
	}
	
	
	
}
