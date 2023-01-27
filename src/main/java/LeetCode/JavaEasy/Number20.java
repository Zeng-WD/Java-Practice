package LeetCode.JavaEasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zeng-WD
 * @date 23:40 2020/12/15
 */
public class Number20 {

    private Number20() {
    }

    private static final class SingletonInstance {
        private static final Number20 INSTANCE = new Number20();
    }

    public static Number20 instance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                Character pop = stack.pop();
                if (!map.get(pop).equals(c)) {
                    result = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }

}
