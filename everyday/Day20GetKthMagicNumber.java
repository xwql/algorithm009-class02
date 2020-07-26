/**
 * 面试题 17.09. 第 k 个数
 *
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class Day20GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        int[] arr = new int[k];
        int a = 0, b = 0, c = 0;
        arr[0] = 1;
        for (int i = 1; i < k; i++) {
            int a3 = arr[a] * 3;
            int b5 = arr[b] * 5;
            int c7 = arr[c] * 7;
            arr[i] = Math.min(a3, Math.min(b5, c7));
            if (arr[i] == a3) a++;
            if (arr[i] == b5) b++;
            if (arr[i] == c7) c++;
        }
        return arr[k - 1];
    }
}
