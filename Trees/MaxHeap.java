package Trees;
/**
 * MaxHeap
 */
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[1 + this.maxsize];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return (2 * pos);
    }

    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        if(pos >= (size/2) && pos <= size){
            return true;
        }
        return false;
    }

    public void swap(int first, int second){
        int temp;
        temp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = temp;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos)) return;

        if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]){
            if(Heap[leftChild(pos)] < Heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    private void insertMax(int element){
        Heap[++size] = element;

        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
        }
    }

    public int extractMax(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.println( " " + Heap[i] + " " + Heap[2 * i] + " " + Heap[(2 * i) + 1]);
		} 
    } 
    
    public static void main(String[] args) {
        MaxHeap heapTree = new MaxHeap(15);
        heapTree.insertMax(10);
        heapTree.insertMax(20);
        heapTree.insertMax(30);
        heapTree.insertMax(40);
        heapTree.insertMax(50);
        heapTree.insertMax(60);
        heapTree.insertMax(70);
		heapTree.print();
    }
}