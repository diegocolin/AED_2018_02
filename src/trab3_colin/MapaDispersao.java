 /**
  * @authors Diego Arndt, Diego Colin Soares e Felipe de Jesus Vieira
  */

public class MapaDispersao<K, T>{
    
    private  Lista<K, T>[] tabela;
    
    public MapaDispersao(int qtd){
        int tamanho = (int) (qtd * 0.5);
        
        int quantidade = procuraPrimo(tamanho, 10);
        
        System.out.println("Melhor tamanho pra tabela: " + quantidade);
        
        // Cria a tabela com o melhor tamanho
        setTabela(new Lista[quantidade]);
        
    }
    
    private int calcularHash(K chave){
        int hash = chave.hashCode() % procuraPrimo(quantosElementos()/2, 10);
        
        if(hash < 0){
            hash = hash * -1;
        }
        System.out.println("chave " + chave + " hash: " + hash);
        
        return hash;
    }
    
    public void inserir(K chave, T objeto){
        if (chave == null || objeto == null){
            return;
        }
        int hash = calcularHash(chave);
        
        ElementoLista<T> elemento = new ElementoLista<>();
        elemento.setElemento(objeto);
        
        if (tabela[hash] == null){
            Lista<K, T> lista = new Lista<>();
            
            lista.insere((T) elemento);
            
            tabela[hash] = lista;
        }else{
            Lista<K, T> listaAux = tabela[hash];
            
            listaAux.insere((T) elemento);
            
            tabela[hash] = listaAux;
        }
    }
    
    public Lista buscar(K chave){
        if(chave == null){
            return null;
        }
        int hash = calcularHash(chave);
        
        if(tabela[hash] == null){
            return null;
        }else{
            return tabela[hash];
        }
    }
    
    public T remover(K chave)
    {
        if(chave == null){
            return null;
        }
        int hash = calcularHash(chave);
        
        if(tabela[hash] == null){
            return null;
        }else{
            T objetoRemovido = (T) tabela[hash];
            
            tabela[hash] = null;
            
            return objetoRemovido;
        }
    }
    
    public int quantosElementos(){
        return this.tabela.length;
    }
    
    private int procuraPrimo(int numero, int limiteAceito){
        boolean isPrimo;
        limiteAceito = numero + limiteAceito;
        
        for (int i = numero; i < limiteAceito; i++){
            isPrimo = true;
            
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    isPrimo = false;
                    break;
                }
            }
            
            if (isPrimo){
                return i;
            }
        }
        return numero;
    }

    public Lista<K, T>[] getTabela() {
        return tabela;
    }

    public void setTabela(Lista<K, T>[] tabela) {
        this.tabela = tabela;
    }
    
}