package Lista;

/**
 *
 * @author dcsoares & darndt
 */
public class ListaComArray implements Lista {

    String array[];

    public ListaComArray() {
        this.array = new String[100];
    }

    public void ListaComArrayTeste() {
        Lista lista = new ListaComArray();
        System.out.println(lista.imprime());
        lista.insere("A");
        lista.insere("B");
        //System.out.println("Esperado A,B = "+lista.imprime());
        lista.insere("C", 0);
        //System.out.println("Esperado C,A,B = "+lista.imprime());
        lista.insere("NAO", 10);
        lista.retira(10);
        //System.out.println("Esperado C,A,B = "+lista.imprime());
        int pos = lista.localiza("B");
        //System.out.println("Esperado 2 = "+pos);
        pos = lista.localiza("BA");
        //System.out.println("Esperado -1 = "+pos);
        String elem = lista.retira(0);
        //System.out.println("Esperado C = "+elem);
        //System.out.println("Esperado A,B = "+lista.imprime());

        System.out.println("Lista 1 = " + lista.imprime());
        
        System.out.println("-=-=-=-=");
        System.out.println("Lista 1 = " + lista.imprimeRecursivo(0, ""));
        System.out.println("-=-=-=-=");

        Lista lista2 = new ListaComArray();
        lista2.insere("X");
        lista2.insere("Y");
        lista2.insere("Z");
        System.out.println("Lista 2 = " + lista2.imprime());

        Lista lista3;
        lista3 = lista.concatena(lista2);
        System.out.println("Lista 3 (concatenação de 1 e 2)= " + lista3.imprime());

        Lista lista4;
        Lista lista5;
        lista4 = lista3.divide();
        System.out.println("Lista 3 (dividida) = " + lista3.imprime());
        System.out.println("Lista 4 (divisão de 3) = " + lista4.imprime());
        lista4.insere("AA", 0);
        System.out.println("Lista 4 com AA na primeira posição = " + lista4.imprime());

        lista5 = lista4.copia();
        System.out.println("Lista 5 (cópia de 4) = " + lista5.imprime());
    }

    @Override
    public Lista concatena(Lista l) {
        Lista listasConcatenadas = new ListaComArray();
        listasConcatenadas = this.copia();
        for (int i = 0; i < l.getTamanho(); i++) {
            listasConcatenadas.insere(l.consulta(i));
        }
        return listasConcatenadas;
    }

    @Override
    public Lista divide() {
        ListaComArray listaDividida = new ListaComArray();
        for (int i = 0; i < (array.length) / 2; i++) {
            listaDividida.insere(array[i]);
        }
        return listaDividida;
    }

    @Override
    public Lista copia() {
        ListaComArray listaCopiada = new ListaComArray();
        for (int i = 0; i < this.getTamanho(); i++) {
            listaCopiada.insere(this.consulta(i));
        }
        return listaCopiada;
    }

    @Override
    public void insere(String valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = valor;
                break;
            }
        }
    }

    @Override
    public void insere(String valor, int posicao) {
        if (array[posicao] == null) {
            array[posicao] = valor;
        } else {
            int tamanhoArray = array.length;
            for (int i = tamanhoArray - 1; i > posicao; i--) {
                array[i] = array[i - 1];
            }
            array[posicao] = valor;
        }
    }

    @Override
    public String retira(int posicao) {
        String retorno = "";
        if (array[posicao] == null) {
            retorno = "Nenhum item foi encontrado nessa posição";
        } else {
            retorno = array[posicao] + " retirado da lista";
            for (int i = posicao; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        return retorno;
    }

    @Override
    public int localiza(String valor) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != null && array[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Boolean estaVazia() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public String imprime() {
        String retorno = "";
        for (int i = 0; i < array.length; i++) {
            // System.out.println(array[i]);
            if (array[i] != null) {
                if (i == 0) {
                    retorno += array[i];
                } else {
                    retorno += ", " + array[i];
                }
            }
        }
        return retorno;
    }

    @Override
    public String imprimeRecursivo(int start, String retorno) {
        if (array[start] == null) {
            return retorno.substring(0, retorno.length()-2);
        } else {
            retorno += array[start]+", ";
            return imprimeRecursivo(start+1, retorno);
        }
    }

    @Override
    public int getTamanho() {
        return array.length;
    }

    @Override
    public String consulta(int i) {
        return array[i];
    }

    @Override
    public String imprimeInverso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ultimoIndiceDe(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimeRecursivoEncadeada(ItemLista prox, String retorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}