package com.test.io.byteStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java有两种类型的流：字节流、字符流 字节流：InputStream、OutputStream及其实现类 字符流：Reader、Writer及其实现类
 */
public class FileUtils {

    public static void fileCopy(String fileSource, String target) throws IOException {
        try (InputStream in = new FileInputStream(fileSource)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[1024];
                int byteSize;
                while ((byteSize = in.read(buffer)) != -1) {
                    out.write(buffer, 0, byteSize);
                }
            }
        }
    }

    public static void fileCopyNIO(String fileSource, String fileTarget) throws IOException {
        try (FileInputStream in = new FileInputStream(fileSource)) {
            try (FileOutputStream out = new FileOutputStream(fileTarget)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static int wordCountInFile(String fileName, String word) throws IOException {
        int count = 0;
        try (FileReader fr = new FileReader(fileName)) {
            try (BufferedReader reader = new BufferedReader(fr)) {
                String readLine;
                while ((readLine = reader.readLine()) != null) {
                    int index = -1;
                    while(readLine.length()>=word.length() && (index = readLine.indexOf(word))>=0) {
                        count++;
                        readLine = readLine.substring(index + word.length());
                    }
                }
            }
        }
        return count;
    }

}
