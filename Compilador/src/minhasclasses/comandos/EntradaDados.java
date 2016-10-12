package minhasclasses.comandos;

import minhasclasses.Item;

public class EntradaDados extends Comando{
	private Item ref1;
	
	public EntradaDados(){}
	
	public Item getListaComandos() {
		return ref1;
	}

	public void setItem(Item ref1) {
		this.ref1 = ref1;
	}
	
}
