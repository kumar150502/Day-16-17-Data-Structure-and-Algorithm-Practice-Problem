import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "apple", "banana", "zebra"};
        System.out.println("The unsorted list is: " + Arrays.toString(words));
        mergeSort(words, 0, words.length - 1);
        System.out.println("The sorted list is: " + Arrays.toString(words));
    }

    private static void mergeSort(String[] words, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(words, lo, mid);
        mergeSort(words, mid + 1, hi);
        merge(words, lo, mid, hi);
    }

    private static void merge(String[] words, int lo, int mid, int hi) {
        String[] temp = new String[hi - lo + 1];
        int i = lo;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= hi) {
            if (words[i].compareTo(words[j]) < 0) {
                temp[k] = words[i];
                i++;
            } else {
                temp[k] = words[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = words[i];
            i++;
            k++;
        }

        while (j <= hi) {
            temp[k] = words[j];
            j++;
            k++;
        }

        for (int i = 0; i < temp.length; i++) {
            words[lo + i] = temp[i];
        }
    }
}
