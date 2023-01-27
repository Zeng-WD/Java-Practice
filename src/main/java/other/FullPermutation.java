package other;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Zeng-WD
 * @date 14:52 2022/6/13
 * 1 到 n 的全排列
 */
public class FullPermutation {

    //实现全排列函数，listA里保存排列完毕的数，listB里面保存还未排列的数字。
    public static void fullPermutation(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        int len_b = listB.size();
        if (len_b == 0) {
            System.out.println(listA);
        } else {
            for (int i = 0; i < len_b; i++) {
                ArrayList<Integer> tempA = (ArrayList<Integer>) listA.clone();
                ArrayList<Integer> tempB = (ArrayList<Integer>) listB.clone();
                tempA.add(tempB.remove(i));
                fullPermutation(tempA, tempB);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        int n = input.nextInt();
        while (n <= 0) {
            System.out.print("n必须大于0，请重新输入：");
            n = input.nextInt();
        }

        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        //totalAmount记录一共有多少种排列
        int totalAmount = 1;

        //初始化待排列的 listB
        for (int i = 1; i <= n; i++) {
            listB.add(i);
            totalAmount *= i;
        }
        System.out.println("\n总共有 " + totalAmount + " 种排列组合：");

        //对 listB 进行全排列
        fullPermutation(listA, listB);
    }

}
