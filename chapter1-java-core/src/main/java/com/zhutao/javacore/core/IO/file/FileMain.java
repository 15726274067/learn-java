package com.zhutao.javacore.core.IO.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. 磁盘操作
 * @Author: zhutao
 * @Date: 2019/2/18 16:58
 * @Version 1.0
 */
public class FileMain {
    public static void main(String[] args){
        Path path = Paths.get("C:\\repo\\JAVA\\learnjava\\chapter1-java-core\\src\\main\\resources\\alice.txt");
        try {
            readText(path);

            readText2Stream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 列出所有文件
    public static void listAllFiles(File dir){
        if(dir == null || !dir.exists()) return;

        if (dir.isFile()){
            System.out.println(dir.getName());
        }

        for (File file: dir.listFiles()){
            listAllFiles(file);
        }
    }

    // 从 Java7 开始，可以使用 Paths 和 Files 代替 File。
    // 通过Path对象读取byte[]
    public static byte[] readAllBytesByPath(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    public static void readText(Path path) throws IOException {
        List<String> strings = Files.readAllLines(path);
        System.out.println(strings);
    }

    public static void readText2Stream(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            System.out.println(Arrays.toString(lines.toArray()));
        }
    }

    // 文本输出
    public static void writeText(Path path, String content) throws IOException {
        Files.write(path, content.getBytes(Charset.defaultCharset()));

//        List<String> lines = new ArrayList<>();
//        lines.add("111");
//        lines.add("222");
//        lines.add("333");
//
//        Files.write(path, lines);
    }


    // 文本追加写入
    public static void appendText(Path path, String content) throws IOException {
        Files.write(path, content.getBytes(Charset.defaultCharset()), StandardOpenOption.APPEND);
    }
}
