package minhasclasses.comandos;

import java.io.Serializable;

import minhasclasses.Tabela;

public abstract class Comando implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String toString();
	
	public abstract String geraCodigoDestino(Tabela tabela);
}
