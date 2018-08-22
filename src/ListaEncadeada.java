/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public class ListaEncadeada implements Lista {

    protected ItemLista primeiro;
    protected ItemLista ultimo;
    protected int qtdeElementos;

    @Override
    public Lista concatena(Lista l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lista copia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lista divide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean estaVazia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprime() {
        String str = "";
        ItemLista proximo = primeiro;
        while (proximo != null) {
            str += proximo.getInfo() + ",";
            proximo = proximo.getProx();
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
        if (posicao < qtdeElementos && posicao!=0) {
            int i = 0;
            ItemLista anterior = primeiro;
            while (i < posicao) {
                anterior=anterior.getProx();
                i++;
            }
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
        }else{
            if (posicao==0){
              novo.setProx(primeiro);
              primeiro=novo;
            }
        }
    }

    @Override
    public int localiza(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String retira(int posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setArray(String[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
