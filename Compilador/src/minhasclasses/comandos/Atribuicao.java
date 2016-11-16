package minhasclasses.comandos;

import minhasclasses.Expressao;
import minhasclasses.Tabela;
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
	
	public String geraCodigoDestinoAtribuicao(Tabela tabela){
		String codigoDestino="";
		Integer referencia = tabela.consultaReferencia(nomeVariavel);
		codigoDestino+=this.expressao.geraCodigoExpressao(tabela);
		codigoDestino+="dstore_"+ referencia.toString();	
		return codigoDestino;
	}
	
	@Override
	public String toString() {
		return "\nComando ATRIBUICAO (variavel, expressao): "+
	           "variavel: " + this.nomeVariavel + 
	           ", expressao: "+this.expressao.toString();
	}
	@Override
	public String geraCodigoDestino() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
