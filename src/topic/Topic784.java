package topic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: ywx
 * @description 字母大小写全排列
 * @Date: 2022/07/28
 */

public class Topic784 {
    List<String> result = new LinkedList<>();

    public List<String> letterCasePermutation(String s) {
        if (s.isEmpty()) {
            return result;
        }
        result.add(s);
        backTrack(s.toCharArray(), 0);
        return result;
    }

    private void backTrack(char[] s, int start) {
        for (int i = start; i < s.length; i++) {
            if (s[i] > '9') {
                s[i] ^= (1 << 5);
                result.add(String.valueOf(s));
                backTrack(s, i + 1);
                s[i] ^= (1 << 5);
            }
        }
    }
}
