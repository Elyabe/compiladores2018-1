package comandoAltoNivel;

import comandoPrimitivo.ListaComandosPrimitivos;
import semantico.Expressao;

public abstract class ComandoCondicional extends ComandoAltoNivel{
	
	ListaComandosAltoNivel listaComandosAltoNivelTrue;
	Expressao expressao;
	
	public ComandoCondicional(Expressao expressao, ListaComandosAltoNivel listaComandosAltoNivelTrue) {
		this.expressao = expressao;
		this.listaComandosAltoNivelTrue = listaComandosAltoNivelTrue;
	}
	
	public ListaComandosAltoNivel getListaComandosAltoNivelTrue() {
		return listaComandosAltoNivelTrue;
	}

	public void setListaComandosAltoNivelTrue(ListaComandosAltoNivel listaComandosAltoNivelTrue) {
		this.listaComandosAltoNivelTrue = listaComandosAltoNivelTrue;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

	@Override
	public abstract ListaComandosPrimitivos geraListaComandosPrimitivos();
	
	@Override
	public abstract String toString();
	
}
