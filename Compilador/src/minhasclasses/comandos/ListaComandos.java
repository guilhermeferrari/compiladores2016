package minhasclasses.comandos;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaComandos implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Comando> comandos;

	public ListaComandos(){
		this.comandos = new LinkedList<Comando>();
	}

	public LinkedList<Comando> getComandos() {
		return this.comandos;
	}
	
	public Comando getComando(int n) {
		return this.comandos.get(n);
	}
	
	public void insere(Comando comando){
		this.comandos.add(comando);
	}
	
	// insere todos os elementos de 'lista'  
	public void insere(ListaComandos lista) {
		this.comandos.addAll(lista.comandos);
	}
	
	public Comando removeUltimo(){
		return comandos.removeLast();
	}
	
	@Override
	public String toString(){
		return this.comandos.toString();
	}
}
