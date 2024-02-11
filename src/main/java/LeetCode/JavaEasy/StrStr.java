package LeetCode.JavaEasy;


/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2024/2/8 22:59
 * @Description 找出字符串中第一个匹配项的下标
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    /**
     * 给你两个字符串 haystack 和 needle
     * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）
     * 如果 needle 不是 haystack 的一部分，则返回 -1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     * <p>
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     * <p>
     * 提示：
     * <p>
     * 1 <= haystack.length, needle.length <= 104
     * haystack 和 needle 仅由小写英文字符组成
     */
    public static int strStr(String haystack, String needle) {
        char[] haystackCharArr = haystack.toCharArray();
        char[] needleCharArr = needle.toCharArray();
        int i = 0;
        int v;
        int k;
        boolean find = false;
        while (i < haystackCharArr.length && !find) {
            k = i;
            v = 0;
            while (k < haystackCharArr.length) {
                if (haystackCharArr[k++] == needleCharArr[v]) {
                    v++;
                    if (v == needleCharArr.length) {
                        find = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            i++;
        }
        return find ? i - 1 : -1;
    }

    public int strStr_(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
