/**
 * @author: ywx
 * @description  生成每种字符都是奇数个的字符串
 * @Date: 2022/08/01
 */

public class Topic1374 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) > 0) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }
        return sb.toString();
    }
}
