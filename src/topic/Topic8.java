package topic;


/**
 * @author: ywx
 * @description 字符串转换整数 (atoi)
 * @Date: 2022/08/03
 */

public class Topic8 {

    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int res = 0;
        boolean tf = false;
        while (index < c.length) {
            if (c[index] == '-') {
                if (tf) {
                    break;
                }
                tf = true;
            } else if (c[index] > '0' && c[index] <= '9') {
                sb.append(c[index]);
            }
            index++;
        }
        try {
            res = Integer.parseInt(sb.toString());
            res = tf ? -res : res;
        } catch (Exception e) {
            res = tf ? -(1 << 32 - 1) : 1 << 32 - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 原题目解为0
         * 我认为是987
         * 非题意解方法myAtoi（）
         */
        System.out.println(new Topic8().myAtoi(" www 987"));
    }
}
