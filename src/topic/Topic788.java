package topic;

/**
 * @author: ywx
 * @description 旋转数字
 * @Date: 2022/09/25
 */

public class Topic788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            boolean flag = false;
            int x = i;
            while (x != 0) {
                int num = x % 10;
                x /= 10;
                if (num == 2 || num == 5 || num == 6 || num == 9) {
                    flag = true;
                } else if (num == 3 || num == 4 || num == 7) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Topic788().rotatedDigits(857);
    }
}
