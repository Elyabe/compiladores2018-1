package comandoAltoNivel;


import java.util.LinkedList;


import comandoPrimitivo.ComandoPrimitivo;
import comandoPrimitivo.ListaComandosPrimitivos;

public class ListaComandosAltoNivel {
	
	private LinkedList<ComandoAltoNivel> listaComandosAltoNivel;
	
	
	public ListaComandosAltoNivel() {
		this.listaComandosAltoNivel = new LinkedList<ComandoAltoNivel>();   
	}
	
	public void addComando(ComandoAltoNivel comando) {
		this.listaComandosAltoNivel.add(comando);
	}
	
	public void addComandoIndice( ComandoAltoNivel comando, int pos )
	{
		this.listaComandosAltoNivel.add(pos, comando);
	}
	
	public void addComandoInicio( ComandoAltoNivel comando )
	{
		this.listaComandosAltoNivel.addFirst(comando);
	}
	
	public ComandoAltoNivel getComando(int indice)
	{
		return this.listaComandosAltoNivel.get(indice);
	}
	
	public void removerComando( int indice )
	{
		this.listaComandosAltoNivel.remove(indice);	
	}
	
	public LinkedList<ComandoAltoNivel> getListaComandosAltoNivel(){
		return this.listaComandosAltoNivel;
	}
	
	public ListaComandosPrimitivos geraListaComandoPrimitivosCompleta() {		
		ListaComandosPrimitivos listaComandosPrimitivosCompleta = new ListaComandosPrimitivos();
		for(ComandoAltoNivel comando : listaComandosAltoNivel ){
			ListaComandosPrimitivos listaComandosPrimitivos = comando.geraListaComandosPrimitivos();
			for(ComandoPrimitivo comandoPrimitivo : listaComandosPrimitivos.getListaComandosPrimitivos()){
				listaComandosPrimitivosCompleta.addComando(comandoPrimitivo);
			}
		}
		
		return listaComandosPrimitivosCompleta;	
	}
	
	
	
	@Override
	public String toString() {
		return  this.listaComandosAltoNivel.toString();
	}
	


}
