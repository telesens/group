package com.github.telesens.group.afanasiev;

import java.util.*;

/**
 * Created by oleg on 11/20/15.
 */
public class TransportNetwork<T> {
    private Collection<Arc<T>> arcs;
    private String name;

    public TransportNetwork(String name) {
        arcs = new ArrayList<>();
        this.name = name;
    }

    public String toString() {
        return "Transport network: " + name + ", count of arcs " + arcs.size();
    }

    public Collection<T> getAllNodes() {
        Collection<T> nodes = new ArrayList<>();
        T startNode;
        T finishNode;

        for (Arc<T> arc : arcs) {
            startNode = arc.getStartNode();
            if (!arcs.contains(startNode))
                if (!nodes.contains(startNode))
                    nodes.add(startNode);

            finishNode = arc.getFinishNode();
            if (!arcs.contains(finishNode))
                if (!nodes.contains(finishNode))
                    nodes.add(finishNode);
        }

        return nodes; 
    }

    public Collection<Arc<T>> getAllArcs() {
        return arcs;
    }

    public Collection<T> getNearestNodes(T srcNode) {
        Collection<T> nodesNext = new ArrayList<>();
        Collection<T> nodesNextAndNextByOne = new ArrayList<>();
        T nextNode;

        for (Arc<T> arc : arcs) {
            nextNode = arc.getOppositeNode(srcNode);

            if (nextNode != null)
                nodesNext.add(nextNode);
        }

        for (T node : nodesNext) {
            if (!nodesNextAndNextByOne.contains(node))
                nodesNextAndNextByOne.add(node);

            for (Arc<T> arc : arcs) {
                nextNode = arc.getOppositeNode(node);

                if (nextNode != null && !nodesNextAndNextByOne.contains(nextNode) && !nextNode.equals(srcNode))
                    nodesNextAndNextByOne.add(nextNode);
            }
        }

        return nodesNextAndNextByOne;
    }

    public Collection<T> getOrderedNodes() {
        Collection<T> orderedNodes = getAllNodes();

        Collections.sort((List<T>)orderedNodes, (n1, n2) -> Integer.compare(countRelArcsByNode(n1), countRelArcsByNode(n2)));
        return orderedNodes;
    }

    public Arc getFastestArc() {
        return Collections.max(arcs, (s1, s2) -> Double.compare(s1.velocity(), s2.velocity()));
    }

    public void addArc(Arc<T> newArc) {
        if (!arcs.contains(newArc))
            arcs.add(newArc);
    }

    private int countRelArcsByNode(T node) {
        int count = 0;

        for (Arc<T> arc : arcs) {
            if (arc.contains(node))
                count++;
        }

        return count;
    }
}
