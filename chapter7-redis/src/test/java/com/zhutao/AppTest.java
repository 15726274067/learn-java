package com.zhutao;

import static org.junit.Assert.assertTrue;

import com.zhutao.learn.redis.lru.LRUCache;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLRU(){
        LRUCache<String, Object> lruCache = new LRUCache<>();
        lruCache.put("key1", "value1");
        lruCache.put("key2", "value2");
        lruCache.get("key1");
        lruCache.put("key3", "value3");
        lruCache.put("key4", "value4");
        lruCache.put("key5", "value5");
        /**
         * key: key2 value: value2
         * key: key3 value: value3
         * key: key4 value: value4
         * key: key5 value: value5
         */
        lruCache.forEach(( k, v ) -> {
            System.out.println("key: " + k + " value: " + v);
        });
    }
}
