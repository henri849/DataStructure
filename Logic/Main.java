class Main{

    public static void main(String[] args){
        int pass = 0; int fail =0;
        BasicLogicalSentence a = new BasicLogicalSentence("a");
        TruthAssignment ta = new TruthAssignment();
        ta.add("a",false);
        if (!a.evaluate(ta)) pass++; else fail++;
        if (new Negation(a).evaluate(ta)) pass++; else fail++;
        if (!new Conjunction(new Negation(a),a).evaluate(ta)) pass++; else fail++;

        System.out.println(pass + " passed, " + fail + " failed");
    }

}