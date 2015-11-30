package com.github.telesens.group.afanasiev.module_1_04;

import java.util.StringTokenizer;

/**
 * Created by oleg on 28.11.15.
 */
public class Abbr {
    public static String get(String srcLine) {
        StringTokenizer st = new StringTokenizer(srcLine);
        StringBuilder res = new StringBuilder();

        while (st.hasMoreElements()) {
            res.append(Character.toUpperCase(st.nextToken().charAt(0)));
        }

        return res.toString();
    }
}
