import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}

public class DetectLoop {
    static boolean cycle(Node head){
        HashSet<Node> st = new HashSet<>();
        while(head!=null){
            if(st.contains(head))
                return true;
            st.add(head);
            head = head.next;
        }
        return false;
    }
    public static void main(String args[]){
        try (Scanner obj = new Scanner(System.in)){
        System.out.print("Enter the number of nodes:");
        int n = obj.nextInt();
        if(n<=0){
            obj.close();
            return;
        }
        System.out.println("Enter the node values:");
        Node head = new Node(obj.nextInt());
        Node temp = head;
        for(int i=1;i<n;i++){
            temp.next = new Node(obj.nextInt());
            temp = temp.next;
        }
        System.out.println("Enter the pos (1 to " + n + ",0 for no loop):");
        int pos = obj.nextInt();
        if(pos>0 && pos<=n){ //Only run if the position is valid
            Node loopNode = head; //Start a new pointer at the beginning(node at the user's chosen position.)
            for(int i=1;i<pos;i++){
                loopNode = loopNode.next;
            }
            temp.next = loopNode;//Connect the Tail to that target node
        }
        if (cycle(head))
            System.out.println("Loop detected: true");
        else
            System.out.println("Loop detected: false");

        obj.close();

    }
    
}
}