package structure.al_cache.LRU;

/**
 * @author: ywx
 * @description
 * @Date: 2022/08/19
 */

public class LruDoubleList {
    // 头尾虚节点
    private final LruNode head;
    private final LruNode tail;
    // 链表元素数
    private int size;

    public LruDoubleList() {
        head = new LruNode(0, 0);
        tail = new LruNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点 node，时间 O(1)
    public void addLast(LruNode node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(LruNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public LruNode removeFirst() {
        if (head.next == tail) {
            return null;
        }
        LruNode first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}
