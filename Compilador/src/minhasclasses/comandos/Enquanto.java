package minhasclasses.comandos;

public class Enquanto {
	
	private Comando atribuicao, para;
	
	Enquanto () {}
	
	public Comando getAtribuicao() {
		return atribuicao;
	}

	public void setAtribuicao(Comando atribuicao) {
		this.atribuicao = atribuicao;
	}

	public Comando getPara() {
		return para;
	}

	public void setPara(Comando para) {
		this.para = para;
	}
}
