package com.github.telesens.group.afanasiev.module_2_04;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by oleg on 12/11/15.
 */
public class BitsCollectorOld implements BitsSaver, BitsGetter, Cloneable, Iterable {
    class BitsCollectorIterator implements Iterator<Boolean> {
        private long iterCursor = -1;

        @Override
        public boolean hasNext() {
            return iterCursor < nBits - 1;
        }

        @Override
        public Boolean next() {
            iterCursor++;
            return getBit(iterCursor);
        }
    }

    private long nBits;
    private byte curByte;
    private long cursor;

    private ArrayList<Byte> listBytes;

    public BitsCollectorOld() {
        listBytes = new ArrayList<>();
        cursor = -1;
        nBits = 0;
    }

    public long size() {
        return nBits;
    }

    public Byte[] toArrayBytes() {
        Byte[] queueArr = listBytes.toArray(new Byte[1]);
        Byte[] res = new Byte[queueArr.length + 1];
        System.arraycopy(queueArr, 0, res, 0, queueArr.length);
        res[queueArr.length] = curByte;

        return res;
    }

    public void addBit(boolean unit) {
        nextCursorPos();
        if (unit)
            curByte = (byte)(curByte | (byte)(1 << cursor));
         else
            curByte = (byte)(curByte & (byte)(~(1 << cursor)));
    }

    public void removeLastBit() {
        prevCursorPos();
    }

    public void removeFirstBit() {
        nBits--;

        if (cursor == 0) {
            cursor = 7;
            curByte = listBytes.get(0);
            listBytes.remove(0);
        } else
            cursor++;
    }

    public void addAllBits(BitsCollectorOld o) {
        Iterator<Boolean> iterator = o.iterator();

        while (iterator.hasNext())
            addBit(iterator.next());
    }

    public Boolean getBit(long index) {
        int indexOfByte = (int)(index / 8);
        int indexOfBit = (int)(index % 8);

        byte targetByte = indexOfByte > 0 ? listBytes.get(indexOfByte - 1) : curByte;
        byte leftPart = (byte)(targetByte & (1 << indexOfBit));
        byte rightPart = (byte)(1 << indexOfBit);
        return leftPart == rightPart;
    }

    public boolean pollBit() {
        boolean res = getBit(0);
        removeFirstBit();
        return res;
    }

    public void fillBits(byte[] src, int startPos, long nBits) {
        listBytes.clear();
        cursor = -1;
        this.nBits = 0;

        int nBytes = (int)nBits / 8;
        int remainBits = (int)(nBits % 8);
        int i = 0;

        while (i < nBytes) {
            listBytes.add(src[startPos + i]);
            cursor = 0;
            i++;
            this.nBits += 8;
        }

        boolean nextBit;
        byte el;
        if (remainBits > 0) {
            el = src[startPos + nBytes + 1];

            for (int j = 0; j < remainBits; j++) {
                nextBit = ((el >> (remainBits - j)) & 1) == 1;
                addBit(nextBit);
            }
            curByte = el;
        }
        else {
            curByte = listBytes.get(0);
            listBytes.remove(0);
        }
    }

    @Override
    public BitsCollectorOld clone() {
        BitsCollectorOld bitsCollectorOldClone = null;

        try {
            bitsCollectorOldClone = (BitsCollectorOld) super.clone();
            bitsCollectorOldClone.listBytes = (ArrayList)listBytes.clone();
        } catch(CloneNotSupportedException exc) {
            exc.printStackTrace();
        }

        return bitsCollectorOldClone;
    }

    @Override
    public Iterator iterator() {
        return new BitsCollectorIterator();
    }

    private void nextCursorPos() {
        nBits++;
        if (cursor == 7) {
            cursor = 0;
            listBytes.add(curByte);
        }
        else
            cursor++;
    }

    private void prevCursorPos() {
        nBits--;
        if(cursor == 0) {
            if (listBytes.size() > 0) {
                cursor = 7;
                curByte = listBytes.get(listBytes.size() - 1);
                listBytes.remove(listBytes.size() - 1);
            } else
                cursor = -1;
        } else
            cursor--;
    }
}
