/**
 * @authors Diego Arndt, Diego Colin Soares e Felipe de Jesus Vieira
 */
public class Principal{

    public static void main(String[] args){
        
        MapaDispersao<String,Veiculo> mp = new MapaDispersao(2000);
        
        //Testa inserir
        Veiculo v = new Veiculo();
        v.setPlaca("AAA-0123");
        v.setModelo("Hyundai Creta");
        v.setAno(2017);
        v.setProprietario("João da Silva");
        mp.inserir(v.getPlaca(), v);
        v = new Veiculo();
        v.setPlaca("AAA-0124");
        v.setModelo("Kombi");
        v.setAno(1965);
        v.setProprietario("John Doe");
        mp.inserir(v.getPlaca(), v);
        
        //Testa quantosElementos
        System.out.println("Quantidade de elementos não nulos: "+mp.quantosElementos());
        //Testa buscar
        mp.buscar("AAA-0124");
        mp.buscar("AAA-0125");
        //Testa remover
        mp.remover("AAA-0125");
        mp.remover("AAA-0124");
        //Testa se remover realmente funcionou
         System.out.println("Quantidade de elementos não nulos: "+mp.quantosElementos());
        }
}