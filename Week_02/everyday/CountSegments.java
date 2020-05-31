package everyday;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSegments {
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;
        String[] split = s.split(" ");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            if(!split[i].isEmpty())
                count++;
        }
        return count;
    }
}
