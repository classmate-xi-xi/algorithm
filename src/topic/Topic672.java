package topic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ywx
 * @description 灯泡开关 Ⅱ
 * @Date: 2022/09/15
 */

public class Topic672 {
    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= status << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }
}
