import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LinkedList
 */
public class LinkedList {
    Node start;
    public void insertion(int data){
        Node p = start;
        if(p != null){
            while(p.next != null){
                if(p.data >= data) break;
                p = p.next;
            }
            if(p.next == null && p.data < data) p.next = new Node(data);
            else {
                Node q = new Node(p.data);
                q.next = p.next;
                p.data = data;
                p.next = q;
            }
        } else {
            start = new Node(data);
        }
    }
    public void delete(int data){
        Node p = start;
        if(p != null)
        {
            while(p.next != null){
            if(p.next.data == data){
                p.next = p.next.next;
                break;
            }
            if(p.data == data) start = p.next;
            p = p.next;
            }
            if(p.data == data) start = null;
        }
    }
    public void display(){
        Node p = start;
        if(p != null)
        {
            while(p.next != null){
            System.out.println(p.data);
            p = p.next;
            }
            System.out.println(p.data);
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Insert new element in linked list :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList ll = new LinkedList();
        boolean exit = false;
        while(!exit)
        {
            System.out.println("Enter Option :\n 1.Insert \n 2.Delete \n 3.Display");
            int option = Integer.parseInt(br.readLine());
            switch(option){
                case 1: int data = Integer.parseInt(br.readLine()); ll.insertion(data); break;
                case 2: int del = Integer.parseInt(br.readLine()); ll.delete(del); break;
                case 3: ll.display(); break;
                default: exit = true;
            }
        }
    }
}