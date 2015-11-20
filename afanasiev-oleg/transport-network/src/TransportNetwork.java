import java.util.*;

/**
 * Created by oleg on 11/20/15.
 */
public class TransportNetwork<T> {
    private Collection<Arc> arcs;
    private String name;

    public TransportNetwork(String name) {
        arcs = new ArrayList<>();
        this.name = name;
    }

    public String toString() {
        String str =
            "Transport network: " + name + ", count of arcs " + arcs.size();

        return str;
    }

    public Object[] getAllNodes() {
        Collection<T> nodes = new ArrayList<>();
        T startNode;
        T finishNode;

        for (Arc arc : arcs) {
            startNode = (T) arc.getStartNode();
            if (!arcs.contains(startNode))
                if (!nodes.contains(startNode))
                    nodes.add(startNode);

            finishNode = (T) arc.getFinishNode();
            if (!arcs.contains(finishNode))
                if (!nodes.contains(finishNode))
                    nodes.add(finishNode);
        }

        return nodes.toArray();  //**** ???? may be not the best idea to return type 'Object'
    }

    public Object[] getAllArcs() {
        return arcs.toArray();
    }

    public Object[] getNearestNodes(T srcNode) {
        Collection<T> nodes = new ArrayList<>();
        Collection<T> nodes1 = new ArrayList<>();
        T nextNode;

        for (Arc arc : arcs) {
            nextNode = (T) arc.getOppositeNode(srcNode);

            if (nextNode != null)
                nodes.add(nextNode);
        }

        for (T node : nodes) {
            if (!nodes1.contains(node))
                nodes1.add(node);

            for (Arc arc : arcs) {
                nextNode = (T) arc.getOppositeNode(node);

                if (nextNode != null && !nodes1.contains(nextNode) && !nextNode.equals(srcNode))
                    nodes1.add(nextNode);
            }
        }

        return nodes1.toArray();
    }

    public Object[] getOrderedNodes() {
        Object[] orderedNodes = getAllNodes();

        Arrays.sort(orderedNodes, (n1, n2) -> Integer.compare(countRelArcs((T) n1), countRelArcs((T) n2)));
        return orderedNodes;
    }

    public Arc getFastestArc() {
        return Collections.max(arcs, (s1, s2) -> Double.compare(s1.velocity(), s2.velocity()));
    }

    public void addArc(Arc newArc) {
        if (!arcs.contains(newArc))
            arcs.add(newArc);
    }

    private int countRelArcs(T node) {
        int count = 0;

        for (Arc arc : arcs) {
            if (arc.contains(node))
                count++;
        }

        return count;
    }
}
