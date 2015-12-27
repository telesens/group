package com.telesens.afanasiev;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by oleg on 12/26/15.
 */
public class FileSelector implements Runnable {
    private ConcurrentSkipListMap<String, BasicFileAttributes> listFiles;
    private AttrSelectable attrSelector;
    private ContentSelectable fileSlc;
    private String matchText = "";

    public FileSelector(ConcurrentSkipListMap<String, BasicFileAttributes> listFiles, AttrSelectable attrSelector, ContentSelectable fileSlc) {
        this.listFiles = listFiles;
        this.attrSelector = attrSelector;
        this.fileSlc = fileSlc;
    }

    public void setMatchText(String matchText) {
        this.matchText = matchText;
    }

    @Override
    public void run() {
        for (Map.Entry<String, BasicFileAttributes> entry : listFiles.entrySet()) {
            if (attrSelector.select(entry.getValue()) && fileSlc.select(entry.getKey(), matchText))
                System.out.printf("%-40s %s %n", " ", entry.getKey());
        }
    }
}
