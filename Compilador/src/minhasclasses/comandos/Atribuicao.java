package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tipo;
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
		if(Compilador.tabela.getTipoSimbolo(nomeVariavel)==Tipo.STRING){
			if(referencia <= 3){
				codigoDestino+="astore_"+ referencia.toString()+"\r\n";
			}
			else{
				
				codigoDestino+="astore "+ referencia.toString()+"\r\n";
			}
		
		}
		else{
			if(referencia <= 3){
				codigoDestino+="dstore_"+ referencia.toString()+"\r\n";
			}
			else{
				
				codigoDestino+="dstore "+ referencia.toString()+"\r\n";
			}
		}
		return codigoDestino;
	}
	
	@Override
	public String toString() {
		return "\nComando ATRIBUICAO (variavel, expressao): "+
	           "variavel: " + this.nomeVariavel + 
	           ", expressao: "+this.expressao.toString();
	}
}
