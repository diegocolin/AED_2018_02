public class TesteListaEncadeada {

    public TesteListaEncadeada() {
        ListaEncadeada lista = new ListaEncadeada();

        lista.insere("L");
        lista.insere("M");
        lista.insere("A");
        lista.insere("B");
        lista.insere("M");
        lista.insere("N");
        lista.insere("O");
        lista.insere("P");
        lista.insere("P");
       
        System.out.println("QUESTAO 4");
        System.out.println("M > "+lista.ultimoIndiceDe("M"));
        System.out.println("P > "+lista.ultimoIndiceDe("P"));
        System.out.println("K > "+lista.ultimoIndiceDe("K"));
        
        System.out.println("QUESTAO 5");
        System.out.println("Lista ordenada normalmente: "+lista.imprime());
        System.out.println("Lista ordenada inversamente: "+lista.imprimeInverso());
        
        System.out.println("Lista ordenada recursivamente: "+lista.imprimeRecursivoEncadeada(lista.primeiro, ""));
        
        /*System.out.println("Lista vazia: "+lista.imprime());
        lista.insere("A");
        lista.insere("B");
        System.out.println("Esperado A,B = "+lista.imprime());
        
        lista.insere("C",0);
        System.out.println("Esperado C,A,B = "+lista.imprime());
        lista.insere("NAO",10);
        System.out.println("Esperado C,A,B = "+lista.imprime());
        
        int pos = lista.localiza("B");
        System.out.println("Esperado 2 = "+pos);
        pos = lista.localiza("BA");
        System.out.println("Esperado -1 = "+pos);
        String elem = lista.retira(0);
        System.out.println("Esperado C = "+elem);
        System.out.println("Esperado A,B = "+lista.imprime());
        
        ListaEncadeada lista2 = new ListaEncadeada();
        lista2.insere("X");
        lista2.insere("Y");
        lista2.insere("Z");
        System.out.println("Lista 2 (X,Y,Z)= "+lista2.imprime());
        
        ListaEncadeada lista3;
        lista3 = (ListaEncadeada)lista.concatena(lista2);
        System.out.println("Lista 3 (concatenação de 1 e 2)= "+lista3.imprime());
        
        ListaEncadeada lista4, lista5;
        lista4 = (ListaEncadeada)lista3.divide();
        System.out.println("Lista 3 (dividida) = "+lista3.imprime());
        System.out.println("Lista 4 (divisão de 3) = "+lista4.imprime());
        lista4.insere("AA",0);
        System.out.println("Lista 4 com AA na primeira posição = "+lista4.imprime());
        
        lista5 = (ListaEncadeada)lista4.copia();
        System.out.println("Lista 5 (cópia de 4) = "+lista5.imprime());*/
        
    }
}