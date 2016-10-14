package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.comandos.ListaComandos;

public class Enquanto extends Comando {
	
	private Expressao condicao;
	private ListaComandos listaComandos;
	
	public Enquanto() {}
	
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

	@Override
	public String toString() {
		return this.condicao.toString();
	}
}
