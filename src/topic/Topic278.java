package topic;

/**
 * @author: ywx
 * @description 第一个错误的版本 --二分查找
 * @Date: 2022/07/17
 */

public class Topic278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //两者的临界点
        return left;
    }
}
