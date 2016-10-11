package minhasclasses.comandos;

import minhasclasses.Expressao;

public class EntradaDados extends Comando{
	private char tipo;
	private Expressao ref1;
	
	public EntradaDados(){}
	
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public Expressao getListaComandos() {
		return ref1;
	}

	public void setExpressao(Expressao ref1) {
		this.ref1 = ref1;
	}
	
}
