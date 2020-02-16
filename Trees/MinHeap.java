package Trees;
/**
 * MinHeap
 */
public class MinHeap {
    private int[] Heap;
    private int size;
    private int minsize;

    public MinHeap(int minsize){
        this.minsize = minsize;
        this.size = 0;
        this.Heap = new int[1 + this.minsize];
        Heap[0] = Integer.MIN_VALUE;
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

    private void minHeapify(int pos){
        if(isLeaf(pos)) return;

        if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
            if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    private void insertmin(int element){
        Heap[++size] = element;

        int current = size;
        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
        }
    }

    public int extractmin(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        minHeapify(1);
        return popped;
    }

    public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.println( " " + Heap[i] + " " + Heap[2 * i] + " " + Heap[(2 * i) + 1]);
		} 
    } 
    
    public static void main(String[] args) {
        MinHeap heapTree = new MinHeap(15);
        heapTree.insertmin(10);
        heapTree.insertmin(20);
        heapTree.insertmin(30);
        heapTree.insertmin(40);
        heapTree.insertmin(50);
        heapTree.insertmin(60);
        heapTree.insertmin(70);
		heapTree.print();
    }
}