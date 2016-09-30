package minhasclasses;

public enum TipoDados {
	NUMERO(1), STRING(2);
	
	private int valor;
	
	TipoDados(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
}
