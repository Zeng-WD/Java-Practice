package LeetCode.JavaNormal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/1/27 21:51
 * @Description 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutation_46 {

    static List<Integer> path;
    static int n;
    static List<List<Integer>> res = new ArrayList<>();

    static int[] param = new int[]{1, 2, 3};

    public static void main(String[] args) {
        List<List<Integer>> permutation = getPermutation(param);
        for (List<Integer> list : permutation) {
            int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(ints));
        }
    }

    public static List<List<Integer>> getPermutation(int[] nums) {
//        for (int x : nums) {
//            path.add(x);
//        }
        path = Arrays.stream(param).boxed().collect(Collectors.toList());
        n = nums.length;
        backtrace(0);
        return res;
    }

    public static void backtrace(int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < n; i++) {
            Collections.swap(path, idx, i);
            backtrace(idx + 1);
            Collections.swap(path, idx, i);
        }
    }

}
