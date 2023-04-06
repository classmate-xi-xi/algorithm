package topic;

/**
 * @author: ywx
 * @description Topic1017 负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * @Date: 2023/04/06
 */

public class Topic1017 {
    /**
     * @param n 4
     * @return 100
     */
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            // 除基取余,保证余数为正整数,余数为0或1
            int num = Math.abs(n % (-2));
            ans.insert(0, (num == 0 ? "0" : "1"));
            n = (n - num) / (-2);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic1017().baseNeg2(4));
    }
}
