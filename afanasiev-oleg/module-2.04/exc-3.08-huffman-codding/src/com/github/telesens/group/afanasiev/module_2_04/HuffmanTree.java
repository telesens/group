package com.github.telesens.group.afanasiev.module_2_04;

/**
 * Created by oleg on 12/11/15.
 */
public class HuffmanTree<T> {

    private class Node<T> {

        public Node(T ch, int weight) {
            this.ch = ch;
            this.weight = weight;

            leftNode = null;
            rightNode = null;
        }

        public Node(Node leftNode, Node rightNode) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;

            ch = null;
            weight = leftNode.weight + rightNode.weight;
        }

        private T ch;
        private int weight;

        private Node leftNode;
        private Node rightNode;
    }

    private Node root;

    public HuffmanTree(T ch, int weight) {
        root = new Node(ch, weight);
    }

    public HuffmanTree(HuffmanTree treeLeft, HuffmanTree treeRight) {
        root = new Node(treeLeft.root, treeRight.root);
    }

    public int getWeight() {
        return root.weight;
    }
}
