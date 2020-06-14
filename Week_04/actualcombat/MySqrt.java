package actualcombat;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        int l = 0, r = x;
        long res = 0;
        while (l <= r) {
            int mid = l + (r - l)/2;
            long mid2 = (long)mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 < x) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
                res = r;
            }
        }
        return (int)res;
    }
}
