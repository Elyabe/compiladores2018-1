package comandoAltoNivel;

import java.util.LinkedList;

import parser.Token;
import semantico.*;

public class ChamadaFuncao extends Operador 
{
	private Token nomeFuncao;
	private LinkedList<Expressao> listaParam;
	
	public ChamadaFuncao(TipoOperador tipoOperador, Token token, Token nomeFuncao, LinkedList<Expressao> listaParam ) 
	{
		super(tipoOperador, token);
		this.nomeFuncao = nomeFuncao;
		this.listaParam = listaParam;
	}

	public LinkedList<Expressao> getListaParam() {
		return listaParam;
	}

	public void setListaParam(LinkedList<Expressao> listaParam) {
		this.listaParam = listaParam;
	}
	
	public Token getNomeFuncao()
	{
		return this.nomeFuncao;
	}

}
