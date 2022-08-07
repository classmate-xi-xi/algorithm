package topic;

import java.util.*;

/**
 * @author: ywx
 * @description 函数的独占时间
 * @Date: 2022/08/07
 */

public class Topic636 {
    public int[] exclusiveTime0(int n, List<String> logs) {
        int[] result = new int[n];
        //Deque模拟栈
        Deque<Integer> deque = new ArrayDeque<>();
        // 0 少一次计算
        int allTime = 0;
        for (String s : logs) {
            String[] log = s.split(":");
            int funId = Integer.parseInt(log[0]), timeOver = Integer.parseInt(log[2]);
            if ("start".equals(log[1])) {
                if (!deque.isEmpty()) {
                    // peekLast
                    result[deque.peekLast()] += timeOver - allTime;
                }
                deque.addLast(funId);
                allTime = timeOver;
            } else {
                // pollLast
                int fun = deque.pollLast();
                result[fun] += timeOver - allTime + 1;
                allTime = timeOver + 1;
            }
        }
        return result;
    }

    public int[] exclusiveTime01(int n, List<String> logs) {
        int[] result = new int[n];
        //Deque模拟栈
        Deque<Integer> deque = new ArrayDeque<>();
        // -1
        int allTime = -1;
        for (String s : logs) {
            String[] log = s.split(":");
            int funId = Integer.parseInt(log[0]), timeOver = Integer.parseInt(log[2]);
            if ("start".equals(log[1])) {
                if (!deque.isEmpty()) {
                    //peekLast
                    result[deque.peekLast()] += timeOver - allTime;
                }
                deque.addLast(funId);
                allTime = timeOver;
            } else {
                //pollLast
                int fun = deque.pollLast();
                result[fun] += timeOver - allTime + 1;
                allTime = timeOver + 1;
            }
        }
        return result;
    }

    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] result = new int[n];
        //Stack
        Stack<Integer> deque = new Stack<>();
        // 换汤不换药
        int allTime = -1;
        for (String s : logs) {
            String[] log = s.split(":");
            int funId = Integer.parseInt(log[0]), timeOver = Integer.parseInt(log[2]);
            if ("start".equals(log[1])) {
                if (!deque.isEmpty()) {
                    result[deque.peek()] += timeOver - allTime;
                }
                deque.add(funId);
                allTime = timeOver;
            } else {
                int fun = deque.pop();
                result[fun] += timeOver - allTime + 1;
                allTime = timeOver + 1;
            }
        }
        return result;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        //Stack
        Stack<Integer> deque = new Stack<>();
        // 换汤不换药
        int allTime = 0;
        for (String s : logs) {
            String[] log = s.split(":");
            int funId = Integer.parseInt(log[0]), timeOver = Integer.parseInt(log[2]);
            if ("start".equals(log[1])) {
                if (!deque.isEmpty()) {
                    result[deque.peek()] += timeOver - allTime;
                }
                deque.add(funId);
                allTime = timeOver;
            } else {
                int fun = deque.pop();
                result[fun] += timeOver - allTime + 1;
                allTime = timeOver + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("0:start:0");
        a.add("1:start:2");
        a.add("1:end:5");
        a.add("0:end:6");
        new Topic636().exclusiveTime(2, a);
    }
}
