package com.telesens.afanasiev;

import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by oleg on 12/26/15.
 */
public interface AttrSelectable {
    boolean select(BasicFileAttributes attr);
}
