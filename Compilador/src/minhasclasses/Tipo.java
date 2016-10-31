package minhasclasses;

import java.io.Serializable;

public enum Tipo implements Serializable{
	NUMERO(1), STRING(2), VARIAVEL(4), OPERADOR(8);
	
	private int valor;
	
	Tipo(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
}
