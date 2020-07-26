/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        char c ;
        int j = 0; //第几位
        int num = 1; //第几个字符窜
        while (true) {
            if (j >= strs[0].length()) break;
            c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j < strs[i].length()) {
                    if (c == strs[i].charAt(j)) {
                        num++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            j++;
            if (num < strs.length) break;
            num = 1;
            sb.append(c);
        }
        return sb.toString();
    }
}
