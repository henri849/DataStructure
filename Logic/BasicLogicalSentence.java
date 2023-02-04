class BasicLogicalSentence implements LogicalSentence{
    public String pc;
    public BasicLogicalSentence(String n){pc =n;}
    public boolean isValid(){
        return false;
    }
    public boolean unsatisfiable(){
        return false;
    }
    public boolean evaluate(TruthAssignment ta){
        return ta.get(pc);
    }
}