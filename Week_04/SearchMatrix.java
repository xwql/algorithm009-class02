/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        int left = 0, right = matrix.length - 1;
        if ( target < matrix[0][0] || target > matrix[right][matrix[0].length - 1]){
            return false;
        }
        int row = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                row = mid;  //处在当前行
                break;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = matrix[0].length - 1;
        if (target < matrix[row][0] || target > matrix[row][right]) {
            return false;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
