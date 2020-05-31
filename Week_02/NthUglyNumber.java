/**
 * 面试题49. 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;  //2 , 3, 5
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int a2 = dp[a] * 2, b3 = dp[b] * 3, c5 = dp[c] * 5;
            dp[i] = Math.min(a2, Math.min(b3, c5));
            if (a2 == dp[i]) a++;
            if (b3 == dp[i]) b++;
            if (c5 == dp[i]) c++;
        }
        return dp[n-1];
    }
}
