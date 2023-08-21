package topic;

/**
 * @author: ywx
 * @description 移动片段得到字符串
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 * @Date: 2023/08/21
 */

public class Topic2337 {
    /**
     * - 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
     * - 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
     * - 将第二个片段向右移动三步，字符串现在变为 "L______RR" 。
     * 可以从字符串 start 得到 target ，所以返回 true 。
     *
     * @param start  "_L__R__R_"
     * @param target "L______RR"
     * @return true
     */
    public boolean canChange(String start, String target) {
        String symbol = "_";
        char s = '_';
        int len = start.length();
        int i = 0;
        int j = 0;
        if (!start.replace(symbol, "").equals(target.replace(symbol, ""))) {
            return false;
        }
        while (i <= len && j <= len) {
            while (i < len && start.charAt(i) == s) {
                i++;
            }
            while (j < len && target.charAt(j) == s) {
                j++;
            }
            if (j == len || i == len) {
                return i == j;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
