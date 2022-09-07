public class BinarySearchTree{
    private node root;

    public BinarySearchTree(node r){
        root = r;
    }
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree(new node(7,null));
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

}