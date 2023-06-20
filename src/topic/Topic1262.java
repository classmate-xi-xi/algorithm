package topic;

/**
 * @author: ywx
 * @description 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * @Date: 2023/06/20
 */

public class Topic1262 {
    public static void main(String[] args) {
        Topic1262 t = new Topic1262();
        t.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
    }
    // 不断求和对3取余.能被三整除的和永远在第一位
    public int maxSumDivThree(int[] nums) {
        int[] res = new int[3];
        for (int num : nums) {
            int a = res[0] + num;
            int b = res[1] + num;
            int c = res[2] + num;
            res[a % 3] = Math.max(res[a % 3], a);
            res[b % 3] = Math.max(res[b % 3], b);
            res[c % 3] = Math.max(res[c % 3], c);
        }
        return res[0];
    }
}
