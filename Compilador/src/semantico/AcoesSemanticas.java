package semantico;
import apoio.*;
import parser.*;

public class AcoesSemanticas {

	public static void inicializacao(String var) {
		
		if(!Compilador.tabela.isExiste(var))
			throw new ErroSemantico("Erro sem�ntico \n A vari�vel " + var + " n�o foi inicializada");
	}
	
	public static void redeclaracao(String var, Simbolo simb, TipoDado tipo) {
		
		if(Compilador.tabela.isExiste(var))
			throw new ErroSemantico("Erro sem�ntico \n A vari�vel " + var + " j� foi declarada");
		else {
	  		simb = new Simbolo(var, tipo,Compilador.tabela.marcador);
	  		
	  		simb.setReferencia(Compilador.tabela, tipo);
	  		Compilador.tabela.inclui(simb);
		}
	}
	
	public static void declaracao(String var) {
		
		if(!Compilador.tabela.isExiste(var))
			throw new ErroSemantico("Erro sem�ntico \n A vari�vel " + var + " n�o foi declarada");
	}
}
