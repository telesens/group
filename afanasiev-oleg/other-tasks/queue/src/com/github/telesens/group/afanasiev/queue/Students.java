package com.github.telesens.group.afanasiev.queue;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by oleg on 12/3/15.
 */
public class Students {
    private ArrayQueue<String> group;

    public Students(int n) {
        group = new ArrayQueue<>(n);
    }

    public boolean add(String name) {
        if (checkName(name))
            return group.offer(name);

        return false;
    }

    public void removeFirst() {
        group.remove();
    }

    @Override
    public String toString() {
        String[] arr = group.toArray(new String[]{});
        Collator collator = Collator.getInstance(new Locale("uk"));

        Arrays.sort(arr, (o1, o2) -> (collator.compare(o1, o2)));
        return Arrays.toString(arr);
    }

    private boolean checkName(String str) {
        Pattern pattern = Pattern.compile("^[A-Z,А-Я&&[^'ЪЬ]][a-zа-я]*$");

        return pattern.matcher(str).find();
    }
}
