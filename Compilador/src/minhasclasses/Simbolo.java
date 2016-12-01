package minhasclasses;

import java.io.Serializable;

public class Simbolo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;      // nome do identificador
    private int referencia;   // referencia usada na geracao do codigo destino
    private static int marcador = 1; // armazena a ultima referencia incluida na tabela
    private Tipo tipo;
    private boolean inicializada; //Identifica se uma variavel foi inicializada
    private boolean utilizada; //Identifica se uma variavel foi utilizada

    public Simbolo(String _nome, Tipo _tipo) {
          this.nome = _nome;
          this.referencia = Simbolo.marcador;
          this.tipo = _tipo;
          if(_tipo == Tipo.NUMERO)
        	  Simbolo.marcador += 2;
          else 
        	  Simbolo.marcador += 1; // se for STRING
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
          return "Nome:"+this.getNome() + " / " + "Referencia:"+this.getReferencia() + "\n";
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

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo _tipo) {
		this.tipo = _tipo;
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
