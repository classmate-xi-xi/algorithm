package topic;

/**
 * @author: ywx
 * @description 温度转换
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 * @Date: 2023/03/21
 */

public class Topic2469 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
