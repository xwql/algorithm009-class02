/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            step = Math.max(dp[i], step);
        }
        return step;
    }

    //二分查找+
    public int lengthOfLISV2(int[] nums) {
        int[] d = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int m = (i + j) >> 2;
                if (d[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            d[i] = x;
            if (i == size) size++;
        }
        return size;
    }
}
