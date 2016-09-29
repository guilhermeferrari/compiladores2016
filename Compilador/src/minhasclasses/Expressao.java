package minhasclasses;

import java.util.LinkedList;

public class Expressao {
	private LinkedList <Item> listaExpressao = new LinkedList<Item>();
	private int linha;
	private String codigoInfixo;
	private char tipoRetorno;
	
	public LinkedList<Item> getListaExpressao() {
		return listaExpressao;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public String getCodigoInfixo() {
		return codigoInfixo;
	}

	public void addCodigoInfixo(String codigoAnterior) {
		codigoInfixo += codigoAnterior;
	}

	public char getTipoRetorno() {
		return tipoRetorno;
	}



	public void setTipoRetorno(char tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}


	public Expressao(){
		
	}
	
	public void addItem(Item item){
		listaExpressao.add(item);
	}
}
