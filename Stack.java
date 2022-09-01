public class Stack{

    int[] stack;
    int place = 0;
    public Stack(int n){
        stack = new int[n];
    }
    public void push(int i) throws RuntimeException{
        if (place >= stack.length-1) throw(new RuntimeException("StackOverflow"));
        stack[place++] = i;
    }

    public int pop()throws RuntimeException{
        if (place <= 0) throw(new RuntimeException("StackUnderflow"));
        return stack[--place];
    }
}