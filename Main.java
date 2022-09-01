public class Main{
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        Stack f = new Stack(10);
        f.push(3);
        if(f.pop() == 3) pass++;
        else fail++;
        System.out.println("pass:"+pass + " ,fail:" + fail);
    }
}