public class Main{
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        Stack f = new Stack(10);
        f.push(3);
        f.push(5);


        if(f.pop() == 5) pass++;
        else fail++;
        f.push(7);
        if(f.pop() == 7) pass++;
        else fail++;
        if(f.pop() == 3) pass++;
        else fail++;

        f.push(3);
        f.push(5);
        for (int i = 0; i < 3; i++){
            try{
                f.pop();
            }catch (RuntimeException a){
                System.out.println(a);
            }
        }
        
        System.out.println("pass:"+pass + " ,fail:" + fail);
    }
}