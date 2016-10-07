package minhasclasses.comandos;

import java.util.LinkedList;

public class ParaMultiplo {
	
	LinkedList<Comando> atribuicoes;
	Comando enquanto;
	
	ParaMultiplo () {}
	
	void insereAtribuicao (Comando atribuicao) {
		this.atribuicoes.add(atribuicao);
	}
	
	void setEnquanto (Comando enquanto) {
		this.enquanto = enquanto;
	}
}
