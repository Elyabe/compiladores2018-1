package comandoAltoNivel;

import comandoPrimitivo.ListaComandosPrimitivos;
import comandoPrimitivo.PrimitivoReturn;
import parser.Token;
import semantico.*;

public class ComandoRetorne extends ComandoAltoNivel 
{
	private Expressao expressao;
	
	public ComandoRetorne( Token token, Expressao expressao ) 
	{
		this.token = token;
		this.expressao = expressao;
	}
	
	@Override
	public ListaComandosPrimitivos geraListaComandosPrimitivos() 
	{
		ListaComandosPrimitivos listaComandosPrimitivos = new ListaComandosPrimitivos();
		PrimitivoReturn comandoRetorne = new PrimitivoReturn( expressao.getTipoResultado(), this.expressao.geraCodigoDestino() );
		listaComandosPrimitivos.addComando(comandoRetorne);
		
		return listaComandosPrimitivos;
	}
	
	@Override
	public String toString() 
	{
		return "[ RETORNE " 
				+ expressao
				+ "]\r\n";
	}
}
