package com.github.telesens.group.afanasiev.module_1_05;

import com.github.telesens.group.afanasiev.module_1_05.AbstractFunc;

/**
 * Created by oleg on 11/16/15.
 */
public class FSin extends AbstractFunc {
    public FSin() {

    }

    @Override
    public double f(double x) {
        return Math.sin(x);
    }
}
