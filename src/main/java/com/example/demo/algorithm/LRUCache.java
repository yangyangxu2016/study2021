package com.example.demo.algorithm;

import java.util.LinkedHashMap;

public class LRUCache {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int size;

    public LRUCache(int capacity){
        this.size = capacity;
    }


    public  void put (int key,int val){
        //存在，更新
        if (cache.containsKey(key)) {
            cache.put(key, val);
            //   提升
            int oldValue= cache.get(key);
            cache.remove(key);
            cache.put(key, oldValue);
            return;
        }
        //    判断容量，大于，移除收个

        if (cache.size() >= size) {
            Integer next = cache.keySet().iterator().next();
            cache.remove(next);

        }
        cache.put(key, val);
    }


    public int get(int key){
        //不存在
        if (!cache.containsKey(key)) {
            return  -1;
        }


        //存在
        int oldValue = cache.get(key);
        //提升
        cache.remove(key);
        cache.put(key, oldValue);

        return oldValue;
    }
}

