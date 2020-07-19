package string;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(arr[left])) left++;
            while (left < right && !Character.isLetter(arr[right])) right--;
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return String.valueOf(arr);
    }
}
