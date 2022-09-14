public class LinkedList{

    node head;
    public LinkedList(int h){
        head = new node(h,null);
    }

    public static void main(String[] args){
        int pass =0;
        int caught = 0;
        int lost = 0;
        int fail = 0;
        LinkedList list = new LinkedList(3);
        if (list.index(0).getVal() == 3) pass++; else fail++;
        list.push(1);
        list.push(4);
        try{
            System.out.println(list.index(3));
        }catch (RuntimeException a){
            if (a.getMessage().equals("LinkedListIndexOutOfBoundsException")){
                caught++;
            }else{
                lost++;
            }
        }
        list.push(9);
        if (list.printwalk().equals("3 1 4 9")) pass++; else fail++;
        
        list.delete(list.index(2));
        if (list.printwalk().equals("3 1 9")) pass++; else fail++;

        list.delete(list.index(0));
        if (list.printwalk().equals("1 9")) pass++; else fail++;

        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);
    }

    public void push(int n){
        node i = head;
        while (i.child != null){
            i = i.child;
        }
        i.child = new node(n,i);
    }

    public node index(int i)throws RuntimeException{
        node c = head;
        for (int j = 0; j<= i; j++){
            if (j == i) return c;
            try{ //doesn't work yet
                c = c.child;
            }catch(ArrayIndexOutOfBoundsException a){
                throw(new RuntimeException("LinkedListIndexOutOfBoundsException"));
            }
            if (c == null) throw(new RuntimeException("LinkedListIndexOutOfBoundsException"));   
        }
        return c;
    }


    public String printwalk(){
        node i = head;
        String ans = "";
        while (i.child != null){
            ans += String.valueOf(i) + " ";
            i = i.child;
        }
        ans += String.valueOf(i);
        return ans;
    }

    public void delete(node victim){
        if (victim.child == null) victim.parent.child = null;
        else{
            if (victim == head) head = victim.child;else victim.parent.child = victim.child;
            victim.child.parent = victim.parent;
        }
    }

}



class node{

    node child;
    node parent;
    int val;
    public node(int v, node p){
        val =v;
        parent = p;
    }

    public int getVal(){return val;}
    public String toString(){
        return String.valueOf(val);
    }
}