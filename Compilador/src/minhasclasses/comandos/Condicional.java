package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tabela;

public class Condicional extends Comando {
	private Expressao expressao;
	private ListaComandos verdadeiro;
	private ListaComandos falso;
	
	public Condicional(){}

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
	
	public String geraCodigoDestino(Tabela tabela){
		int labelElse = tabela.getLabelCondicional(); // Label usada caso a expressão do if resulte em false.
		tabela.incLabelCondicional();
		String comandoIf ="";
		
		comandoIf += expressao.geraCodigoExpressao(tabela);//Código da expressão de análise do if();
		comandoIf += "dconst_0 \r\n";
		comandoIf += "dcmpg \r\n";
		comandoIf += "ifeq CONDICIONAL_"+ labelElse + "\r\n";//Se der false, vá para else, se não, execute o código do if.
		//Código do if
    	for(Comando com : verdadeiro.getComandos()){
    		comandoIf += com.geraCodigoDestino(tabela);
    	}
    	comandoIf += "goto CONDICIONALEND_"+tabela.getLabelCondicionalEnd()+"\r\n";//Terminou o if, vá para depois do código do else;
    	comandoIf += "CONDICIONAL_"+labelElse +":\r\n";
    	for(Comando com : falso.getComandos()){
    		comandoIf += com.geraCodigoDestino(tabela);
    	}
    	comandoIf += "CONDICIONALEND_"+tabela.getLabelCondicionalEnd()+":\r\n";
    	tabela.incLabelCondicionalEnd();
		return comandoIf;
	}
	

	@Override
	public String toString() {
		return "\nComando CONDICIONAL (condicao, lista verdadeiro, lista falso): "+
	           "condicao: "+this.expressao.toString() + 
	           ", lista verdadeiro: "+ this.verdadeiro +
               ", lista falso: "     + this.falso;
	}	
}