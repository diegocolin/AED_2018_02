/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public interface Pilha<T> {
    
    void push(T v);
    
    T pop();
    
    T peek();
    
    Boolean vazia();
    
    void libera();
    
}
