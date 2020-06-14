import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Jump {
    public int jump(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        int reachStep = 0; //加一的分界点
        int reach = 0;      //能跳到的最远距离
        for (int i = 0; i < nums.length; i++) {
            int newReach = i + nums[i]; //新的最远距离
            if (newReach > reach) {
                for (int j = reach + 1; j <= newReach && j < nums.length; j++) {
                    dp[j] = dp[reachStep] + 1;
                }
                reach = newReach;
            }
            if (i >= reachStep){
                reachStep = reach; //i大于分界点，分界点更新为最远距离
            }
        }
        return dp[nums.length - 1];
    }

    public int jump1(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
