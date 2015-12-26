package com.telesens.afanasiev;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by oleg on 12/26/15.
 */
public class FileCollector implements Runnable {
    private ConcurrentSkipListMap<String, BasicFileAttributes> listFiles;
    private String dir;
    private String pattern;
    private PathMatcher matcher;

    public FileCollector(ConcurrentSkipListMap<String, BasicFileAttributes> listFiles, String dir) {
        this.listFiles = listFiles;
        this.dir = dir;
        this.pattern = "*";
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void run() {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        iterateFilesFromFolder(new File(dir));
    }

    private  void iterateFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        BasicFileAttributes attr;
        Path path;
        try {
            for (File file : folderEntries) {
                if (file.isDirectory())
                    iterateFilesFromFolder(file);
                else {
                    path = file.toPath();
                    if (matcher.matches(path.getFileName())) {
                        attr = Files.readAttributes(path, BasicFileAttributes.class);
                        listFiles.put(file.getPath(), attr);

                        System.out.printf(String.format("%-25s | %.2f Kb %n", file.getName(), sizeToKb(attr.size())));
                        Thread.sleep(100);
                    }
                }
            }
        } catch(InterruptedException | IOException exc) {
            exc.printStackTrace();
        }
    }

    private double sizeToKb(long sizeInBytes) {
        return sizeInBytes / 1024.0;
    }
}
