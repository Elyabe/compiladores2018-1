package semantico;

public class AcoesSemanticas {

	public static void inicializacao(Tabela tab, String var) {
		
		if(!tab.isExiste(var))
			System.out.println("Erro sem�ntico A vari�vel "+ var + " n�o foi inicializada");
		
	}
	
	public static void declaracao(Tabela tab, String var) {
		
		if(tab.isExiste(var))
			System.out.println("Erro sem�ntico \n A vari�vel " + var + " j� foi declarada");
		
	}
}
