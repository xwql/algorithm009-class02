public class NumDecodings {
    public int numDecodings(String s) {
        char[] nums = s.toCharArray();
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == '0') continue;
            int num = 0;
            for (int j = i; j < len && j - i < 2; j++) {
                num = num * 10 + (nums[j] - '0');
                if (num <= 26) dp[i] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
