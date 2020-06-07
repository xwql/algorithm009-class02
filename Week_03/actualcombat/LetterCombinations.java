package actualcombat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        search(digits, map, "", 0, ans);
        return ans;
    }

    private void search(String digits, HashMap<Character, String> map, String tmpStr, int i, List<String> ans) {
        if (i == digits.length()) {
            ans.add(tmpStr);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            search(digits, map, tmpStr + letters.charAt(j), i + 1, ans);
        }
    }
}
