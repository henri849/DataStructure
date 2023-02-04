class Implication implements LogicalSentence {
    LogicalSentence arg1;
    LogicalSentence arg2;

    public Implication(LogicalSentence arg1_, LogicalSentence arg2_){
        arg1 = arg1_;
        arg2 = arg2_;
    }

    public boolean evaluate(TruthAssignment ta){
        return arg1.evaluate(ta) || !arg2.evaluate(ta);
    }
    // public boolean isValid(){
    //     return arg1.isValid() && arg2.isValid();
    // }

    public boolean unsatisfiable(){
        allmypc = Union()
        for (TruthAssignment e: allTruthAssignments(allmypc))
    }
}