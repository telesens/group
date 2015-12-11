package com.github.telesens.group.afanasiev.module_2_04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oleg on 12/6/15.
 */
public class GenArray<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    private Collection<T> arr;

    public GenArray() {
        arr = new ArrayList<T>();
    }

    public void addEl(T el) {
        arr.add(el);
    }

    public void removeEl(T el) {
        arr.remove(el);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("List of elements: \nS");

        for (T el : arr)
            sb.append(el);

        return sb.toString();
    }
}
