package minhasclasses.comandos;

import minhasclasses.Expressao;

public class Atribuicao extends Comando{
		
	
	private String nomeVariavel;
	private Expressao expressao;
	
	public String getNomeVariavel() {
		return nomeVariavel;
	}
	public void setNomeVariavel(String nomeVariavel) {
		this.nomeVariavel = nomeVariavel;
	}
	public Expressao getExpressao() {
		return expressao;
	}
	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}
	
	public Atribuicao(String nomeVariavel,Expressao expressao){
		this.expressao=expressao;
		this.nomeVariavel=nomeVariavel;
	}
	

}
