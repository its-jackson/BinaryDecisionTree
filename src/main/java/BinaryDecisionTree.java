public abstract class BinaryDecisionTree implements Tree, Node {
   private final DecisionNode rootNode;

   private int failedAttempts;

   public abstract String getTreeName();
   public abstract boolean isTreeComplete();
   public abstract boolean isTreeValid();
   public abstract void setupTrueFalseNodes();

   public BinaryDecisionTree(DecisionNode rootNode) {
      this.rootNode = rootNode;
      setupTrueFalseNodes();
   }

   @Override
   public DecisionNode getRoot() {
      return rootNode;
   }

   @Override
   public Node getValidNode() {
      return getRoot().getValidNode();
   }

   public int getFailedAttempts() {
      return failedAttempts;
   }

   public void incrementFailedAttempts() {
      failedAttempts++;
   }

   public void resetFailedAttempts() {
      failedAttempts = 0;
   }
}
