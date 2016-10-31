package minhasclasses;

import java.io.Serializable;

public class Simbolo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;      // nome do identificador
    private int referencia;   // é uma referência usada na geração do código destino
    private static int marcador = 1; // armazena a última referência incluída na tabela
    private char tipo;
    private boolean inicializada; //Identifica se uma variavel foi inicializada
    private boolean utilizada; //Identifica se uma variavel foi utilizada

    public Simbolo(String _nome) {
          this.nome = _nome;
          this.referencia = Simbolo.marcador;
          Simbolo.marcador += 2;
          this.inicializada = false;
          this.utilizada = false;
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
	
	public boolean getInicializada(){
		return this.inicializada;
	}
	
	public void setInicializada(boolean inicializada){
		this.inicializada = inicializada;
	}
	
	public boolean getUtilizada(){
		return this.utilizada;
	}
	
	public void setUtilizada(boolean utilizada){
		this.utilizada = utilizada;
	}
    
}
