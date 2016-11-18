package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tabela;
import parser.*;

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
	
	public String geraCodigoDestino(){
		String codigoDestino="";
		Integer referencia = Compilador.tabela.consultaReferencia(nomeVariavel);
		codigoDestino+=this.expressao.geraCodigoExpressao();
		codigoDestino+="dstore_"+ referencia.toString();	
		return codigoDestino;
	}
	
	@Override
	public String toString() {
		return "\nComando ATRIBUICAO (variavel, expressao): "+
	           "variavel: " + this.nomeVariavel + 
	           ", expressao: "+this.expressao.toString();
	}
}
