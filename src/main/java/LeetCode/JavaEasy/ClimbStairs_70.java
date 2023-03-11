package LeetCode.JavaEasy;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/11 22:38
 * @Description
 */
public class ClimbStairs_70 {

    static int result = 0;

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    public static int climbStairs(int n) {
        // 是斐波那契数列
        // f(x) = f(x - 1) + f(x - 2)
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
