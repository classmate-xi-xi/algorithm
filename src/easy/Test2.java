package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: ywx
 * @description
 * @Date: 2022/08/26
 */

public class Test2 {
    /**
     * Input:
     * 1,2,2,3,4,5
     * 2,4,1,2,3
     * output:
     * 1,2,3,4
     * @param a
     * @param b
     */
    public void test2(int[] a, int[] b) {
        Arrays.asList(a);
        List<Integer> listA = distinct(a);
        List<Integer> listB = distinct(b);
        listA.stream().distinct();
        listA.retainAll(listB);
        for (int la : listA) {
            System.out.println(la);
        }
    }

    private List<Integer> distinct(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (!res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Test2().test2(new int[]{1, 2, 2, 3, 4, 5}, new int[]{2, 4, 1, 2, 3});
    }
}
