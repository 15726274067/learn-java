package com.zhutao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 14:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate = null;

    /**
     * StringRedisTemplate类继承 RedisTemplate, 提供了字符串的操作
     * 不需要设定序列化器
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping(value = "string", method = RequestMethod.GET)
    public Map<String, Object> testString(){
        String redisKey = "int_redis:template:key";
        String stringRedisKey = "int_string:redis:template:key";

        redisTemplate.opsForValue().set(redisKey, "1");
        redisTemplate.opsForValue().increment(redisKey, 2);
        redisTemplate.opsForValue().decrement(redisKey);

        stringRedisTemplate.opsForValue().set(stringRedisKey, "1");
        stringRedisTemplate.opsForValue().increment(stringRedisKey, 2);
        stringRedisTemplate.opsForValue().decrement(stringRedisKey);

        Map<String, Object> map = new HashMap<>();
        map.put(redisKey, redisTemplate.opsForValue().get(redisKey));
        map.put(stringRedisKey, stringRedisTemplate.opsForValue().get(stringRedisKey));
        return map;
    }

    @GetMapping("/hash")
    public Map<String, Object> testHash(){
        String redisKey = "hash_redis:template:key";
        Map<String, String> map = new HashMap<>();
        map.put("field1", "value1");
        map.put("field2", "value2");
        map.put("field3", "value3");

        redisTemplate.opsForHash().putAll(redisKey, map);

        redisTemplate.opsForHash().put(redisKey, "field4", "value4");

        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(redisKey);
        boundHashOperations.put("field5", "value5");
        System.out.println("size: " + boundHashOperations.size());

        Map<String, Object> result = new HashMap<>();
        result.put("result", redisTemplate.opsForHash().entries(redisKey));
        return result;
    }


    @GetMapping("/list")
    public Map<String, Object> testList(){
        String redisKey = "list_redis:template:key";
        List<String> list = new ArrayList<>();
        for (int i=0; i< 10; i++){
            list.add("value" + i);
        }
        Long res = redisTemplate.opsForList().leftPushAll(redisKey, list);
        System.out.println(res);

        System.out.println(redisTemplate.opsForList().range(redisKey, 0 ,-1));

        System.out.println(redisTemplate.opsForList().rightPop(redisKey));

        System.out.println(redisTemplate.opsForList().range(redisKey, 0 ,-1));

        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();

        // [list_redis:template:key, value9]
        System.out.println(jedis.blpop(1000, redisKey));

        Map<String, Object> result = new HashMap<>();
        result.put("result", redisTemplate.opsForList().range(redisKey, 0 ,-1));
        return result;
    }

    @GetMapping("/set")
    public Map<String, Object> testSet(){
        String setKey1 = "set:redis:template:1";
        String setKey2 = "set:redis:template:2";
        String setKey3 = "set:redis:template:3";
        String setDiff1 = "set:diff:1&3";

        Long addResult = redisTemplate.opsForSet().add(setKey1, "a", "b", "c", "a");
        redisTemplate.opsForSet().add(setKey2, "a", "c", "d", "a", "e");
        redisTemplate.opsForSet().add(setKey3, "a", "b", "c", "f", "g");

        redisTemplate.opsForSet().differenceAndStore(setKey1, setKey3, setDiff1);

        // 返回所有元素
        Map<String, Object> result = new HashMap<>();
        result.put("setKey1AddResult", addResult);
        result.put("set1Size", redisTemplate.opsForSet().size(setKey1));
        result.put("set1RandomMember", redisTemplate.opsForSet().randomMember(setKey1));
        result.put("set1Members", redisTemplate.opsForSet().members(setKey1));
        result.put("setDiff1Members", redisTemplate.opsForSet().members(setDiff1));
        result.put("set1&2Union", redisTemplate.opsForSet().union(setKey1, setKey2));
        // 差集具有顺序相关性
        result.put("set3&1Diff", redisTemplate.opsForSet().difference(setKey3, setKey1));
        result.put("set1&3Intersect", redisTemplate.opsForSet().intersect(setKey1, setKey3));

        return result;
    }

    @GetMapping("/trans")
    public Map<String, Object> testTrans(){

        String watchKey = "watchKey";
        String key1 = "trans:key1";
        String key2 = "trans:key2";

        redisTemplate.opsForValue().set(watchKey, "value");
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                redisTemplate.watch(watchKey);
                redisTemplate.multi();
                operations.opsForValue().set(key1, "value1");
                operations.opsForValue().set(key2, "value2");
                Object value1= operations.opsForValue().get("trans:key1");
                System.out.println("命令在队列中,没有被执行,所以这里的值为null: " + value1);
                redisTemplate.exec();
                return null;
            }
        });

        Map<String, Object> map = new HashMap<>();
        map.put("value", redisTemplate.opsForValue().get(key1));
        map.put("value2", redisTemplate.opsForValue().get(key2));
        return map;
    }

    @GetMapping("pipeline")
    public Map<String, Object> testPipeLine(){
        String key1 = "key";
        Long start = System.currentTimeMillis();
        
        redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                Object value = null;
                for (int i=0; i<=100000; i++){
                    operations.opsForValue().set(key1 + i, "value "+ i);
                    value = operations.opsForValue().get(key1);
                    if (i == 100000){
                        System.out.println("命令只进入队列,值为空 " + value);
                    }
                }
                return null;
            }
        });

        Long end = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        map.put("cost", end-start);
        return map;
    }
}
