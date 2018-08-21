/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public interface Lista {

    void ListaComArrayTeste();

    Lista concatena(Lista l);

    Lista copia();

    Lista divide();

    Boolean estaVazia();

    String[] getArray();

    String imprime();

    void insere(String valor);

    void insere(String valor, int posicao);

    int localiza(String valor);

    String retira(int posicao);

    void setArray(String[] array);
    
}
