package minhasclasses;

import java.io.Serializable;
import java.util.LinkedList;
import minhasclasses.Tabela;

public class Expressao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList <Item> listaExpressao;
	private int linha;
	private String codigoInfixo;
	private int tamPilha;
	private static int maxPilha;
	private Tipo tipoDados;
	
	public void calculoPilha(){
		
		int auxMax=0;
		for(Item item : this.listaExpressao){
			if((item.getTipo() == Tipo.NUMERO) || (item.getTipo()==Tipo.VARIAVEL)){
				auxMax+=2;
				if(auxMax>this.tamPilha){
					this.tamPilha = auxMax;
				}
			}
			if(item.getTipo()==Tipo.OPERADOR){
				auxMax--;
			}
		}
		if(this.tamPilha>Expressao.maxPilha){
			Expressao.maxPilha = this.tamPilha;
		}
	}
	
	
	
	public static int getMaxPilha() {
		return maxPilha;
	}



	public static void setMaxPilha(int maxPilha) {
		Expressao.maxPilha = maxPilha;
	}



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
		
		// questao da prova simulada: otimiza o operador modulo
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
		if(item.getTipo() == Tipo.OPERADOR && item.getValor() == "+" &&
				this.listaExpressao.get(this.listaExpressao.size()-1).getTipo() == Tipo.STRING &&
				this.listaExpressao.get(this.listaExpressao.size()-2).getTipo() == Tipo.STRING) {
					/*
					 * O detalhe aqui é que não podemos simplesmente concatenar as duas strings porquê
					 * temos que considerar as aspas duplas na String. Ou seja, temos que remover a segunda
					 * aspas do primeiro elemento e a primeira aspas do segundo, para que tenhamos "lekTravesso"
					 * ao invés do indesejado "lek""travesso" com a concatenação.
					 */
					String inicio = this.listaExpressao.get(this.listaExpressao.size()-2).getValor().substring
							(0, this.listaExpressao.get(this.listaExpressao.size()-2).getValor().length()-1);
					String fim = this.listaExpressao.getLast().getValor().substring(1);	
					this.listaExpressao.get(this.listaExpressao.size()-2).setValor(inicio + fim);
					this.listaExpressao.removeLast();
				
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
	
	// usado em verificacao semantica tipo warning: expressoes 
	// condicionais em laco formadas somente por constante
	public boolean isSomenteConstanteNumerica() {
		boolean soConstanteNumerica = true;
		for (Item item : this.listaExpressao){
			if(item.getTipo() == Tipo.VARIAVEL) {
				soConstanteNumerica = false;
				break;
			}
		}
		return soConstanteNumerica;
	}
	
	public String geraCodigoExpressao(Tabela tabela){
		String codigoExpressao="";
		for(Item item : this.listaExpressao){
			if(item.getTipo() == Tipo.NUMERO){
				codigoExpressao += "ldc2_w " + item.getValor() + "\r\n";
			}
			
			else if(item.getTipo() == Tipo.OPERADOR){
				if((item.getValor().equals("+"))){
					if((this.getTipoDados() == Tipo.NUMERO)){
						codigoExpressao+="dadd\r\n";
					} else if(this.getTipoDados() == Tipo.STRING){
						
						codigoExpressao += "astore_"+(Simbolo.getMarcador()+1) +" \r\n";
						codigoExpressao += "astore_"+(Simbolo.getMarcador()) +" \r\n";
						codigoExpressao += "new java/lang/StringBuilder \r\n";
						codigoExpressao += "dup \r\n";
						codigoExpressao += "invokespecial java/lang/StringBuilder/<init>()V \r\n";
						codigoExpressao += "aload_"+(Simbolo.getMarcador()) +" \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder \r\n";
						codigoExpressao += "aload_"+(Simbolo.getMarcador()+1) +" \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String \r\n";
						
					}
				}
				else if(item.getValor().equals("-")){
					codigoExpressao+="dsub\r\n";
				}
				else if(item.getValor().equals("*")){
					codigoExpressao+="dmul\r\n";
				}
				else if(item.getValor().equals("/")){
					codigoExpressao+="ddiv\r\n";
				}
				else if(item.getValor().equals("e")){
					codigoExpressao+="iand\r\n";
				}
			}
				
			else if(item.getTipo() == Tipo.STRING){
				codigoExpressao += "ldc " + item.getValor() + "\r\n";
			}
			else if(item.getTipo() == Tipo.VARIAVEL){
				String nomeDaVariavel = item.getValor();
				int referenciaDaVariavel = tabela.consultaReferencia(nomeDaVariavel); 
                codigoExpressao += "dload " + referenciaDaVariavel + "\r\n";
			}
		}
		return codigoExpressao;
	}
	
}



