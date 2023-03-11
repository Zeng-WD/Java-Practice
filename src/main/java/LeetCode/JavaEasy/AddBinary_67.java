package LeetCode.JavaEasy;

import java.util.Collections;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/11 19:19
 * @Description 二进制求和
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     * 示例 1：
     * 输入:a = "11", b = "1"
     * 输出："100"
     * 示例 2：
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     * 提示：
     * 1 <= a.length, b.length <= 104
     * a 和 b 仅由字符 '0' 或 '1' 组成
     * 字符串如果不是 "0" ，就不含前导零
     */
    public static String addBinary(String a, String b) {
        int diffLength = a.length() - b.length();
        if (diffLength > 0) {
            b = String.join("", Collections.nCopies(diffLength, "0")) + b;
        }
        if(diffLength < 0) {
            a = String.join("", Collections.nCopies(Math.abs(diffLength), "0")) + a;
        }
        StringBuilder c = new StringBuilder();
        int e = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int intA = Integer.parseInt(a.charAt(i) + "");
            int intB = Integer.parseInt(b.charAt(i) + "");
            if (intA + intB + e > 1) {
                if (intA + intB + e > 2) {
                    c.append('1');
                } else {
                    c.append('0');
                }
                e = 1;
            } else {
                if (intA + intB + e == 1) {
                    c.append("1");
                } else {
                    c.append("0");
                }
                e = 0;
            }
        }
        if (e > 0) {
            c.append("1");
        }
        return c.reverse().toString();
    }

}
