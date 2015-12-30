package com.github.telesens.group.afanasiev.module_2_04;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created by oleg on 12/15/15.
 */
public class BitsCollector implements Iterable, Cloneable {
    class BitsCollectorIterator implements Iterator<Integer> {
        private Iterator<Boolean> iterator = queueBits.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Integer next() {
            return iterator.next() ? 1 : 0;
        }
    }

    private ArrayDeque<Boolean> queueBits;

    public BitsCollector() {
        queueBits = new ArrayDeque<>();
    }

    public void pushBit(int bit) {
        queueBits.add(bit == 0 ? false : true);
    }

    public int pollBit() {
        return queueBits.poll() ? 1 : 0;
    }

    public int size() {
        return queueBits.size();
    }

    public void pushBitsFrom(BitsCollector src) {
        Iterator<Integer> iterator = src.iterator();

        while (iterator.hasNext())
            this.pushBit(iterator.next());
    }

    public void pushBitsFrom(byte[] arr, int startPos, int nBits) {
        int cursor = startPos;
        int nextBit;

        for (int i = 1; i <= nBits; i++) {
            nextBit = (arr[cursor] >> ((i - 1) % 8)) & 1;
            this.pushBit(nextBit);

            if (i % 8 == 0)
                cursor++;
        }
    }

    public void removeLastBit() {
        queueBits.removeLast();
    }

    public Byte[] toArrayBytes() {
        int n = queueBits.size() / 8;
        int remainBits = queueBits.size() % 8;
        int size = remainBits == 0 ? n : n + 1;

        Byte[] res = new Byte[size];
        Iterator<Boolean> iterator = queueBits.iterator();

        boolean nextBit;
        byte curByte = 0;
        int bitCursor = 0;
        int byteCursor = 0;

        while (iterator.hasNext()) {
            nextBit = iterator.next();
            if (nextBit)
                curByte = (byte)(curByte | (1 << bitCursor));
            else
                curByte = (byte)(curByte & ~(1 << bitCursor));

            if (bitCursor == 7) {
                res[byteCursor] = curByte;
                bitCursor = 0;
                byteCursor++;
            } else
                bitCursor++;
        }

        if (remainBits > 0)
            res[n] = curByte;

        return res;
    }

    @Override
    public Iterator iterator() {
        return new BitsCollectorIterator();
    }

    @Override
    public BitsCollector clone() {
        BitsCollector cloned = null;
        try {
            cloned = (BitsCollector) super.clone();
            cloned.queueBits = queueBits.clone();
        } catch (CloneNotSupportedException exc) {
            exc.printStackTrace();
        }
        return cloned;
    }
}
