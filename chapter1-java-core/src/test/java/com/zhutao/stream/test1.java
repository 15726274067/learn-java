package com.zhutao.stream;

import com.zhutao.javacore.stream.Part1;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: zhutao
 * @Date: 2019/1/26 16:06
 * @Version 1.0
 */
public class test1 {

    @Test
    public void testPart1(){
        Part1 part1 = new Part1();
        try {
            part1.readText("C:\\repo\\JAVA\\learnjava\\chapter1-java-core\\src\\main\\resources\\alice.txt", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStream(){
        Part1 part1 = new Part1();
        part1.limitTest();
    }
}
