package minhasclasses.comandos;

import java.util.LinkedList;

public class ParaMultiplo {
	
	private LinkedList<Comando> atribuicoes;
	private LinkedList<Comando> enquantos;
	
	ParaMultiplo () {}
	
	public void insereAtribuicao (Comando atribuicao) {
		this.atribuicoes.add(atribuicao);
	}
	
	public LinkedList<Comando> getAtribuicoes() {
		return atribuicoes;
	}
	
	public void insereEnquanto (Comando enquanto) {
		this.enquantos.add(enquanto);
	}
	
	public LinkedList<Comando> getEnquantos() {
		return enquantos;
	}
}
