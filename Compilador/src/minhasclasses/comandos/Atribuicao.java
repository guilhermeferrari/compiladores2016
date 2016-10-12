package minhasclasses.comandos;

import java.util.List;

import minhasclasses.Expressao;

public class Atribuicao extends Comando{
		
	
	private List<String> nomeVariavel;
	private List<Expressao> expressao;
	
	public List<String> getNomeVariavel() {
		return nomeVariavel;
	}
	public void setNomeVariavel(List<String> nomeVariavel) {
		this.nomeVariavel = nomeVariavel;
	}
	public List<Expressao> getExpressao() {
		return expressao;
	}
	public void setExpressao(List<Expressao> expressao) {
		this.expressao = expressao;
	}
	
	public Atribuicao(){}
	

}
