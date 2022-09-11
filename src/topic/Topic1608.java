package topic;

/**
 * @author: ywx
 * @description 特殊数组的特征值
 * @Date: 2022/09/12
 */

public class Topic1608 {
    public int specialArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len + 1; i++) {
            int num = 0;
            for (int nmb : nums) {
                if (nmb >= i) {
                    num++;
                }
            }
            if (num == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
