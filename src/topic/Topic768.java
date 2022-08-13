package topic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ywx
 * @description 最多能完成排序的块 II
 * @Date: 2022/08/13
 */

public class Topic768 {
    public int maxChunksToSorted(int[] arr) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        Arrays.sort(temp);
        int count = 0, sum = 0, arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += temp[i];
            arrSum += arr[i];
            if (sum == arrSum) {
                count++;
            }
        }
        return count;
    }

    public int maxChunksToSorted1(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (!stack.isEmpty() && num < stack.peekLast()) {
                int head = stack.removeLast();
                while (!stack.isEmpty() && num < stack.peekLast()) {
                    stack.removeLast();
                }
                stack.addLast(head);
            } else {
                stack.addLast(num);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int a = new Topic768().maxChunksToSorted(new int[]{2, 1, 3, 4, 4});
        System.out.println(a);
    }
}
