public abstract class DecisionNode implements Node, Validatable {
    private Node trueNode;
    private Node falseNode;

    private boolean lastValidationResult;
    private long lastValidationTime, evaluationDelay;

    @Override
    public Node getValidNode() {
        long startTime = System.currentTimeMillis();

        if ((evaluationDelay <= 0) || (startTime - lastValidationTime >= evaluationDelay)) {
            lastValidationResult = isValid();
            lastValidationTime = startTime;
        }

        return lastValidationResult ? trueNode.getValidNode() : falseNode.getValidNode();
    }

    /**
     * This method sets the interval (in milliseconds) in which to evaluate this node.
     * For example, if this delay is set 5000,
     * then this decision node will only call its "isValid" method once every 5 seconds and cache the value.
     */
    public void setEvaluationDelay(long delay) {
        evaluationDelay = delay;
    }

    public void addOnTrueNode(Node node) {
        trueNode = node;
    }

    public void addOnFalseNode(Node node) {
        falseNode = node;
    }
}
