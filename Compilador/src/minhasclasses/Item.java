package minhasclasses;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// pode ser '1' (numero), '2' (string), '4' (variavel) ou '8' (operador).
	// usar preferencialmente a enumera��o Tipo:
	// Tipo.NUMERO(1), Tipo.STRING(2), Tipo.VARIAVEL(4), Tipo.OPERADOR(8)
	private Tipo tipo;

	public String valor;
	
	public Item(Tipo tipo, String valor){
		this.tipo  = tipo;
		this.valor = valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor(){
		return valor;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	@Override
	public String toString(){
		return "Tipo: " + this.tipo + " Valor: " + this.valor;
	}
}	
