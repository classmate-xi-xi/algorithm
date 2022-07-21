package topic;

/**
 * @author: ywx
 * @description 反转字符串中的单词III
 * @Date: 2022/07/21
 */

public class Topic557 {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            char[] cs = string.toCharArray();
            reverseString(cs);
            sb.append(cs);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

    }
}
