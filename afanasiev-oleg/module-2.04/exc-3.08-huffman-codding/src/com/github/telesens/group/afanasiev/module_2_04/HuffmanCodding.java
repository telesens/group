package com.github.telesens.group.afanasiev.module_2_04;

import java.util.PriorityQueue;

/**
 * Created by oleg on 12/11/15.
 */
public class HuffmanCodding {
    private PriorityQueue<HuffmanTree<Character>> freqChars;
    private HuffmanTree<Character> hTree;

    public HuffmanCodding() {

        freqChars = initFreqChars();
        hTree = createHTree();
    }

    public Byte[] code(String text) {
        for (int i = 0; i < text.length(); i++) {

        }
    }

    public String decode(Byte[] code) {

    }

    private PriorityQueue<HuffmanTree<Character>> initFreqChars() {
        freqChars = new PriorityQueue<>((ch1, ch2)->(Integer.compare(ch1.getWeight(), ch2.getWeight())));

        freqChars.add(new HuffmanTree<>('r', 1));
        freqChars.add(new HuffmanTree<>('!', 1));
        freqChars.add(new HuffmanTree<>('p', 2));
        freqChars.add(new HuffmanTree<>(' ', 2));
        freqChars.add(new HuffmanTree<>('o', 2));
        freqChars.add(new HuffmanTree<>('b', 3));
        freqChars.add(new HuffmanTree<>('e', 4));

        return freqChars;
    }

    private HuffmanTree createHTree() {
        HuffmanTree<Character> hTree;
        HuffmanTree<Character> node1, node2;

        while(freqChars.size() != 1) {
            node1 = freqChars.poll();
            node2 = freqChars.poll();

            hTree = new HuffmanTree<>(node1, node2);
            freqChars.add(hTree);
        }

        return freqChars.poll();
    }
}
