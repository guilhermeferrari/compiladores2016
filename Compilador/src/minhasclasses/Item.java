package minhasclasses;

public class Item {
	// pode ser '1' (número), '2' (string), '4' (variável) ou '8' (operador).
	private Tipo tipo;

	private String valor;
	
	public Item(Tipo tipo, String valor){
		this.tipo  = tipo;
		this.valor = valor;
	}
	
	public String getValor(){
		return valor;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	public enum Tipo {
		NUMERO(1),STRING(2),VARIAVEL(4),OPERADOR(8);

		public int valorTipo;
		
		Tipo(int valor) {
			valorTipo = valor;
		}
		
		public int getValorTipo() {
			return valorTipo;
		}
	}
}	
