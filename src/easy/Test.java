package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ywx
 * @description
 * @Date: 2022/08/26
 */

public class Test {
    /**
     * 100人 9出
     */
    public void numberOff(int num, int out) {

        List<Integer> nums = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            nums.add(i);
        }
        int len = nums.size();
        int index = 0;
        while (len > 0) {
            index = (index + out - 1) % (len);
//            System.out.print(" "+nums.remove(index));
            len--;
        }
    }

    public int findTheWinner(int n, int k) {
        //最后剩下一个人的情况时胜利者的下标是0
        int f = 0;
        //开始逆推
        for (int i = 2; i != n + 1; ++i) {
            f = (f + k) % i;//循环右移m位
        }
        return f + 1;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(new Test().findTheWinner(100000, 9));
        long time1 = System.currentTimeMillis();
        System.out.println((double) (time1 - time) / 1000);
    }


}
