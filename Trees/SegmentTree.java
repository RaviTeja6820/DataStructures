package Trees;

/**
 * SegmentTree
 */
public class SegmentTree {
    int[] nodes;

    SegmentTree(int[] arr, int n){

        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        int max_size = 2 * (int) Math.pow(2, height) - 1;

        nodes = new int[max_size];

        constructSTree(arr, 0, n - 1, 0);
    }

    public int constructSTree(int[] arr, int si, int ei, int ci){
        System.out.println(si + " " + ei);
        if(si == ei){
            nodes[ci] = arr[si];
            return arr[si];
        }

        int mid = getMid(si, ei);

        nodes[ci] = constructSTree(arr, si, mid, (ci * 2) + 1) + 
                    constructSTree(arr, mid + 1, ei, (ci * 2) + 2);
        return nodes[ci];
    }

    public int getMid(int s, int e){
        return (e+s)/2;
    }

    public int getSum(int si, int ei, int sq, int eq, int ci){

        if(sq <= si && eq >= ei){
            return nodes[ci];
        }

        if(ei < sq || si > eq){
            return 0;
        }

        int mid = getMid(si, ei);

        return getSum(si, mid, sq, eq, 2 * ci + 1) + 
                getSum(mid + 1, ei, sq, eq, 2 * ci + 2);
    }

    public int getSumInRange(int n, int sq, int eq){
        if(sq < 0 || eq > n - 1 || sq > eq){
            System.out.println("Invalid Input");
            return -1;
        }
        return getSum(0, n - 1, sq, eq, 0);
    }

    public void updateValue(int si, int ei, int i, int diff, int ci){
        if(i < si || i > ei){
            return;
        } 
        nodes[ci] = nodes[ci] + diff;

        if(ei != si){
            int mid = getMid(si, ei);
            updateValue(si, mid, i, diff, 2 * ci + 1);
            updateValue(mid + 1, ei, i, diff, 2 * ci + 2);
        }
    }

    public void updateValueOn(int[] arr, int n, int i, int newValue){
        if(i < 0 || i > n - 1){
            System.out.println("Invalid Input");
            return;
        }

        int diff = newValue - arr[i];

        arr[i] = newValue;

        updateValue(0, n - 1, i, diff, 0);
    }
    public static void main(String args[]){
        int[] arr = {1, 2, 5, 7, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr, n);

        System.out.println("Sum of value in range (1 - 3) is " + tree.getSumInRange(n, 1, 3));

        tree.updateValueOn(arr, n, 2, 10);

        System.out.println("Updated Sum of values in given range = " + tree.getSumInRange(n, 1, 3));
    }
}