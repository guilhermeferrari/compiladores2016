package minhasclasses.comandos;
import minhasclasses.Tipo;
import minhasclasses.Item;
import minhasclasses.Tabela;
import minhasclasses.comandos.Exibe;
import parser.*;

public class EntradaDados extends Comando{
	private Item nomeVar;

	public EntradaDados(){}

	public void setItem(Item nomeVar) {
		this.nomeVar = nomeVar;
	}
	
	public Item getItem() {
		return nomeVar;
	}
	
	public String geraCodigoDestino(){
		String codigoLeia ="";
		int referencia = Compilador.tabela.consultaReferencia(this.nomeVar.valor);
		Tipo tipo = Compilador.tabela.getTipoSimbolo(this.nomeVar.valor);
				
		codigoLeia += "new java/util/Scanner \r\n";
		codigoLeia += "dup \r\n";
		codigoLeia += "getstatic java/lang/System/in Ljava/io/InputStream; \r\n";
		codigoLeia += "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n";

		if(tipo == Tipo.STRING){
			System.out.println("estou aqui no string "+referencia);
			codigoLeia += "invokevirtual java/util/Scanner/nextLine()Ljava/lang/String; \r\n";
			codigoLeia += "astore "+referencia+"\r\n";
		}
		else {
			System.out.println("estou aqui no numero "+referencia);
			codigoLeia += "invokevirtual java/util/Scanner/nextDouble()D \r\n";
			codigoLeia += "dstore "+referencia+"\r\n";
		}		
		return codigoLeia;
	}

	@Override
	public String toString() {
		return "\nComando ENTRADA (item): "+
		       "item: "+this.nomeVar.toString();
	}
		
}
