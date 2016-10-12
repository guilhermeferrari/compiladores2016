package minhasclasses.comandos;

import java.util.LinkedList;

import minhasclasses.*;

public final class ParaHelper {

    /**
     * Cria uma expressao que será usada para os incrementos unitários da 
     * variável usada na declaração do looping.
     * @param variavel A variável usada no comando
     * @return A expressão incrementadora de 1 unidade.
     */
    public static Expressao criaPassoUnitario (String variavel) {
        Expressao expressao = new Expressao();
        expressao.addItem(new Item (Tipo.NUMERO, "1"));
        expressao.addCodigoInfixo("1");
        expressao.addItem(new Item (Tipo.VARIAVEL, variavel));
        expressao.addItem(new Item (Tipo.OPERADOR, "+"));
        expressao.addCodigoInfixo("+ " + variavel);
        
        return expressao;
    }
    
    /**
     * Cria uma expressao que será responsável por incrementar a variável dentro
     * do looping.
     * Método usado para quando se usa a palavra chave "passo" no programa fonte.
     * @param exp Expressao do passo.
     * @param variavel Variável que será incrementada.
     * @return A Expressão incrementadora.
     */
    public static Expressao criaPassoParaSimples(Expressao exp,
                                                 String variavel) {
        Expressao expressao = exp;
        
        expressao.addItem(new Item (Tipo.VARIAVEL, variavel));
        expressao.addItem(new Item (Tipo.OPERADOR, "+"));
        expressao.addCodigoInfixo("+ " + variavel);
        
        return expressao;
    }

    public static Expressao criaExpressaoCondicional( Expressao expressaoInicial,
                                                      Expressao expressaoFinal,
                                                      String    variavel,
                                                      String    operadorMenorI,
                                                      String    operadorMaiorI) {
        Expressao expressao = new Expressao();
        boolean expressaoCriada = false;
        LinkedList<Item> listaInicial = expressaoInicial.getListaExpressao();
        LinkedList<Item> listaFinal   = expressaoFinal.getListaExpressao();
        Item itemInicial = listaInicial.get(0);
        Item itemFinal   = listaFinal.get(0);
        
        expressao.addItem(new Item(Tipo.VARIAVEL,variavel));
        expressao.addCodigoInfixo(variavel);
        
        if (listaInicial.size()==1) {
            if (itemInicial.getTipo()==Tipo.NUMERO) {
                if (listaFinal.size()==1) {
                    if (itemFinal.getTipo()==Tipo.NUMERO) {
                        float valorInicial, valorFinal;
                        valorInicial = Float.parseFloat(itemInicial.getValor());
                        valorFinal   = Float.parseFloat(itemFinal.getValor());
                        expressao.addItem(new Item(Tipo.NUMERO,
                                                   itemFinal.getValor()));
                        expressaoCriada = true;
                        if ( valorInicial < valorFinal ) {
                            expressao.addItem( new Item(Tipo.OPERADOR,
                                                        operadorMenorI) );
                            expressao.addCodigoInfixo(operadorMenorI+" "+
                                                      itemFinal.getValor());
                        } else {
                            expressao.addItem( new Item(Tipo.OPERADOR,
                                                        operadorMaiorI) );
                            expressao.addCodigoInfixo(operadorMaiorI+" "+
                                                      itemFinal.getValor());
                        }
                    }
                }
            }
        }
        
        if ( !expressaoCriada ) {
            expressao.addExpressao(expressaoFinal);
            expressao.addItem( new Item(Tipo.OPERADOR, operadorMenorI) );
            expressao.addCodigoInfixo(operadorMenorI+" "+
                                      expressaoFinal.getCodigoInfixo());
        }
        
        return expressao;
    }
    
    public static void configuraLacoEnquantoSimples(Para para,
                                                    Expressao expressaoPasso,
                                                    Expressao expressaoFim,
                                                    ListaComandos listaComandos,
                                                    String operadorMenorI,
                                                    String operadorMaiorI) {
        
        Comando atribuicao = null;
        Comando enquanto   = null;
        Expressao expressaoCondicional = null;
        /*String variavel = ((Atribuicao)para.getAtribuicao()).getSimbolo();
        
        if ( expressaoPasso!=null ) { //Existe passo
            expressaoPasso = ParaHelper.
                              criaPassoParaSimples(expressaoPasso,
                                                   variavel);
        } else //Se não, o passo é unitário
            expressaoPasso = ParaHelper.criaPassoUnitario(variavel);

        atribuicao = new Atribuicao (variavel, expressaoPasso);
        listaComandos.insere(atribuicao);
        
        expressaoCondicional = ParaHelper.criaExpressaoCondicional(
                                  ((Atribuicao)para.getAtribuicao()).
                                      getExpressao(), //@todo Criar esse método na classe Atribuição
                                  expressaoFim,
                                  variavel, //@todo Criar esse método na classe Atribuição
                                  operadorMenorI,
                                  operadorMaiorI);
                                           
        //System.out.println("ExpressaoCondicional: "+expressaoCondicional.getCodigoInfixo());
        //System.out.println("ExpressaoPasso: "+expressaoPasso.getCodigoInfixo());

        listaComandos.insere(new Atribuicao(variavel,expressaoPasso));
        enquanto = new Enquanto(expressaoCondicional,listaComandos);  //Supondo existente!
        para.setEnquanto(enquanto);*/
    }
    
    public static void configuraLacoEnquantoMultiplo(ParaMultiplo para,
                                                     Expressao expressaoFim,
                                                     ListaComandos listaComandos,
                                                     String operadorMenorI,
                                                     String operadorMaiorI) {
        
        Expressao expressaoPasso = null;
        Expressao expressaoCondicional = null;
        Comando atribuicao = null;
        Comando enquanto   = null;
        /*LinkedList<Atribuicao> atribuicoes = para.getAtribuicoes();
        Atribuicao ultimaAtribuicao = atribuicoes.get(atribuicoes.size()-1); 
        String ultimaVariavel = ultimaAtribuicao.getSimbolo();
        //FAZER M�TODO getSimbolo() na classe Atribuicao!

        expressaoPasso = ParaHelper.criaPassoUnitario(ultimaVariavel);

        atribuicao = new Atribuicao (ultimaVariavel, expressaoPasso);
        listaComandos.insere(atribuicao);
        expressaoCondicional = ParaHelper.criaExpressaoCondicional(
                                   ultimaAtribuicao.getExpressao(),
                                   expressaoFim,
                                   ultimaVariavel,
                                   operadorMenorI,
                                   operadorMaiorI);
        enquanto = new Enquanto (expressaoCondicional, listaComandos);
        for (int i = atribuicoes.size()-2; i >= 0; i--) {
            String variavel = atribuicoes.get(i).getSimbolo();

            expressaoPasso = ParaHelper.criaPassoUnitario(variavel);

            atribuicao = new Atribuicao (variavel, expressaoPasso);
            listaComandos = new ListaComandos();
            listaComandos.insere(enquanto);
            listaComandos.insere(atribuicao);
            expressaoCondicional = ParaHelper.criaExpressaoCondicional(
                                       ultimaAtribuicao.getExpressao(),
                                       expressaoFim,
                                       variavel,
                                       operadorMenorI,
                                       operadorMaiorI);
            enquanto = new Enquanto (expressaoCondicional, listaComandos);
        }
        para.setEnquanto(enquanto);*/
    }
    
}