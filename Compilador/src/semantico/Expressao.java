package semantico;

import java.util.LinkedList;
import codigoDestino.*;
import comandoPrimitivo.*;
import parser.Compilador;
import parser.Token;

public class Expressao {

	LinkedList<Item> listaExpInfixa;
	LinkedList<Item> listaExpPosFixa;
	private TipoDado tipoResultado;
	public int tam = 0;

	static LinkedList<String> listaOperandoString =  new LinkedList<String>();

//	TIPO da expressao: Tipo dos elementos que ela contem
//	TIPO DO RESULTADO: O que ela deixa na pilha apos a aplicacao do operador, se existir
	public Expressao() {
		this.listaExpInfixa = new LinkedList<Item>();
		this.listaExpPosFixa = new LinkedList<Item>();
	}
	
	public Expressao( TipoDado tipoResultado ) 
	{
		this.listaExpInfixa = new LinkedList<Item>();
		this.listaExpPosFixa = new LinkedList<Item>();
		this.tipoResultado = tipoResultado;
	}

	public LinkedList<Item> getListaExpInfixa() {
		return this.listaExpInfixa;
	}
	public LinkedList<Item> getListaExpPosFixa() {
		return this.listaExpPosFixa;
	}

	// o tipo da expressao eh igual ao tipo do primeiro elemento posfixo (que deve ser um operando)
	public TipoDado getTipo() {
		return ((Operando)(this.listaExpPosFixa.getFirst())).tipoDado;
	}
	
	public TipoDado getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(TipoDado tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public void addListaExpInfixa(Item item) {
		this.listaExpInfixa.add(item);
	}

//	O tipo resultado da expressao eh o mesmo tipo dos elementos que ela contem
//	Até que um operador que nao retorne um resultado numerico nao seja inserido na expressao
	public void addListaExpPosFixa(Item item) 
	{
		this.listaExpPosFixa.add(item);
		if ( item instanceof Operador && ((Operador)item).tipoOperador != TipoOperador.CONCAT )
			this.tipoResultado = TipoDado.NUMERO;
		else
			this.tipoResultado = this.getTipo();
	}

	public void imprimeExpressao() {
		System.out.println(this.listaExpPosFixa);
	}

	public String geraCodigoDestino(){

		String codigoDestinoExpressao = "";
		int referencia;
		
		for(Item item : this.listaExpPosFixa) 
		{
			// se for operando
			if(item instanceof Operando) 
			{
				Operando operando = (Operando)item;
				// se for numero
				char separador = ' ';
				switch ( operando.getTipoDado() )
	    		{
	    			case NUMERO:
	    				switch ( operando.getTipoElemento() )
	    				{
	    					case VAR:
	    						referencia = Compilador.tabela.pesquisaTabela(operando.getLexema()). getReferencia();
	    						separador = ( referencia < 4 ) ? '_' : ' ';
	    						codigoDestinoExpressao += "dload" + separador + referencia + "\r\n";
	    						
	    						// Possibilidade de sinal nas variaveis
	    						if ( operando.sinal == Sinal.NEG )
	    						{
	    							codigoDestinoExpressao += "ldc2_w -1.0 \r\n";
	    							codigoDestinoExpressao += "dmul \r\n";
	    						}
	    						
	    						break;
	    					case CTE:
	    						codigoDestinoExpressao += "ldc2_w " + operando.getLexema() + "\r\n";
	    						break;
	    				}
	    				
	    				CodigoDestino.tamanhoPilha += 2;
						CodigoDestino.tamanhoTotalPilha = Integer.max( CodigoDestino.tamanhoPilha , CodigoDestino.tamanhoTotalPilha );
						
	    				break;
	    			case PALAVRA:
	    				switch ( operando.getTipoElemento() )
	    				{
	    					case VAR:
	    						referencia = Compilador.tabela.pesquisaTabela(operando.getLexema()). getReferencia();
	    						separador = ( referencia < 4 ) ? '_' : ' ';
	    						codigoDestinoExpressao += "aload" + separador + referencia + "\r\n";
	    						break;
	    					case CTE:
	    						codigoDestinoExpressao += "ldc " + operando.getLexema() + "\r\n";
	    						break;
	    				}
	    				CodigoDestino.tamanhoPilha += 1;
						CodigoDestino.tamanhoTotalPilha = Integer.max( CodigoDestino.tamanhoPilha , CodigoDestino.tamanhoTotalPilha );
	    				break;
	    		}
		
			}
			// se for operador
			if(item instanceof Operador) 
			{
				Operador operador = (Operador)item;

				switch ( operador.getTipoOperador() )
				{
					case SOMA:
						codigoDestinoExpressao += "dadd \r\n";
						break;
					case SUB:
						codigoDestinoExpressao += "dsub \r\n";
						break;
					case MUL:
						codigoDestinoExpressao += "dmul \r\n";
						break;
					case DIV:
						codigoDestinoExpressao += "ddiv \r\n";	
						break;
					case POT:
						codigoDestinoExpressao += "invokestatic java/lang/Math/pow(DD)D \r\n";
						break;
					case LOG:
						codigoDestinoExpressao += "invokestatic java/lang/Math/log10(D)D \r\n";
						break;
					case MAX:
						codigoDestinoExpressao += "invokestatic java/lang/Double/max(DD)D \r\n";
						break;
					case MIN:
						codigoDestinoExpressao += "invokestatic java/lang/Double/min(DD)D \r\n";
						break;
					case OU:
						PrimitivoLabel labelSAIDAou = new PrimitivoLabel("SAIDAou");
	
						codigoDestinoExpressao += "dconst_0 \r\n"	//Primeiro empilha 0 e compara com a expressao
						+"dcmpg \r\n"								//se o resultado for igual, quer dizer que
						+"ifeq " + labelSAIDAou.getLabel()			//a expressao eh falsa, portanto deve sair
						+"pop2 \r\n"	
						+"dconst_1 \r\n"							//Sendo a expressao verdadeira, basta desempilhar 
						+ labelSAIDAou.geraCodigoDestino();			//a expressao e empilhar 1 como resultado valido
						break;
					case OUEXCLUSIVO:
						PrimitivoLabel labelSAIDAouExclusivo = new PrimitivoLabel("SAIDAouExclusivo");
						PrimitivoLabel labelComparaSegundo0 = new PrimitivoLabel("ComparaSegundo0");
						PrimitivoLabel labelComparaSegundo1 = new PrimitivoLabel("ComparaSegundo1");
						PrimitivoLabel labelCOLOCATRUEXOR = new PrimitivoLabel("COLOCATRUEXOR");
						PrimitivoLabel labelCOLOCAFALSEXOR = new PrimitivoLabel("COLOCAFALSEXOR");
						
						codigoDestinoExpressao += "dconst_0 \r\n"	
						+ "dcmpg \r\n"								
						+ "ifeq " + labelComparaSegundo0.getLabel()	
						+ "goto " + labelComparaSegundo1.getLabel()
						+ labelComparaSegundo0.geraCodigoDestino()
						+ "dconst_0 \r\n"
						+ "dcmpg \r\n"								
						+ "ifeq " + labelCOLOCAFALSEXOR.getLabel()	
						+ "goto " + labelCOLOCATRUEXOR.getLabel()
						+ labelComparaSegundo1.geraCodigoDestino()	
						+"dconst_0 \r\n"							 
						+ "dcmpg \r\n"								
						+ "ifeq " + labelCOLOCATRUEXOR.getLabel()	
						+ labelCOLOCAFALSEXOR.geraCodigoDestino()
						+ "dconst_0 \r\n"
						+ "goto " + labelSAIDAouExclusivo.getLabel()
						+ labelCOLOCATRUEXOR.geraCodigoDestino()
						+ "dconst_1 \r\n"
						+ labelSAIDAouExclusivo.geraCodigoDestino();	
						break;
					case E:
						PrimitivoLabel labelSAIDAe = new PrimitivoLabel("SAIDAe");
						PrimitivoLabel labelTestaSegundo1e = new PrimitivoLabel("TestaSegundo1e");
						PrimitivoLabel labelColocaTrueE = new PrimitivoLabel("ColocaTrueE");
						codigoDestinoExpressao += "dconst_0 \r\n"			
								+ "dcmpg \r\n"								 
								+ "ifne " + labelTestaSegundo1e.getLabel()	
								+ "pop2 \r\n"								
								+ "dconst_0 \r\n"							
								+ "goto " + labelSAIDAe.getLabel()
								+ labelTestaSegundo1e.geraCodigoDestino()
								+ "dconst_0 \r\n"			
								+ "dcmpg \r\n"				 
								+ "ifne " + labelColocaTrueE.getLabel()
								+  "dconst_0 \r\n"
								+  "goto " + labelSAIDAe.getLabel()
								+ labelColocaTrueE.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAe.geraCodigoDestino();
						break;
					case IGUAL:
						PrimitivoLabel labelCOLOCATRUEigual = new PrimitivoLabel("COLOCATRUEigual");
						PrimitivoLabel labelSAIDAigual = new PrimitivoLabel("SAIDAigual");

						if ( this.getTipo() == TipoDado.NUMERO )
						{
							codigoDestinoExpressao += "dcmpg \r\n"
								+ "ifeq "+labelCOLOCATRUEigual.getLabel() 
								+ "dconst_0 \r\n"
								+ "goto "+labelSAIDAigual.getLabel()
								+ labelCOLOCATRUEigual.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAigual.geraCodigoDestino();
						} else if ( this.getTipo() == TipoDado.PALAVRA )
						{
							codigoDestinoExpressao += "invokevirtual java/lang/String/compareTo(Ljava/lang/String;)I \r\n"
								+ "iconst_0 \r\n"
								+ "if_icmpeq " + labelCOLOCATRUEigual.getLabel()
								+ "dconst_0 \r\n"
								+ "goto " + labelSAIDAigual.getLabel()
								+ labelCOLOCATRUEigual.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAigual.geraCodigoDestino();
						}
						break;
					case CONCAT:
							codigoDestinoExpressao += "invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String; \r\n";
						break;
					case DIFERENTE:
						PrimitivoLabel labelCOLOCATRUEdiferente = new PrimitivoLabel("COLOCATRUEdiferente");
						PrimitivoLabel labelSAIDAdiferente = new PrimitivoLabel("SAIDAdiferente");

						codigoDestinoExpressao += "dcmpg \r\n"
								+ "ifeq "+labelCOLOCATRUEdiferente.getLabel() 
								+ "dconst_1 \r\n"
								+ "goto "+labelSAIDAdiferente.getLabel()
								+ labelCOLOCATRUEdiferente.geraCodigoDestino()
								+ "dconst_0 \r\n"
								+ labelSAIDAdiferente.geraCodigoDestino();
						break;
					case NEGACAO:
						PrimitivoLabel labelCOLOCATRUEnegacao = new PrimitivoLabel("COLOCATRUEnegacao");
						PrimitivoLabel labelSAIDAnegacao = new PrimitivoLabel("SAIDAnegacao");

						codigoDestinoExpressao += "dconst_0 \r\n"
								+ "dcmpg \r\n"
								+ "ifeq " + labelCOLOCATRUEnegacao.getLabel() 
								+ "dconst_0 \r\n"
								+ "goto " + labelSAIDAnegacao.getLabel()
								+ labelCOLOCATRUEnegacao.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAnegacao.geraCodigoDestino();
						break;
					case MENOR:
						PrimitivoLabel labelCOLOCATRUEmenor = new PrimitivoLabel("COLOCATRUEmenor");
						PrimitivoLabel labelSAIDAmenor = new PrimitivoLabel("SAIDAmenor");
						
						codigoDestinoExpressao += "dcmpg \r\n"
								+ "iflt "+labelCOLOCATRUEmenor.getLabel() 
								+ "dconst_0 \r\n"
								+ "goto "+labelSAIDAmenor.getLabel()
								+ labelCOLOCATRUEmenor.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAmenor.geraCodigoDestino();
						break;
					case MAIORIGUAL:
						PrimitivoLabel labelCOLOCATRUEmaiorIgual = new PrimitivoLabel("COLOCATRUEmaiorIgual");
						PrimitivoLabel labelSAIDAmaiorIgual = new PrimitivoLabel("SAIDAmaiorIgual");
						
						codigoDestinoExpressao += "dcmpg \r\n"
								+ "ifge " + labelCOLOCATRUEmaiorIgual.getLabel() 
								+ "dconst_0 \r\n"
								+ "goto "+labelSAIDAmaiorIgual.getLabel()
								+ labelCOLOCATRUEmaiorIgual.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAmaiorIgual.geraCodigoDestino();
						break;
				}
				
				CodigoDestino.tamanhoPilha -= 2;
			}	
		}	
			
		return codigoDestinoExpressao;	
	}
	
	public void otimizarNegacao()
	{
		Item itemAtual;
		Operador operador;
		int qtdNegacoesConsecutivas = 0;

		for ( int idItem = 0; idItem < this.getListaExpPosFixa().size(); idItem++ )
		{
			itemAtual = this.getListaExpPosFixa().get(idItem);
			
			if ( itemAtual instanceof Operador )
			{
				operador = (Operador)itemAtual;
				if ( operador.getTipoOperador() == TipoOperador.NEGACAO )
				{
					qtdNegacoesConsecutivas++;
					if ( qtdNegacoesConsecutivas == 2 ) 
					{
						this.getListaExpPosFixa().remove(idItem);
						this.getListaExpPosFixa().remove(idItem-1);
						idItem -= 2;
						qtdNegacoesConsecutivas = 0;
					}
				} else
					qtdNegacoesConsecutivas = 0;
					
			} else
			{
				qtdNegacoesConsecutivas = 0;
			}
		}
	}

	public void otimizarOperacoesConstantes()
	{
		Item itemAtual, itemA, itemB;
		Operando operandoA, operandoB;
		Operador operador;
		double A, B;
		
		for( int idItem = 0; idItem < this.getListaExpPosFixa().size(); idItem++ )
		{
			itemAtual = this.getListaExpPosFixa().get(idItem);
			
			// Se for um operador binario
			if ( itemAtual instanceof Operador )
			{
				operador = (Operador)itemAtual;
				
				if ( operador.getTipoOperador() == TipoOperador.LOG || operador.getTipoOperador() == TipoOperador.NEGACAO )
				{
					itemA = this.getListaExpPosFixa().get(idItem-1);
					
					if ( itemA instanceof Operando)
					{
						operandoA = (Operando)itemA;
						if ( operandoA.getTipoDado() == TipoDado.NUMERO && operandoA.getTipoElemento() == TipoElemento.CTE )
						{
							A = Double.parseDouble( operandoA.getLexema() );
							switch( operador.getTipoOperador() )
							{
								case LOG:
									A = Math.log10( A );
									break;
							}
							
							this.listaExpPosFixa.remove( idItem );
							this.listaExpPosFixa.remove( idItem - 1 );
							// Calcula o indice que o novo elemento ocupará na lista
							idItem--;
							
							// Adiciona o elemento resultado da otimizacao na lista da expressao
							Item valorOtimizado = new Operando( TipoDado.NUMERO, TipoElemento.CTE, new Token(0, Double.toString(A) ), Sinal.POS );
							this.listaExpPosFixa.add( idItem, valorOtimizado );	
						}
					}
					
				} else 
				{
					itemA = this.getListaExpPosFixa().get(idItem-2);
					itemB = this.getListaExpPosFixa().get(idItem-1);
					
					if ( itemA instanceof Operando && itemB instanceof Operando )
					{
						operandoA = (Operando)itemA;
						operandoB = (Operando)itemB;
						
						if ( operandoA.getTipoDado() == TipoDado.NUMERO && operandoA.getTipoElemento() == TipoElemento.CTE &&
								operandoB.getTipoDado() == TipoDado.NUMERO && operandoB.getTipoElemento() == TipoElemento.CTE )
						{
							A = Double.parseDouble( operandoA.getLexema() );
							B = Double.parseDouble( operandoB.getLexema() );
							switch( operador.getTipoOperador() )
							{
								case SOMA:
									A += B;
									break;
								case SUB:
									A -= B;
									break;
								case MUL:
									A *= B;
									break;
								case DIV: 
									A /= B;
									break;
								case POT:
									A = Math.pow( A, B );
									break;
							}
							
							// Remove os 3 elementos otimizados
							this.listaExpPosFixa.remove( idItem );
							this.listaExpPosFixa.remove( idItem - 1 );
							this.listaExpPosFixa.remove( idItem - 2 );
							
							// Calcula a posicao do novo valor otimizado na lista
							idItem -= 2;
							
							// Adiciona o elemento resultado da otimizacao na lista da expressao
							Item valorOtimizado = new Operando( TipoDado.NUMERO, TipoElemento.CTE, new Token(0, Double.toString(A) ), Sinal.POS );
							this.listaExpPosFixa.add( idItem, valorOtimizado );
						}
					}
				}
				
			}
				
		}
	}
	
	
	public String toString() {
		return "[infixa: "+this.getListaExpInfixa() +
				"]; posfixa: ["+this.getListaExpPosFixa()+"]";
	}
	//Tarefa 07
	public void otimizaPosfixa() {
		int tam=this.listaExpPosFixa.size();
		LinkedList<Item> listaExpPosFixaOtimizada=this.listaExpPosFixa;
		for(int i=0;i< tam-2;) {
			int otimizou=0,zero=0;
			//a verificacao usa os proximos 3 itens
			Item item1=listaExpPosFixaOtimizada.get(i);
			Item item2=listaExpPosFixaOtimizada.get(i+1);
			Item item3=listaExpPosFixaOtimizada.get(i+2);
			//se for a sequencia operando operando operador
			if(item1 instanceof Operando && item2 instanceof Operando && item3 instanceof Operador) {
				Operando op1=(Operando) item1;
				Operando op2=(Operando) item2;
				//se seguir a sequencia 0 x operador
				if(op1.getTipoDado()==TipoDado.NUMERO &&
						item1.getLexema().equals("0.0") && op2.getTipoDado()==TipoDado.NUMERO &&
								op2.getTipoElemento()==TipoElemento.VAR) {
					Operador operador=(Operador) item3;
					//substitui por 0 ou por x dependendo do operador
					switch(operador.getTipoOperador()) {
						case SOMA:
							listaExpPosFixaOtimizada.remove(i);
								listaExpPosFixaOtimizada.remove(i+1);
								otimizou=1;
							break;
						case SUB:
								listaExpPosFixaOtimizada.remove(i);
								listaExpPosFixaOtimizada.remove(i+1);
								otimizou=1;
							break;
						case MUL:
								listaExpPosFixaOtimizada.remove(i+1);
								listaExpPosFixaOtimizada.remove(i+1);
								otimizou=1;
							break;
						case DIV:
								listaExpPosFixaOtimizada.remove(i+1);
								listaExpPosFixaOtimizada.remove(i+1);
								otimizou=1;
							break;
						default:
							break;
					}
				}
				else {
					//se for a sequencia x 0 operador
					if(op2.getTipoDado()==TipoDado.NUMERO &&
							item2.getLexema().equals("0.0") && op1.getTipoDado()==TipoDado.NUMERO &&
									op1.getTipoElemento()==TipoElemento.VAR) {
						Operador operador=(Operador) item3;
						//substitui por 0 ou por x dependendo do operador
						switch(operador.getTipoOperador()) {
						case SOMA:
							listaExpPosFixaOtimizada.remove(i+1);
							listaExpPosFixaOtimizada.remove(i+1);
							otimizou=1;
						break;
					case SUB:
							listaExpPosFixaOtimizada.remove(i+1);
							listaExpPosFixaOtimizada.remove(i+1);
							otimizou=1;
						break;
					case MUL:
							listaExpPosFixaOtimizada.remove(i);
							listaExpPosFixaOtimizada.remove(i+1);
							otimizou=1;
						break;
					default:
						break;
						}
					}
				}
			}
			//se otimizou, vericar se precisa otimizar novamente do inicio da expressao
			if(otimizou==1) {
				tam=listaExpPosFixaOtimizada.size();
				i=0;
			}
			else i++;
		}
		//substui a expPosFixa pela sua versao otimizada
		this.listaExpPosFixa=listaExpPosFixaOtimizada;
	}

	// Tarefa 08
	// Otimizacao de codigo tipo elemento neutro envolvendo a constante 1
	public void otimizarPosFixaConst1()
	{
		int idItem, qtdOperandosPendentes, i;
		Item itemAtual, itemA, itemB;
		// Considere a expressao no formato: A (segundo op.) B (primeiro op.) <operador>
		for( idItem = 0; idItem < this.listaExpPosFixa.size(); idItem++)
		{
			itemAtual = this.listaExpPosFixa.get(idItem);
			if( itemAtual instanceof Operador )
			{
				TipoOperador tipoOp =  ((Operador)itemAtual).getTipoOperador() ;
				// Verifica se o primeiro elemento a esquerda de / e um operando
				if( tipoOp == TipoOperador.DIV )
				{
					itemB = this.listaExpPosFixa.get(idItem-1);
					if ( itemB instanceof Operando && ((Operando)itemB).getTipoElemento() == TipoElemento.CTE 
												   && Double.parseDouble( ((Operando)itemB).getLexema() ) == 1.0 )
					{
						this.getListaExpPosFixa().remove( idItem );
						this.getListaExpPosFixa().remove( idItem - 1 );
						idItem -= 2;
					}

				} else 
				{
					if ( tipoOp == TipoOperador.MUL )
					{
						itemB = this.listaExpPosFixa.get(idItem-1);
						if ( itemB instanceof Operando )
						{
								// Se o primeiro elemento a esquerda de * eh um operando constante de valor 1
								if ( ((Operando)itemB).getTipoElemento() == TipoElemento.CTE && Double.parseDouble( ((Operando)itemB).getLexema() ) == 1.0 )
								{
									this.getListaExpPosFixa().remove( idItem );
									this.getListaExpPosFixa().remove( idItem - 1 );
									idItem -= 2;
								} else
								{ 
									// Analise o segundo operando 
									itemA = this.listaExpPosFixa.get(idItem-2);
									if ( itemA instanceof Operando && ((Operando)itemA).getTipoElemento() == TipoElemento.CTE 
																   && Double.parseDouble( ((Operando)itemA).getLexema() ) == 1.0)
									{
										
										this.getListaExpPosFixa().remove( idItem );
										this.getListaExpPosFixa().remove( idItem - 2 );
										idItem -= 2;
									}
								}
								
						} else
						{
							// Caso o primeiro elemento seja um operador 
							// Procura o segundo operando do * com base na quantidade de operandos que cada operador requer.
							qtdOperandosPendentes = 1;
							itemA = null;
							i = idItem - 1;
							do
							{
								itemA = this.listaExpPosFixa.get(i);
										
								if ( itemA instanceof Operando )
									qtdOperandosPendentes--;
								else if ( itemA instanceof Operador )
									qtdOperandosPendentes++;
								i--;
							} while ( qtdOperandosPendentes > 0 );
							
							itemA = this.getListaExpPosFixa().get(i);
							
							// i guarda o indice do primeiro elemento que compoe o segundo operando de *
							// se eh possivel otimizar remove o operador * e o operando localizado.
								if ( itemA instanceof Operando && ((Operando)itemA).getTipoElemento() == TipoElemento.CTE && 
										Double.parseDouble( ((Operando)itemA).getLexema() ) == 1.0)
								{
										this.getListaExpPosFixa().remove( idItem );
										this.getListaExpPosFixa().remove( i );
										idItem -= 2;
								} 
						}
					}
				}
			}
		}
		
	}
	
}