package com.github.telesens.group.afanasiev.module_2_04;

import java.io.Serializable;

/**
 * Created by oleg on 12/6/15.
 */
public class Institute implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;

    public Institute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + name + "\n");
        return sb.toString();
    }
}
