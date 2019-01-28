package com.zhutao.stream;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: zhutao
 * @Date: 2019/1/26 16:06
 * @Version 1.0
 */
public class test1 {

    @Test
    public void testPart1(){
        try {
            readText("C:\\repo\\JAVA\\learnjava\\chapter1-java-core\\src\\main\\resources\\alice.txt", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStream(){
        limitTest();
    }


    /**
     * 1. 从迭代到stream操作
     * java8+
     * 实现统计文本中所有长单词
     */
    public void readText(String filePath, int length) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split( " "));
        int count = 0;

        /**
         * 使用集合迭代实现
         */
        for (String word: words){
            if (word.length()>length) count++;
        }

        System.out.println("count: " + count);
        /**
         * 使用流实现
         */
        long countByStream = words.stream()
                .filter(word -> word.length()>length)
                .count();
        System.out.println("countByStream: " + countByStream);

        /**
         * 并行流实现并行计算
         */
        Long countByParallelStream = words.parallelStream()
                .filter(word -> word.length()>length)
                .count();
        System.out.println("countByParallelStream: " + countByParallelStream);

    }

    /**
     * 2. 创建stream
     *
     * 集合: Collection#stream将集合转换为流
     *
     * 数组 Stream#of
     */
    public Stream createStream(){

        /**
         * 数组->stream
         */

        int[] arr = { 1, 2, 3 };
        Stream arrStream1 = Stream.of(arr);

        Stream arrStream2 = Stream.of("str1", "bbb", "aaaa");

        Stream<String> arrStream3 = Arrays.stream(new String[]{ "aaa", "bbb", "ccc" });

        //将数组部分转换成Stream
        Stream<String> arrStream4 = Arrays.stream(new String[]{ "aaa", "bbb", "ccc" }, 1, 3);

        /**
         * Collection -> stream
         */
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stream listStream = list.stream();

        // 不含任何元素的stream 泛型推导
        Stream<Integer> streamEmpty = Stream.empty();

        /**
         * 创建无穷的Stream
         * 1. 常量值的Stream
         * 2. 随机数的Stream
         */
        Stream<String> stringStream = Stream.generate(() -> "echo");

        Stream<Double> doubleStream = Stream.generate(Math::random);

        Stream<BigInteger> bigIntegerStream = Stream.iterate(BigInteger.ZERO,
                n -> n.add(BigInteger.ONE));

        Stream<Integer> integerStream1 = Stream.iterate(0,
                n -> n + 1);

        bigIntegerStream.max(BigInteger::compareTo);
        doubleStream.max(Double::compareTo);
        integerStream1.min(Integer::compareTo);

        return Stream.empty();
    }

    /**
     * 3. 流的转换
     * 转换操作产生新的流
     * 原有的流转换之后,不允许被继续操作,会抛出
     * java.lang.IllegalStateException: stream has already been operated upon or closed
     * filter, map, flatMap
     */
    public void flatMapTest(){
        Stream<Integer> integerStream = Stream.of(new Integer[]{ 1, 2, 3, 5, 7 });

        Stream integerStream1 = integerStream.filter(x -> x > 3);

        Stream integerStream2 = integerStream.map(x -> x + 2);

    }

    /**
     * 4. 提取子流和组合流
     * limit
     * skip
     * concat
     */
    public void limitTest(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Stream<String> stringStream = list.stream().skip(1);

//        Stream<String> stringStreamBak = stringStream;
//        stringStreamBak.skip(1).limit(1);

        // 原Stream不变, 都是返回新的流
        Stream<String> stringStream1 = Stream.concat(stringStream, Stream.of(new String[]{ "ddd", "eee", "fff"}));

        System.out.println(Arrays.toString(stringStream1.toArray()));
        System.out.println(Arrays.toString(stringStream1.toArray()));

    }

    /**
     * 5. 其他流转换
     * distinct, sorted, peek
     */
}
