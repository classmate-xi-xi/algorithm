package structure.al_cache.LRU;

import java.util.HashMap;

/**
 * @author: ywx
 * @description
 * @Date: 2022/08/19
 */

public class LruCache {
    private final HashMap<Integer, LruNode> nodeHashMap;

    private final LruDoubleList cache;

    private final int cap;

    private LruCache(int capacity) {
        this.cap = capacity;
        nodeHashMap = new HashMap<>();
        cache = new LruDoubleList();
    }

    public int get(int key) {
        if (!nodeHashMap.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return nodeHashMap.get(key).val;
    }

    public void put(int key, int value) {
        if (nodeHashMap.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 插入的数据为最近使用的数据
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, value);
    }

    /**
     * 将某个 key 提升为最近使用的
     *
     * @param key
     */
    private void makeRecently(int key) {
        LruNode node = nodeHashMap.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    /**
     * 添加最近使用的元素
     *
     * @param key
     * @param value
     */
    private void addRecently(int key, int value) {
        LruNode node = new LruNode(key, value);
        cache.addLast(node);
        nodeHashMap.put(key, node);
    }

    /**
     * 删除某一个 key
     *
     * @param key
     */
    private void deleteKey(int key) {
        LruNode node = nodeHashMap.get(key);
        // 从链表中删除
        cache.remove(node);
        // 从map中删除
        nodeHashMap.remove(key);
    }

    /**
     * 删除最久未使用的元素
     */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        LruNode delNode = cache.removeFirst();
        int delKey = delNode.key;
        nodeHashMap.remove(delKey);
    }
}
