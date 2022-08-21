package topic;

/**
 * @author: ywx
 * @description 检查单词是否为句中其他单词的前缀
 * @Date: 2022/08/21
 */

public class Topic1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] words = searchWord.toCharArray();
        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            if (words.length > sentences[i].toCharArray().length) {
                continue;
            }
            int word = 0;
            for (int j = 0; j < words.length; j++) {
                if (sentences[i].toCharArray()[j] == words[j]) {
                    word++;
                }
                if (word == words.length) {
                    return i + 1;
                }
            }
        }
//        "".startsWith()
        return -1;
    }

    public static void main(String[] args) {
        int prefixOfWord =
                new Topic1455().isPrefixOfWord("dumb they google jonathan corona errichto winstontang love love", "lov");
        System.out.println(prefixOfWord);
    }
}
