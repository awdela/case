package com.test.concurrent.conpractice.procon;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Indexer implements Runnable{

    private final BlockingQueue<File> fileQueue;

    public Indexer(BlockingQueue<File> queue) {
        this.fileQueue = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                indexFile(fileQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void indexFile(File take) {
        //TODO
    }

    public static void main(String[] args) {
        BlockingQueue<File> fileQueue = new LinkedBlockingQueue<>(100);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }else {
                    return false;
                }
            }
        };
        for (int i=0;i<10;i++) {
            new Thread(new FileCrawler(fileQueue, filter)).start();
        }
        for (int i=0;i<10;i++) {
            new Thread(new Indexer(fileQueue)).start();
        }
    }

}
