package topic;

/**
 * @author: ywx
 * @description 重新格式化字符串
 * @Date: 2022/08/11
 */

public class Topic1417 {
    public String reformat(String s) {
        int cCount = 0, nCount = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c <= '9' && c >= '0') {
                cCount++;
            } else {
                nCount++;
            }
        }
        if (Math.abs(cCount - nCount) > 1) {
            return "";
        }
        if (cCount > nCount) {
            cCount = 0;
            nCount = 1;
        } else {
            cCount = 1;
            nCount = 0;
        }
        // 原 for (char c : cs) --蠢驴、、、、
        // cs已经被修改。。。。。
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                cs[cCount] = c;
                cCount += 2;
            } else {
                cs[nCount] = c;
                nCount += 2;
            }
        }
        return new String(cs);
    }
}
