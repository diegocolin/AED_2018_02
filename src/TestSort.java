
/**
 * @author darndt
 */
public class TestSort {

    public static void main(String[] args) {
        int vetor[] = {9, 0, 4, 2, 3, 8, 7, 1, 6, 5};

        BubbleSort bs = new BubbleSort(vetor);
        
        System.out.println("Bubble Sort:");
        System.out.println("Vetor não ordenado:");
        System.out.println(bs.toString());

        vetor = bs.bubbleSort();

        System.out.println("Vetor ordenado:");
        System.out.println(bs.toString());
    }
}
