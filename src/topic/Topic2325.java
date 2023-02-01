package topic;

/**
 * @author: ywx
 * @description 解密消息
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次）
 * 据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * @Date: 2023/02/01
 */

public class Topic2325 {
    /**
     * @param key     key = "the quick brown fox jumps over the lazy dog"
     * @param message message = "vkbs bs t suepuv"
     * @return "this is a secret"
     */
    public String decodeMessage(String key, String message) {
        // 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母顺序
        char[] chars = new char[26];
        char cur = 'a';
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (c != ' ' && chars[index] == '\0') {
                chars[index] = cur;
                cur++;
            }
        }
        // 按照对照表,替换message
        StringBuilder sb = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(" ");
            } else {
                sb.append(chars[c - 'a']);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = new Topic2325().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println(a);
    }

}
