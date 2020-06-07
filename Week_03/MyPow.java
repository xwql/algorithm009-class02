/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long n) {
        if (n == 0)
            return 1.0;
        double half = quickMul(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    /**
     * 通过了
     * 2.00000
     * -2147483648
     * @param x
     * @param n
     * @return
     */
    public double myPowV2(double x, int n) {
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if (n == 0) {
            return 1.0;
        }
        double half = myPowV2(x, n/2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
