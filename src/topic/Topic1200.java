package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ywx
 * @description 1200题最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * @Date: 2022/07/04
 */

public class Topic1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = arr.length;
        Arrays.sort(arr);
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < max) {
                List<Integer> list = new ArrayList<>();
                //所有具有最小绝对差的元素对 清空原来的答案list
                lists.clear();
                max = diff;
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
            }else if (diff == max) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Topic1200 t = new Topic1200();
        int arr[] = new int[]{5,2,1,3};
        System.out.println(t.minimumAbsDifference(arr).toString());
    }
}
