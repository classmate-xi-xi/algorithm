package topic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ywx
 * @description 数组中的字符串匹配
 * @Date: 2022/08/06
 */

public class Topic1408 {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    res.add(words[j]);
                    break;
                }
            }
        }
        return res;
    }
}
