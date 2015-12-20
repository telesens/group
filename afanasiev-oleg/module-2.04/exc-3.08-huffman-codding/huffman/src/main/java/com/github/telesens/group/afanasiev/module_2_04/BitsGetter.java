package com.github.telesens.group.afanasiev.module_2_04;

/**
 * Created by oleg on 12/12/15.
 */
public interface BitsGetter {
    long size();
    Byte[] toArrayBytes();
    boolean pollBit();
}
