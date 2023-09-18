package topic;


/**
 * @author: ywx
 * @description: 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，
 * 如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * @date: 2023/9/18
 */
public class Topic443 {
    /**
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * 输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * @param chars ["a","a","b","b","c","c","c"]
     * @return 6
     */
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            int idx = i;
            while (idx < n && chars[i] == chars[idx]) {
                idx++;
            }
            int cnt = idx - i;
            chars[j++] = chars[i];
            if (cnt > 1) {
                int start = j;
                int end = start;
                while (cnt != 0) {
                    chars[end++] = (char)((cnt % 10) + '0');
                    cnt /= 10;
                }
                reverse(chars, start, end - 1);
                j = end;
            }
            i = idx;
        }
        return j;
    }
   private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int compress = new Topic443().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println(compress);
    }
}
