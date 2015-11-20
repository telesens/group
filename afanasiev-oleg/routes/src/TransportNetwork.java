import java.util.*;

/**
 * Created by oleg on 11/20/15.
 */
public class TransportNetwork<T> {
    private Collection<Section> sections;
    private String name;

    public TransportNetwork(String name) {
        sections = new ArrayList<Section>();
        this.name = name;
    }

    public String toString() {
        String str =
            "Transport network: " + name + ", count of sections " + sections.size();

        return str;
    }

    public Object[] getAllNodes() {
        Collection<T> nodes = new ArrayList<T>();
        T startNode;
        T finishNode;

        for (Section section : sections) {
            startNode = (T)section.getStartNode();
            if (!sections.contains(startNode))
                if (!nodes.contains(startNode))
                    nodes.add(startNode);

            finishNode = (T) section.getFinishNode();
            if (!sections.contains(finishNode))
                if (!nodes.contains(finishNode))
                    nodes.add(finishNode);
        }

        return nodes.toArray(); //*********????
    }

    public Object[] getAllSections() {
        return sections.toArray();
    }

    public Object[] getNearestNodes(T srcNode) {
        Collection<T> nodes = new ArrayList<T>();
        T nextNode;

        for (Section section : sections) {
            nextNode = (T)section.getStartNode(); // ****??? hard code
            if (isNearest(srcNode, nextNode))
                if (!nodes.contains(nextNode))
                    nodes.add(nextNode);

            nextNode = (T)section.getFinishNode();
            if (isNearest(srcNode, nextNode))
                if (!nodes.contains(nextNode))
                    nodes.add(nextNode);
        }

        return nodes.toArray();
    }

    public T[] getOrderedNodes() {
        T[] orderedSections = (T[])sections.toArray();

        Arrays.sort(orderedSections, (n1, n2) -> Integer.compare(countRelSections(n1), countRelSections(n2)));
        return orderedSections;
    }

    public Section getFastestSection() {
        return Collections.max(sections, (s1, s2)->Double.compare(s1.velocity(), s2.velocity()));
    }

    public void addSection(Section newSection) {
        if (!sections.contains(newSection))
            sections.add(newSection); // ? if exists
    }

    public int getCountSections() {
        return sections.size();
    }

    public Section getSectionByNumber(int n) {
        if (n >= 1 || n <= sections.size())
            return ((List<Section>)sections).get(n -1);
        else
            return null;
    }

    private boolean isNearest(T node1, T node2) {
        T oppositeNode;

        for (Section section : sections) {
            oppositeNode = (T)section.getOppositeNode(node1);

            if (oppositeNode != null)
                if (section.getOppositeNode(node1).equals(node2))
                    return true;
        }

        return false;
    }

    private int countRelSections(T node) {
        int count = 0;

        for (Section section : sections) {
            if (section.contains(node))
                count++;
        }

        return count;
    }

    //***** add same methods****
}
