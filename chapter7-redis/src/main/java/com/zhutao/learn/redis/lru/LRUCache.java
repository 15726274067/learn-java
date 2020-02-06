package com.zhutao.learn.redis.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zhutao
 * @Date: 2019/3/23 20:07
 * @Version 1.0
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int SIZE = 4;

    public LRUCache() {
        // true 表示让 LinkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super(SIZE, 0.75f, true);
    }

    /**
     * 在 put 等操作之后执行，当 removeEldestEntry() 方法返回 true 时会移除最晚的节点，
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > SIZE;
    }
}
