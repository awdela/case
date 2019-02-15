package com.test.concurrent.conpractice.procon;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable{

    private final BlockingQueue<File> fileQueue;

    private final FileFilter fileFilter;

    private final File root= new File("/root");

    public FileCrawler(BlockingQueue<File> queue, FileFilter filter) {
        fileQueue = queue;
        fileFilter = filter;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] allFiles = root.listFiles(fileFilter);
        if (allFiles!=null) {
            for(File file:allFiles) {
                if (file.isDirectory()) {
                    crawl(file);
                }
                else if(file.isFile()){
                    fileQueue.put(file);
                }
            }
        }

    }

}
