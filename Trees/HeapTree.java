public class HeapTree {
    private int[] Heap;
    private int size;
    private int maxsize;

    public HeapTree(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[1 + this.maxsize];
        Heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int pos) 
	{ 
		return pos / 2; 
    } 
    
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
    } 
    
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
    } 
    
    private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

    private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
    } 
    
    // private void maxHeapify(int pos) 
	// { 
	// 	if (isLeaf(pos)) 
	// 		return; 

	// 	if (Heap[pos] < Heap[leftChild(pos)] || 
	// 		Heap[pos] < Heap[rightChild(pos)]) { 

	// 		if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
	// 			swap(pos, leftChild(pos)); 
	// 			maxHeapify(leftChild(pos)); 
	// 		} 
	// 		else { 
	// 			swap(pos, rightChild(pos)); 
	// 			maxHeapify(rightChild(pos)); 
	// 		} 
	// 	} 
    // } 
    
    public void insertMax(int element) 
	{ 
		Heap[++size] = element; 

		// Traverse up and fix violated property 
		int current = size; 
		while (Heap[current] > Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	}
	
	public void insertMin(int element) 
    { 
        if (size >= maxsize) { 
            return; 
        } 
        Heap[++size] = element; 
        int current = size; 
  
        while (Heap[current] < Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    }
    
    // public int extractMax() 
	// { 
	// 	int popped = Heap[1]; 
	// 	Heap[1] = Heap[size--]; 
	// 	maxHeapify(1); 
	// 	return popped; 
    // } 
    
    public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
					Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree(15);
        heapTree.insertMin(10);
        heapTree.insertMin(20);
        heapTree.insertMin(30);
        heapTree.insertMin(40);
        heapTree.insertMin(50);
        heapTree.insertMin(60);
        heapTree.insertMin(70);
		heapTree.print();
    }
}