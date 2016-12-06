package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tabela;
import parser.*;

public class Condicional extends Comando {
	private Expressao expressao;
	private ListaComandos verdadeiro;
	private ListaComandos falso;
	
	static private int labelCondicional = 0; 
	static private int labelCondicionalEnd = 0;
	

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
	
	public String geraCodigoDestino(){
		int labelElse = Condicional.labelCondicional; // Label usada caso a expressão do if resulte em false.
		Condicional.labelCondicional++;
		String comandoIf ="";
		
		comandoIf += expressao.geraCodigoExpressao();//Código da expressão de análise do if();
		comandoIf += "dconst_0 \r\n";
		comandoIf += "dcmpg \r\n";
		comandoIf += "ifeq CONDICIONAL_"+ labelElse + "\r\n";//Se der false, vá para else, se não, execute o código do if.
		//Código do if
    	for(Comando com : verdadeiro.getComandos()){
    		comandoIf += com.geraCodigoDestino();
    	}
    	comandoIf += "goto CONDICIONALEND_"+Condicional.labelCondicionalEnd+"\r\n";//Terminou o if, vá para depois do código do else;
    	comandoIf += "CONDICIONAL_"+labelElse +":\r\n";
    	if(this.falso != null) {
    		for(Comando com : falso.getComandos()){
    			comandoIf += com.geraCodigoDestino();
    		}
		}
    	comandoIf += "CONDICIONALEND_"+Condicional.labelCondicionalEnd+":\r\n\r\n";
    	Condicional.labelCondicionalEnd++;
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