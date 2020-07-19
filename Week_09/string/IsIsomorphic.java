package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (maps.containsKey(s.charAt(i))) {
                if (maps.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (mapt.containsKey(t.charAt(i))) {
                    if (maps.get(t.charAt(i)) != s.charAt(i)) {
                        return false;
                    }
                }
                maps.put(s.charAt(i), t.charAt(i));
                mapt.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
