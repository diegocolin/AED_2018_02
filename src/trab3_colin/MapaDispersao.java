/**
 * @authors Diego Arndt, Diego Colin Soares e Felipe de Jesus Vieira
 */

public class MapaDispersao<K, T> {

    private Lista<K, T>[] tabela;

    public MapaDispersao(int qtd) {
        int tamanho = (int) (qtd * 0.5);
        int quantidade = procurarPrimo(tamanho, 10);
        setTabela(new Lista[quantidade]);
    }

    private int calcularHash(K chave) {
        int hash = chave.hashCode() % procurarPrimo(this.tabela.length / 2, 10);
        if (hash < 0) {
            hash = hash * -1;
        }
        return hash;
    }

    public boolean inserir(K chave, T dado) {
        if (chave == null || dado == null) {
            System.out.println("Insira uma chave e um objeto para inserir.");
            return false;
        }
        int hash = calcularHash(chave);
        ElementoLista<T> elemento = new ElementoLista<>();
        elemento.setElemento(dado);
        if (tabela[hash] == null) {
            Lista<K, T> lista = new Lista<>();
            lista.insere((T) elemento);
            tabela[hash] = lista;
             System.out.println("Objeto inserido.");
            return true;
        
        } else {
            System.out.println("Esse objeto já existe no hash");
            return false;
        }
       
    }

    public T remover(K chave) {
        if (chave == null) {
            System.out.println("Insira uma chave para remover.");
            return null;
        }
        int hash = calcularHash(chave);
        if (tabela[hash] == null) {
            System.out.println("Nenhum elemento encontrado com a chave '"+chave+"'.");
            return null;
        } else {
            T objetoRemovido = (T) tabela[hash];
            tabela[hash] = null;
            System.out.println("Objeto removido");
            return objetoRemovido;
        }
    }

    public T buscar(K chave) {
        if (chave == null) {
            System.out.println("Insira uma chave para buscar.");
            return null;
        }
        int hash = calcularHash(chave);
        if (tabela[hash] == null) {
            System.out.println("Nenhum elemento encontrado com a chave '"+chave+"'.");
            return null;
        } else {
            System.out.println("Elemento com a chave '"+chave+"' encontrado na posição "+hash+" da tabela");
            return (T) tabela[hash];
        }
    }
    
    public int quantosElementos() {
        int quantidadeNaoNulos=0;
        for (int i=0;i<this.tabela.length;i++){
            if (this.tabela[i]!=null){
                quantidadeNaoNulos++;
            } 
        }
          return quantidadeNaoNulos;
    }

    private int procurarPrimo(int numero, int limiteAceito) {
        boolean isPrimo;
        limiteAceito = numero + limiteAceito;
        for (int i = numero; i < limiteAceito; i++) {
            isPrimo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimo = false;
                    break;
                }
            }
            if (isPrimo) {
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
