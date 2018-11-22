package comandoAltoNivel;

import comandoPrimitivo.*;
import parser.Token;
import semantico.Expressao;

public class ComandoRepetir extends ComandoAltoNivel {
	
	private Expressao expressao;
	private ListaComandosAltoNivel listaComandosAltoNivelRepetir;
	
	public ComandoRepetir(Expressao expressao, ListaComandosAltoNivel listaComandosAltoNivelRepetir, Token token) {
		this.expressao = expressao;
		this.listaComandosAltoNivelRepetir = listaComandosAltoNivelRepetir;
		this.token = token;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() {
		ListaComandosPrimitivos lista = new ListaComandosPrimitivos();
		ListaComandosPrimitivos listaRepetir = this.listaComandosAltoNivelRepetir.geraListaComandoPrimitivosCompleta();
		PrimitivoLabel labelInicioRepetir = new PrimitivoLabel("LABELINICIOREPETIR");
		
		//Label pra marcar onde come�a o la�o e pra onde deve retonar caso for repetir 
		lista.addComando(labelInicioRepetir);
		//Adicionando todos os comando que esta dentro do la�o
		for (ComandoPrimitivo comando : listaRepetir.getListaComandosPrimitivos() ) {
			lista.addComando(comando);
		}
		//Criando um salto para o inicio caso a express�o seja falsa, passamos uma ListaComandoPrimitivos vazia
		//pois o interesse � executar algo caso a express�o seja falsa, em caso de verdadeira apenas segue o fluxos do programa
		PrimitivoSeExpFalsoGoto comandoSeExpFalsoGoto = new PrimitivoSeExpFalsoGoto(this.expressao.geraCodigoDestino(), labelInicioRepetir, new ListaComandosPrimitivos());
		lista.addComando(comandoSeExpFalsoGoto);
		
		return lista;
	}

	@Override
	public String toString() {
		return "\nComando Repetir - lexema: \"" + this.getLexema() 
	     + "\" - expressao: " + this.expressao + " - lista comandos repetir: " 
		 + this.listaComandosAltoNivelRepetir;
	}

}
