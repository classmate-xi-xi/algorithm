package topic;

/**
 * @author: ywx
 * @description 在既定时间做作业的学生人数
 * @Date: 2022/08/19
 */

public class Topic1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                result++;
            }
        }
        return result;
    }
}
