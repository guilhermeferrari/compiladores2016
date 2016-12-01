package minhasclasses;

import java.io.Serializable;
import java.util.LinkedList;

import parser.Compilador;

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
	private static Integer contLabel = 0;
	private static Integer contAnd = 1;
	private static Integer contOr = 1;

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
			if(this.listaExpressao.get(this.listaExpressao.size()-2).getTipo().equals(Tipo.NUMERO) ||
			   this.listaExpressao.get(this.listaExpressao.size()-1).getTipo().equals(Tipo.NUMERO) ||
			   this.listaExpressao.get(this.listaExpressao.size()-2).getTipo().equals(Tipo.VARIAVEL) ||
			   this.listaExpressao.get(this.listaExpressao.size()-1).getTipo().equals(Tipo.VARIAVEL)){

				if (listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("1") || listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("1")
						|| listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("0") || listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("0")) {
					String aux="";

					if (listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("0") && !listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("0")) {
						System.out.println("TESTE");
						switch(item.getValor()) {
							case "+":
								aux = listaExpressao.get(this.listaExpressao.size()-1).getValor();
								break;
							case "-":
								aux = listaExpressao.get(this.listaExpressao.size()-1).getValor();
								break;
							case "*":
								aux = "0";
								break;
							case "/":
								System.out.println("Caso Divisao1");
								aux = "0";
								break;
						}

					}
					if (listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("0")) {
						aux = String.valueOf(1).toString();
						String valor = item.getValor();

						switch(valor.toString()){

							case "+":
								aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
								break;
							case "-":
								aux = listaExpressao.get(this.listaExpressao.size()-2).getValor();
								break;
							case "*":
								aux = String.valueOf(0).toString();
								break;
						}
					}
					if (!listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("0")  && !listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("0")) {
						if (listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("1")) {
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
						if (listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("1") && item.getValor().equals("*")){
							aux = listaExpressao.get(this.listaExpressao.size()-1).getValor();
						}
					}
				if(aux.length()>0){

					if(this.listaExpressao.get(this.listaExpressao.size()-1).getTipo().equals(Tipo.VARIAVEL)){

						if(this.listaExpressao.get(this.listaExpressao.size()-2).getValor().equals("0")){
							if(item.getValor().equals("*")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}
							else if(item.getValor().equals("/")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}
							else
								this.listaExpressao.remove(this.listaExpressao.size()-2);
						}
						else{
							this.listaExpressao.remove(this.listaExpressao.size()-2);

						}
					}
					else if (this.listaExpressao.get(this.listaExpressao.size()-2).getTipo().equals(Tipo.VARIAVEL)) {
						if(this.listaExpressao.get(this.listaExpressao.size()-1).getValor().equals("0")){

							if(item.getValor().equals("*")){

								this.listaExpressao.remove(this.listaExpressao.size()-2);
							}
							else if(item.getValor().equals("/")){

								this.listaExpressao.remove(this.listaExpressao.size()-2);
							}
							else if(item.getValor().equals("^")){

								this.listaExpressao.remove(this.listaExpressao.size()-2);
								this.listaExpressao.get(this.listaExpressao.size()-1).setValor(String.valueOf("1"));
							}
							else
								this.listaExpressao.remove(this.listaExpressao.size()-1);
						}
						else{
							this.listaExpressao.remove(this.listaExpressao.size()-1);

						}
					}
					else{
						if(this.listaExpressao.get(this.listaExpressao.size()-1).equals("0")){
							;
							if(item.getValor().equals("+")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}

						}
						else{

							if(item.getValor().equals("+")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}
							if(item.getValor().equals("*")){
								this.listaExpressao.remove(this.listaExpressao.size()-2);
							}
							if(item.getValor().equals("-")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}
							if(item.getValor().equals("/")){
								this.listaExpressao.remove(this.listaExpressao.size()-1);
							}

						}

						System.out.println(this.listaExpressao.get(this.listaExpressao.size()-1));
						this.listaExpressao.get(this.listaExpressao.size()-1).setValor(String.valueOf(aux));
						//System.out.println(this.listaExpressao.get(this.listaExpressao.size()-2));

					}
					return;
				}


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

	public String geraCodigoExpressao() {


		String codigoExpressao="";
		for(Item item : this.listaExpressao){
			if(item.getTipo() == Tipo.NUMERO){
				if(item.getValor().contains(".")){
					codigoExpressao += "ldc2_w " + item.getValor() + "\r\n";
				} else {
					codigoExpressao += "ldc2_w " + item.getValor() + ".0\r\n";
				}
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
				else if(item.getValor().equals("^")){
					codigoExpressao+="dstore_1\r\n";//Desempilha a base e o coloca em mem[1]
					codigoExpressao+="dup\r\n"; //Duplica o topo (expoente)
					codigoExpressao+="dconst_0\r\n"; //Empilha 0.0
					codigoExpressao+="dcmpg\r\n"; //Desempilha e compara expoente e zero
					codigoExpressao+="ifne DiferenteZero\r\n";
/*exp = 0*/       	//Se o exponte é zero:
					codigoExpressao+="pop2\r\n"; //Desempilha expoente
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto Fim\r\n";

/*exp != 0*/       	// Se o expoente é diferente de zero
					codigoExpressao+="DiferenteZero:\r\n";

					//Otimização (Base = 0):
					codigoExpressao+="dload_1\r\n";//Empilha a base
					codigoExpressao+="dconst_0\r\n"; //Empilha 0.0
					codigoExpressao+="dcmpg\r\n"; //Desempilha e compara base e zero
					codigoExpressao+="ifne BaseDiferenteZero\r\n";
					codigoExpressao+="pop2\r\n"; //Desempilha expoente
					codigoExpressao+="dconst_0\r\n"; //Empilha 0.0
					codigoExpressao+="goto Fim\r\n";

/*base != 0*/       codigoExpressao+="BaseDiferenteZero:\r\n";
					codigoExpressao+="dup\r\n"; //Duplica o topo (expoente)
					codigoExpressao+="dconst_0\r\n"; //Empilha 0.0
					codigoExpressao+="dcmpg\r\n"; //Desempilha e compara expoente e zero
					codigoExpressao+="ifgt ExpPositivo\r\n";

/*exp < 0*/       	//Expoente Negativo:
					codigoExpressao+="dstore_2\r\n";//Desempilha o expoente e o coloca em mem[2]
					codigoExpressao+="dload_1\r\n";//Empilha a base
					codigoExpressao+="LoopExpNegativo:\r\n";
					codigoExpressao+="dload_2\r\n";//Empilha o expoente
					codigoExpressao+="dconst_1\r\n"; //
					codigoExpressao+="dneg\r\n"; //Empilha -1.0
					codigoExpressao+="dcmpg\r\n"; //Desempilha e compara expoente e -1
					codigoExpressao+="ifeq Fim2\r\n";
					codigoExpressao+="dload_1\r\n";//Empilha a base
					codigoExpressao+="dmul\r\n"; //Base * Base
					codigoExpressao+="dload_2\r\n";//Empilha o expoente
					codigoExpressao+="dconst_1\r\n"; //Empilha 1.0
					codigoExpressao+="dadd\r\n"; //Expoente + 1
					codigoExpressao+="dstore_2\r\n";//Desempilha o expoente e o coloca em mem[2]
					codigoExpressao+="goto LoopExpNegativo\r\n";

/*exp > 0*/       	//Expoente Positivo:
					codigoExpressao+="ExpPositivo:\r\n";
					codigoExpressao+="dstore_2\r\n";//Desempilha o expoente e o coloca em mem[2]
					codigoExpressao+="dload_1\r\n";//Empilha a base
					codigoExpressao+="LoopExpPositivo:\r\n";
					codigoExpressao+="dload_2\r\n";//Empilha o expoente
					codigoExpressao+="dconst_1\r\n"; //Empilha 1.0
					codigoExpressao+="dcmpg\r\n"; //Desempilha e compara expoente e 1
					codigoExpressao+="ifeq Fim\r\n";
					codigoExpressao+="dload_1\r\n";//Empilha a base
					codigoExpressao+="dmul\r\n"; //Base * Base
					codigoExpressao+="dload_2\r\n";//Empilha o expoente
					codigoExpressao+="dconst_1\r\n"; //Empilha 1.0
					codigoExpressao+="dsub\r\n"; //Expoente - 1
					codigoExpressao+="dstore_2\r\n";//Desempilha o expoente e o coloca em mem[2]
					codigoExpressao+="goto LoopExpPositivo\r\n";

					//Se o Expoente é Negativo devemos inverter o valor:
					codigoExpressao+="Fim2:\r\n";
					codigoExpressao+="dstore_1\r\n";//Desempilha o resultado invertido e o coloca em mem[1]
					codigoExpressao+="dconst_1\r\n"; //Empilha 1.0
					codigoExpressao+="dload_1\r\n";//Empilha o resultado invertido
					codigoExpressao+="ddiv\r\n"; // resultado certo = 1/resultado invertido

					codigoExpressao+="Fim:\r\n";
				}
				else if(item.getValor().equals("e")){
					codigoExpressao += "dconst_1\r\n";
					codigoExpressao += "dcmpg\r\n";
					// Verifico se o topo é igual à 1
					codigoExpressao += "ifeq topoUm_"+contAnd+"\r\n";

					// Se o topo da pilha for zero, logo o resultado será sempre 0, já que
					// 0 * (0 | 1) é sempre zero. Retiramos então o topo da pilha, empilhamos 0
					// e partimos para a label final.
					codigoExpressao += "pop2\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto final_"+contAnd+"\r\n";

					// Caso o topo seja igual à 1, entra aqui. Empilho 1 e comparo o topo com o
					// próximo, a fim de verificar se são iguais ou não.
					codigoExpressao += "topoUm_"+contAnd+":\r\n";
					codigoExpressao += "dconst_1\r\n";
					codigoExpressao += "dcmpg\r\n";
					// Caso seja igual à um, a resposta será um e desvia para a label 1. Senão, a operação
					// de and irá dar zero, portanto empilharemos 0.
					codigoExpressao += "ifeq um_"+contAnd+"\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto final_"+contAnd+"\r\n";
					// Agora, tendo desempilhado 1, segue para a label 'um' e o empilhamos 1, já que 1x1 == 1.
					codigoExpressao += "um_"+contAnd+":\r\n";
					codigoExpressao += "dconst_1\r\n";
					codigoExpressao += "final_"+contAnd+":\r\n";
					contAnd++;
					//System.out.println(codigoExpressao);
				}
				else if(item.getValor().equals("ou")){
					//É necessário empilhar zero para utilizar o dcmpg e testar se o topo é zero
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="dcmpg\r\n";
					//verifica se o topo é igual a 0
					codigoExpressao+="ifeq topoZero_"+contOr+"\r\n";

					//Entra aqui se o topo for 1. 1 ou qualquer coisa = 1
					//retira o topo da pilha
					codigoExpressao+="pop2\r\n";
					//empilha 1
					codigoExpressao+="dconst_1\r\n";
					//vai para o label final
					codigoExpressao+="goto final_"+contOr+"\r\n";

					//Entra aqui se o topo for 0. O resultado de ifeq tem que empilhar 0
					codigoExpressao+="topoZero_"+contOr+":\r\n";
					//empilha zero para poder utilizar o dcmpg
					codigoExpressao+="dconst_0\r\n";
					//compara o topo e o proximo
					codigoExpressao+="dcmpg\r\n";
					//ser for zero vai pro label zero
					codigoExpressao+="ifeq zero_"+contOr+"\r\n";
					//entra aqui se o resultado nao for zero. empilha 1 pois 0 ou 1 = 1
					codigoExpressao+="dconst_1\r\n";
					//vai pro final
					codigoExpressao+="goto final_"+contOr+"\r\n";
					//label zero
					codigoExpressao+="zero_"+contOr+":\r\n";
					//empilha 0 pois 0 ou 0 = 0
					codigoExpressao+="dconst_0\r\n";

					//label final
					codigoExpressao+="final_"+contOr+":\r\n";
					contOr++;
					System.out.println("and:"+codigoExpressao);
				}
				else if(item.getValor().equals("nao")){
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="dcmpg\r\n";
					codigoExpressao+="ifeq notDeZero\r\n";
					//se for diferente de zero a reposta é zero
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto final\r\n";
					//se for igual a zero a resposta é 1
					codigoExpressao+="notDeZero:\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="final:\r\n";
				}
				else if(item.getValor().equals("==")){

					codigoExpressao+="dcmpg\r\n";
					//Caso os numeros sejam iguais faz um desvio para o LABEL
					//e armazena 1 na pilha.
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+= ("LABEL_0"+contLabel + ":\r\n");
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel+=2;


				}
				else if(item.getValor().equals("!=")){
					codigoExpressao+="dcmpg\r\n";
					//Caso os numeros sejam diferentes armazena 1 na pilha.
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+= ("LABEL_0"+contLabel + ":\r\n");
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel+=2;

				}
				else if(item.getValor().equals(">")){
					codigoExpressao+="dcmpg\r\n"; //True: Push 1; False: Push 0 or -1;
					//Caso o primeiro numero seja maior, armazena 1 na pilha.
					codigoExpressao+="ifgt LABEL_0"+contLabel.toString()+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+="LABEL_0"+contLabel.toString() + ":\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
				else if(item.getValor().equals(">=")){
					codigoExpressao+="dcmpg\r\n"; //True: Push 1 or 0; False: Push -1;
					//Caso o primeiro numero seja maior ou igual, armazena 1 na pilha.
					codigoExpressao+="ifge LABEL_0"+contLabel.toString()+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+="LABEL_0"+contLabel.toString() + ":\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
				else if(item.getValor().equals("<")){
					codigoExpressao+="dcmpg\r\n";
					//Caso o primeiro numero seja menor, armazena 1 na pilha.
					codigoExpressao+="ifge LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+="LABEL_0"+contLabel + ":\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
				else if(item.getValor().equals("<=")){
					codigoExpressao+="dcmpg\r\n";
					//Caso o primeiro numero seja menor ou igual, armazena 1 na pilha.
					codigoExpressao+="ifgt LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +":\r\n";
					codigoExpressao+="LABEL_0"+contLabel + ":\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
			}
			else if(item.getTipo() == Tipo.STRING){
				codigoExpressao += "ldc " + item.getValor() + "\r\n";
			}
			else if(item.getTipo() == Tipo.VARIAVEL){
				String nomeDaVariavel = item.getValor();
				int referenciaDaVariavel = Compilador.tabela.consultaReferencia(nomeDaVariavel);
                if( referenciaDaVariavel < 4 ){
                	codigoExpressao += "dload_" + referenciaDaVariavel + "\r\n";
                }
                else{
                	codigoExpressao += "dload " + referenciaDaVariavel + "\r\n";
                }
			}
		}
		return codigoExpressao;
	}

}
