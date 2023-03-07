package topic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: ywx
 * @description 花括号展开 II
 * @Date: 2023/03/07
 */

public class Topic1096 {
    private final TreeSet<String> s = new TreeSet<>();

    /**
     * 输出中 不应 出现重复的组合结果。
     *
     * @param expression "{a,b}{c,{d,e}}"               "{{a,z},a{b,c},{ab,z}}"
     * @return ["ac","ad","ae","bc","bd","be"]          ["a","ab","ac","z"]
     */
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            s.add(exp);
            return;
        }
        int i = j;
        while (exp.charAt(i) != '{') {
            --i;
        }
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Topic1096().braceExpansionII("{a,b}{c,{d,e}}");
        System.out.println(strings.toString());
    }
}
