package Trees;

import java.util.ArrayList;

/**
 * BinaryTree
 */
public class BinaryTree {
    Node root;
    BinaryTree(){
        this.root = null;
    }
    BinaryTree(int data){
        this.root = new Node(data);
    }
    public void insert(int data){
        Node p = root;
        while(true){
            if(data <= p.data){
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if(p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }
    public void displayLevel(){
        Node p = root;
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(p);
        while(true){
            System.out.print(queue.get(0).data + " ");
            if(queue.get(0).left != null){
                queue.add(queue.get(0).left);
            }
            if(queue.get(0).right != null){
                queue.add(queue.get(0).right);
            }
            queue.remove(0);
            if (queue.size() == 0) {
                break;
            }
        }
    }
    public void displayInOrder(Node next){
        Node p = next;
        if(p.left != null){
            displayInOrder(p.left);
        }
        System.out.print(p.data + " ");
        if(p.right != null){
            displayInOrder(p.right);
        }
    }
    public void displayPreOrder(Node next){
        Node p = next;
        if(p.left != null){
            displayPreOrder(p.left);
        }
        if(p.right != null){
            displayPreOrder(p.right);
        }
        System.out.print(p.data + " ");
    }
    public void displayPostOrder(Node next){
        Node p = next;
        System.out.print(p.data + " ");
        if(p.left != null){
            displayPostOrder(p.left);
        }
        if(p.right != null){
            displayPostOrder(p.right);
        }
    }
public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(50);
    tree.insert(52);
    tree.insert(51);
    tree.insert(53);
    tree.insert(48);
    tree.insert(49);
    tree.insert(47);
    tree.displayLevel(); System.out.println("\n");
    tree.displayInOrder(tree.root); System.out.println("\n");
    tree.displayPreOrder(tree.root); System.out.println("\n");
    tree.displayPostOrder(tree.root); System.out.println("\n");
}    
}