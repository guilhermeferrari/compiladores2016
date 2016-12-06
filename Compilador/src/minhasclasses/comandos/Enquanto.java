package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tabela;
import minhasclasses.comandos.ListaComandos;
import parser.*;

public class Enquanto extends Comando {
	private Expressao condicao;
	private ListaComandos listaComandos;
	static private int contagemEnquanto=0;
	

	public Enquanto() {
	}
	
	public Enquanto(Expressao expressao, ListaComandos listaComandos){
		this.condicao = expressao;
		this.setListaComandos(listaComandos);
	}
	
	public Expressao getCondicao() {
		return condicao;
	}

	public void setCondicao(Expressao condicao) {
		this.condicao = condicao;
	}

	public ListaComandos getListaComandos() {
		return listaComandos;
	}

	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}
	
	public String geraCodigoDestino(){
		String saida = new String();
		int numLabel = contagemEnquanto;
		contagemEnquanto ++;

		saida += "RotuloInicio_Enquanto"+(numLabel)+": \r\n";
		saida += condicao.geraCodigoExpressao() + " \r\n";
		saida += "dconst_0 \r\n";
		saida += "dcmpg \r\n";		
		saida += "ifeq RotuloFim_Enquanto"+(numLabel)+" \r\n";
		
		for(Comando com : listaComandos.getComandos()){
			saida += com.geraCodigoDestino();
		}
		
		saida += "goto RotuloInicio_Enquanto"+(numLabel)+" \r\n";
		saida += "RotuloFim_Enquanto"+(numLabel)+": \r\n\r\n";
		return saida;
	}

	@Override
	public String toString() {
		return "\nComando ENQUANTO (condicao, lista comandos): "+
		           "condicao: "+this.condicao.toString() + 
		           "lista comandos: "+ this.listaComandos;
	}
}
