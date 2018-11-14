
package ordenacao;

import java.util.Random;
import org.junit.Test;
import org.junit.BeforeClass;
import java.text.NumberFormat;
import static org.junit.Assert.fail;
/**
 *
 * @author Marcel
 */
public class ClassificadorTest {
    private static final int tamanho = 1000;
    private static Integer[] vetorBase = new Integer[tamanho];
    private static NumberFormat nf = NumberFormat.getIntegerInstance();
    
    public ClassificadorTest() {
    }

    
    @BeforeClass
    public static void umaVez(){
        Random r = new Random();
        for (int i=0; i < vetorBase.length; i++){
            vetorBase[i] = r.nextInt(1_000_000);
        }    
        for (int o: vetorBase){
            System.out.print(o+", ");
        }
        System.out.println("\n");
        
        // apenas para carregar a classe Classificador e não comprometer a verificação do tempo
        String[] carrega = {"b","a"};
        Classificador.bubbleSort(carrega);
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    
    public Integer[] antesDoTeste(){
        Integer[] teste = new Integer[tamanho];
        System.arraycopy(vetorBase,0,teste,0,vetorBase.length);
        return teste;
    }
    /**
     * Test of bubbleSort method, of class Classificador.
     */
    @Test(timeout=2000)  // 2 seg para executar
    public void testBubbleSort() {
        Integer[] testeB = antesDoTeste();
        System.out.println("bubbleSort");
        long inicio = System.nanoTime();
        Classificador.bubbleSort(testeB);
        long fim = System.nanoTime();
        System.out.println("Tempo (ns) = "+nf.format(fim-inicio));

        int anterior = testeB[0];
        for (int o: testeB){
            if (o<anterior){
                fail("Não ordenado:"+anterior+" depois "+o);
            }
        }        
    }

    /**
     * Test of quickSort method, of class Classificador.
     */
    @Test(timeout=2000)  // 2 seg para executar
    public void testQuickSort() {
        System.out.println("quickSort");
        Integer[] testeQ = antesDoTeste();

        long inicio = System.nanoTime();
        Classificador.quickSort(testeQ);
        long fim = System.nanoTime();
        System.out.println("Tempo (ns) = "+nf.format(fim-inicio));

        int anterior = testeQ[0];
        for (int o: testeQ){
            if (o<anterior){
                fail("Não ordenado:"+anterior+" depois "+o);
            }
        }        
    }

    /**
     * Test of mergeSort method, of class Classificador.
     */
    @Test(timeout=2000)  // 2 seg para executar
    public void testMergeSort() {
        System.out.println("mergeSort");
        Integer[] testeM = antesDoTeste();
        
        long inicio = System.nanoTime();
        Classificador.mergeSort(testeM);
        long fim = System.nanoTime();
        System.out.println("Tempo (ns) = "+nf.format(fim-inicio));

        int anterior = testeM[0];
        for (int o: testeM){
            if (o<anterior){
                fail("Não ordenado:"+anterior+" depois "+o);
            }
        }        
    }
}
