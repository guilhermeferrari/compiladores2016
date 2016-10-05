package minhasclasses;

public enum Tipo {
	NUMERO(1), STRING(2), VARIAVEL(4), OPERADOR(8);
	
	private int valor;
	
	Tipo(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
}
