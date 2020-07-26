import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class Day55RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = count; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    if (j > count) {
                        int temp = arr1[count];
                        arr1[count] = arr1[j];
                        arr1[j] = temp;
                    }
                    count++;
                }
            }
        }
        if (arr1.length > arr2.length) {
            Arrays.sort(arr1, count, arr1.length);
        }
        return arr1;
    }
}
