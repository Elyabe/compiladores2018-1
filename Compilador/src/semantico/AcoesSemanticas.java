package semantico;

public class AcoesSemanticas {
	
	public static void declaraVariavel(String nome, int linha, int ref, Tabela tabela) {
		
		boolean ver=tabela.push(nome,ref);
		if(ver==false) System.out.println("Erro sem�ntico: declara��o da vari�vel "+nome+" repetida na linha "+linha+"\n");

	}
	
	public static void verificaDeclaracao(String nome, int linha, Tabela tabela) {
		if(!tabela.existe(nome)) System.out.println("Erro sem�ntico: vari�vel "+nome+" n�o declarada na linha "+linha+"\n");
	}
	
}
