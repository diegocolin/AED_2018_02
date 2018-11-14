
/**
 * @author darndt
 */
public class BubbleSort {

    private int vet[];

    public BubbleSort(int[] vet) {
        this.vet = vet;
    }
    
    public int[] bubbleSort() {
        int trocas = 0;
        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i] > vet[i + 1]) {
                int temp = vet[i];
                vet[i] = vet[i + 1];
                vet[i + 1] = temp;
                trocas++;
            }
        }
        if (trocas != 0) {
            bubbleSort();
        }
        return vet;
    }

    @Override
    public String toString() {
        String str = String.valueOf(vet[0]);
        for (int i = 1; i < vet.length; i++) {
            str += ", " + vet[i];
        }
        return str;
    }
}
