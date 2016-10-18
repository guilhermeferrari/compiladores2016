package minhasclasses.comandos;

import java.util.LinkedList;

public class ListaComandos{ 
	
	private LinkedList<Comando> comandos;

	public ListaComandos(){
		comandos = new LinkedList<Comando>();
	}

	public LinkedList<Comando> getComandos() {
		return comandos;
	}
	
	public void insere(Comando comando){
		comandos.add(comando);
	}
	
	// insere todos os elementos de 'lista'  
	public void insere(ListaComandos lista) {
		comandos.addAll(lista.comandos);
	}
	
	public Comando removeUltimo(){
		return comandos.removeLast();
	}
	
	@Override
	public String toString(){
		return this.comandos.toString();
	}
}
