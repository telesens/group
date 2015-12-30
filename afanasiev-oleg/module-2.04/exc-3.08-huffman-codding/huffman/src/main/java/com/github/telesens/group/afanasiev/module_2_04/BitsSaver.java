package com.github.telesens.group.afanasiev.module_2_04;

/**
 * Created by oleg on 12/11/15.
 */
public interface BitsSaver {
    void addBit(boolean unit);
    void removeLastBit();
    void addAllBits(BitsCollectorOld o);

    BitsSaver clone();
}
