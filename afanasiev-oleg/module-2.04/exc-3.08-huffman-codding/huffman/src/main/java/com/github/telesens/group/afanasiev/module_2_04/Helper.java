package com.github.telesens.group.afanasiev.module_2_04;

import java.util.List;

/**
 * Created by oleg on 12/13/15.
 */
public class Helper {
    public static Byte[] longToByteArray(long value) {
        return new Byte[] {
                (byte) (value >> 56),
                (byte) (value >> 48),
                (byte) (value >> 40),
                (byte) (value >> 32),
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value
        };
    }

    public static Byte[] intToByteArray(int value) {
        return new Byte[] {
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value
        };
    }

    public static long byteArrayToLong(byte[] arr, int from) {
        long res = 0;
        for (int i = 0; i < 8; i++)
            res += ((long) arr[from + 7 - i] & 0xffL) << (8 * i);

        return res;
    }

    public static int byteArrayToInt(byte[] arr, int from) {
        int res = 0;
        for (int i = 0; i < 4; i++)
            res += ((long) arr[from + 3 - i] & 0xffL) << (4 * i);

        return res;
    }

    public static byte[] ListToArrByte(List<Byte> list) {
        byte[] res = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
