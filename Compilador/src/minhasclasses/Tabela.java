package minhasclasses;

import java.util.HashMap;

public class Tabela {
	private HashMap<String,Simbolo> tab;

	public Tabela() {
		this.tab = new HashMap<String,Simbolo>();
	
	}

	public boolean inclui(Simbolo _simb) {
		if(this.tab.containsKey(_simb.getNome()))
			return false;
	    else {
	    	this.tab.put(_simb.getNome(),_simb);
	        return true;
	    }
	}

	public int consultaReferencia(String _chave) {
		return ((Simbolo)this.tab.get(_chave)).getReferencia();
	}
	
	public char getTipoSimbolo(String _chave){
		return ((Simbolo)this.tab.get(_chave)).getTipo();
	}
	
	public boolean isExiste(String _chave) {
		return this.tab.containsKey(_chave);
	}

	public String toString() {
		return this.tab.toString();
	}
	
	public void setInicializada(String _chave){
		((Simbolo)this.tab.get(_chave)).setInicializada(true);
	}
	
	public void warningVar(){ //Verifica se a variavel foi declarada e nao foi inicializada
		for(String _chave : this.tab.keySet()){
			if(!this.tab.get(_chave).getInicializada()){
				System.out.println("Warning: variavel " + this.tab.get(_chave).getNome() + " foi declarada e nao foi inicializada.");
			}
			if(!this.tab.get(_chave).getUtilizada() && this.tab.get(_chave).getInicializada()){
				System.out.println("Warning: variavel " + this.tab.get(_chave).getNome() + " foi declarada, inicializada e nao foi utilizada.");
			}
		}
	}
	
	public void setUtilizada(String _chave){
		((Simbolo)this.tab.get(_chave)).setUtilizada(true);
	}
}
