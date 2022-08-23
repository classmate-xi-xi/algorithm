package topic;


/**
 * @author: ywx
 * @description 实现 strStr()
 * @Date: 2022/08/23
 */

public class Topic28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int hlen = haystack.length(), nlen = needle.length();
        for (int i = 0; i + nlen <= hlen; i++) {
            boolean flag = true;
            for (int j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Topic28().strStr("hello", "ll");
        System.out.println(i);
    }
}
