package com.zhutao.javacore.core.io.reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: zhutao
 * @Date: 2019/2/18 17:11
 * @Version 1.0
 */
public class ReaderMain {
    public static void main(String[] args){
        Path path = Paths.get("C:\\repo\\JAVA\\learnjava\\chapter1-java-core\\src\\main\\resources\\alice.txt");
        try {
            InputStream inputStream = getReader(path);
            System.out.println(readAllBytes(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取流对象
     * 读取字节的对象称为流
     * 1) 使用Files下静态方法newInputStream()
     * 2) openStream()
     * 3) ByteArrayInputStream()
     */
    public static InputStream getReader(Path path) throws IOException {
        InputStream inputStream = Files.newInputStream(path);
        OutputStream outputStream = Files.newOutputStream(path);

        // 从字节数组读取流
        byte[] bytes = new byte[10];
        InputStream inputStream1 = new ByteArrayInputStream(bytes);
        // 流输入到字节数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(2);
        byte[] bytes1 = byteArrayOutputStream.toByteArray();

        return inputStream;
    }

    public static void readByte(Path path) throws IOException {
        InputStream inputStream = Files.newInputStream(path);
        // 读取单个字节
        int b = inputStream.read();
        System.out.println(b);
    }


    /**
     * 实现从输入流读取所有字节
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] readAllBytes(InputStream in) throws IOException {
        // 写输出流结束后,必须关闭该输出流
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            copy(in, outputStream);
            return outputStream.toByteArray();
        }
    }

    private static void copy(InputStream in, ByteArrayOutputStream outputStream) throws IOException {
        final int BLOCKSIZE = 1024;
        byte[] bytes = new byte[BLOCKSIZE];

        int len;
        while ((len = in.read(bytes)) != -1){
            // 写字节
            outputStream.write(bytes, 0, len);
        }
    }


}
