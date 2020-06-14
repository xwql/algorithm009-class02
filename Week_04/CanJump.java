import java.util.Arrays;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null) return true;
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
    //记录能到达的最远位置
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i < len; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i <= reach && reach < len - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= len - 1;
    }
}
