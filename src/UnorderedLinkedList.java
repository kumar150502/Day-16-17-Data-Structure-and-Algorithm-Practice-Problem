import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class UnorderedLinkedList {
    private Node head;

    public UnorderedLinkedList() {
        head = null;
    }

    public void add(String word) {
        Node newNode = new Node(word);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(String word) {
        if (head == null) {
            return;
        }

        if (head.data.equals(word)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(word)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void saveToFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        Node current = head;
        while (current != null) {
            fileWriter.write(current.data + "\n");
            current = current.next;
        }
        fileWriter.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        UnorderedLinkedList unorderedLinkedList = new UnorderedLinkedList();
        while (scanner.hasNext()) {
            String word = scanner.next();
            unorderedLinkedList.add(word);
        }

        scanner.close();

        System.out.println("Enter a word to search: ");
        String word = scanner.next();
        if (unorderedLinkedList.contains(word)) {
            System.out.println("The word " + word + " is found");
        } else {
            System.out.println("The word " + word + " is not found");
        }

        unorderedLinkedList.saveToFile(file);
    }
}

class Node {

    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}
