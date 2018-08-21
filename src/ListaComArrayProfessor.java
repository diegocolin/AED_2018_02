
/**
 *
 * @author marcel
 */
public class ListaComArrayProfessor implements ListaProfessor   {
    private String[] valores;
    private static final int MAXTAM = 100;
    private int ultimo = 0;
    
    public ListaComArrayProfessor() {
        valores = new String[MAXTAM];
    }
    
    @Override
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
    
    
    @Override
	public boolean estaCheia() {
        return (ultimo == MAXTAM);
    }
    
    
    @Override
	public boolean estaVazia() {
        return (ultimo == 0);
    }
    
    @Override
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
    
    
    @Override
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

    
    @Override
    public int localiza(String x){
        for (int i=0; i < this.ultimo; i++){
            if (valores[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    
    @Override
    public int getTamanho() {
        return this.ultimo;
    }

    @Override
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

    @Override
    public String consulta(int p){
        try {
            return this.valores[p];
        } catch (IndexOutOfBoundsException iae){
            return null;
        }
    }

    @Override
    public ListaProfessor concatena(ListaProfessor outra){
        if (this.getTamanho()+outra.getTamanho() > MAXTAM)
            return null;

        ListaComArrayProfessor nova = new ListaComArrayProfessor();
        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(this.consulta(i));
        }
        for (int i=0; i < outra.getTamanho(); i++){
            nova.insere(outra.consulta(i));
        }

        return nova;
    }

    @Override
    public ListaProfessor divide(){
        if (this.estaVazia())
            return null;

        ListaComArrayProfessor nova = new ListaComArrayProfessor();
        int meio = this.getTamanho() / 2;

        for (int i = meio; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
            valores[i] = null;
        }
        this.ultimo = meio;
        return nova;
    }

    @Override
    public ListaProfessor copia(){
        ListaComArrayProfessor nova = new ListaComArrayProfessor();

        for (int i=0; i < this.getTamanho(); i++){
            nova.insere(valores[i]);
        }

        return nova;
    }

}
