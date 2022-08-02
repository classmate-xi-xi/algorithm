package topic;


/**
 * @author: ywx
 * @description 整数反转
 * @Date: 2022/08/02
 */

public class Topic7 {
    /**
     * 双指针
     * @param x
     * @return
     */
    public int reverse(int x) {
        char[] c = String.valueOf(x).toCharArray();
        int left, right = c.length - 1;
        if (c[0] == '-') {
            left = 1;
        } else {
            left = 0;
        }
        while (left < right) {
            char s = c[left];
            c[left] = c[right];
            c[right] = s;
            left++;
            right--;
        }
        String res = String.valueOf(c);
        try{
            return Integer.parseInt(res);
        }catch(Exception e){
            return 0;
        }
    }

    /**
     * 数学解
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Topic7().reverse(-2143847412));
    }
}
