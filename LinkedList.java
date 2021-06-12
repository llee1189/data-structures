import java.util.Scanner;

public class LinkedList {
    Node head;
    Node temp;
    static class Node {
        int data;
        Node next = null;
        Node(int d) {
            data = d;
        }
    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        createHead(list);
        continueList(list);
        System.out.println("Head: " + list.head.data);
        list.temp = list.head.next;
        while (list.temp != null) {
            System.out.println("Next: " + list.temp.data);
            list.temp = list.temp.next;
        }
    }

    static void createHead(LinkedList l) {
        int value;
        Scanner sc = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.println("Choose the head value...");
            try {
                value = sc.nextInt();
                sc.nextLine();
                l.head = new Node(value);
                l.temp = l.head;
                success = true;
            }
            catch (Exception e) {
                sc.nextLine();
                System.out.println("ERROR: You did not enter a valid number.");
                System.out.println("");
            }
        }
    }

    static void continueList(LinkedList l) {
        String yn;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Continue? (y/n)");
            yn = sc.nextLine();
            if (yn.equals("y")) {
                int value;
                System.out.println("Choose the next value.");
                value = sc.nextInt();
                sc.nextLine();
                l.temp.next = new Node(value);
                l.temp = l.temp.next;
                continue;
            } else if (yn.equals("n")) {
                break;
            } else {
                System.out.println("ERROR: Could not understand input.");
            }
        }

    }
}