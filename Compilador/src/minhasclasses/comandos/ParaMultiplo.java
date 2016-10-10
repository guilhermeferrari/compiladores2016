package minhasclasses.comandos;

import java.util.LinkedList;

public class ParaMultiplo {
	
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
}
