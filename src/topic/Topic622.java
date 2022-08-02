package topic;

/**
 * @author: ywx
 * @description 构建一个循环队列
 * @Date: 2022/08/02
 */

public class Topic622 {

    class MyCircularQueue {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
        //头结点
        private ListNode head;
        //尾节点
        private ListNode tail;
        //容量
        private final int capacity;
        //长度
        private int size;

        //构造器，设置队列长度为 k
        public MyCircularQueue(int k) {
            capacity = k;
            size = 0;
        }

        //向循环队列插入一个元素。如果成功插入则返回真
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (head == null) {
                head = tail = node;
            }else {
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }

        //从循环队列中删除一个元素。如果成功删除则返回真
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            ListNode node = head;
            head = node.next;
            size--;
            return true;
        }
        //从队首获取元素。如果队列为空，返回 -1
        public int Front() {
            if (isEmpty()) {
                return -1;
            }else {
                return head.val;
            }
        }
        //获取队尾元素。如果队列为空，返回 -1
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }else {
                return tail.val;
            }
        }
        //检查循环队列是否为空
        public boolean isEmpty() {
            return size == 0;
        }
        //检查循环队列是否已满
        public boolean isFull() {
            return capacity == size;
        }
    }
}

