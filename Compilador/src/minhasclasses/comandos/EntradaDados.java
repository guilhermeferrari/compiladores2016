package minhasclasses.comandos;
import minhasclasses.Tipo;
import minhasclasses.Item;
import minhasclasses.Tabela;
import minhasclasses.comandos.Exibe;
import parser.*;

public class EntradaDados extends Comando{
	private Item ref1;

	public EntradaDados(){}

	public void setItem(Item ref1) {
		this.ref1 = ref1;
	}
	
	public Item getItem() {
		return ref1;
	}
	
	public String geraCodigoDestino(){
		String codigoLeia ="";
		if(ref1.getTipo() == Tipo.STRING){
			codigoLeia += "new java/util/Scanner \r\n";
			codigoLeia += "dup \r\n";
			codigoLeia += "getstatic java/lang/System/in Ljava/io/InputStream \r\n";
			codigoLeia += "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n";
			codigoLeia += "invokevirtual java/util/Scanner/nextLine()String \r\n";
			codigoLeia += "dstore_+"ref1"+\r\n\";
		}
		else 
		{
			codigoLeia += "new java/util/Scanner \r\n";
			codigoLeia += "dup \r\n";
			codigoLeia += "getstatic java/lang/System/in Ljava/io/InputStream\r\n";
			codigoLeia += "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n";
			codigoLeia += "invokevirtual java/util/Scanner/nextDouble()Double \r\n";
			codigoLeia += "dstore_+"ref1"+\r\n\";
		}	
		
		return codigoLeia;
	}

	@Override
	public String toString() {
		return "\nComando ENTRADA (item): "+
		       "item: "+this.ref1.toString();
	}
		
}
