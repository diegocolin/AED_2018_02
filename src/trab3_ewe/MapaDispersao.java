package trab3.ewe;

/**
 *
 * @author ejust
 * @param <K> - Tipo da chave
 * @param <T> - Valor
 */
public class MapaDispersao<K, T>
{
    private final ListaEncadeada<K, T>[] tabela;
    private final int tamanhoTabela;

        public MapaDispersao(int qtd)
    {
        int tamanho = (int) (qtd * 0.5);

        this.tamanhoTabela = procuraPrimo(tamanho, 10);

        System.out.println("Melhor tamanho pra tabela: " + this.tamanhoTabela);
        
        // Cria a tabela com o melhor tamanho
        this.tabela = new ListaEncadeada[this.tamanhoTabela];
        
    }
    
    private int calculaHash(K chave)
    {
        int hash = chave.hashCode() % this.tamanhoTabela;
        
        if(hash < 0)
            hash = hash * -1;
        
        System.out.println("chave " + chave + " hash: " + hash);
        
        return hash;
    }
    
    
    public void inserir(K chave, T objeto)
    {
        if (chave == null || objeto == null)
            return;    

        int hash = calculaHash(chave);
        
        ElementoLista<T> elemento = new ElementoLista<>();
        elemento.setElemento(objeto);
            
        if (tabela[hash] == null)
        {
            ListaEncadeada<K, T> lista = new ListaEncadeada<>();
            
            lista.insere((T) elemento);
            
            tabela[hash] = lista;
        }
        else 
        {
            ListaEncadeada<K, T> listaAux = tabela[hash];
            
            listaAux.insere((T) elemento);
            
            tabela[hash] = listaAux;
        }
    }
    
    public ListaEncadeada buscar(K chave)
    {
        if(chave == null)
            return null;
        
        int hash = calculaHash(chave);

        if(tabela[hash] == null)
            return null;
        else
        {
            return tabela[hash];
        }
    }
    
    public T remover(K chave)
    {
        if(chave == null)
            return null;
        
        int hash = calculaHash(chave);
        
        if(tabela[hash] == null)
            return null;
        else
        {
            T objetoRemovido = (T) tabela[hash];
            
            tabela[hash] = null;
            
            return objetoRemovido;
        }
    }

    private int procuraPrimo(int numero, int limiteAceito)
    {
        boolean isPrimo;
        limiteAceito = numero + limiteAceito;

        for (int i = numero; i < limiteAceito; i++)
        {
            isPrimo = true;

            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    isPrimo = false;
                    break;
                }
            }

            if (isPrimo)
            {
                return i;
            }
        }

        return numero;
    }
    
    public int verificaColisao(K chave)
    {
        int hash = calculaHash(chave);
        
        if(tabela[hash] == null)
            return 0;
        else 
        {
            return tabela[hash].getTamanho();
        }
    }
    
    public ListaEncadeada posicaoComMaisColisoes()
    {
        ListaEncadeada listaMaisColisoes = new ListaEncadeada();
        
        for(int i = 0; i < tamanhoTabela; i++)
        {
            if(tabela[i] != null)
            {
                if(tabela[i].getTamanho() > listaMaisColisoes.getTamanho())
                {
                    listaMaisColisoes = tabela[i];
                }
            }
        }
        
        System.out.println("A posição com mais colisões tem " + listaMaisColisoes.getTamanho() + " itens na lista");
        
        return listaMaisColisoes;
    }

}
