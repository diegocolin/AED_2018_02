package ListaComArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dcsoares
 */
public class PersonalListaComArray {
    String array[];

    public PersonalListaComArray() {
        this.array = new String[100];
    }
   
    

    public void ListaComArrayTeste() {
       PersonalListaComArray lista = new PersonalListaComArray();
        System.out.println(lista.imprime());
        lista.insere("A");
        lista.insere("B");
        System.out.println("Esperado A,B = "+lista.imprime());
        lista.insere("C",0);
        System.out.println("Esperado C,A,B = "+lista.imprime());
        lista.insere("NAO",10);
        lista.retira(10);
        System.out.println("Esperado C,A,B = "+lista.imprime());
        int pos = lista.localiza("B");
        System.out.println("Esperado 2 = "+pos);
        pos = lista.localiza("BA");
        System.out.println("Esperado -1 = "+pos);
        String elem = lista.retira(0);
        System.out.println("Esperado C = "+elem);
        System.out.println("Esperado A,B = "+lista.imprime());
        
        PersonalListaComArray lista2 = new PersonalListaComArray();
        lista2.insere("X");
        lista2.insere("Y");
        lista2.insere("Z");
        System.out.println("Lista 2 = "+lista2.imprime());
        
        PersonalListaComArray lista3;
        lista3 = lista.concatena(lista2);
        System.out.println("Lista 3 (concatenação de 1 e 2)= "+lista3.imprime());
        
        PersonalListaComArray lista4;
        PersonalListaComArray lista5;
        lista4 = lista3.divide();
        System.out.println("Lista 3 (dividida) = "+lista3.imprime());
        System.out.println("Lista 4 (divisão de 3) = "+lista4.imprime());
        lista4.insere("AA",0);
        System.out.println("Lista 4 com AA na primeira posição = "+lista4.imprime());
        
        lista5 = lista4.copia();
        System.out.println("Lista 5 (cópia de 4) = "+lista5.imprime());
    }
    
   public PersonalListaComArray concatena(PersonalListaComArray l){
       PersonalListaComArray listasConcatenadas = new PersonalListaComArray();
       listasConcatenadas=this.copia();
       for (int i=0;i<l.getArray().length;i++){
           listasConcatenadas.insere(l.getArray()[i]);
       }
       return listasConcatenadas;
    }
   
       private PersonalListaComArray divide() {
         PersonalListaComArray listaDividida = new PersonalListaComArray();
       for (int i=0;i<(array.length)/2;i++){
           listaDividida.insere(array[i]);
       }
       return listaDividida;
    }
       
       private PersonalListaComArray copia() {
        PersonalListaComArray listaCopiada = new PersonalListaComArray();
         for (int i=0;i<this.getArray().length;i++){
           listaCopiada.insere(this.getArray()[i]);
       }
        return listaCopiada;
    }


    
    public void insere(String valor){
    for (int i=0; i<array.length;i++){
        if (array[i]==null){
        array[i]=valor;
        break;
        }
    }    
    }
    public void insere(String valor, int posicao){
        if (array[posicao]==null){
            array[posicao]=valor;
        }else{
            int tamanhoArray=array.length;
            for (int i=tamanhoArray-1; i>posicao;i--){
                array[i]=array[i-1];
            }
            array[posicao]=valor;
        }
    }
    
    public String retira(int posicao){
        String retorno="";
        if (array[posicao]==null){
            retorno = "Nenhum item foi encontrado nessa posição";
        } else {
            retorno = array[posicao]+" retirado da lista";
            for (int i=posicao; i<array.length-1;i++){
                array[i]=array[i+1];
            }
        }
        return retorno;
    }
    
    public int localiza(String valor){
        
        for (int i=0; i<array.length-1;i++){
                if (array[i] != null && array[i].equals(valor)){
                    return i;
                }
            }
        
        return -1;
    }
    
    public Boolean estaVazia(){
         for (int i=0; i<array.length;i++){
                if (array[i]!=null){
                    return Boolean.FALSE;
                }
            }
         return Boolean.TRUE;
    }
        
    public String imprime(){
        String retorno="";
        for (int i=0; i<array.length;i++){
           // System.out.println(array[i]);
           if (array[i]!=null){
                   if (i==0){
                   retorno +=array[i];
                   }else{
            retorno+= ", "+array[i];
            }
           }
        }
        return retorno;
    }
    
    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }
    
}