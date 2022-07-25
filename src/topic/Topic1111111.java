package topic;

/**
 * @author: ywx
 * @description 判定字符是否唯一
 * @Date: 2022/07/25
 */

public class Topic1111111 {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
