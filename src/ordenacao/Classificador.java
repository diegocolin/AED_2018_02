package ordenacao;

/**
 *
 * @author marcel
 */
public class Classificador {

    public static <E extends Comparable> void bubbleSort(E[] vetor) {
        int n = vetor.length - 1;
        boolean troca;
        for (int i = 0; i < n; i++) {
            troca = false;
            for (int j = n; j > i; j--) {
                if ((vetor[j - 1]).compareTo(vetor[j]) > 0) {
                    E temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    troca = true;
                }
            }
            if (!troca) {
                return;
            }
        }
    }

    private static <E extends Comparable> E[] quickSort(E[] a, int left, int right) {
        int i = left;
        int j = right;
        E x = a[left];

        while (i <= j) {
            while (a[i].compareTo(x) < 0) {
                i++;
            }
            while (x.compareTo(a[j]) < 0) {
                j--;
            }
            if (i <= j) {
                E temp = a[i];
                a[i] = a[j];
                i++;
                a[j] = temp;
                j--;
            }
        }
        if (left < j) {
            quickSort(a, left, j);
        }
        if (i < right) {
            quickSort(a, i, right);
        }
        return a;
    }

    public static <E extends Comparable> void quickSort(E[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static <E extends Comparable> E[] mergeSort(E[] a, int low, int height) {
        int l = low;
        int h = height;

        if (l >= h) {
            return a;
        }

        int mid = (l + h) / 2;

        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, h);

        int end_lo = mid;
        int start_hi = mid + 1;
        while ((l <= end_lo) && (start_hi <= h)) {
            if (a[l].compareTo(a[start_hi]) < 0) {
                l++;
            } else {
                E temp = a[start_hi];
                for (int k = start_hi - 1; k >= l; k--) {
                    a[k + 1] = a[k];
                }
                a[l] = temp;
                l++;
                end_lo++;
                start_hi++;
            }
        }
        return a;
    }

    public static <E extends Comparable> void mergeSort(E[] vetor) {
        mergeSort(vetor, 0, vetor.length - 1);
    }
}
