import java.io.*;
import java.util.*;

class pickingFactories{

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        // I supose the input would be 
        //N
        //p_0 
        //P_1
        //P_i
        int n = sc.nextInt();//number of factories
        int inc = sc.nextInt(); // 108
        int exc = 0; //12
        for (int i =1; i < n; i++){
            int exc2 =Math.max(inc, exc); // 108

            inc = exc + sc.nextInt();
            System.out.println(":: Ex:" + exc2 + ", In:" + inc);
            exc = exc2; 
        }
        System.out.println(Math.max(inc, exc));

        //8, 5 ,3, 100, 2v, 10
    }
}