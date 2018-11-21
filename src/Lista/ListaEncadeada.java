package Lista;

/**
 *
 * @author dcsoares & darndt
 */
public class ListaEncadeada<T> implements Lista<T> {

    protected ItemLista primeiro;
    protected ItemLista ultimo;
    protected int qtdeElementos;

    @Override
    public Lista concatena(Lista l) {
        Lista retorno = this;
        for (int i = 0; i < l.getTamanho(); i++) {
            retorno.insere(l.consulta(i));
        }
        return retorno;
    }

    @Override
    public Lista copia() {
        return this;
    }

    @Override
    public Lista divide() {
        if (primeiro != null) {
            ItemLista itemAnalisado = primeiro;

            itemAnalisado = primeiro;
            for (int j = 0; j < (qtdeElementos / 2); j++) {
                ultimo = itemAnalisado;
                itemAnalisado = itemAnalisado.getProx();
            }
            ultimo.setProx(null);

        }
        return this;
    }

    @Override
    public Boolean estaVazia() {
        if (primeiro == null || qtdeElementos == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String imprime() {
        String str = "";
        ItemLista proximo = primeiro;
        while (proximo != null) {
            str += proximo.getInfo() + ",";
            proximo = proximo.getProx();
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public String imprimeRecursivoEncadeada(ItemLista atual, String retorno) {
        if (atual == null) {
            return retorno.substring(0, retorno.length() - 1);
        } else {
            retorno += atual.getInfo() + ",";
            return imprimeRecursivoEncadeada(atual.getProx(), retorno);
        }
    }

    @Override
    public String imprimeInverso() {
        String str = "";
        for (int i = 0; i < imprime().length(); i++) {
            str = str + imprime().charAt(imprime().length() - i - 1);
        }
        return str;

    }

    @Override
    public void insere(String valor) {
        if (primeiro == null) {
            primeiro = new ItemLista();
            primeiro.setInfo(valor);
            ultimo = primeiro;
        } else {
            ItemLista pUltimo = ultimo;
            ItemLista novo = new ItemLista();
            novo.setInfo(valor);
            ultimo.setProx(novo);
            ultimo = novo;
        }
        this.qtdeElementos++;
    }

    @Override
    public void insere(String valor, int posicao) {
        ItemLista novo = new ItemLista();
        novo.setInfo(valor);
        if (posicao < qtdeElementos && posicao != 0) {
            int i = 0;
            ItemLista anterior = primeiro;
            while (i < posicao) {
                anterior = anterior.getProx();
                i++;
            }
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
            this.qtdeElementos++;
        } else {
            if (posicao == 0) {
                novo.setProx(primeiro);
                primeiro = novo;
                this.qtdeElementos++;
            }
        }

    }

    @Override
    public int localiza(String valor) {
        if (primeiro != null) {
            ItemLista itemAnalisado = primeiro;
            for (int i = 0; i < qtdeElementos; i++) {
                if (itemAnalisado.getInfo().equals(valor)) {
                    return i;
                } else {
                    itemAnalisado = itemAnalisado.getProx();
                }

            }
        }
        return -1;
    }

    @Override
    public String retira(int posicao) {

        if (primeiro != null) {
            ItemLista itemAnalisado = primeiro;
            ItemLista itemAnterior = primeiro;
            if (posicao != 0) {
                for (int i = 0; i < qtdeElementos; i++) {
                    if (i == (posicao - 1)) {
                        itemAnterior = itemAnalisado;
                    }
                    if (i == posicao) {
                        itemAnterior.setProx(itemAnalisado.getProx());
                        return itemAnalisado.getInfo();
                    }
                    itemAnalisado = itemAnalisado.getProx();
                }
            } else {
                String retirado = primeiro.getInfo();
                primeiro = primeiro.getProx();
                return retirado;
            }
        }
        return "Posicao nao existente";
    }

    @Override
    public int getTamanho() {
        return qtdeElementos;
    }

    @Override
    public String consulta(int i) {
        if (i < qtdeElementos) {
            if (primeiro != null) {
                ItemLista itemAnalisado = primeiro;
                for (int j = 0; j < qtdeElementos; j++) {
                    if (j == i) {
                        return itemAnalisado.getInfo();
                    }
                    itemAnalisado = itemAnalisado.getProx();
                }
            }
        }
        return "Essa lista nao tem a posicao " + i;
    }

    @Override
    public int ultimoIndiceDe(T x) {
        int result = -1;
        int cont = 0;
        ItemLista atual = primeiro;
        while (atual != null) {
            if (atual.getInfo() == x) {
                result = cont;
            }
            cont++;
            atual = atual.getProx();
        }
        return result;
    }

    @Override
    public String imprimeRecursivo(int start, String retorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
