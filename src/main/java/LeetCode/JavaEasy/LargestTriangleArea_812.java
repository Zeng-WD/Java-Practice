package LeetCode.JavaEasy;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/1/27 21:55
 * @Description 最大三角形面积
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 */
public class LargestTriangleArea_812 {

    private static final int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {4, 0}};

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(points));
    }

    public static double largestTriangleArea(int[][] points) {
        double maxAre = 0.0;

        for (int a = 0; a < points.length; a++) {
            for (int b = a + 1; b < points.length; b++) {
                for (int c = b + 1; c < points.length; c++) {
                    int x1 = points[a][0];
                    int y1 = points[a][1];
                    int x2 = points[b][0];
                    int y2 = points[b][1];
                    int x3 = points[c][0];
                    int y3 = points[c][1];
                    maxAre = Math.max(maxAre, (Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2)));
                }
            }
        }

        return maxAre / 2;
    }
}
