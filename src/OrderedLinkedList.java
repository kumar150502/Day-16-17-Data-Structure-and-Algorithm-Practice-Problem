import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class OrderedLinkedList {
    private Node head;

    public OrderedLinkedList() {
        head = null;
    }

    public void add(int number) {
        Node newNode = new Node(number);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            Node previous = null;
            while (current != null && current.data < number) {
                previous = current;
                current = current.next;
            }

            if (current == null) {
                previous.next = newNode;
            } else {
                newNode.next = current;
                previous.next = newNode;
            }
        }
    }

    public void remove(int number) {
        if (head == null) {
            return;
        }

        if (head.data == number) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != number) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        previous.next = current.next;
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
        File file = new File("numbers.txt");
        Scanner scanner = new Scanner(file);
        OrderedLinkedList orderedLinkedList = new OrderedLinkedList();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            orderedLinkedList.add(number);
        }

        scanner.close();

        System.out.println("Enter a number to search: ");
        int number = scanner.nextInt();
        if (orderedLinkedList.contains(number)) {
            System.out.println("The number " + number + " is found");
        } else {
            System.out.println("The number " + number + " is not found");
        }

        orderedLinkedList.saveToFile(file);
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
