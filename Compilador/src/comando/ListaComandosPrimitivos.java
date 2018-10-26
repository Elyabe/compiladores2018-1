package comando;


import java.util.LinkedList;

public class ListaComandosPrimitivos 
{

	private LinkedList<ComandoPrimitivo> listaComandosPrimitivos;
	
	public ListaComandosPrimitivos()
	{
		this.listaComandosPrimitivos = new LinkedList<ComandoPrimitivo>();
	}
	
	public void addComando(ComandoPrimitivo _comandoPrimitivo)
	{
		this.listaComandosPrimitivos.add(_comandoPrimitivo);
	}

	public LinkedList<ComandoPrimitivo> getListaComandosPrimitivos()
	{
		return this.listaComandosPrimitivos;
	}

	public StringBuilder geraCodigoDestinoTotal()
	{
		StringBuilder codigoDestino = new StringBuilder();
		
		for (ComandoPrimitivo comandoPrimitivo : this.listaComandosPrimitivos) 
		{
			codigoDestino.append( comandoPrimitivo.geraCodigoDestino() );
			codigoDestino.append("\n");
		}
		return codigoDestino;
	}
	
	
	public String toString()
	{
		return "{" + this.getListaComandosPrimitivos() + "}";
	}
	
}