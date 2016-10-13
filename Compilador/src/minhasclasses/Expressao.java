package minhasclasses;

import java.util.LinkedList;

public class Expressao {
	private LinkedList <Item> listaExpressao;
	private int linha;
	private String codigoInfixo;

	private Tipo tipoDados;
	
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

	public void setCodigoInfixo(String codigoInfixo) {
		this.codigoInfixo = codigoInfixo;
	}
	
	public void addCodigoInfixo(String elemento) {
		codigoInfixo += elemento + " ";
	}
	
	public void addExpressao(Expressao exp) {
		LinkedList<Item> listaExpressao = exp.getListaExpressao();
		addCodigoInfixo( exp.getCodigoInfixo() );
		
		for(int i=0; i<listaExpressao.size(); i++){
			addItem( listaExpressao.get(i) );
		}
		
		setLinha( exp.getLinha() );
		setTipoDados( exp.getTipoDados() );
	}

	public Tipo getTipoDados() {
		return tipoDados;
	}

	public void setTipoDados(Tipo tipo) {
		this.tipoDados = tipo;
	}
	
	public void addItem(Item item){
		/*
		 * A título de otimizar as constantes, o código que adiciona itena à lista de Itens antes verifica
		 * se o Item a ser então adicionado se trata de um operador.
		 * Caso seja, verifica se ambos itens anteriores adicionados à lista são também constantes.
		 * Esse é o único caso possível em que podemos fazer o cálculo prévio para otimização, logo o novo
		 * valor é calculado e substituído no lugar do penúltimo item, enquanto o último é excluído da lista.
		 * O operador, nesse caso, não chega a ser adicionado à lista.
		 * Exemplo: 2 3 + -> 5
		 */
		if(item.getTipo().getValor() == 8) {
			if(this.listaExpressao.get(this.listaExpressao.size()-2).getTipo().getValor() == 1 &&
					this.listaExpressao.get(this.listaExpressao.size()-1).getTipo().getValor() == 1) {
				float valor = 0;
				switch(item.getValor()) {
					case "+":
						valor = Float.valueOf(listaExpressao.get(this.listaExpressao.size()-2).getValor()) +
									Float.valueOf(listaExpressao.get(this.listaExpressao.size()-1).getValor());
						break;
					case "-":
						valor = Float.valueOf(listaExpressao.get(this.listaExpressao.size()-2).getValor()) -
									Float.valueOf(listaExpressao.get(this.listaExpressao.size()-1).getValor());
						break;
					case "*":
						valor = Float.valueOf(listaExpressao.get(this.listaExpressao.size()-2).getValor()) *
									Float.valueOf(listaExpressao.get(this.listaExpressao.size()-1).getValor());
						break;
					case "/":
						valor = Float.valueOf(listaExpressao.get(this.listaExpressao.size()-2).getValor()) /
									Float.valueOf(listaExpressao.get(this.listaExpressao.size()-1).getValor());
						break;
					case "^":
						valor = (float) Math.pow((double)Float.valueOf(listaExpressao.get(this.listaExpressao.size()-2).getValor()),
									(double)Float.valueOf(listaExpressao.get(this.listaExpressao.size()-1).getValor()));
						break;
						
				}
				this.listaExpressao.get(this.listaExpressao.size()-2).setValor(String.valueOf(valor));
				this.listaExpressao.remove(this.listaExpressao.size()-1);
				return;
			}
		}
		
		/*
		 * Analogamente, caso um item do tipo string esteja para ser adicionado na lista de itens,
		 * caso a última posição da lista esteja sendo ocupada por outra string, efetuaremos a concatenação
		 * para otimização.
		 */
		if(item.getTipo().getValor() == 2 &&
				this.listaExpressao.get(this.listaExpressao.size()-1).getTipo().getValor() == 2) {
					String valor = this.listaExpressao.get(this.listaExpressao.size()-1).getValor() + item.getValor();
					this.listaExpressao.get(this.listaExpressao.size()-1).setValor(valor);
			
		}
		listaExpressao.add(item);
	}
	public void removeUltimo(){
		listaExpressao.removeLast();
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
