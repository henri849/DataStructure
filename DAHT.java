public class DAHT{
    Data[] ht;
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        int caught = 0;
        int lost = 0;
        DAHT hasht = new DAHT();
        if (hasht != null)pass++; else fail++;

        hasht.insert(new Data(7,4));

        if (hasht.search(4).value == 7)pass++; else fail++;

        hasht.delete(4);


        try{
            if (hasht.search(4) != null)fail++;
        }catch (RuntimeException a){
            if (a.getMessage().equals("SearchRehashImpossible")){
                caught++;
            }else{
                System.out.println("0");
                lost++;
            }
        }

        //No longer possible with linear probing
        // try{
        //     hasht.insert(new Data(1,345));
        // }catch (RuntimeException a){
        //     if (a.getMessage().equals("HashTableInsertOverflow")){
        //         caught++;
        //     }else{
        //         lost++;
        //     }
        // }
        
        hasht.insert(new Data(5,0));
        hasht.insert(new Data(3,1));
        hasht.insert(new Data(2,2));

        //No longer possible with linear probing
        // try{
        //     hasht.delete(500);
        // }catch (RuntimeException a){
        //     if (a.getMessage().equals("HashTableDeleteOverflow")){
        //         caught++;
        //     }else{
        //         lost++;
        //     }
        // }

        if (hasht.search(0).value == 5)pass++; else fail++;
        
        try{
            if (hasht.search(50) != null)fail++;
        }catch (RuntimeException a){
            if (a.getMessage().equals("SearchRehashImpossible")){
                caught++;
            }else{
                lost++;
                System.out.println("1");
            }
        }


        //No longer possible with linear probing
        // try{
        //     hasht.search(500);
        // }catch (RuntimeException a){
        //     if (a.getMessage().equals("HashTableSearchOverflow")){
        //         caught++;
        //     }else{
        //         lost++;
        //         System.out.println("2");
        //     }
        // }

        hasht.insert(new Data(234,3));
        hasht.insert(new Data(32,4));
        try{
            hasht.insert(new Data(8,5));
        }catch (RuntimeException a){
            if (a.getMessage().equals("HashTableFilled")){
                caught++;
            }else{
                lost++;
                System.out.println("2");
            }
        }

        hasht.delete(3);
        hasht.delete(4);
        try{
            if (hasht.search(3) != null)fail++;
        }catch (RuntimeException a){
            if (a.getMessage().equals("SearchRehashImpossible")){
                caught++;
            }else{
                lost++;
                System.out.println("3");
            }
        }

        hasht.insert(new Data(89,3));
        if (hasht.search(3).value == 89)pass++; else fail++;

        hasht.insert(new Data(23,8));
        if (hasht.search(8).value == 23)pass++; else fail++;

        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);
    }
    public DAHT(){
        ht = new Data[5];
    }

    // Inserts Data objects at the index of the hashed data.key
    public void insert(Data x)throws RuntimeException{
        int k = x.key;
        int h = hash(k);
        try{
            while (ht[h] != null){
                // If we've gone full circle looking for a new spot
                if (h == (hash(x.key)-1 + ht.length) %ht.length) throw(new RuntimeException("HashTableFilled"));
                h = hash(++k);
            }
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableInsertOverflow"));
        }
        try{
             ht[h] = x;
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableInsertOverflow"));
        }
    }

    //Finds the presented datapoint in the Hash Table and switches it out for null
    public Data delete(int k){
        Data val;
        try{
            val = ht[hash(k)];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableDeleteOverflow"));
        }
        ht[hash(k)] = null; // quite unessesary but whatever
        return val;
    }

    //returns Data object for requested key integer
    public Data search(int k)throws RuntimeException{
        Data r;
        int h = rehash(k);
        try{
            r = ht[h];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableSearchOverflow"));
        }
        return r;
    }

    //Returns a hash, current set to be direct
    public int hash(int k){
        return k%ht.length; //just to cause colisions
    }

    //REHASHING FOR SEARCH
    public int rehash(int k) throws RuntimeException{
        int h = hash(k);
        if (ht[h] == null) throw(new RuntimeException("SearchRehashImpossible"));
        while (ht[h].key != k){
            // If we've gone full circle looking for a new spot
            if (h == hash(k)-1) throw(new RuntimeException("SearchRehashImpossible"));
            h++;
            h%= ht.length;
            if (ht[h] == null) throw(new RuntimeException("SearchRehashImpossible"));
        }
        return h;
    }
}

//Data objects, contains key, value pair
class Data{
    int key;
    int value;
    public Data(int v, int k){
        key = k;
        value = v;
    }
    public String toString(){
        return "Key:" + String.valueOf(key) + ", Value:" + String.valueOf(value);
    }
}