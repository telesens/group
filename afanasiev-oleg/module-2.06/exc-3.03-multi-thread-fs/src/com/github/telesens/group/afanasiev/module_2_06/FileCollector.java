package com.github.telesens.group.afanasiev.module_2_06;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import  java.io.File;

/**
 * Created by oleg on 12/21/15.
 */
public class FileCollector implements Runnable{

    public static volatile Map<String, Long> files = new ConcurrentSkipListMap<>();
    private  String path = ".";

    public int getSize() {
        return files.size();
    }


    @Override
    public void run() {
        iterateFilesFromFolder(new File(path));
    }

    private  void iterateFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory())
                iterateFilesFromFolder(entry);
            else {
                files.put(entry.getName(), entry.length());
                //System.out.println(entry.getName());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Long> entry : files.entrySet() ) {
            sb.append(String.format("%s : %d %n", entry.getKey(), entry.getValue()));
        }

        return sb.toString();
    }
}
