package structure.al_cache.LRU;

/**
 * @author: ywx
 * @description
 * @Date: 2022/08/19
 */

public class LruNode {
    public int key, val;
    public LruNode next, prev;
    public LruNode(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
