package LeetCode.test;

import org.checkerframework.checker.units.qual.A;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zeng-WD
 * @date 23:42 2020/12/15
 */
public class Test {

    public static  List<List<Integer>> result = new ArrayList<>();

    public static  List<Integer> list;

    public static int n;


    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[] {1, 2, 3};
        method(arr);
        result.forEach(System.out::println);
    }

    public static void method(int[] arr) {
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        n = list.size();
        backTrace(0);
    }

    public static void backTrace(int idx) {
        if (idx == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < n; i++) {
            Collections.swap(list, idx, i);
            backTrace(idx + 1);
            Collections.swap(list, idx, i);
        }

    }

}
