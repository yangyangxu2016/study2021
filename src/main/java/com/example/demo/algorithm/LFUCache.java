package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * todo
 * date：2021/11/16  10:36 上午
 *
 * @author xuyy
 */
public class LFUCache {
    //键和值映射 快速定位key的val
    HashMap<Integer, Integer> keyToVal = new HashMap();

    //快速定位key访问次数
    HashMap<Integer, Integer> keyToFreq = new HashMap();

    //访问次数和键映射  访问次数获取key，删除最远时间访问的
    HashMap<Integer, LinkedHashSet<Integer>> freqToKey = new HashMap();

    //最小访问次数
    private Integer minFreq;

    //容量
    private Integer cap ;


    public LFUCache(int capacity) {
        this.keyToVal = new HashMap();
        this.keyToFreq = new HashMap();
        this.freqToKey = new HashMap<>();
        this.minFreq = 0;
        this.cap = capacity;
    }
    //获取key，更新访问次数
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加访问次数
        increaseFreq(key);
        return keyToVal.get(key);
    }


    /**
     * 1、存在更新，增加次数
     * 2、不存在插入，容量慢了，删除最小，次数为1
     * 2、容量不满，放入，增加次数
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        //已满
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key,1);

        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        //最小访问次数坑定为1
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKey.get(minFreq);
        Integer deleteKey = keyList.iterator().next();
        // freqToKey
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKey.remove(minFreq);
        }

        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }


    //获取次数
    private void increaseFreq(int key) {
        //更新 keyToFreq
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        //更新freqToKey
        freqToKey.get(freq).remove(key);
        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);

       //移除列表
        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            //如果移除等于最下，
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }

    }

}
