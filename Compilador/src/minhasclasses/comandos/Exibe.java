package minhasclasses.comandos;

import java.io.Serializable;

import minhasclasses.Item;
import minhasclasses.Simbolo;
import minhasclasses.Tipo;
import parser.Compilador;

public class Exibe extends Comando implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
		
		codigoExibicao+="getstatic java/lang/System/out Ljava/io/PrintStream;\r\n";		
		
		if(this.item.getTipo() == Tipo.VARIAVEL) {
			int referencia = Compilador.tabela.consultaReferencia(item.getValor());
			Tipo tipo = Compilador.tabela.getTipoSimbolo(item.getValor());		

			if(tipo == Tipo.NUMERO){
				if(referencia==0) codigoExibicao+="dload_0\r\n";
				else if(referencia==1) codigoExibicao+="dload_1\r\n";
				else if(referencia==2) codigoExibicao+="dload_2\r\n";
				else if(referencia==3) codigoExibicao+="dload_3\r\n";
				else codigoExibicao+="dload "+referencia+"\r\n";
			
				codigoExibicao+="invokevirtual java/io/PrintStream/print(D)V\r\n";
			}
			else if(tipo == Tipo.STRING){
				if(referencia==0) codigoExibicao+="aload_0\r\n";
				else if(referencia==1) codigoExibicao+="aload_1\r\n";
				else if(referencia==2) codigoExibicao+="aload_2\r\n";
				else if(referencia==3) codigoExibicao+="aload_3\r\n";
				else codigoExibicao+="aload "+(Simbolo.getMarcador())+"\r\n";
			
				codigoExibicao+="invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\r\n";
			}
		}
		
		else if(this.item.getTipo() == Tipo.STRING) {
			codigoExibicao += "ldc " + this.item.getValor() + "\r\n"; 
			codigoExibicao+="invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\r\n";
		}

		else if(this.item.getTipo() == Tipo.NUMERO) {
			if(this.item.getValor().contains("."))
				codigoExibicao += "ldc2_w " + this.item.getValor() + " \r\n";
			else
				codigoExibicao += "ldc2_w " + this.item.getValor() + ".0 \r\n";	
			
			codigoExibicao+="invokevirtual java/io/PrintStream/print(D)V\r\n";
		}
		
		return codigoExibicao;
	}
	
	@Override
	public String toString(){
		return "\nComando EXIBE (item): "+
	           this.item.toString();
	}
}
