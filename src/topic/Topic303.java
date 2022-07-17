package topic;

/**
 * @author: ywx
 * @description 区域和检索 - 数组不可变
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的和，其中left <= right
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的总和
 * 包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 * @Date: 2022/07/17
 */

public class Topic303 {

    //前缀和数组
    private int[] preSum;

    //NumArray
    //前缀和思想
    public Topic303(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, -4, 2, 6, -2,1};
        Topic303 t = new Topic303(num);
        System.out.println(t.sumRange(2,5));
    }
}
