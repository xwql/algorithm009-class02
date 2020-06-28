import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 *
 * 示例:
 *
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 说明：
 *
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 */
public class MaxSumSubmatrix {
    /* first  consider the situation matrix is 1D
    we can save every sum of 0~i(0<=i<len) and binary search previous sum to find
    possible result for every index, time complexity is O(NlogN).
    so in 2D matrix, we can sum up all values from row i to row j and create a 1D array
    to use 1D array solution.
    If col number is less than row number, we can sum up all values from col i to col j
    then use 1D array solution.
*/
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        boolean colsBig = col > row;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            for (int j = i; j >= 0; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int k = 0; k < n; k++) {
                    arr[k] = arr[k] + (colsBig ? matrix[j][k] : matrix[k][j]);
                    val = val + arr[k];
                    Integer subres = set.ceiling(val - target);
                    if (null != subres) {
                        ans = Math.max(ans, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return ans;
    }
}
