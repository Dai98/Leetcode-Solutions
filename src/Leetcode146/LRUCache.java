package Leetcode146;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2);
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // 返回  1
 *cache.put(3,3);    // 该操作会使得密钥 2 作废
 *cache.get(2);       // 返回 -1 (未找到)
 *cache.put(4,4);    // 该操作会使得密钥 1 作废
 *cache.get(1);       // 返回 -1 (未找到)
 *cache.get(3);       // 返回  3
 *cache.get(4);       // 返回  4
 */
class Node{
    int key;
    int value;
    Node pre;
    Node next;

    public Node(){}

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {

    Node head;
    Node tail;
    int capacity;
    int size;
    HashMap<Integer,Node> hashmap = new HashMap<>();

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
        this.capacity = capacity;
        this.size = 0;
    }

    // 将节点添加在头节点之后
    private void add(Node node){
        Node origin = head.next;
        head.next = node;
        node.pre = head;
        node.next = origin;
        origin.pre = node;
    }

    // 删除某个节点
    private void remove(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }

    public int get(int key) {
        Node node = hashmap.get(key);
        if(null == node){
            return -1;
        }
        // 更新缓存记忆
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashmap.get(key);
        // 节点已经存在于哈希表中
        if(null != node){
            node.value = value;
            remove(node);
            add(node);
        }else{
            if(size < capacity){
                size++;
            }else{
                Node delNode = tail.pre;
                hashmap.remove(delNode.key);
                remove(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            hashmap.put(key, newNode);
        }
    }

}
