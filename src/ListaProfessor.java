/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public interface ListaProfessor {

    ListaProfessor concatena(ListaProfessor outra);

    String consulta(int p);

    ListaProfessor copia();

    ListaProfessor divide();

    boolean estaCheia();

    boolean estaVazia();

    int getTamanho();

    String imprime();

    void insere(String x);

    void insere(String x, int p);

    int localiza(String x);

    String retira(int p);
    
}
