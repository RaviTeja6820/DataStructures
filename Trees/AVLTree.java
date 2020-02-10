/**
 * AVLTree
 */
public class AVLTree {
    int key, height;
    AVLTree left, right;
    
    public static final AVLTree NIL = new AVLTree();

    AVLTree(){
        left = right = null;
        height = -1;
    }

    AVLTree(int key){
        this.key = key;
        left = right = NIL;
        height = 1;
    }

    AVLTree(int key, AVLTree left, AVLTree right){
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + left.size() + right.size();
    }

    public void add(int key){
        int oldSize = size();
        grow(key);
    }

    public AVLTree grow(int key){
        if(this == NIL) return new AVLTree(key);
        if (key == this.key) return this;
        if(key < this.key) left = left.grow(key);
        else {right = right.grow(key);}
        rebalance();
        height = 1 + Math.max(left.height, right.height);
        return this;
    }

    public void rebalance(){
        if(right.height > left.height + 1){
            if(right.left.height > right.right.height) right.rotateRight();
            rotateLeft();
        } else if(left.height > right.height + 1){
            if(left.right.height > left.left.height) left.rotateLeft();
            rotateRight();
        }
    }

    public void rotateLeft(){
        left = new AVLTree(key, left, right.left);
        key = right.key;
        right = right.right;
    }

    public void rotateRight(){
        right = new AVLTree(key, left.right, right);
        key = left.key;
        left = left.left;
    }

    public int size(){
        if(this == NIL) {return 0;};
        return 1;
    }

    public String toString(){
        if(this == NIL) return "";
        return left + " " + key + " " + right;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree(10);
        tree.add(11);
        tree.add(12);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(13);
        System.out.println(tree);
    }
}