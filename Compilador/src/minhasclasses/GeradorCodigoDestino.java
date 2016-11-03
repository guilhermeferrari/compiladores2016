package minhasclasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import minhasclasses.comandos.Comando;

public class GeradorCodigoDestino {
	public static void geraCodigoAssembler(List<Comando> ListaComandos){
		BufferedWriter arqSaida;
		try{
			arqSaida = new BufferedWriter(new FileWriter("codigo_assembler.j"));
			arqSaida.write(".source prog_destino.java\r\n");
            arqSaida.write(".class public prog_destino\r\n");
            arqSaida.write(".super java/lang/Object\r\n");
            arqSaida.write(".method public <init>()V\r\n");
            arqSaida.write(".limit stack 1\r\n");
            arqSaida.write(".limit locals 1\r\n");
            arqSaida.write("aload_0\r\n");
            arqSaida.write("invokespecial java/lang/Object/<init>()V\r\n");
            arqSaida.write("return\r\n");
            arqSaida.write(".end method\r\n");
            arqSaida.write(".method public static main([Ljava/lang/String;)V\r\n"); 
		}catch(IOException e){
			e.printStackTrace();
		}
	}
    static String processaListaComandos(List<Comando> listaComandos){
    	String saida ="";
    	String nomeDaVariavel, codigoExpressao;
    	int refereciaDaVariavel;
    	for(Comando com : listaComandos){
    		
    	}
    	
    	
    	return saida;
    }

}
