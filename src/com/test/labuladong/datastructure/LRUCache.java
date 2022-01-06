package com.test.labuladong.datastructure;

import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int cap;

    public LRUCache(int cap){
        this.cap = cap;
    }

    public void put(int k, int v){
        if (cache.containsKey(k)){
            cache.put(k,v);
            makeRecently(k);
            return;
        }
        if (cache.size() == cap){
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(k,v);
    }

    public int get(int k){
        if (!cache.containsKey(k)){
            return -1;
        }
        makeRecently(k);
        return cache.get(k);
    }

    public void makeRecently(int k){
        int v = cache.get(k);
        cache.remove(k);
        cache.put(k, v);
    }

}
