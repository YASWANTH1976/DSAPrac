import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LoopDetection {
    public static boolean detectLoop(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }

        return false;

    }
}