package minhasclasses.comandos;

import minhasclasses.Tabela;

public class Para extends Comando {
	
	private Comando atribuicao, enquanto;
	
	public Para () {}
	
	public void setAtribuicao (Comando atribuicao) {
		this.atribuicao = atribuicao;
	}
	
	public Comando getAtribuicao() {
		return atribuicao;
	}
	
	public void setEnquanto (Comando enquanto) {
		this.enquanto = enquanto;
	}
	
	public Comando getEnquanto() {
		return enquanto;
	}
	
	public String toString() {
		String message = "";
		message += "---------- Para ----------\n";
		message += atribuicao;
		message += enquanto;
		message += "--------------------------\n";
		return message;
	}

	@Override
	public String geraCodigoDestino(Tabela tabela) {
		// TODO Auto-generated method stub
		return null;
	}
}
