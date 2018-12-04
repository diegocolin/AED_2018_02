/**
 * @authors Diego Arndt, Diego Colin Soares e Felipe de Jesus Vieira
 */
public class Lista<K, T> {

    private ElementoLista<T> primeiroElemento;
    private ElementoLista<T> ultimoElemento;
    private int qtdElementos = 0;

    public Lista() {
    }

    public int ultimoIndiceDe(T x) {
        ElementoLista elementoLista = primeiroElemento;
        int qtdOcorrencias = 0;
        int ultimaOcorrencia = 0;

        int i = 0;
        while ((elementoLista != null)) {
            if (elementoLista.getElemento().equals(x)) {
                qtdOcorrencias += 1;

                ultimaOcorrencia = i;
            }

            i++;
            elementoLista = elementoLista.getProxElemento();
        }

        if (qtdOcorrencias == 0) {
            return -1;
        }
        return ultimaOcorrencia;
    }

    public String imprimeInverso() {
        String listaInvertida = "";

        for (int i = qtdElementos - 1; i >= 0; i--) {
            listaInvertida += consulta(i) + " - ";
        }

        return listaInvertida;
    }

    public void insere(T elemento) {
        ElementoLista novoElemento = new ElementoLista();
        novoElemento.setElemento(elemento);

        if (this.estaVazia()) {
            primeiroElemento = novoElemento;
        } else {
            ultimoElemento.setProxElemento(novoElemento);
        }

        ultimoElemento = novoElemento;

        qtdElementos++;
    }

    public void insere(T valorElemento, int posicao) {
        if (posicao >= 0 && posicao <= qtdElementos) {
            ElementoLista novoElemento = new ElementoLista();
            novoElemento.setElemento(valorElemento);

            ElementoLista elemPosicaoX;

            if (posicao == 0) {
                novoElemento.setProxElemento(primeiroElemento);

                primeiroElemento = novoElemento;
            } else {
                elemPosicaoX = this.consultaInterna(posicao - 1);

                novoElemento.setProxElemento(elemPosicaoX.getProxElemento());

                elemPosicaoX.setProxElemento(novoElemento);
            }

            qtdElementos++;

        }
    }

    public T retira(int posicao) {
        if (posicao == 0) {
            T elementoRemovido = this.primeiroElemento.getElemento();

            this.primeiroElemento = primeiroElemento.getProxElemento();

            qtdElementos--;

            return elementoRemovido;
        } else if (posicao > 0 && posicao < qtdElementos) {
            ElementoLista<T> elementoLista = this.consultaInterna(posicao - 1);

            ElementoLista<T> elementoRemovido = elementoLista.getProxElemento();

            elementoLista.setProxElemento(elementoRemovido.getProxElemento());

            qtdElementos--;

            return elementoRemovido.getElemento();
        } else if (posicao == qtdElementos) {
            T elementoRemovido = this.ultimoElemento.getElemento();

            ElementoLista novoUltimo = this.consultaInterna(posicao - 1);

            this.ultimoElemento = novoUltimo;

            novoUltimo.setProxElemento(null);

            qtdElementos--;

            return elementoRemovido;
        }

        return null;
    }

    public boolean estaVazia() {
        return primeiroElemento == null;
    }

    private ElementoLista<T> consultaInterna(int posicao) {
        if (posicao >= 0 && posicao < this.qtdElementos) {
            ElementoLista proximo = primeiroElemento;

            for (int i = 0; i < posicao; i++) {
                proximo = proximo.getProxElemento();
            }

            return proximo;
        } else {
            return null;
        }
    }

    public int localiza(T elemento) {
        ElementoLista elementoLista = primeiroElemento;

        int i = 0;
        while ((elementoLista != null)) {
            if (elementoLista.getElemento().equals(elemento)) {
                return i;
            }

            i++;
            elementoLista = elementoLista.getProxElemento();
        }

        return -1;
    }

    public String imprime() {
        String lista = "";

        if (estaVazia()) {
            return lista = "Lista vazia";
        }

        ElementoLista elemento = this.primeiroElemento;

        while (elemento != null) {
            lista += elemento.getElemento() + " - ";

            elemento = elemento.getProxElemento();
        }

        return lista;
    }

    public T consulta(int posicao) {
        return this.consultaInterna(posicao).getElemento();
    }

    public int getTamanho() {
        return qtdElementos;
    }

    public ElementoLista getPrimeiroElemento() {
        return primeiroElemento;
    }

    public void setPrimeiroElemento(ElementoLista primeiroElemento) {
        this.primeiroElemento = primeiroElemento;
    }

    public ElementoLista getUltimoElemento() {
        return ultimoElemento;
    }

    public void setUltimoElemento(ElementoLista ultimoElemento) {
        this.ultimoElemento = ultimoElemento;
    }

    public void setTamanhoLista(int tamanhoLista) {
        this.qtdElementos = tamanhoLista;
    }
}
