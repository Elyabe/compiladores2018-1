package semantico;
import apoio.*;
import parser.Token;

public class AcoesSemanticas {
	
	public static void declaraVariavel(Token t, TipoDado tipo, Tabela tabela) {
		boolean ver=tabela.incluiSimbolo(new Simbolo(t,tipo,Tabela.getRef(tipo)));
		if(ver==false) System.out.println("Erro sem�ntico: declara��o da vari�vel "+t.image+" repetida na linha "+t.beginLine+"\n");

	}
	
	public static void verificaDeclaracao(Token t, Tabela tabela) {
		if(!tabela.verificaExistenciaSimbolo(t.image)) 
			throw new ErroSemantico("\nErro sem�ntico: vari�vel \""+t.image+"\" n�o declarada na linha "+t.beginLine+"\n");
	}
	
}
