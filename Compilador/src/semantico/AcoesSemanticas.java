package semantico;
import apoio.*;

public class AcoesSemanticas {

	public static void inicializacao(Tabela tab, String var) {
		
		if(!tab.isExiste(var))
			throw new ErroSemantico("Erro sem�ntico \n A vari�vel " + var + " n�o foi inicializada");
	}
	
	public static void declaracao(Tabela tab, String var) {
		
		if(tab.isExiste(var))
			throw new ErroSemantico("Erro sem�ntico \n A vari�vel " + var + " j� foi declarada");
		
	}
}
