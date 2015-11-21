package com.github.telesens.group.afanasiev;

/**
 * Created by oleg on 11/20/15.
 */
public class Arc<T> {
    public static class ErrorNodesInit extends Exception {
        public void printError() {
            System.err.println("ErrorNodesInit! Two nodes must be differ");
        }
    }

    private double tMin;
    private double sKm;
    private T startNode;
    private T finishNode;

    public Arc(T startNode, T finishNode, double sKm, double tMin) throws ErrorNodesInit {
        if (startNode.equals(finishNode))
                throw new ErrorNodesInit();

        this.startNode = startNode;
        this.startNode = startNode;
        this.finishNode = finishNode;
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
        return sKm * 60 / tMin;
    }

    @Override
    public String toString() {
        return
                "(From " + startNode + " to " + finishNode +
                        ", distance "+ sKm + " km, time " + tMin + " min, velocity " + String.format("%1$,.2f", velocity()) + " km/h)";
    }
}
