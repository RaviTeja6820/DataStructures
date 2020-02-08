
/**
 * LinkedList
 */
public class LinkedList {
    public static void main(String[] args) {
        Node start = new Node(11);
        start.next = new Node(22);
        start.next.next = new Node(33);
        start.next.next.next = new Node(44);
        for(Node p = start; (p.next != null); p = p.next){
            System.out.println(p.data);
        }
    }
}