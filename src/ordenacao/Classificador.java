package ordenacao;

import javafx.scene.input.KeyCode;

/**
 *
 * @author marcel
 */
public class Classificador {

    public static <E extends Comparable> void bubbleSort(E[] vet) {
        int trocas = 0;
        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i].compareTo(vet[i + 1]) > 0) {
                E temp = vet[i];
                vet[i] = vet[i + 1];
                vet[i + 1] = temp;
                trocas++;
            }
        }
        if (trocas != 0) {
            bubbleSort(vet);
        }
    }

    public static <E extends Comparable> void quickSort(E[] vetor) {

    }

    public static <E extends Comparable> void mergeSort(E[] vetor) {
        int low = 0, high = 0, pi;
        for (int i = 1; i < vetor.length - 1; i++) {
            low = 0;
            high = vetor.length;
            if (vetor[i].compareTo(low) < 0) {
                low = i;
            }
            if (vetor[i].compareTo(high) > 0) {
                high = i;
            }
        }
        if (low < high) {
            E pivot = vetor[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (vetor[j].compareTo(pivot) <= 0) {
                    i++;
                    E temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
            E temp = vetor[i + 1];
            vetor[i + 1] = vetor[high];
            vetor[high] = temp;

            pi = i + 1;
            //mergeSort(vetor);
            //mergeSort(vetor);
        }
    }

}
