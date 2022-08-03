package topic;

/**
 * @author: ywx
 * @description 回文数
 * @Date: 2022/08/03
 */

public class Topic9 {
    public boolean isPalindrome(int x) {
        boolean b = false;
        char[] c = String.valueOf(x).toCharArray();
        int left, right = c.length - 1;
        if (c[0] == '-') {
            return b;
        } else {
            left = 0;
        }
        while (left <= right) {
            if (c[left] == c[right]) {
                left++;
                right--;
                b = true;
            } else {
                b = false;
                break;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        new Topic9().isPalindrome(3);
    }
}
