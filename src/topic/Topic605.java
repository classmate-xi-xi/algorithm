package topic;

/**
 * @author: ywx
 * @description 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * @Date: 2023/08/21
 */

public class Topic605 {
    public static void main(String[] args) {
        System.out.println(new Topic605().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    /**
     * @param flowerbed [1,0,0,0,1]
     * @param n         1
     * @return true
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] f = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, f, 1, flowerbed.length);
        for (int i = 1; i < f.length - 1; i++) {
            if (f[i - 1] == 0 && f[i] == 0 && f[i + 1] == 0) {
                f[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
