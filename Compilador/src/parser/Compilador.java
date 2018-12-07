/* Generated By:JavaCC: Do not edit this line. Compilador.java */
package parser;

import java.io.*;
import semantico.*;
import apoio.*;
import tratamentoErro.*;
import comandoAltoNivel.*;
import comandoPrimitivo.*;
import codigoDestino.*;
import java.util.LinkedList;


public class Compilador implements CompiladorConstants {
        public static Tabela tabela = new Tabela();

        public static void main(String args[])  throws ParseException  {
                Compilador compilador = null;
                try {
                        // Leitura do arquivo com o codigo fonte
                        compilador = new Compilador(new FileInputStream(Config.pathProgFonte + Config.nomeArquivo + Config.extensaoFonte));

                        // Primeira passagem
                        ListaComandosAltoNivel listaComandosAltoNivel = new ListaComandosAltoNivel();
                        Compilador.inicio(listaComandosAltoNivel);

                        System.out.println("***** Primeira Passagem *****\u005cn"
                                                                + "Lista de Comandos Alto Nivel:\u005cn"
                                                                + listaComandosAltoNivel);

                        // Exibicao da tabela de simbolos
                        System.out.println("\u005cn\u005cn***** Tabela de Simbolos *****\u005cn"
                                                                + tabela);

                        //Warnings
                        AcoesSemanticas.warnings();

                        // Segunda passagem
                        ListaComandosPrimitivos listaComandosPrimitivos = new ListaComandosPrimitivos();
                        listaComandosPrimitivos = listaComandosAltoNivel.geraListaComandoPrimitivosCompleta();
                        System.out.println("\u005cn\u005cn***** Segunda Passagem *****\u005cn"
                                                                + "Lista de Comandos Primitivos:\u005cn"
                                                                + listaComandosPrimitivos);

                        // Terceira passagem
                        CodigoDestino codigoDestino = new CodigoDestino(listaComandosPrimitivos);
                        System.out.println("\u005cn\u005cn***** Terceira Passagem *****\u005cn"
                                                                + "Lista de Comandos Destino:\u005cn"
                                                                + codigoDestino);

                        // Criacao do arquivo destino
                        codigoDestino.geraArquivo(Config.pathSaida + Config.nomeArquivo + Config.extensaoCodigoDestino );
                        System.out.println("\u005cn\u005cn***** Criacao do arquivo destino *****\u005cn"
                                                                + "Arquivo destino: "
                                                                + Config.pathSaida + Config.nomeArquivo + Config.extensaoCodigoDestino);

                        // Fim
                        if(AcoesSemanticas.qtdWarnings > 0 ) {
                          System.out.println("\u005cn\u005cn***** Compilacao bem sucedida com "+AcoesSemanticas.qtdWarnings+" warnings! *****");
                        }else {
                                System.out.println("\u005cn\u005cn***** Compilacao bem sucedida! *****");
                        }


                }
                catch(FileNotFoundException e) {
                        System.err.println("\u005cnErro: arquivo nao encontrado");
                }
                catch (IOException e) {
                        System.out.println("Erro de criacao de arquivo" + e.getMessage());
                }
                catch(TokenMgrError e) {
                        System.err.println("\u005cnErro lexico: " + e.getMessage());
                }
                catch(ParseException e) {
                        System.err.println("\u005cnErro Sintatico: " + e.getMessage());
                }
                catch(ErroSemantico e) {
                        System.err.println("\u005cnErro Semantico: " + e.getMessage());
                }
        }

//Gramatica de expressoes:
  static final public Expressao iniciaExpressao() throws ParseException {
        Expressao exp = new Expressao();
    expressao(exp);
            exp.otimizarPosFixaConst1();
        exp.otimizaPosfixa();
                {if (true) return exp;}
    throw new Error("Missing return statement in function");
  }

  static final public void expressao(Expressao exp) throws ParseException {
        Token t ;
        Item item = null;
    termo(exp);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      t = jj_consume_token(OU);
                        item = new Operador(TipoOperador.OU,t);
                        exp.addListaExpInfixa(item);
      termo(exp);
                        exp.addListaExpPosFixa(item);
    }
  }

  static final public void termo(Expressao exp) throws ParseException {
        Token t;
        Item item = null;
    termo1(exp);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case E:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      t = jj_consume_token(E);
                        item = new Operador(TipoOperador.E,t);
                        exp.addListaExpInfixa(item);
      termo1(exp);
                        exp.addListaExpPosFixa(item);
    }
  }

  static final public void termo1(Expressao exp) throws ParseException {
        Token t;
        Item item = null;
        TipoOperador operador;
    termo2(exp);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IGUAL:
    case MENOR:
    case MAIORIGUAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        t = jj_consume_token(IGUAL);
                               operador = TipoOperador.IGUAL;
        break;
      case MENOR:
        t = jj_consume_token(MENOR);
                                   operador = TipoOperador.MENOR;
        break;
      case MAIORIGUAL:
        t = jj_consume_token(MAIORIGUAL);
                                       operador = TipoOperador.MAIORIGUAL;
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                        item = new Operador(operador,t);
                        exp.addListaExpInfixa(item);
      termo2(exp);
                        item = new Operador(operador,t);
                        exp.addListaExpPosFixa(item);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  static final public void termo2(Expressao exp) throws ParseException {
        Token t;
        Item item = null;
    termo3(exp);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONCAT:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      t = jj_consume_token(CONCAT);
                        item = new Operador(TipoOperador.CONCAT,t);
                        exp.addListaExpInfixa(item);
      termo3(exp);
                        item = new Operador(TipoOperador.CONCAT,t);
                        exp.addListaExpPosFixa(item);
    }
  }

  static final public void termo3(Expressao exp) throws ParseException {
        Token t;
        TipoOperador operador;
        Item item = null;
    termo4(exp);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
      case SUB:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
        t = jj_consume_token(SOMA);
                                operador = TipoOperador.SOMA;
        break;
      case SUB:
        t = jj_consume_token(SUB);
                               operador = TipoOperador.SUB;
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                        item = new Operador(operador,t);
                        exp.addListaExpInfixa(item);
      termo4(exp);
                        item = new Operador(operador,t);
                        exp.addListaExpPosFixa(item);
    }
  }

  static final public void termo4(Expressao exp) throws ParseException {
        Token t;
        TipoOperador operador;
        Item item = null;
    pot(exp);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
        t = jj_consume_token(MUL);
                              operador = TipoOperador.MUL;
        break;
      case DIV:
        t = jj_consume_token(DIV);
                              operador = TipoOperador.DIV;
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                        item = new Operador(operador,t);
                        exp.addListaExpInfixa(item);
      pot(exp);
                        item = new Operador(operador,t);
                        exp.addListaExpPosFixa(item);
    }
  }

  static final public void pot(Expressao exp) throws ParseException {
        Token t;
        TipoOperador operador;
        Item item = null;
    termo5(exp);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case POT:
      t = jj_consume_token(POT);
                    operador = TipoOperador.POT;
                item = new Operador(operador, t);
            exp.addListaExpInfixa(item);
      pot(exp);
                item = new Operador(operador, t);
            exp.addListaExpPosFixa(item);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
  }

  static final public void termo5(Expressao exp) throws ParseException {
        Token tokenVar, tokenEntrada;
        Item item = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AP:
      tokenEntrada = jj_consume_token(AP);
                item = new Operador(TipoOperador.AP, tokenEntrada);
                exp.addListaExpInfixa(item);
      expressao(exp);
      tokenEntrada = jj_consume_token(FP);
                item = new Operador(TipoOperador.FP, tokenEntrada);
                exp.addListaExpInfixa(item);
      break;
    case NUM:
      tokenEntrada = jj_consume_token(NUM);
                item = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.POS);
                AcoesSemanticas.incompatibilidadeTipoExpressao(item,exp,tokenEntrada);
                exp.addListaExpInfixa(item);
                exp.addListaExpPosFixa(item);
      break;
    case SOMA:
      jj_consume_token(SOMA);
      tokenEntrada = jj_consume_token(NUM);
                item = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.POS);
                AcoesSemanticas.incompatibilidadeTipoExpressao(item,exp,tokenEntrada);
                exp.addListaExpInfixa(item);
                exp.addListaExpPosFixa(item);
      break;
    case SUB:
      jj_consume_token(SUB);
      tokenEntrada = jj_consume_token(NUM);
                item = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.NEG);
                AcoesSemanticas.incompatibilidadeTipoExpressao(item,exp,tokenEntrada);
                exp.addListaExpInfixa(item);
                exp.addListaExpPosFixa(item);
      break;
    case VAR:
      tokenVar = jj_consume_token(VAR);
                tabela.verificaVariavelDeclarada(tokenVar.image);
                item = new Operando(tabela.tipoVariavel(tokenVar.image),TipoElemento.VAR, tokenVar, Sinal.POS);
                AcoesSemanticas.incompatibilidadeTipoExpressao(item,exp,tokenVar);
                tabela.pesquisaTabela(tokenVar.image).setIsUtilizada(true);
                exp.addListaExpInfixa(item);
                exp.addListaExpPosFixa(item);
      break;
    case STRING:
      tokenEntrada = jj_consume_token(STRING);
                item = new Operando(TipoDado.PALAVRA,TipoElemento.CTE, tokenEntrada, Sinal.POS);
                AcoesSemanticas.incompatibilidadeTipoExpressao(item,exp,tokenEntrada);
                exp.addListaExpInfixa(item);
                exp.addListaExpPosFixa(item);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//GRAMATICA COMPLETA
  static final public void inicio(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
    programa(listaComandosAltoNivel);
    jj_consume_token(0);
  }

  static final public void programa(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXIBE:
      case LEITURA:
      case SE:
      case ENQUANTO:
      case PARA:
      case SELETOR:
      case FACA:
      case REPEAT:
      case SEREPETE:
      case DUPLO:
      case MATRIX3D:
      case NUMERO:
      case PALAVRA:
      case VAR:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_6;
      }
      comando(listaComandosAltoNivel);
    }
  }

  static final public void comando(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      atribuicao(listaComandosAltoNivel);
      jj_consume_token(PV);
      break;
    case NUMERO:
    case PALAVRA:
      declaracao(listaComandosAltoNivel);
      break;
    case SE:
      se(listaComandosAltoNivel);
      break;
    case ENQUANTO:
      enquanto(listaComandosAltoNivel);
      break;
    case LEITURA:
      le(listaComandosAltoNivel);
      break;
    case EXIBE:
      exibe(listaComandosAltoNivel);
      break;
    case PARA:
      para(listaComandosAltoNivel);
      break;
    case SELETOR:
      seletor(listaComandosAltoNivel);
      break;
    case FACA:
      fazerEnquanto(listaComandosAltoNivel);
      break;
    case REPEAT:
      repeat(listaComandosAltoNivel);
      break;
    case SEREPETE:
      seRepete(listaComandosAltoNivel);
      break;
    case DUPLO:
      duplo(listaComandosAltoNivel);
      break;
    case MATRIX3D:
      matrix3D(listaComandosAltoNivel);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void atribuicao(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token atrib, var;
        ComandoAltoNivel comando = null;
        Expressao expressao = null;
    var = jj_consume_token(VAR);
                tabela.verificaVariavelDeclarada(var.image);
    atrib = jj_consume_token(ATRIB);
    expressao = iniciaExpressao();
                AcoesSemanticas.incompatibilidadeTipoAtribuicao (tabela.pesquisaTabela(var.image), expressao, var);
                comando = new ComandoAtribuicao(tabela.pesquisaTabela(var.image), expressao, atrib);
                tabela.pesquisaTabela(var.image).setIsInicializada(true);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao,var);
                listaComandosAltoNivel.addComando(comando);
  }

  static final public void declaracao(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token atrib, variavel;
        TipoDado tipo = null;
        ComandoAltoNivel comando = null;
        Expressao expressao = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
      jj_consume_token(NUMERO);
                      tipo = TipoDado.NUMERO;
      break;
    case PALAVRA:
      jj_consume_token(PALAVRA);
                       tipo = TipoDado.PALAVRA;
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    variavel = jj_consume_token(VAR);
                tabela.insereNaTabela(variavel, tipo);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIB:
      atrib = jj_consume_token(ATRIB);
      expressao = iniciaExpressao();
                        AcoesSemanticas.incompatibilidadeTipoAtribuicao (tabela.pesquisaTabela(variavel.image), expressao, variavel);
                        comando = new ComandoAtribuicao(tabela.pesquisaTabela(variavel.image), expressao, atrib);
                        tabela.pesquisaTabela(variavel.image).setIsInicializada(true);
                        AcoesSemanticas.faltaInicializacaoVariavel(expressao,variavel);
                        listaComandosAltoNivel.addComando(comando);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_7;
      }
      jj_consume_token(VIRGULA);
      variavel = jj_consume_token(VAR);
                        //System.out.println(variavel.image);
                        tabela.insereNaTabela(variavel, tipo);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATRIB:
        atrib = jj_consume_token(ATRIB);
        expressao = iniciaExpressao();
                                AcoesSemanticas.incompatibilidadeTipoAtribuicao (tabela.pesquisaTabela(variavel.image), expressao, variavel);
                                comando = new ComandoAtribuicao(tabela.pesquisaTabela(variavel.image), expressao, atrib);
                                tabela.pesquisaTabela(variavel.image).setIsInicializada(true);
                                AcoesSemanticas.faltaInicializacaoVariavel(expressao,variavel);
                                listaComandosAltoNivel.addComando(comando);
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
    }
    jj_consume_token(PV);
  }

//Inclusão do senao(else) como opcional apos a leitura da listaProgramaSe
  static final public void se(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token se,senao;
        ListaComandosAltoNivel listaProgramaSe =  new ListaComandosAltoNivel();
        ListaComandosAltoNivel listaProgramaSenao =  new ListaComandosAltoNivel();
        Expressao expressao = null;
        ComandoAltoNivel  comando = null;
    se = jj_consume_token(SE);
    jj_consume_token(AP);
    expressao = iniciaExpressao();
    jj_consume_token(FP);
    programa(listaProgramaSe);
                comando = new ComandoCondicionalSimples(expressao, listaProgramaSe, se);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao,se);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SENAO:
      senao = jj_consume_token(SENAO);
      programa(listaProgramaSenao);
            comando = new ComandoCondicionalCompleto(expressao, listaProgramaSe, listaProgramaSenao, se);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(FIMSE);
          listaComandosAltoNivel.addComando(comando);
  }

  static final public void fazerEnquanto(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token fazer;
        ListaComandosAltoNivel listaProgramaFazerEnquanto = new ListaComandosAltoNivel();
        Expressao expressao = null;
        ComandoAltoNivel comando = null;
    fazer = jj_consume_token(FACA);
    programa(listaProgramaFazerEnquanto);
    jj_consume_token(FAZERENQUANTO);
    jj_consume_token(AP);
    expressao = iniciaExpressao();
    jj_consume_token(FP);
    jj_consume_token(PV);
                comando = new ComandoFazerEnquanto(expressao, listaProgramaFazerEnquanto, fazer);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao, fazer);
                listaComandosAltoNivel.addComando(comando);
  }

  static final public void enquanto(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token enq;
        ListaComandosAltoNivel listaProgramaEnquanto = new ListaComandosAltoNivel();
        Expressao expressao = null;
        ComandoAltoNivel comando = null;
    enq = jj_consume_token(ENQUANTO);
    jj_consume_token(AP);
    expressao = iniciaExpressao();
    jj_consume_token(FP);
    programa(listaProgramaEnquanto);
                comando = new ComandoEnquanto(expressao, listaProgramaEnquanto, enq);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao,enq);
                listaComandosAltoNivel.addComando(comando);
    jj_consume_token(FIMENQUANTO);
  }

  static final public void le(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token le, t;
        ComandoEntrada comando = null;
    le = jj_consume_token(LEITURA);
    t = jj_consume_token(VAR);
                comando = new ComandoEntrada(tabela.pesquisaTabela(t.image), le);
                tabela.pesquisaTabela(t.image).setIsInicializada(true);
                tabela.pesquisaTabela(t.image).setIsUtilizada(true);
                listaComandosAltoNivel.addComando(comando);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
      jj_consume_token(VIRGULA);
      t = jj_consume_token(VAR);
                        comando = new ComandoEntrada(tabela.pesquisaTabela(t.image), le);
                        tabela.pesquisaTabela(t.image).setIsInicializada(true);
                        listaComandosAltoNivel.addComando(comando);
    }
    jj_consume_token(PV);
  }

  static final public void exibe(ListaComandosAltoNivel listaExibe) throws ParseException {
        Token exibe;
        Expressao expressao = null;
        ComandoSaida comando = null;
    exibe = jj_consume_token(EXIBE);
    expressao = iniciaExpressao();
                comando = new ComandoSaida(expressao, exibe);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao,exibe);
                listaExibe.addComando(comando);
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_9;
      }
      jj_consume_token(VIRGULA);
      expressao = iniciaExpressao();
                        comando = new ComandoSaida(expressao, exibe);
                        AcoesSemanticas.faltaInicializacaoVariavel(expressao,exibe);
                        listaExibe.addComando(comando);
    }
    jj_consume_token(PV);
  }

  static final public void para(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token tokenPara;
        ListaComandosAltoNivel listaProgramaPara = new ListaComandosAltoNivel();
        Expressao expressao = null;
        ComandoAltoNivel comando = null;
        ListaComandosAltoNivel listaAtribuicaoInicio = new ListaComandosAltoNivel();
        ListaComandosAltoNivel listaAtribuicaoPasso = new ListaComandosAltoNivel();
    tokenPara = jj_consume_token(PARA);
    jj_consume_token(AP);
    atribuicao(listaAtribuicaoInicio);
    jj_consume_token(PV);
    expressao = iniciaExpressao();
    jj_consume_token(PV);
    atribuicao(listaAtribuicaoPasso);
    jj_consume_token(FP);
    programa(listaProgramaPara);
    jj_consume_token(FIMPARA);
                comando = new ComandoPara(listaAtribuicaoInicio, expressao, listaAtribuicaoPasso, listaProgramaPara, tokenPara);
                AcoesSemanticas.faltaInicializacaoVariavel(expressao, tokenPara);
                listaComandosAltoNivel.addComando(comando);
  }

  static final public void seletor(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token tokenSeletor, tokenEntrada;
        Item itemCaso = null;
        Expressao expressaoSeletor = null;
        ComandoAltoNivel comando = null;
        ListaComandosAltoNivel listaPrograma = new ListaComandosAltoNivel();
        LinkedList<ListaComandosAltoNivel> listaComandosAltoNivelCasos = new LinkedList<ListaComandosAltoNivel>();
        LinkedList<Item> listaOpcaoCasos = new LinkedList<Item>();
    tokenSeletor = jj_consume_token(SELETOR);
    jj_consume_token(AP);
    expressaoSeletor = iniciaExpressao();
    jj_consume_token(FP);
    label_10:
    while (true) {
      jj_consume_token(CASO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUM:
        tokenEntrada = jj_consume_token(NUM);
                                      itemCaso = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.POS);
        break;
      case SOMA:
        jj_consume_token(SOMA);
        tokenEntrada = jj_consume_token(NUM);
                                              itemCaso = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.POS);
        break;
      case SUB:
        jj_consume_token(SUB);
        tokenEntrada = jj_consume_token(NUM);
                                             itemCaso = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenEntrada, Sinal.NEG);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(DP);
      programa(listaPrograma);
          listaComandosAltoNivelCasos.add(listaPrograma);
          listaOpcaoCasos.add(itemCaso);
          listaPrograma = new ListaComandosAltoNivel();
      jj_consume_token(FIMCASO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASO:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_10;
      }
    }
          comando = new ComandoSeletor(expressaoSeletor, listaComandosAltoNivelCasos, listaOpcaoCasos, token);
          AcoesSemanticas.faltaInicializacaoVariavel(expressaoSeletor, tokenSeletor);
          listaComandosAltoNivel.addComando(comando);
    jj_consume_token(FIMSELETOR);
  }

  static final public void repeat(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token tokenRepeat, tokenNumero;
        ListaComandosAltoNivel listaProgramaRepeat = new ListaComandosAltoNivel();
        ComandoAltoNivel comando = null;
        Item item;
    tokenRepeat = jj_consume_token(REPEAT);
    jj_consume_token(AP);
    tokenNumero = jj_consume_token(NUM);
      item = new Operando(TipoDado.NUMERO,TipoElemento.CTE, tokenNumero, Sinal.POS);
    jj_consume_token(FP);
    programa(listaProgramaRepeat);
    jj_consume_token(FIMREPEAT);
      comando = new ComandoRepeat(listaProgramaRepeat, tokenRepeat, item);
          listaComandosAltoNivel.addComando(comando);
  }

  static final public void seRepete(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token se_repete, token_repete_n;
        Expressao exp = null;
        Item item;
        ListaComandosAltoNivel lista_escopo_SeRepete = new ListaComandosAltoNivel();
        ComandoAltoNivel comando = null;
    se_repete = jj_consume_token(SEREPETE);
    jj_consume_token(AP);
    exp = iniciaExpressao();
    jj_consume_token(VIRGULA);
    token_repete_n = jj_consume_token(NUM);
                item = new Operando(TipoDado.NUMERO,TipoElemento.CTE, token_repete_n, Sinal.POS);
    jj_consume_token(FP);
    programa(lista_escopo_SeRepete);
                comando = new ComandoSeRepete(exp, token_repete_n, item, lista_escopo_SeRepete);
                AcoesSemanticas.faltaInicializacaoVariavel(exp, se_repete);
                listaComandosAltoNivel.addComando(comando);
    jj_consume_token(FIMSEREPETE);
  }

  static final public void duplo(ListaComandosAltoNivel listaComandosAltoNivel) throws ParseException {
        Token tokenDuplo;
        ListaComandosAltoNivel listaProgramaDuplo = new ListaComandosAltoNivel();
        ComandoAltoNivel comando = null;
    tokenDuplo = jj_consume_token(DUPLO);
    programa(listaProgramaDuplo);
        comando = new ComandoDuplo(listaProgramaDuplo, tokenDuplo);
                listaComandosAltoNivel.addComando(comando);
    jj_consume_token(FIMDUPLO);
  }

// Tarefa 18
  static final public void matrix3D(ListaComandosAltoNivel listaMatrix3D) throws ParseException {
        Token tokenMatrix3D, tokenVarDimX, tokenVarDimY, tokenVarDimZ, tokenCteInit, tokenCteLimSup;
        ComandoAltoNivel comandoMatrix3D = null;
        Item cteInicializacao = null;
        Item cteLimiteSuperior = null;
        Expressao expInicializacao = new Expressao();
        Expressao expCondicaoParada = new Expressao();
        ListaComandosAltoNivel blocoComandosMatrix = new ListaComandosAltoNivel();
    tokenMatrix3D = jj_consume_token(MATRIX3D);
    jj_consume_token(AP);
    tokenVarDimX = jj_consume_token(VAR);
                                  if ( !tabela.verificaSimbolo( tokenVarDimX.image ) ) tabela.insereNaTabela( tokenVarDimX, TipoDado.NUMERO );
                                  tabela.pesquisaTabela( tokenVarDimX.image ).setIsInicializada(true);
    jj_consume_token(VIRGULA);
    tokenVarDimY = jj_consume_token(VAR);
                                  if ( !tabela.verificaSimbolo( tokenVarDimY.image ) ) tabela.insereNaTabela( tokenVarDimY, TipoDado.NUMERO );
                                  tabela.pesquisaTabela( tokenVarDimY.image ).setIsInicializada(true);
    jj_consume_token(VIRGULA);
    tokenVarDimZ = jj_consume_token(VAR);
                                  if ( !tabela.verificaSimbolo( tokenVarDimZ.image ) ) tabela.insereNaTabela( tokenVarDimZ, TipoDado.NUMERO );
                                  tabela.pesquisaTabela( tokenVarDimZ.image ).setIsInicializada(true);
    jj_consume_token(SUB);
    tokenCteInit = jj_consume_token(NUM);
                                  cteInicializacao = new Operando( TipoDado.NUMERO, TipoElemento.CTE, tokenCteInit, Sinal.POS );
                                  expInicializacao.addListaExpInfixa( cteInicializacao );
                                  expInicializacao.addListaExpPosFixa( cteInicializacao );
    jj_consume_token(TO);
    tokenCteLimSup = jj_consume_token(NUM);
                                  cteLimiteSuperior = new Operando( TipoDado.NUMERO, TipoElemento.CTE, tokenCteLimSup, Sinal.POS );
                                  expCondicaoParada.addListaExpInfixa( cteLimiteSuperior );
                                  expCondicaoParada.addListaExpPosFixa( cteLimiteSuperior );
    jj_consume_token(FP);
    programa(blocoComandosMatrix);
    jj_consume_token(FIMMATRIX3D);
                                        comandoMatrix3D = new ComandoMatrix3D( tokenMatrix3D, tokenVarDimX, tokenVarDimY, tokenVarDimZ, expInicializacao, expCondicaoParada, blocoComandosMatrix );
                                        listaMatrix3D.addComando( comandoMatrix3D );
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CompiladorTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xaaa2a700,0xaaa2a700,0x80000000,0x0,0x0,0x0,0x800,0x0,0x0,0x0,0x80000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x100,0x200,0x6800,0x6800,0x1000,0x18,0x18,0x60,0x60,0x80,0x302001c,0x2000001,0x2000001,0x1,0x400,0x800000,0x400,0x0,0x800000,0x800000,0x1c,0x0,};
   }

  /** Constructor with InputStream. */
  public Compilador(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Compilador(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompiladorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Compilador(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CompiladorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Compilador(CompiladorTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CompiladorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[58];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 58; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
