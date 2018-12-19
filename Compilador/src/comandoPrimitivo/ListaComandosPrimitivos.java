package comandoPrimitivo;

import java.util.LinkedList;

public class ListaComandosPrimitivos {
	
	private LinkedList<ComandoPrimitivo> listaComandosPrimitivos;
	
	public ListaComandosPrimitivos() {
		this.listaComandosPrimitivos = new LinkedList<ComandoPrimitivo>(); 
	}

	public void addComando(ComandoPrimitivo comando) {
		this.listaComandosPrimitivos.add(comando);
	}
	
	public void addComandoIndice( ComandoPrimitivo comando, int pos )
	{
		this.listaComandosPrimitivos.add(pos, comando);
	}
	
	public void addComandoInicio( ComandoPrimitivo comando )
	{
		this.listaComandosPrimitivos.addFirst(comando);
	}
	
	public ComandoPrimitivo getComando(int indice)
	{
		return this.listaComandosPrimitivos.get(indice);
	}
	
	public void removerComando( int indice )
	{
		this.listaComandosPrimitivos.remove(indice);	
	}
	
	public LinkedList<ComandoPrimitivo> getListaComandosPrimitivos(){
		return this.listaComandosPrimitivos;
	}
	
	public String geraCodigoDestinoTotal() {
		
		StringBuilder codigo = new StringBuilder();
	
		for(ComandoPrimitivo comandoPrimitivo : this.listaComandosPrimitivos) {
			codigo.append(comandoPrimitivo.geraCodigoDestino());
		}
		return codigo.toString();
	}
	
	@Override
	public String toString() {
		return  this.listaComandosPrimitivos.toString();
	}
	
}
