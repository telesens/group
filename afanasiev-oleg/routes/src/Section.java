/**
 * Created by oleg on 11/20/15.
 */
public class Section<T> {
    public static class ErrorNodesInit extends Exception {
        public void printError() {
            System.err.println("ErrorNodesInit! Two nodes must be differ");
        }
    }

    private double tMin;
    private double sKm;
    private T startNode;
    private T finishNode;

    public Section(T startNode, T finishNode, double sKm, double tMin) throws ErrorNodesInit {
        if (startNode.equals(finishNode))
                throw new ErrorNodesInit();

        this.startNode = startNode;
        this.finishNode = finishNode;
        this.sKm = sKm;
        this.tMin = tMin;
    }

    //******* in progress ******
    public Section(String startNodeName, String finishNodeName, double sKm, double tMin) throws ErrorNodesInit  {
        if (startNodeName.equals(finishNodeName))
            throw new ErrorNodesInit();

        this.sKm = sKm;
        this.tMin = tMin;
    }

    public T getStartNode() {
        return startNode;
    }

    public T getFinishNode() {
        return finishNode;
    }

    public T getOppositeNode(T node) {
        if (startNode.equals(node))
            return finishNode;

        if (finishNode.equals(node))
            return startNode;

        return null;
    }

    public boolean contains(T node) {
        if (startNode.equals(node) || finishNode.equals(node))
            return true;
        else
            return false;
    }

    /**
     *
     * @return velocity on km/h unit
     */
    public double velocity() {
        return sKm / (tMin * 60);
    }

    @Override
    public String toString() {
        String str =
                "Start node: " + startNode + ", finish node " + finishNode +
                        ", distance "+ sKm + " time " + tMin + ", velocity " + velocity();

        return str;
    }
}
