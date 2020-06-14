package actualcombat;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= num) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res * res == num || (res + 1) *  (res + 1) == num;
    }

    public boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        int left = 0, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long m = (long)mid * mid;
            if (m == num) {
                return true;
            } else if (m < num) {
                left = mid +  1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
