package topic;

/**
 * @author: ywx
 * @description 文件夹操作日志搜集器
 * @Date: 2022/09/09
 */

public class Topic1598 {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            if ("../".equals(s)) {
                if (count > 0) {
                    count--;
                }
            } else if (!"./".equals(s)) {
                count++;
            }
        }
        return count;
    }
}
