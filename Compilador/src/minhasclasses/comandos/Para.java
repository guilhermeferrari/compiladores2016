package minhasclasses.comandos;

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
}
