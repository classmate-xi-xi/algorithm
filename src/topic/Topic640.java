package topic;

/**
 * @author: ywx
 * @description 求解方程
 * @Date: 2022/08/10
 */

public class Topic640 {
    private int xCount;
    private int sum;

    public String solveEquation(String equation) {
        String[] str = equation.split("=");
        parseString(str[0], 1);
        parseString(str[1], -1);
        if (xCount == 0) {
            return sum == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + (-sum / xCount);
        }
    }

    public void parseString(String equation, int sign) {
        int i = 0, curSign = 1;
        while (i < equation.length()) {
            char c = equation.charAt(i);
            if (c == 'x') {
                if (sign * curSign == 1) {
                    xCount++;
                } else {
                    xCount--;
                }
                i++;
            } else if (c == '-' || c == '+') {
                curSign = c == '-' ? -1 : 1;
                i++;
            } else {
                int num = 0;
                while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                    num = num * 10 + equation.charAt(i) - '0';
                    i++;
                }
                num = num * sign * curSign;
                if (i < equation.length() && equation.charAt(i) == 'x') {
                    xCount += num;
                    i++;
                } else {
                    sum += num;
                }
            }
        }
    }

    public static void main(String[] args) {
        String ans = new Topic640().solveEquation("x+5-3+x=6+x-2");
        System.out.println(ans);
    }
}
