package com.github.telesens.group.afanasiev.module_2_04;

import java.util.*;

/**
 * Created by oleg on 12/11/15.
 */
public class HuffmanCodding {

    public byte[] code(byte[] bytesContent, int length) {

        Map<Byte, Long> tableFrequency = fillFrequencyTable(bytesContent, length);
        PriorityQueue<HuffmanTree<Byte>> queueOrderedBytes = fillQueueOrderedBytes(tableFrequency);
        HuffmanTree<Byte> hTree = createHTree(queueOrderedBytes);

        BitsCollector packedBits = new BitsCollector();

        for (int i = 0; i < length; i++) {
            hTree.compressEl(bytesContent[i], packedBits);
        }

        Byte[] header = createHeader(hTree.getTableOfCorrespondence(), packedBits.size());
        Byte[] arrPacked = packedBits.toArrayBytes();

        byte[] result = new byte[header.length + arrPacked.length];

        for (int i = 0; i < header.length; i++)
            result[i] = header[i];

        for (int i = 0; i < arrPacked.length; i++)
            result[header.length + i] = arrPacked[i];

        return result;
    }

    public byte[] decode(byte[] code) {

        long nBits = Helper.byteArrayToLong(code, 0);
        int nDifferBytes = code[8];

        byte nextByte;
        int nNextBits;
        BitsCollector nextBitsCollector;
        int cursor = 9;
        int n;
        int remainBits;

        Map<Byte, BitsCollector> tableOfCorrespondence = new Hashtable<>();

        while (nDifferBytes > 0) {
            nextByte = code[cursor];
            cursor++;

            nNextBits = Helper.byteArrayToInt(code, cursor);
            cursor += 4;

            n = nNextBits / 8;
            remainBits = nNextBits % 8;
            nextBitsCollector = new BitsCollector();
            nextBitsCollector.pushBitsFrom(code, cursor, nNextBits);

            cursor += remainBits == 0 ? n: n + 1;

            tableOfCorrespondence.put(nextByte, nextBitsCollector);

            nDifferBytes--;
        }

        HuffmanTree<Byte> hTree = createHTree(tableOfCorrespondence);
        ArrayList<Byte> extracted = new ArrayList<>();
        BitsCollector bitsPacked = new BitsCollector();

        bitsPacked.pushBitsFrom(code, cursor, (int) nBits);

        hTree.decodeEl(bitsPacked, extracted);

        return Helper.ListToArrByte(extracted);
    }
    
    private Map<Byte, Long> fillFrequencyTable(byte[] bytesContent, int length) {
        Map<Byte, Long> tableFrequency = new HashMap<>();
        Long n;
        for (int i = 0; i < length; i++) {
            n = tableFrequency.get(bytesContent[i]);
            n = (n == null) ? 0 : n;
            tableFrequency.put(bytesContent[i], n + 1);
        }

        return tableFrequency;
    }

    private PriorityQueue<HuffmanTree<Byte>> fillQueueOrderedBytes(Map<Byte, Long> tableFrequency) {
        PriorityQueue<HuffmanTree<Byte>> queueOrderedBytes = new PriorityQueue<>();
        Long weight;

        for (Byte nextByte : tableFrequency.keySet()) {
            weight = tableFrequency.get(nextByte);
            queueOrderedBytes.add(new HuffmanTree<>(nextByte, weight));
        }

        return queueOrderedBytes;
    }

    private HuffmanTree createHTree(PriorityQueue<HuffmanTree<Byte>> queueOrderedBytes) {
        HuffmanTree<Byte> hTree;
        HuffmanTree<Byte> node1, node2;
        HuffmanTree<Byte> resTree;

        while(queueOrderedBytes.size() != 1) {
            node1 = queueOrderedBytes.poll();
            node2 = queueOrderedBytes.poll();

            hTree = new HuffmanTree<>(node1, node2);
            queueOrderedBytes.add(hTree);
        }

        resTree = queueOrderedBytes.poll();
        resTree.createTableOfCorrespondence();

        return resTree;
    }

    private HuffmanTree createHTree(Map<Byte, BitsCollector> tableOfCorrespondence) {
        HuffmanTree<Byte> hTree;
        hTree = new HuffmanTree<>(tableOfCorrespondence);

        return hTree;
    }

    /**
     * Create header for huffman archivator. Format of the header is next:
     * | 8 bytes (total quantity of the bits represents as long) | 1 bytes (quantity of the possible bytes)
     * | nDiffBytes * 9 ('table of frequency': 9 = 1 origin byte, 8 bytes - long number that represent frequency)|
     *
     * @param tableOfCorrespondence
     * @param nTotalBits
     *
     * @return Byte[]
     */
    private Byte[] createHeader(Map<Byte, BitsCollector> tableOfCorrespondence, long nTotalBits) {
        ArrayList<Byte> header = new ArrayList<>();

        // 1 - nTotalBits
        Byte[] longArr = Helper.longToByteArray(nTotalBits);
        header.addAll(Arrays.asList(longArr));

        // 2 - size of different bytes
        int nDifferentBytes = tableOfCorrespondence.size();
        header.add((byte)nDifferentBytes);

        // 3 - save 'tableOfCorrespondence'
        byte nextByte;
        BitsCollector nextBitsCollector;
        Byte[] nBitsArr;

        for (Map.Entry<Byte, BitsCollector> entry : tableOfCorrespondence.entrySet()) {
            nextByte = entry.getKey();
            nextBitsCollector = entry.getValue();
            nBitsArr = Helper.intToByteArray(nextBitsCollector.size());
            header.add(nextByte);
            header.addAll(Arrays.asList(nBitsArr));
            header.addAll(Arrays.asList(nextBitsCollector.toArrayBytes()));
        }

        return header.toArray(new Byte[]{});
    }
}
