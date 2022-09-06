package topic;

/**
 * @author: ywx
 * @description 最后一个单词的长度
 * @Date: 2022/09/06
 */

public class Topic58 {
    public int lengthOfLastWord(String s) {
//        s = s.trim();
//        return s.length() - s.lastIndexOf(" ") - 1;
        char blank = ' ';
        int index = s.length() - 1;
        while (index > 0 && s.charAt(index) == blank) {
            index--;
        }
        if (index < 0) {
            return 0;
        }
        int wordLen = 0;
        while (index >= 0 && s.charAt(index) == blank) {
            wordLen++;
            index--;
        }
        return wordLen;
    }
}
