package topic;

/**
 * @author: ywx
 * @description 循环队列
 * @Date: 2022/08/15
 */

public class Topic641 {
    class MyCircularDeque {
        class Node {
            Node prev, next;
            int val;

            Node(int _val) {
                val = _val;
            }
        }

        int size, k;
        Node head, tail;

        public MyCircularDeque(int _k) {
            k = _k;
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head.next.next.prev = head;
            head.next = head.next.next;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()){
                return false;
            }
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : head.next.val;
        }

        public int getRear() {
            return isEmpty() ? -1 : tail.prev.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }
    }
}
