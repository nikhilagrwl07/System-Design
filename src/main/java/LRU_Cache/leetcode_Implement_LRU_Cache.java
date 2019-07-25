package LRU_Cache;


/*Implement_LRU_Cache
A cache is a mechanism by which future requests for that data are served faster
and/or at a lower cost.
Requirements
1. Fixed size: The cache needs to have some bounds to limit memory usage.
2. Fast access: O(1) cache insert and lookup operations.
3. Entry replacement algorithm: When the cache is full, the less useful cache
entries are purged from cache. The algorithm to
replace these entries is Least Recently Used (LRU)
or the cache entries which have not been accessed recently will be replaced.
 */

import java.util.HashMap;

public class leetcode_Implement_LRU_Cache {

    public static void main(String[] args) {
        // Test case 1.
        LRUCache lrucache = new LRUCache(2);

        print(lrucache.get(1) == -1);

        lrucache.set(2, 1);
        lrucache.printDLL();
        lrucache.set(1, 1);
        lrucache.printDLL();
//        print(lrucache);
        print(lrucache.get(2) == 1);
        lrucache.printDLL();
//        print(lrucache);

        lrucache.set(4, 1);
        lrucache.printDLL();
        print(lrucache.get(1) == -1);
        print(lrucache.get(2) == 1);
        lrucache.printDLL();
    }

    public static void print(Object obj) {
        System.out.println("print :: " + obj);
    }
}

class LRUCache {

    private int capacity;
    private HashMap<Integer, LRUNode> cache; // HashMap to support O(1) get.
    private LRUNode anchor; // Root of DLL

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, LRUNode>();

        this.anchor = new LRUNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.anchor.left = this.anchor;
        this.anchor.right = this.anchor;
    }

    public int get(int key) {
        LRUNode node = this.cache.get(key);
        if (node != null) {
            moveToTop(node);
            return node.value;
        } else {
            return -1; // Check the requirement. Normally it returns null.
        }
    }

    public void set(int key, int value) {
        LRUNode node = this.cache.get(key);
        if (node != null) {
            moveToTop(node);
            node.value = value;
        } else {
            LRUNode newNode;
            if (this.cache.size() >= this.capacity) {
                // Unlink from ddl and reuse the object.
                System.out.println(" anchor.left.key :: " + anchor.left.key);
                newNode = remove(this.anchor.left.key);
                newNode.key = key;
                newNode.value = value;
            } else {
                newNode = new LRUNode(key, value);
            }
            linkAsTop(newNode);
            this.cache.put(key, newNode);
        }
    }

    private LRUNode remove(int key) {
// Remove a key/value node from cache.
        LRUNode node = this.cache.get(key);
        this.cache.remove(key);

// Unlink and remove from dll.
        LRUNode left = node.left;
        LRUNode right = node.right;
        left.right = right;
        right.left = left;
        return node;
    }

    private void linkAsTop(LRUNode node) {
        // Link node to anchor'right in dll.
        LRUNode anchor = this.anchor;
        LRUNode anchor_right = anchor.right;

        node.left = anchor;
        node.right = anchor_right;
        anchor_right.left = node;
        anchor.right = node;
    }

    private void moveToTop(LRUNode node) {
        // Unlink node from its current position.
        LRUNode left = node.left;
        LRUNode right = node.right;
        left.right = right;
        right.left = left;
        linkAsTop(node);
    }

    public String toString() {
        String ret = "";
        LRUNode node;
        for (int key : this.cache.keySet()) {
            node = this.cache.get(key);
            ret += "<" + key + ", " + node.value + ">\n";
        }
        return ret;
    }

    public void printDLL() {
        LRUNode cursor = this.anchor;
        while (cursor.right != this.anchor) {
            System.out.print(cursor.right + " ");
            cursor = cursor.right;
        }
        System.out.println();
    }

    public void clear() {
        this.cache.clear();
        this.anchor.left = this.anchor;
        this.anchor.right = this.anchor;
    }
}

class LRUNode {

    public LRUNode left;
    public LRUNode right;
    public int key;
    public int value;

    public LRUNode(int key, int value) {
        this.left = null;
        this.right = null;
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "<" + this.key + ", " + this.value + ">";
    }
}
