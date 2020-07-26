import java.util.ArrayDeque;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Day64 {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.addLast(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.removeLast();
                    if (stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peekLast());
                }
            }
        }
        return max;
    }
}
