import java.util.HashMap;
import java.util.Map;

class TruthAssignment{
    private HashMap<String,Boolean> theRep = new HashMap();

    public static void main(String[] args){
        int pass = 0; int fail = 0;
        TruthAssignment ta = new TruthAssignment();
        ta.add("a",false);
        ta.add("s",true);
        ta.add("g",false);
        ta.add("l",false);
        if (!ta.get("a")) pass++; else fail++;
        if (ta.get("s")) pass++; else fail++;
        if (!ta.get("g")) pass++; else fail++;
        if (!ta.get("l")) pass++; else fail++;
        ta.add("a",true);
        if (ta.get("a")) pass++; else fail++;
        TruthAssignment ta2 = new TruthAssignment(5,new String[] {"a","b","c"});
        System.out.println("pass:"+pass + ", fail:" + fail);
    }
    public TruthAssignment(){}
    public TruthAssignment(int k, String[] c){
        k-=1;
        String bin = "0".repeat(c.length - Integer.toBinaryString(k).length()) + Integer.toBinaryString(k);
        for (int i = 0; i < c.length; i++){
            this.add(c[i],bin.charAt(bin.length() - i -1) == '1');
        }
    }


    public String toString(){
        String rtn = "";
        for (Map.Entry<String, Boolean> mElem: theRep.entrySet()){
            rtn += mElem.getKey() + " :: " + mElem.getValue();
            rtn += "\n";
        }
        return rtn;
    }
    public void add(String proC, boolean value){
        theRep.put(proC,value);
    }
    public boolean get(String value){
        return theRep.get(value);
    }
}