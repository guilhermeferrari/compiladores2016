package minhasclasses;

import java.util.LinkedList;

public class Expressao {
	private LinkedList <Item> listaExpressao;
	private int linha;
	private String codigoInfixo;
	private TipoDados tipoDados;
	
	public Expressao(){
		codigoInfixo = "";
		listaExpressao = new LinkedList<Item>();
	}
	
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

	public void addCodigoInfixo(String elemento) {
		codigoInfixo += elemento + " ";
	}

	public TipoDados getTipoDados() {
		return tipoDados;
	}

	public void setTipoDados(TipoDados tipo) {
		this.tipoDados = tipo;
	}
	
	public void addItem(Item item){
		listaExpressao.add(item);
	}
	
	@Override
	public String toString(){
		String message = "";
		
		for (int i=0; i<listaExpressao.size(); i++){
			message += listaExpressao.get(i).getValor() + " ";
		}
		
		return message;
	}
}
