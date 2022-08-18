package topic;

/**
 * @author: ywx
 * @description 最大相等频率
 * @Date: 2022/08/18
 */

public class Topic1224 {
    public int maxEqualFreq(int[] nums) {

        //每种数值的计数
        int[] numsCount = new int[100000 + 1];
        //对于每个计数，有多少个数值的计数相同
        int[] countsCount = new int[100000 + 1];
        //当前共有多少种计数
        int have = 0;
        //返回值
        int ret = 0;


        for (int i = 0; i < nums.length; ++i) {
            //这个数值的计数+1
            numsCount[nums[i]] += 1;

            int count = numsCount[nums[i]];

            //修正目前计数的情况
            countsCount[count - 1] -= 1;
            countsCount[count] += 1;

            //修正目前有多少计数
            if (countsCount[count - 1] == 0) {
                --have;
            }
            if (countsCount[count] == 1) {
                ++have;
            }

            //当目前只有两种计数，并且仅有一个数值的计数为1，或者两种计数值相差1且其中一个count_counts值为1，该前缀满足条件
            if ((have == 2 &&
                    (countsCount[1] == 1 ||
                            (countsCount[count + 1] == 1 || countsCount[count] == 1 && countsCount[count - 1] > 0)
                    )
            )) {
                ret = i;
            }
        }
        //如果所有数都只有一个或者所有数都相同，那么整个数组都是
        if (countsCount[1] == nums.length || countsCount[nums.length] == 1) {
            return nums.length;
        }
        return ret + 1;
    }
}
