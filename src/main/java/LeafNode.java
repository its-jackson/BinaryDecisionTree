public abstract class LeafNode implements Node, Actionable {
    private BinaryDecisionTree subtree = null;

    public LeafNode() {}

    public LeafNode(BinaryDecisionTree subtree) {
        this.subtree = subtree;
    }

    public abstract String getStatus();

    @Override
    public Node getValidNode() {
        return this;
    }

    public BinaryDecisionTree getSubtree() {
        return subtree;
    }

    public void addOnSubtree(BinaryDecisionTree subtree) {
        this.subtree = subtree;
    }
}
