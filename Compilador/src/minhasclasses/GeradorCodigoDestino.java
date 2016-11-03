package minhasclasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import minhasclasses.comandos.Comando;
import minhasclasses.comandos.ListaComandos;

public class GeradorCodigoDestino {
	public static void geraCodigoAssembler(ListaComandos listaComandos){
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
            arqSaida.write(".limit stack "+Expressao.getMaxPilha()+"\r\n");
            arqSaida.write(".limit locals "+(Simbolo.getMarcador()+1)+"\r\n"); //o +1 se deve ao fato de ter de adicionar o this, todo programa deve possui-lo
            arqSaida.write(processaListaComandos(listaComandos));
            arqSaida.write("return\r\n");
            arqSaida.write(".end method\r\n");
            arqSaida.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e) {

            System.out.println(e.getMessage());

      }
	}
    static String processaListaComandos(ListaComandos listaComandos){
    	String saida ="";
    	for(Comando com : listaComandos.getComandos()){
    		saida += com.geraCodigoDestino();
    		
    	}
    	
    	
    	return saida;
    }

}
