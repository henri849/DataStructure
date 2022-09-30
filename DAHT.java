public class DAHT{
    Data[] ht;
    public static void main(String[] args){
        int pass = 0;
        int fail = 0;
        int caught = 0;
        int lost = 0;
        DAHT hasht = new DAHT();
        if (hasht != null)pass++; else fail++;

        hasht.insert(new Data(7,19));

        if (hasht.search(19).value == 7)pass++; else fail++;

        hasht.delete(new Data(7,19));

        if (hasht.search(19) == null)pass++; else fail++;

        try{
            hasht.insert(new Data(1,345));
        }catch (RuntimeException a){
            if (a.getMessage().equals("HashTableInsertOverflow")){
                caught++;
            }else{
                lost++;
            }
        }
        
        hasht.insert(new Data(5,19));
        hasht.insert(new Data(3,98));
        hasht.insert(new Data(2,76));


        try{
            hasht.delete(new Data(5,500));
        }catch (RuntimeException a){
            if (a.getMessage().equals("HashTableDeleteOverflow")){
                caught++;
            }else{
                lost++;
            }
        }

        if (hasht.search(19).value == 5)pass++; else fail++;
        
        if (hasht.search(50) == null)pass++; else fail++;

        try{
            hasht.search(500);
        }catch (RuntimeException a){
            if (a.getMessage().equals("HashTableSearchOverflow")){
                caught++;
            }else{
                lost++;
            }
        }
        System.out.println("pass:"+pass + ", fail:" + fail + ", caught exceptions:"+caught + ", lost exceptions:" + lost);
    }
    public DAHT(){
        ht = new Data[100];
    }

    // Inserts Data objects at the index of the hashed data.key
    public void insert(Data x)throws RuntimeException{
        try{
            ht[hash(x.key)] = x;
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableInsertOverflow"));
        }
    }

    //Finds the presented datapoint in the Hash Table and switches it out for null
    public Data delete(Data x){
        Data val;
        try{
            val = ht[hash(x.key)];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableDeleteOverflow"));
        }
        ht[hash(x.key)] = null; // quite unessesary but whatever
        return val;
    }

    //returns Data object for requested key integer
    public Data search(int k)throws RuntimeException{
        Data r;
        try{
            r = ht[hash(k)];
        }catch(ArrayIndexOutOfBoundsException a){
            throw(new RuntimeException("HashTableSearchOverflow"));
        }
        return r;
    }

    //Returns a hash, current set to be direct
    public int hash(int k){
        return k;
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