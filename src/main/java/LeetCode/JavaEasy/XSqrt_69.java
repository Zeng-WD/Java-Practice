package LeetCode.JavaEasy;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/11 21:49
 * @Description x 的平方根
 */
public class XSqrt_69 {

    static int s;

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     * 提示：
     * 0 <= x <= 231 - 1
     */
    public static int mySqrt(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrt(x)));
    }

    public static double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }
}
