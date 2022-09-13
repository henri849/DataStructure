public class BinarySearchTree{
    private node root;

    public BinarySearchTree(int r){
        root = new node(r,null);
    }
    public static void main(String[] args){
        int pass =0;
        int fail = 0;
        BinarySearchTree tree = new BinarySearchTree(3);
        tree.Insert(1);
        tree.Insert(0);
        tree.Insert(3);

        tree.Insert(4);
        tree.Insert(5);
        tree.Insert(9);
        tree.Insert(6);
        if (tree.root.l_child.parent.equals(tree.root)) pass++; else fail++;
        if (tree.root.l_child.getVal() == 1) pass++; else fail++;
        if (tree.root.l_child.l_child.getVal() == 0) pass++; else fail++;
        if (tree.root.r_child.getVal() == 4) pass++; else fail++;

        node min = tree.minimum(tree.root);
        if (min.getVal() == 0) pass++; else fail++;

        if (tree.successor(min).getVal() == 1) pass++; else fail++;

        String pw = tree.printwalk();

        if (pw.equals("0 1 3 3 4 5 6 9 ")) pass++; else fail++;


        tree.delete(tree.root.l_child.l_child); // removing the 0 so a Scrub
        pw = tree.printwalk();
        if (pw.equals("1 3 3 4 5 6 9 ")) pass++; else fail++;

        tree.delete(tree.root.r_child.r_child); // removing the 5 so a splice
        pw = tree.printwalk();
        if (pw.equals("1 3 3 4 6 9 ")) pass++; else fail++;

        tree.Insert(0); //readding 0

        tree.delete(tree.root.l_child); // removing the 1 so a rotate
        pw = tree.printwalk();
        if (pw.equals("0 3 3 4 6 9 ")) pass++; else fail++;

        System.out.println("pass:"+pass + ", fail:" + fail);
    }
    public void delete(node victim){
        node l = victim.l_child;
        node r = victim.r_child;
        if (victim.parent == null) victim = null; // In the case where the root node is being deleted
        else if (l == null && r == null){ //scrub
            if (victim.parent.l_child.equals(victim)) victim.parent.l_child = null;
            else victim.parent.r_child = null;
        }
        else if (l == null && r != null){ //splice
            victim.parent.r_child = r;
        }
        else if (l != null && r == null){
            victim.parent.l_child = l;
        }else{ //rotate 
            rotate(victim);
        }
    }

    public void rotate(node victim){
        node l = victim.l_child;
        node r = victim.r_child;
        node p = minimum(r);
        if (p.parent.r_child.equals(p)) p.parent.r_child = null;
        else p.parent.l_child = null;

        if (victim.equals(victim.parent.r_child)){
            victim.parent.r_child =p;
        }else{
            victim.parent.l_child =p;
        }

        l.parent = p;
        r.parent = p;

        p.l_child = l;
        if (!p.equals(r))p.r_child = r;
        p.parent = victim.parent;
    }

    //Walks through the tree and produces string with every node in numeric order
    public String printwalk(){
        //print minimum
        String ans = "";
        node min = minimum(root);
        node last = min;
        node next = successor(min);

        ans += min + " "; 
        while (!next.equals(last)){
            ans += next + " "; 
            last = next;
            next = successor(next);
        }
        return ans;
    }
    //Finds next largest node
    public node successor(node start){
        node min = start;
        if (start.r_child != null) return minimum(start.r_child);
        node parent = start.parent;
        while (parent != null && start.equals(parent.r_child)){
            start = parent;
            parent = start.parent;
        }
        if ((parent == null && min.getVal() > start.getVal()) || min.getVal() > parent.getVal()) return min;
        return parent;
    }
    public node minimum(node top){
        if (top == null || top.l_child == null) return top;
        return minimum(top.l_child);
    }
    public void Insert(int n){
        find_insert(root, n);
    }

    public void find_insert(node spot, int n){
        if (n <= spot.getVal()){
            if (spot.l_child == null){ // if left doesn't exist
                spot.l_child = new node(n,spot);
            }else{
                find_insert(spot.l_child,n);
            }
        }else{
            if (spot.r_child == null){
                spot.r_child = new node(n,spot);
            }else{
                find_insert(spot.r_child,n);
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
    public String toString(){
        return String.valueOf(val);
    }
    public int getVal(){return val;}
}