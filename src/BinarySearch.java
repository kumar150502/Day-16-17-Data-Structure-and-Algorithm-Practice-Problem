import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        String[] words = scanner.nextLine().split(",");
        Arrays.sort(words);
        System.out.println("Enter the word to be searched: ");
        String word = scanner.next();
        int index = binarySearch(words, word);
        if (index > -1) {
            System.out.println("The word " + word + " was found at index " + index);
        } else {
            System.out.println("The word " + word + " was not found");
        }
    }

    public static int binarySearch(String[] words, String word) {
        int low = 0;
        int high = words.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (words[mid].equals(word)) {
                return mid;
            } else if (words[mid].compareTo(word) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
