package com.example.algorithm.medium;

import java.util.HashMap;

/**
 * @ClassName LRUCache
 * @Description LRU 缓存 最近最少使用
 *
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。这里为了兼容泛型, get(key) 不存在时  返回 null
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Ash Jan
 * @Date 2021/7/4 18:02
 */
public class LRUCache<K, V> {


    public static void main(String[] args) {
        // 初始化缓存 最多存放三个元素
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        lruCache.get(3);
        Object o = lruCache.get(1);
        System.out.println(o);

    }

    private class CacheNode<K, V> {
        CacheNode prev;
        CacheNode next;
        K key;
        V value;

        public CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 头节点
     */
    private CacheNode head = new CacheNode(-1, -1);

    /**
     * 尾节点
     */
    private CacheNode tail = new CacheNode(-1, -1);

    /**
     * 缓存数据个数
     */
    private int capacity;

    /**
     * 使用hashMap存储数据，规避链表查询速度相对慢的问题
     */
    private HashMap<K, CacheNode<K, V>> cacheMap = new HashMap();


    /**
     * 初始化缓存
     * @param capacity 缓存个数
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    /**
     * <font color='red'>这里为了兼容泛型, get(key) 不存在时  返回 null</font>
     * @param key
     * @return
     */
    public V get(K key) {
        if(!cacheMap.containsKey(key)) {
            return null;
        }
        CacheNode<K, V> current = cacheMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return cacheMap.get(key).value;
    }

    public void put(K key, V value) {
        if(get(key) != null) {
            cacheMap.get(key).value = value;
            return;
        }

        // 清除掉链表第一个元素
        if(capacity == cacheMap.size()) {
            cacheMap.remove(head.next);
            head.next = head.next.next;
            head.next.prev = head;
        }

        CacheNode cacheNode = new CacheNode(key, value);
        cacheMap.put(key, cacheNode);
        moveToTail(cacheNode);
    }


    private void moveToTail(CacheNode<K, V> current) {
        // 注意到这里的时候 current 的上下节点都是null, 不再考虑这种情况
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }


}
