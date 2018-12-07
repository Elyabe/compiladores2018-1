package semantico;

import java.util.LinkedList;
import codigoDestino.*;
import comandoPrimitivo.*;
import parser.Compilador;

public class Expressao {

	LinkedList<Item> listaExpInfixa;
	LinkedList<Item> listaExpPosFixa;
	public int tam = 0;

	static LinkedList<String> listaOperandoString =  new LinkedList<String>();

	public Expressao() {
		this.listaExpInfixa = new LinkedList<Item>();
		this.listaExpPosFixa = new LinkedList<Item>();
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

	public void addListaExpInfixa(Item item) {
		this.listaExpInfixa.add(item);
	}
	public void addListaExpPosFixa(Item item) {
		this.listaExpPosFixa.add(item);
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
					case OU:
						PrimitivoLabel labelSAIDAou = new PrimitivoLabel("SAIDAou");
	
						codigoDestinoExpressao += "dconst_0 \r\n"	//Primeiro empilha 0 e compara com a expressao
						+"dcmpg \r\n"								//se o resultado for igual, quer dizer que
						+"ifeq " + labelSAIDAou.getLabel()			//a expressao eh falsa, portanto deve sair
						+"pop2 \r\n"	
						+"dconst_1 \r\n"							//Sendo a expressao verdadeira, basta desempilhar 
						+ labelSAIDAou.geraCodigoDestino();			//a expressao e empilhar 1 como resultado valido
						break;
					case E:
						PrimitivoLabel labelSAIDAe = new PrimitivoLabel("SAIDAe");
						
						codigoDestinoExpressao += "dconst_1 \r\n"			//Primeiro empilha 1 e compara com o topo
								+"dcmpg \r\n"								//se o resultado for igual, quer dizer que 
																			//o segundo que decide o resultado
								+"ifeq " + labelSAIDAe.getLabel()			//portanto deve sair
								+"pop2 \r\n"								//se nao for 1, ele desempilha e empilha 0
								+"dconst_0 \r\n"							//Sai
								+ labelSAIDAe.geraCodigoDestino();
						break;
					case IGUAL:
						PrimitivoLabel labelCOLOCATRUEigual = new PrimitivoLabel("COLOCATRUEigual");
						PrimitivoLabel labelSAIDAigual = new PrimitivoLabel("SAIDAigual");

						codigoDestinoExpressao += "dcmpg \r\n"
								+ "ifeq "+labelCOLOCATRUEigual.getLabel() 
								+ "dconst_0 \r\n"
								+ "goto "+labelSAIDAigual.getLabel()
								+ labelCOLOCATRUEigual.geraCodigoDestino()
								+ "dconst_1 \r\n"
								+ labelSAIDAigual.geraCodigoDestino();
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