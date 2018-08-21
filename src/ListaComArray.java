package ListaComArray;
/**
 *
 * @author marcel
 */
public class ListaComArray  {
    private String[] valores;
    private static final int MAXTAM = 100;
    private int ultimo = 0;
    
    public ListaComArray() {
        valores = new String[MAXTAM];
    }
    
    public void insere(String x){
        /*
        if (ultimo < MAXTAM){
            valores[ultimo] = x;
            ultimo++;
        }
        */
        try {
            valores[ultimo] = x;
            ultimo++;            
        } catch (ArrayIndexOutOfBoundsException aiobe){  
            // não é feito nada, ou seja, o elemento não é incluído por não ter mais espaço
        }
    }
    
    
	public boolean estaCheia() {
        return (ultimo == MAXTAM);
    }
    
    
	public boolean estaVazia() {
        return (ultimo == 0);
    }
    
	public void insere(String x, int p){
        if (!this.estaCheia()
            && p <= ultimo){
            String temp;
            for (int i = p; i <= ultimo; i++){
                temp = valores[i];
                valores[i] = x;
                x = temp;
            }
            ultimo++;
        }
    }
    
    
    public String retira(int p){
        String retorno=null;
        if (!this.estaVazia()
            && p >= 0 
            && p < ultimo){
            retorno = valores[p];
            for (int i = p; i < ultimo-1; i++){
                valores[i] = valores[i+1];
            }
            ultimo--;
            valores[ultimo] = null;  // opcional
        }
        return retorno;
    }

    
    public int localiza(String x){
        for (int i=0; i < this.ultimo; i++){
            if (valores[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    
    public int getTamanho() {
        return this.ultimo;
    }

    public String imprime() {
        String retorno = "[";

        for (int i=0; i < this.ultimo; i++){
            retorno += valores[i]+"; ";
        }
        try {
            // para retirar a última vírgula e espaço
            retorno = retorno.substring(0,retorno.length()-2);
            return retorno+"]";
        } catch (StringIndexOutOfBoundsException strExc){
            return "[]";
        }
    }

    public String consulta(int p){
        try {
            return this.valores[p];
        } catch (IndexOutOfBoundsException iae){
            return null;
        }
    }

    public ListaComArray concatena(ListaComArray outra){
        if (this.getTamanho()+outra.getTamanho() > MAXTAM)
            return null;

        ListaComArray nova = new ListaComArray();
        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(this.consulta(i));
        }
        for (int i=0; i < outra.getTamanho(); i++){
            nova.insere(outra.consulta(i));
        }

        return nova;
    }

    public ListaComArray divide(){
        if (this.estaVazia())
            return null;

        ListaComArray nova = new ListaComArray();
        int meio = this.getTamanho() / 2;

        for (int i = meio; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
            valores[i] = null;
        }
        this.ultimo = meio;
        return nova;
    }

    public ListaComArray copia(){
        ListaComArray nova = new ListaComArray();

        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
        }

        return nova;
    }

}
