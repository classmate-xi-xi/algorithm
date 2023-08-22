package topic;

/**
 * @author: ywx
 * @description 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * @Date: 2023/08/22
 */

public class Topic345 {
    /**
     * @param s "hello"
     * @return "holle"
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = s.length() - 1;
        int i = 0;
        while (i < n) {
            while (i < s.length() && !isVowels(arr[i])) {
                i++;
            }
            while (n > 0 && !isVowels(arr[n])) {
                n--;
            }
            if (i < n) {
                char temp = arr[i];
                arr[i] = arr[n];
                arr[n] = temp;
                i++;
                n--;
            }
        }
        return new String(arr);
    }

    private boolean isVowels(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
