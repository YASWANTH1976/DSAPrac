import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class EvenOdd {
    public static Node oddEvenList(Node head) {
        if (head == null)
            return head;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        Node temp = head;
        int index = 1;
        while (temp != null) {
            if (index % 2 == 1)
                odd.add(temp.data);
            else
                even.add(temp.data);
            temp = temp.next;
            index++;
        }
        temp = head;
        for (int val : odd) {
            temp.data = val;
            temp = temp.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the number of nodes:");
        int n = obj.nextInt();
        if (n == 0) {
            System.out.println("List is empty");
            obj.close();
            return;
        }
        System.out.print("Enter node values:");
        Node head = new Node(obj.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(obj.nextInt());
            tail = tail.next;
        }
        System.out.print("Original List:");
        printList(head);
        head = oddEvenList(head);
        System.out.print("After segregation");
        printList(head);
        obj.close();

    }
}