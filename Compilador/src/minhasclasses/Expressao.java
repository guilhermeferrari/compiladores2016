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
		
		// quest�o da prova simulada: otimiza o operador m�dulo
		if(item.getTipo() == Tipo.OPERADOR &&
		   item.getValor() == "@") {
			if(this.listaExpressao.getLast().getTipo() == Tipo.NUMERO) {
				double x = Double.parseDouble(this.listaExpressao.getLast().getValor());
				if(x < 0) {
					x = x * -1;
					this.listaExpressao.getLast().setValor(String.valueOf(x));
					return;
				}
			}
		}
	
		if(item.getTipo() == Tipo.OPERADOR && this.listaExpressao.size() >= 2 ) {
			if(this.listaExpressao.get(this.listaExpressao.size()-2).getTipo() == Tipo.NUMERO ||
			   this.listaExpressao.get(this.listaExpressao.size()-1).getTipo() == Tipo.NUMERO ||
			   this.listaExpressao.get(this.listaExpressao.size()-2).getTipo() == Tipo.VARIAVEL ||
			   this.listaExpressao.get(this.listaExpressao.size()-1).getTipo()== Tipo.VARIAVEL){
				if (listaExpressao.get(this.listaExpressao.size()-2).getValor() == "1" || listaExpressao.get(this.listaExpressao.size()-1).getValor() == "1" || listaExpressao.get(this.listaExpressao.size()-2).getValor() == "0" || listaExpressao.get(this.listaExpressao.size()-1).getValor() == "0") {
					String aux = "";
					if (listaExpressao.get(this.listaExpressao.size()-2).getValor() == "0" && listaExpressao.get(this.listaExpressao.size()-1).getValor() != "0") {
						switch(item.getValor()) {
							case "+":
								aux = listaExpressao.get(this.listaExpressao.size()-1).getValor();
								break;
							case "*":
								aux = "0";
								break;
							case "/":
								aux = "0";	
								break;
						}
		
					}	
					if (listaExpressao.get(this.listaExpressao.size()-1).getValor() == "0") {
						switch(item.getValor()) {
							case "+":
								aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
								break;
							case "-":
								aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
								break;
							case "*":
								aux = "0";
								break;	
						}
					}
					if (listaExpressao.get(this.listaExpressao.size()-2).getValor() != "0" && listaExpressao.get(this.listaExpressao.size()-1).getValor() != "0") {
					
						if (listaExpressao.get(this.listaExpressao.size()-1).getValor() == "1") {
							switch(item.getValor()) {
								case "*":
									aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
									break;
								case "/":
									aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();	
									break;
								case "^":
									aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
							}
						}
						if (listaExpressao.get(this.listaExpressao.size()-2).getValor() == "1" && item.getValor()== "*"){
							aux = listaExpressao.get(this.listaExpressao.size()-1).getValor();
						}
					}
				this.listaExpressao.get(this.listaExpressao.size()-2).setValor(aux);
				this.listaExpressao.remove(this.listaExpressao.size()-1);
				return;	
				}	
			}
		}
		
		/*
		 * A título de otimizar as constantes, o código que adiciona itena à lista de Itens antes verifica
		 * se o Item a ser então adicionado se trata de um operador.
		 * Caso seja, verifica se ambos itens anteriores adicionados à lista são também constantes.
		 * Esse é o único caso possível em que podemos fazer o cálculo prévio para otimização, logo o novo
		 * valor é calculado e substituído no lugar do penúltimo item, enquanto o último é excluído da lista.
		 * O operador, nesse caso, não chega a ser adicionado à lista.
		 * Exemplo: 2 3 + -> 5
		 */
		if(item.getTipo() == Tipo.OPERADOR && this.listaExpressao.size() >= 2 ) {
			if(this.listaExpressao.get(this.listaExpressao.size()-2).getTipo() == Tipo.NUMERO &&
					this.listaExpressao.get(this.listaExpressao.size()-1).getTipo() == Tipo.NUMERO) {
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
		 * Analogamente, caso os dois últimos itens da lista sejam strings e o item recém-lido seja o 
		 * de concatenação (+), efetuaremos a concatenação das duas strings para otimização.
		 */
		if(item.getValor() == "+" &&
				this.listaExpressao.get(this.listaExpressao.size()-1).getTipo() == Tipo.STRING &&
				this.listaExpressao.get(this.listaExpressao.size()-2).getTipo() == Tipo.STRING) {
		
					this.listaExpressao.get(this.listaExpressao.size()-1).setValor(
							this.listaExpressao.get(this.listaExpressao.size()-1).getValor() + 
							this.listaExpressao.get(this.listaExpressao.size()-2).getValor());
					this.listaExpressao.remove(this.listaExpressao.size()-1);
				
					return;
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
	
	// usado em verificacao sem�ntica tipo warning: expressoes 
	// condicionais em laco formadas somente por constante
	public boolean isSomenteConstanteNumerica() {
		boolean soConstanteNumerica = true;
		for (Item item : this.listaExpressao){
			if(item.getTipo() != Tipo.NUMERO) {
				soConstanteNumerica = false;
				break;
			}
		}
		return soConstanteNumerica;
	}
	
}



