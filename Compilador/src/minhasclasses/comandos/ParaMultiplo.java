package minhasclasses.comandos;

import java.util.LinkedList;

import minhasclasses.Tabela;

public class ParaMultiplo  {
	
	private LinkedList<Comando> atribuicoes;
	private Comando enquanto;
	
	public ParaMultiplo () {
		atribuicoes = new LinkedList<Comando>();
	}
	
	public void insereAtribuicao (Comando atribuicao) {
		this.atribuicoes.add(atribuicao);
	}
	
	public LinkedList<Comando> getAtribuicoes() {
		return atribuicoes;
	}
	
	public void setEnquanto (Comando enquanto) {
		this.enquanto = enquanto;
	}
	
	public Comando getEnquanto() {
		return enquanto;
	}
	
	public String toString() {
		String message = "";
		message += "------ ParaMultiplo ------\n";
		//for (int i=0; i<atribuicoes.size(); i++)
			//message += (Atribuicao)(atribuicoes.get(i));
		message += enquanto;
		message += "--------------------------\n";
		return message;
	}

}
