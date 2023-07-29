import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "apple", "banana", "zebra"};
        System.out.println("The unsorted list is: " + Arrays.toString(words));
        insertionSort(words);
        System.out.println("The sorted list is: " + Arrays.toString(words));
    }

    public static void insertionSort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String current = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].compareTo(current) > 0) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = current;
        }
    }
}
