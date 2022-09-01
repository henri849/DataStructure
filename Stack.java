public class Stack{

    int[] stack;
    int place = 0;
    public Stack(int n){
        stack = new int[n];
    }
    public void push(int i) throws RuntimeException{
        try{
            stack[place++] = i;
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("StackOverflow"));
        }
    }
    public int pop()throws RuntimeException{
        try{
            return stack[--place];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("StackUnderflow"));
        }
    }
    public java.lang.Integer peek(){
        if (place == 0) return null;
        else{
            return stack[place-1];
        }
    
    }
}