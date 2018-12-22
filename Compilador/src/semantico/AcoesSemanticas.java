package semantico;


import java.util.LinkedList;
import comandoAltoNivel.*;
import parser.*;
import tratamentoErro.*;

public class AcoesSemanticas {
	
	public static int qtdWarnings = 0;
	
	
	
	public static void verificarExistenciaMetodo( Token metodo )
	{
		if (!Compilador.tabelaPrograma.verificarNamespace(metodo.image) )
		  	throw new ErroSemantico("Linha " + metodo.beginLine + ": Voce nao declarou o PROCEDIMENTO " + metodo.image );
	}
	
	public static void verificarExistenciaMetodoMain()
	{
		if (!Compilador.tabelaPrograma.verificarNamespace(Compilador.imageMain) )
		  	throw new ErroSemantico("Deeemocraticameeente! Voce nao declarou o PROCEDIMENTO " + Compilador.imageMain );
	}
	
	public static void otimizarComandosCondicionais( ListaComandosAltoNivel listaComandosAltoNivel )
	{
		int k;
		ComandoAltoNivel comando;
		ComandoCondicional comandoCondicional;
		ComandoCondicionalCompleto comandoCondicionalCompleto;
		
		for ( int idComando = 0; idComando < listaComandosAltoNivel.getListaComandosAltoNivel().size(); idComando++ )
		{
			comando = listaComandosAltoNivel.getListaComandosAltoNivel().get( idComando );
			
			if ( comando instanceof ComandoCondicional )
			{
				comandoCondicional = (ComandoCondicional)comando;
				
				if ( comandoCondicional.getExpressao().getListaExpPosFixa().size() == 1 )
				{
					Operando operando = (Operando)comandoCondicional.getExpressao().getListaExpPosFixa().getFirst();
							
					// Se eh possível otimizar
					if ( operando.getTipoDado() == TipoDado.NUMERO && operando.getTipoElemento() == TipoElemento.CTE )
					{
						// Se o resultado da expressao eh falso
						if ( Double.parseDouble( operando.getLexema() ) == 0.0 )
						{
							if ( comandoCondicional instanceof ComandoCondicionalSimples )
								listaComandosAltoNivel.getListaComandosAltoNivel().remove( idComando );
							else
							{
								// Adiciona os comandos que compoem o bloco false na lista principal
								comandoCondicionalCompleto = (ComandoCondicionalCompleto)comandoCondicional;
								for( k = 0 ; k < comandoCondicionalCompleto.getListaComandosAltoNivelFalse().getListaComandosAltoNivel().size(); k++ )
								{
									ListaComandosAltoNivel listaTrue = comandoCondicionalCompleto.getListaComandosAltoNivelFalse();
									listaComandosAltoNivel.getListaComandosAltoNivel().add(idComando + k, listaTrue.getListaComandosAltoNivel().get(k) );
								}
								
								// Remove o comando Condicional Completo da lista programa
								listaComandosAltoNivel.getListaComandosAltoNivel().remove( idComando + k );
							}
							
						} else // O resultado da expressao eh verdadeiro
						{
							// Adiciona os comandos que compoem o bloco verdadeiro na lista principal
							for( k = 0 ; k < comandoCondicional.getListaComandosAltoNivelTrue().getListaComandosAltoNivel().size(); k++ )
							{
								ListaComandosAltoNivel listaTrue = comandoCondicional.getListaComandosAltoNivelTrue();
								listaComandosAltoNivel.getListaComandosAltoNivel().add(idComando + k, listaTrue.getListaComandosAltoNivel().get(k) );
							}
							// Remove o comando Condicional Completo da lista programa
							listaComandosAltoNivel.getListaComandosAltoNivel().remove( idComando + k );
						}
						idComando--;
					}
				}
			}
		}
	}
	
	public static void adicionarQuebraLinha( ListaComandosAltoNivel listaExibe, String namespace, Token tokenLn )
	{
		Expressao expressao = new Expressao( namespace );
		Item stringNovaLinha = new Operando( TipoDado.PALAVRA, TipoElemento.CTE, new Token(0, "\"\\n\""), Sinal.POS  );
		expressao.addListaExpInfixa( stringNovaLinha );
		expressao.addListaExpPosFixa( stringNovaLinha );
		listaExibe.addComando( new ComandoSaida(expressao, tokenLn) );
	}
	
	public static void verificarParesAtribuicaoMultipla( LinkedList<Token> lstVar, LinkedList<Expressao> lstExp, Token atrib )
	{
		if ( lstVar.size() != lstExp.size() ) throw new ErroSemantico( "Os numeros de variaveis e expressoes sao diferentes na linha " + atrib.beginLine + "\n" );
	}
	
	
	public static void gerarAtribuicoesMultiplas( ListaComandosAltoNivel listaComandosAltoNivel, Tabela tabela, LinkedList<Token> listaVar, LinkedList<Expressao> listaExp, Token atrib  )
	{
		ComandoAltoNivel comando = null;
		for ( int k = 0; k < listaVar.size(); k++ )
		{
			Namespace namespace = tabela.pesquisarNamespaceTabela( listaVar.get(k).image);
			if ( namespace instanceof Simbolo )
			{
				comando = new ComandoAtribuicao( (Simbolo)namespace, listaExp.get(k), atrib);
				listaComandosAltoNivel.addComando( comando );
//				Compilador.tabela.pesquisaTabela(listaVar.get(k).image).setIsInicializada(true);
				((Simbolo) namespace).setIsInicializada(true);
			} else 
				throw new ErroSemantico( "ATRIBUICAO INVALIDA: " + namespace.getNome() + " nao eh uma variavel ");
			
		}
	}

	
	public static void incompatibilidadeTipoExpressao (Item item, Expressao expressao, Token token) {
		Operando operando = (Operando) item;
		 													//Tratamento de incompatibilidade de tipos entre expressoes.
															//Percorre a lista a listaExpInfixa.
		for(Item itemAux : expressao.getListaExpInfixa()) { 
															//Verifica somente os itens que sao operando.
			if(itemAux instanceof Operando) {
				Operando operandoAux = (Operando)itemAux;
															// Verfica se o tipo de dados do item passado eh diferente do
															// tipo de dados dos itens da lista.
				if(!(operando.getTipoDado()==operandoAux.getTipoDado())) {
															// Erro de incompatibilidade de tipos entre expressoes.
					throw new ErroSemantico("Incompatibilidade de tipos entre expressoes na linha: " + token.beginLine); 
				}
			}
		}
	} 
	
	public static void incompatibilidadeTipoAtribuicao (Simbolo simbolo, Expressao expressao, Token token) {
															// Tratamento de incompatibilidade de tipos no comando de atribuicao, 
															// isto e, entre variavel que recebe a expressao e a expressao.
															// Percorre a lista a listaExpInfixa.
		for(Item itemAux : expressao.getListaExpInfixa()) {
															//Verifica somente os itens que sao operando.
			if(itemAux instanceof Operando) {
				Operando operandoAux = (Operando)itemAux;
															//Verifica se o tipo de dado dos itens da 
															//expressao eh diferente do tipo de dado do simbolo.
				if(!(simbolo.getTipo()==operandoAux.getTipoDado())) {
															// Erro de incompatibilidade entre o tipo de dado da variavel e o tipo 
															// de dados dos itens da expressao.
					throw new ErroSemantico("Incompatibilidade de tipos no comando de atribuicao entre variavel e a expressao na linha : " + token.beginLine);
				}
			}
		}
	}
	
	public static void faltaInicializacaoVariavel (Expressao expressao, Tabela tabela, Token token) {
															//Tratamento, falta de inicializacao de uma variavel
															//Percorre a lista a listaExpInfixa.
		for(Item itemAux : expressao.getListaExpInfixa()) {
															//Verifica somente os itens que sao operando.
			if(itemAux instanceof Operando) {
				Operando operandoAux = (Operando)itemAux;
															//Verifica somente os itens que sao operando do tipo elemento VAR.
				if(operandoAux.getTipoElemento() == TipoElemento.VAR){
					Namespace namespace = tabela.pesquisarNamespaceTabela(operandoAux.getLexema()); 
					//Consulta o simbolo, retornando seu status (True ou False).
					if ( namespace instanceof Simbolo && !((Simbolo)namespace).getIsInicializada() )
					{
							//Erro, falta inicializacao de uma variavel se for False.
								throw new ErroSemantico("Falta de inicializacao de uma variavel na linha : " + token.beginLine);
					}
						
				}
			}
		}
	}
	
	//Estender AVISO DE WARNINGS para restante das namespaces
	public static void warnings() 
	{
		//percorrer tabela de simbolos
		Compilador.tabelaPrograma.tab.forEach((key, value) -> {
			Simbolo simbolo;
			if ( value instanceof Simbolo )
			{
				simbolo = (Simbolo)value;
				//verificar se isInicializada == false, a variavel n�o foi inicializada
				if(simbolo.getIsInicializada() == false) 
				{
					System.out.println("Warning: Variavel declarada "+simbolo.getNome()+" declarada, mas nao inicializada.");
					qtdWarnings++;
				}
				
				//verificar se isInicializada == true isUtilizada == false, variavel foi inicializada porem nao foi utilizada
				if(simbolo.getIsInicializada() == true && simbolo.getIsUtilizada() == false) 
				{
					System.out.println("Warning: Variavel "+value.getNome()+" declarada, inicializada, mas nao utilizada.");
					qtdWarnings++;
				}
			}
			
		});
			
	}
}
