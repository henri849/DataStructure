public class BinarySearchTree{
    private node root;

    public BinarySearchTree(node r){
        root = r;
    }
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree(new node(3,null));
        Insert(1);
        Insert(1);
        Insert(3);

        Insert(4);
        Insert(5);
        Insert(9);
        Insert(6);
    }
    public void printwalk(){
        //print minimum
        //print sucsessor
    }

    public node minimum(node top = root){
        if (top == null || top.l_child == null) return top;
        return minimum(top.l_child)
    }
    public void Insert(node n){
        find_insert(root, n) = n;
    }

    public void find_insert(node spot, node n){
        if (spot == null){
            return spot;
        }else{
            if (n.getVal() <= spot.getVal()){
                if (spot.l_child == null){ // if left doesn't exist
                    return spot.l_child;
                }else{
                    find_insert(spot.l_child,n);
                }
            }else{
                if (spot.r_child == null){
                    return spot.r_child;
                }else{
                    find_insert(spot.r_child,n);
                }
            }
            
        }
    }

}

class node{

    node l_child;
    node r_child;
    node parent;
    int val;
    public node(int v, node p){
        val = v;
        parent = p;
    }

    public int getVal(){return val;}

}