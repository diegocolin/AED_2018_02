/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public class PilhaVetor<T> implements Pilha<T> {

    int n = 0;
    int tam = 100;
    T[] vet;

    @Override
    public void push(T v) {
        if (n < tam) {
            vet[n] = v;
            n++;
        }
    }

    @Override
    public T pop() {
        T v = null;
        if (n > 0) {
            v = vet[n - 1];
            vet[n - 1] = null;
            n--;
        }
        return v;

    }

    @Override
    public T peek() {
        return vet[n - 1];
    }

    @Override
    public Boolean vazia() {
        if (n == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public void libera() {
        //TODO
    }

}
