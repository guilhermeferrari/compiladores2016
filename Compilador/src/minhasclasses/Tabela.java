package minhasclasses;

import java.io.Serializable;
import java.util.HashMap;

public class Tabela implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int labelCondicional = 0;//Esse label é utilizado localmente, e sempre muda. 
	private int labelCondicionalEnd = 0;//Esse label é usado uma vez apenas, quando iniciamos um comando condicional.
	
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

	public Simbolo getSimbolo (String _var) {
		return (Simbolo)this.tab.get(_var);
	}
	
	public int consultaReferencia(String _chave) {
		return ((Simbolo)this.tab.get(_chave)).getReferencia();
	}
	
	public Tipo getTipoSimbolo(String _chave){
		return ((Simbolo)this.tab.get(_chave)).getTipo();
	}
	
	public boolean isExiste(String _chave) {
		return this.tab.containsKey(_chave);
	}

	public String toString() {
		return this.tab.toString();
	}
	
	public boolean isInicializada(String _var) {
		return ((Simbolo)this.tab.get(_var)).getInicializada();
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
	
	public int getLabelCondicional(){
		return this.labelCondicional;
	}
	
	public int getLabelCondicionalEnd(){
		return this.labelCondicionalEnd;
	}
	
	public void incLabelCondicional(){
		this.labelCondicional++;
	}
	
	public void incLabelCondicionalEnd(){
		this.labelCondicionalEnd++;
	}
	
}
