package LLD.questions.LRUCache.questions;

import java.util.HashMap;
import java.util.Map;

/** for LRU cache we need a hashmap to find the enty in cache
 * a doubly linked list for making the entry for data
 **/

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev, next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        // if map has key then delete the cur node & push it after first
        // if not then just return null
        if (key == null || !map.containsKey(key)) return null;
        Node<K, V> node = map.get(key);
        deleteNode(node);
        insertToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        // if map contains then just push it to first
        // if map not contains then just restructure it
        if (key == null) return;
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertToHead(node);
        } else {
            if (map.size() >= capacity) {
                // delete the node & erase from map
                Node<K, V> lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }
            Node<K, V> node = new Node<>(key, value);
            insertToHead(node);
            map.put(node.key, node);
        }
    }

    private void deleteNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
    }

    private void insertToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);

        cache.put(1, 5);
        cache.put(2, 78);
        cache.put(3, 45);

        System.out.println(cache.get(3));
    }
}
