
import java.util.Random;

class radixSort{

    public static void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    // Function to get the largest element from an array
    public static int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    public static void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
        countingSort(array, size, place);
    }
    public static void printwalk(int[] a){
        for (int j = 0; j< a.length; j++){
            System.out.println(a[j]);
        }
    }
    public static void main(String args[]) {
        int[] a = { 231, 123, 231, 422, 21, 1, 2};

        radixSort.radixSort(a,a.length);
        // radixSort.printwalk(a);
        
        Random rand = new Random();
        for (int i = 1; i <= 10; i++){
            int[] b = new int[i*100000];
            for (int j = 0; j < i*100000; j++){
                b[j] = rand.nextInt(999);
            }
            final long startTime = System.currentTimeMillis();
            radixSort.radixSort(b,i*100000);
            final long endTime = System.currentTimeMillis();
            System.out.println((i*100000) + " nums, " + (endTime-startTime) + " ms");
        }
    }
}