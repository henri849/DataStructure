class Negation implements LogicalSentence {
    private LogicalSentence arg;
    public Negation(LogicalSentence a){
        arg = a;
    }
    public boolean isValid(){
        return arg.unsatisfiable();
    }
    public boolean evaluate(TruthAssignment ta){
        return !arg.evaluate(ta);
    }
    public boolean unsatisfiable(){
        return false; //dot product of kuzmaul vectors
    }
}