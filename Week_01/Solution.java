import java.util.HashMap;
import java.util.Stack;

public class Solution {
    HashMap<Character, Character> hashMap ;
    public Solution () {
        hashMap = new HashMap<Character,Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}' , '{');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.hashMap.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push('}');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     *
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     *
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     *
     * 示例 1:
     *
     * 输入: secret = "1807", guess = "7810"
     *
     * 输出: "1A3B"
     *
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * 示例 2:
     *
     * 输入: secret = "1123", guess = "0111"
     *
     * 输出: "1A1B"
     *
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bulls-and-cows
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        char[] secr = secret.toCharArray();
        char[] gues = guess.toCharArray();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secr.length; i++) {
            for (int j = 0; j < gues.length; j++) {
                if (secr[i] == gues[j] && i == j) {
                    bulls++;
                    gues[j] = 'a';
                    break;
                } else if (secr[i] == gues[j] && i != j && secr[j] != gues[j] && secr[i] != gues[i]) {
                    cows++;
                    gues[j] = 'a';
                    break;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
    //第二个方法更慢了(:3_ヽ)_
    public String getHintV2(String secret, String guess) {
        char[] secr = secret.toCharArray();
        char[] gues = guess.toCharArray();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secr.length; i++) {
            if (secr[i] == gues[i]) {
                bulls++;
                secr[i] = 'a';
                gues[i] = 'a';
            }
        }
        for (int i = 0; i < secr.length; i++) {
            if (secr[i] == 'a') continue;
            for (int j = 0; j < gues.length; j++) {
                if (gues[j] == 'a')
                    continue;
                if (secr[i] == gues[j]) {
                    cows++;
                    gues[j] = 'a';
                    break;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHintV3(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int sec = Character.getNumericValue(secret.charAt(i));
            int gus = Character.getNumericValue(guess.charAt(i));
            if (sec == gus) {
                bulls++;
            } else {
                if (numbers[sec] < 0) cows++;
                if (numbers[gus] > 0) cows++;
                numbers[sec]++;
                numbers[gus]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 示例1:
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     *
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        if (pattern.length() != s.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(s[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s[i])) {
                    return false;
                }
            }
            map.put(pattern.charAt(i),s[i]);
        }
        return true;
    }
}
