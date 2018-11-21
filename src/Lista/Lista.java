package Lista;

/**
 *
 * @author dcsoares & darndt
 */
public interface Lista<T> {

    Lista concatena(Lista l);

    Lista copia();

    Lista divide();

    Boolean estaVazia();

    String imprime();
    
    String imprimeInverso();
    
    String imprimeRecursivoEncadeada(ItemLista atual, String retorno);
    
    String imprimeRecursivo(int start, String retorno);

    void insere(String valor);

    void insere(String valor, int posicao);

    int localiza(String valor);

    String retira(int posicao);
    
    int getTamanho();

    String consulta(int i);
    
    int ultimoIndiceDe(T x);
    
}