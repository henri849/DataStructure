import java.util.Random;

class HeapSort{

    public static void sort(int arr[]){
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int arr[], int N, int i){
        int largest = i; // Initialize largest as root
        int l = leftChild(i);
        int r = rightChild(i);
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }
 
    public static void printwalk(int[] heap){
        for (int j = 0; j< heap.length; j++){
            System.out.println(heap[j]);
        }
    }

    public static void main(String[] args){
        int[] a = {9,8,3,1,5,2};
        HeapSort.sort(a);

        Random rand = new Random();
        for (int i = 1; i <= 10; i++){
            int[] b = new int[i*100000];
            for (int j = 0; j < i*100000; j++){
                b[j] = rand.nextInt(1000000);
            }
            final long startTime = System.currentTimeMillis();
            HeapSort.sort(b);
            final long endTime = System.currentTimeMillis();
            System.out.println((i*100000) + " nums, " + (endTime-startTime) + " ms");
        }
    }
    public static int parent(int pos) { return (pos - 1) / 2; }
    public static int leftChild(int pos) { return (2 * pos) + 1;}
    public static int rightChild(int pos){return (2 * pos) + 2;}

}