package minhasclasses;

public class Simbolo {
	private String nome;      // nome do identificador
    private int referencia;   // é uma referência usada na geração do código destino
    private static int marcador = 1; // armazena a última referência incluída na tabela
    private char tipo;

    public Simbolo(String _nome) {
          this.nome = _nome;
          this.referencia = Simbolo.marcador;
          Simbolo.marcador += 2;
    }

    public String getNome() {
          return this.nome;
    }

    public int getReferencia() {
          return this.referencia;
    }

    public String toString() {
          return "Nome:"+this.getNome() + " / " + "Referência:"+this.getReferencia() + "\n";
    }

	public static int getMarcador() {
		return marcador;
	}

	public static void setMarcador(int marcador) {
		Simbolo.marcador = marcador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
    
}
