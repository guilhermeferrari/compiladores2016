package minhasclasses.comandos;

import minhasclasses.Item;
import minhasclasses.Simbolo;
import minhasclasses.Tabela;
import minhasclasses.Tipo;
import parser.*;

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
	
	public String geraCodigoDestino(){
		String codigoExibicao="";
		int referencia = Compilador.tabela.consultaReferencia(item.getValor());
				
		if(this.item.getTipo() == Tipo.NUMERO){
			if(referencia==0) codigoExibicao+="dstore_0\r\n";
			else if(referencia==1) codigoExibicao+="dstore_1\r\n";
			else if(referencia==2) codigoExibicao+="dstore_2\r\n";
			else if(referencia==3) codigoExibicao+="dstore_3\r\n";
			else codigoExibicao+="dstore "+referencia+"\r\n";
			
			codigoExibicao+="getstatic java/lang/System/out Ljava/io/PrintStream;\r\n";		
			codigoExibicao+="invokevirtual java/io/PrintStream/println(D)V\r\n";
		}
		else if(this.item.getTipo() == Tipo.STRING){
			if(referencia==0) codigoExibicao+="astore_0\r\n";
			else if(referencia==1) codigoExibicao+="astore_1\r\n";
			else if(referencia==2) codigoExibicao+="astore_2\r\n";
			else if(referencia==3) codigoExibicao+="astore_3\r\n";
			else codigoExibicao+="astore "+(Simbolo.getMarcador())+"\r\n";
			
			codigoExibicao+="getstatic java/lang/System/out Ljava/io/PrintStream;\r\n";		
			codigoExibicao+="invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\r\n";
		}
		else
			codigoExibicao+="erro no comando exibicao - tipo nao identificado\r\n";
		
		return codigoExibicao;
	}
	
	@Override
	public String toString(){
		return "\nComando EXIBE (item): "+
	           this.item.toString();
	}
}
