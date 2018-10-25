package comandoPrimitivo;

public class PrimitivoSeExpFalsoGoto extends ComandoPrimitivo{
	
	String expDestinoAssembler;
	PrimitivoLabel labelFalse;
	ListaComandosPrimitivos listaComandosPrimitivosTrue;
	
	public PrimitivoSeExpFalsoGoto(String expDestinoAssembler, PrimitivoLabel labelFalse, ListaComandosPrimitivos listaComandosPrimitivosTrue){
		this.expDestinoAssembler = expDestinoAssembler;
		this.labelFalse = labelFalse;
		this.listaComandosPrimitivosTrue = listaComandosPrimitivosTrue;
	}
	
	public String geraCodigoDestino() {
		
		String codigoDestino = this.expDestinoAssembler
				+ "dconst_0\n"
				+ "dcmpg\n"
				+ "ifeq "+this.labelFalse.getLabel() + "\n"
				+ this.listaComandosPrimitivosTrue.geraCodigoDestinoCompleto();
		
		return codigoDestino;
	}
	
	public String toString() {
		return "Primitivo SeExpFalsoGoto" + this.expDestinoAssembler + " " + this.labelFalse + " \t" + this.listaComandosPrimitivosTrue;
	}
	
	

}