package minhasclasses.comandos;

import minhasclasses.*;

public final class ParaHelper {
	
    public static Expressao criaPassoUnitario (Simbolo variavel) {
    	Expressao expressao = new Expressao();
      	expressao.addItem(new Item (Tipo.NUMERO, "1"));
      	expressao.addCodigoInfixo("1");
    	expressao.addItem(new Item (Tipo.VARIAVEL, variavel.getNome()));
      	expressao.addItem(new Item (Tipo.OPERADOR, "+"));
      	expressao.addCodigoInfixo("+ " + variavel.getNome());
      	return expressao;
    }
    
}
