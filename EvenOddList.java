import java.util.Scanner;
import java.util.ArrayList;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next  = null;
        }
    }
public class EvenOddList {
    static Node segregateEvenOdd(Node head){
        if(head==null || head.next==null)
            return head;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        Node temp = head;
        int index = 1;
        while(temp!=null){
            if(index%2==1){
                odd.add(temp.data);
            }
            else{
                even.add(temp.data);
            }
            temp = temp.next;
            index++;
        }
        odd.addAll(even);
        temp = head;
        int i = 0;
        while(temp!=null){
            temp.data = odd.get(i);
            i++;
            temp = temp.next;
        }
        return head;

    }
    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter no of nodes:");
        int n = obj.nextInt();
        if(n==0){
            System.out.print("List is empty");
            obj.close();
            return;
        }
        System.out.print("Enter node values:");
        int val = obj.nextInt();
        Node head = new Node(val);
        Node tail = head;
        for(int i=1;i<n;i++){
            val = obj.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        System.out.println("Original List:");
        printList(head);
        head = segregateEvenOdd(head);
        System.out.println("After segregation:");
        printList(head);
        obj.close();
    }
}
