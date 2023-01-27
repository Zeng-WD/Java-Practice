package other;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/1/27 21:44
 * @Description 双蛋问题
 * 雙蛋問題
 * 有N個蛋，最少扔多少次（M），找到臨界層（有T層，臨界層之下，扔下的蛋不會碎，零界點往上，扔下的蛋會碎掉，沒有碎掉的蛋能夠繼續使用）
 * 遞歸思想
 * T層樓 N個蛋 關於 M(T, N)
 * 第一次選擇扔的樓層k
 * 若雞蛋碎了    M(k, N - 1)
 * 若雞蛋不碎    M(T - k, N)
 * 取兩次情況的較大值再加初始扔的次數1 Max(M(k, N - 1), M(T - k, N)) + 1
 */
public class DoubleEgg {

    public static final int T = 500;

    public static final int N = 20;

    public static void main(String[] args) {

        System.out.printf("雙蛋問題，當樓層為：%d層，雞蛋個數為：%d個時，需要至少扔 %d 次\n", T, N, doubleEggs(T, N));

    }

    /**
     * 雙蛋問題解
     *
     * @param T 樓層數量
     * @param N 雞蛋數量
     * @return 至少扔出次數
     */
    public static int doubleEggs(int T, int N) {
        int[][] dp = new int[T + 1][N + 1];

        // 边界处理,只有一个鸡蛋，i层就要扔i次
        for (int i = 1; i <= T; i++) {
            dp[i][1] = i;
        }

        // 边界处理,只有一层，不论鸡蛋有几个只要扔一次就可以
        for (int j = 1; j <= N; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= T; i++) {
            for (int j = 2; j <= N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    min = Math.min(min, Math.max(dp[i - k][j], dp[k - 1][j - 1]) + 1);
                }
                dp[i][j] = min;
            }
        }

        return dp[T][N];
    }

}
