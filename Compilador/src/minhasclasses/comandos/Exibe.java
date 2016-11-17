package minhasclasses.comandos;

import minhasclasses.Item;
import minhasclasses.Tabela;
import minhasclasses.Tipo;

public class Exibe extends Comando{
	private Item item;
	
	public Exibe(Item item){
		this.item = item;
	}
	
	public Exibe(Tipo tipo,String itemValor){
		this.item  = new Item(tipo,itemValor);
	}
	
	public Item getItem(){
		return this.item;
	}
	
	public void setItem(Item item){
		this.item = item;
	}
	
	public String geraCodigoDestino(Tabela tabela){
		String codigoExibicao="";
		if(item.getTipo() == Tipo.NUMERO){
			codigoExibicao += "ldc2_w " + item.getValor() + "\r\n";
		}
		else if(item.getTipo() == Tipo.STRING){
			codigoExibicao += "ldc " + item.getValor() + "\r\n";
		}
		else if(item.getTipo() == Tipo.VARIAVEL){
			String nomeVar = item.getValor();
			int referencia = tabela.consultaReferencia(nomeVar); 
            codigoExibicao += "dload " + referencia + "\r\n";
		}
		return codigoExibicao;
	}
	
	@Override
	public String toString(){
		return "\nComando EXIBE (item): "+
	           this.item.toString();
	}

	@Override
	public String geraCodigoDestino() {
		// TODO Auto-generated method stub
		return null;
	}
}
