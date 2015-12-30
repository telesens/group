package com.github.telesens.group.afanasiev.module_2_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleg on 12/11/15.
 */
public class HuffmanTree<T> implements Comparable<HuffmanTree<T>> {

    private class Node<T> {

        public Node(T el, long weight) {
            this.el = el;
            this.weight = weight;

            leftNode = null;
            rightNode = null;
        }

        public Node(Node leftNode, Node rightNode) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;

            el = null;
            weight = leftNode.weight + rightNode.weight;
        }

        private T el;
        private long weight;

        private Node leftNode;
        private Node rightNode;
    }

    private Node root;
    private Map<T, BitsCollector> tableOfCorrespondence;

    public HuffmanTree(T el, long weight) {
        root = new Node(el, weight);
    }

    public HuffmanTree(HuffmanTree treeLeft, HuffmanTree treeRight) {
        root = new Node(treeLeft.root, treeRight.root);
    }

    public HuffmanTree(Map<T, BitsCollector> tableOfCorrespondence) {
        this.tableOfCorrespondence = tableOfCorrespondence;
        root = new Node<T>(null, 0);
        builtNodesByTableOfCorrespondence();
    }

    public long getWeight() {
        return root.weight;
    }

    public void createTableOfCorrespondence() {
        tableOfCorrespondence = new HashMap<>();
        traverseTree(root, new BitsCollector());
    }

    public void compressEl(T el, BitsCollector dst) {
        BitsCollector decodedBits = tableOfCorrespondence.get(el);
        dst.pushBitsFrom(decodedBits);
    }

    public void decodeEl(BitsCollector bitsPacked, ArrayList<Byte> collectorEl) {
        decodeElIter(bitsPacked, root, collectorEl);
    }

    public void decodeElIter(BitsCollector bitsPacked, Node<T> curNode, ArrayList<Byte> collectorEl) {

        if (curNode.el != null) {
            collectorEl.add((Byte) curNode.el);
            decodeElIter(bitsPacked, root, collectorEl);
            return;
        }

        if (bitsPacked.size() == 0)
            return;

        if (bitsPacked.pollBit() == 1) {
            decodeElIter(bitsPacked, curNode.rightNode, collectorEl);
        } else {
            decodeElIter(bitsPacked, curNode.leftNode, collectorEl);
        }
    }

    public Map<T, BitsCollector> getTableOfCorrespondence() {
        return tableOfCorrespondence;
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return Long.compare(this.getWeight(), o.getWeight());
    }

    private void traverseTree(Node<T> node, BitsCollector bitsCollector) {
        if (node.leftNode == null) {// check node.rightNode == null doesn't have any sense
            tableOfCorrespondence.put((T) node.el, bitsCollector.clone());
            //return;
        } else {

            bitsCollector.pushBit(0);
            traverseTree(node.leftNode, bitsCollector);
            bitsCollector.removeLastBit();

            bitsCollector.pushBit(1);
            traverseTree(node.rightNode, bitsCollector);
            bitsCollector.removeLastBit();
        }
    }

    private void builtNodesByTableOfCorrespondence() {
        for (Map.Entry<T, BitsCollector> entry : tableOfCorrespondence.entrySet()) {
            addNode(root, entry.getKey(), entry.getValue());
        }
    }

    private void addNode(Node<T> node, T el, BitsCollector bits) {

        if (bits.size() == 0) {
            node.el = el;
            return;
        }

        int nextBit = bits.pollBit();

        if (nextBit == 0) {
            if (node.leftNode == null)
                node.leftNode = new Node<T>(null, 0);

            addNode(node.leftNode, el, bits);
        } else {
            if (node.rightNode == null)
                node.rightNode = new Node<T>(null, 0);

            addNode(node.rightNode, el, bits);
        }
    }
}
