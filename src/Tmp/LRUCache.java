package Tmp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity){
        this.capacity=capacity;
        cache = new LinkedHashMap(capacity, 0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
    }
    public int get(Integer key){
        if(cache.containsKey(key))return cache.get(key);
        return -1;
    }

    public void put(Integer key, Integer value){
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1)+" ");
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.print(cache.get(2)+" ");
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.print(cache.get(1)+" ");   // 返回 -1 (未找到)
        System.out.print(cache.get(3)+" ");       // 返回  3
        System.out.print(cache.get(4)+" ");      // 返回  4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */