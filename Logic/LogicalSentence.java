public interface LogicalSentence{

    public boolean isValid();
    public boolean unsatisfiable();

    public boolean evaluate(TruthAssignment t);
}