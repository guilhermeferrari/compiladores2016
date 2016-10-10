package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.comandos.ListaComandos;

public class Condicional extends Comando {
	
	private Expressao expressao;
	private ListaComandos verdadeiro;
	private ListaComandos falso;
	
	public Condicional(){}
	
	public Condicional(Expressao expressao, ListaComandos verdadeiro, ListaComandos falso){
		this.expressao = expressao;
		this.verdadeiro = verdadeiro;
		this.falso = falso;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

	public ListaComandos getVerdadeiro() {
		return verdadeiro;
	}

	public void setVerdadeiro(ListaComandos verdadeiro) {
		this.verdadeiro = verdadeiro;
	}

	public ListaComandos getFalso() {
		return falso;
	}

	public void setFalso(ListaComandos falso) {
		this.falso = falso;
	}
}
