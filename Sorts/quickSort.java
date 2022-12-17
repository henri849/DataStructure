import java.util.Random;


class quickSort{


    public static int partition (int a[], int start, int end)  
    {  
        int pivot = a[end];
        int i = (start - 1);  
        for (int j = start; j <= end - 1; j++)  
        {  
            //current elem < pivot  
            if (a[j] < pivot)  
            {  
                i++;
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }  
        }  
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1);  
    }  


    public static void quickSort(int arr[], int start, int end){
        if (start < end){  
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);  
            quickSort(arr, p + 1, end);  
        }  
    }

    public static void main(String[] args){
        int pass=0;int fail=0;int caught=0;int lost=0;
        int[] a = {5,24,6,21};
        quickSort(a,0,a.length-1);
        if (a[0] == 5 && a[1] == 6 && a[2] ==21 && a[3] == 24)pass++; else fail++;
        a = new int[]{-5,32,6,12};
        quickSort(a,0,a.length-1);
        if (a[0] == -5 && a[1] == 6 && a[2] ==12 && a[3] == 32)pass++; else fail++;
        Random rand = new Random();


        for (int i = 1; i <= 10; i++){
            int[] b = new int[i*100000];
            for (int j = 0; j < i*100000; j++){
                b[j] = rand.nextInt(1000000);
            }
            final long startTime = System.currentTimeMillis();
            quickSort(b,0,i*100000-1);
            final long endTime = System.currentTimeMillis();
            System.out.println((i*100000) + " nums, " + (endTime-startTime) + " ms");
        }


        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);
    }

}