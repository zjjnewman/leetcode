package leetcode.bytedance.linkedhashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制 https://leetcode-cn.com/problems/lru-cache/
 *
 * 关于LinkedHashMap中三个函数，亲测：
 * //Callbacks to allow LinkedHashMap post-actions
 * 这是《专门》用于linkedHashMap的回调函数，用于处理某些指定的情况
 *
 *
 *
 * 这个和 LinkedHashMap 217行的boolean变量 accessOrder 配合使用，实现：若 accessOrder为true 更新已有的map中已有的值，
 * 会自动放在link最后。会按照访问顺序更新当前访问的entry，最新访问的会放在linked最后。
 * 若指定 accessOrder 则应该使用构造方法 public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
 *
 * 1 void afterNodeAccess(Node<K,V> p) { }
 *
 *
 * LinkedHashMap源码299行：若evict，removeEldestEntry(first)都为true，会remove最旧的entry。
 * 可以重写源码508行 removeEldestEntry(first)方法，实现返回值的控制，这时可以使capacity
 * 大小固定。（只要不是构造方法中的插入Map集合，evict就为true）
 *
 * 2 void afterNodeInsertion(boolean evict) { }
 *
 *
 * 这个方法是LinkedHashMap在删除元素后相应对链表结构调整。
 * 3 void afterNodeRemoval(Node<K,V> p) { }
 *
 *
 * 综上所述：若实现LRU，
 * 需要继承：         LinkedHashMap
 * 用构造方法：       LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) （accessOrder为true）
 * 重写508行方法：    removeEldestEntry(first)，实现固定容量，若超过就移除最久没访问的entry
 */

public class LC0146 {
    class LRUCache extends LinkedHashMap<Integer, Integer>{

        int capacity;

        public LRUCache(int capacity) {
            /**
             * 这里初始化一个数据结构的容量，这个数据结构用 LinkedHashMap
             */
            //这里第三个参数true代表按访问顺序把最新访问的entry放到最后。
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > capacity;
        }

        public int get(int key) {
            /**
             * 1 获取这个key
             * 2 这个key刚被使用，要改变其在链表中的位置，应该放在队尾表明最近使用了
             */
            // 这种比较耗时
//            try {
//                return super.get(key);
//            } catch (NullPointerException e){
//                return -1;
//            }

//            Integer v;
//            if((v = super.get(key)) == null){
//                return -1;
//            } else {
//                return v;
//            }

//            return super.get(key) == null ? -1 : super.get(key);

            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            /**
             * 首先容量固定，不能扩容
             * 1 若put的值已存在，或不存在并且，容量未满可以直接插入，并且放在link尾
             * 2 若put的值为新值，并且容量已满，要把其中LRU的值换出来，并且把刚put的值放在link尾
             */
            super.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LC0146().new LRUCache(16);
//        for (int i = 0; i < 16; i++) {
//            lruCache.put(i, i);
//        }
        System.out.println(lruCache);
        System.out.println(lruCache.get(8));
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
