package topic;

/**
 * @author: ywx
 * @description 拆炸弹
 * @Date: 2022/09/24
 */

public class Topic1652 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k == 0) {
            return new int[len];
        }
        int[] newCode = new int[len * 2];
        for (int i = 0; i < newCode.length; i++) {
            newCode[i] = code[i % len];
        }
        int[] res = new int[len];
        int[] preCode = new int[newCode.length];
        preCode[0] = newCode[0];
        for (int i = 1; i < preCode.length; i++) {
            preCode[i] = preCode[i - 1] + newCode[i];
        }
        for (int i = 0; i < len; i++) {
            if (k > 0) {
                res[i] = preCode[i + k] - preCode[i];
            } else {
                res[i] = preCode[i + len - 1] - preCode[i + k + len - 1];
            }
        }
        return res;
    }
}
