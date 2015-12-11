package com.github.telesens.group.afanasiev.module_2_04;

/**
 * Created by oleg on 12/10/15.
 */
public class Main {
    private static String text = "beep boop beer!";
    public static void main(String[] args) {
        System.out.println("------------Huffman coding----------\n");
        HuffmanCodding hArc = new HuffmanCodding();
        Byte[] packed = hArc.code(text);
        System.out.printf("Packed: %s %n", packed);
        String extractedText = hArc.decode(packed);
        System.out.printf("Exctracted: %s, %n", extractedText);
    }
}
