package topic;

import java.util.ArrayList;

/**
 * @author: ywx
 * @description 宝石与石头
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头
 * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * @Date: 2023/07/25
 */

public class Topic771 {
    public static void main(String[] args) {
        int i = new Topic771().numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }

    /**
     * @param jewels jewels = "aA"
     * @param stones stones = "aAAbbbb"
     * @return 3
     */
    public int numJewelsInStones(String jewels, String stones) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < jewels.length(); i++) {
            chars.add(jewels.charAt(i));
        }
        int i = 0;
        for (int j = 0; j < stones.length(); j++) {
            char c = stones.charAt(j);
            if (!chars.contains(c)) {
                continue;
            }
            i++;
        }
        return i;
    }
}
