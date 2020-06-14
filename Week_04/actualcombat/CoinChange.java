package actualcombat;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //当前的目标金额是 n，至少需要 dp(n) 个硬币凑出该金额
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 0; j < coins.length; j++) {
                //if (i - coins[j] < 0) continue;
                //dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    //贪心算法，无法通过全部案例
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int times = 0;
        for (int j = coins.length - 1; j >= 0 ; j--) {
            if (coins[j] > amount) continue;
            for (int i = j; i >= 0; i--) {
                int rem = amount % coins[i];
                times += amount / coins[i];
                amount = rem;
                if (amount == 0) break;
            }
            if (amount == 0) {
                break;
            } else {
                times = 0;
            }
        }
        return times == 0 ? -1 : times;
    }
}
