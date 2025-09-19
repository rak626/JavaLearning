# LRU Cache – Complete LLD Interview Notes

---

## 1. Problem Statement
Design an **LRU (Least Recently Used) Cache** that supports:
- `get(key)` → return value if present, else -1. **O(1)**
- `put(key, value)` → insert or update key. If capacity exceeded, evict least recently used. **O(1)**

---

## 2. Core Design

### Data Structures
- **HashMap<Key, Node>** → O(1) lookup
- **Doubly Linked List (DLL)** → O(1) insertion & removal  
  - Head = most recently used  
  - Tail = least recently used  

---

## 3. Class Design

### Node Class
```java
class Node {
    int key, value;
    Node prev, next;

    Node(int k, int v) {
        key = k;
        value = v;
    }
}
```

### LRUCache Class
```java
class LRUCache {
    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail; // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertToHead(node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
```

---

## 4. Complexity
- **Time Complexity:**  
  - `get` → O(1)  
  - `put` → O(1)  
- **Space Complexity:** O(capacity)

---

## 5. Thread Safety

### Option A: Synchronized Methods
```java
public synchronized int get(int key) { ... }
public synchronized void put(int key, int value) { ... }
```

### Option B: ReentrantLock
```java
private final ReentrantLock lock = new ReentrantLock();

public int get(int key) {
    lock.lock();
    try {
        // same logic
    } finally {
        lock.unlock();
    }
}
```

---

## 6. Extensions: TTL (Expiry)

### Node with Expiry Time
```java
class Node {
    int key, value;
    long expiryTime; // in ms
    Node prev, next;

    Node(int k, int v, long ttl) {
        key = k;
        value = v;
        expiryTime = System.currentTimeMillis() + ttl;
    }
}
```

### Modified `get`
```java
public int get(int key) {
    if (!map.containsKey(key)) return -1;
    Node node = map.get(key);

    if (System.currentTimeMillis() > node.expiryTime) {
        remove(node);
        map.remove(key);
        return -1;
    }

    remove(node);
    insertToHead(node);
    return node.value;
}
```

### Cleanup Strategies
- **Lazy cleanup** (evict on access)  
- **Background thread** for proactive expiry

---

## 7. Alternative: LinkedHashMap

```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // access-order
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
```

- Much simpler than custom DLL.  
- Still O(1) for `get` and `put`.

---

## 8. Scaling: Distributed Cache

### Key Idea
- Local LRU works for single process only.
- For distributed system:
  - Use **consistent hashing** to map keys → nodes.
  - Replicate across nodes for fault tolerance.
  - Production-ready: **Redis, Memcached, Hazelcast**.

### Example: Consistent Hashing
```java
class ConsistentHashing {
    private SortedMap<Integer, String> circle = new TreeMap<>();

    public void addNode(String node) {
        int hash = hash(node);
        circle.put(hash, node);
    }

    public String getNode(String key) {
        if (circle.isEmpty()) return null;
        int hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int hash(String s) {
        return s.hashCode() & 0x7fffffff;
    }
}
```

---

## 9. Recap
- **Core Design:** HashMap + DLL  
- **Complexity:** O(1) get/put  
- **Thread Safety:** synchronized / locks  
- **TTL Extension:** expiryTime in Node  
- **Alternative:** LinkedHashMap  
- **Scaling:** Consistent hashing / use Redis
