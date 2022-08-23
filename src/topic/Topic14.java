package topic;

/**
 * @author: ywx
 * @description 最长公共前缀
 * @Date: 2022/08/23
 */

public class Topic14 {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j;
            int minLen = Math.min(str.length(), strs[i].length());
            for (j = 0; j < minLen; j++) {
                if (str.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            str = str.substring(0,j);
        }
        return str;
    }

    public static void main(String[] args) {
        String s = new Topic14().longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(s);
    }
}
