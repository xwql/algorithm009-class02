//242.给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int a = t.charAt(i) - 'a';
            if (ints[a] == 0)
                return false;
            ints[a]--;
        }
        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) - 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println("isAnagram = " + isAnagram.isAnagram("anagram","nagaram"));

    }
//350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<>();
        int k = 0;
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for (int i : nums2) {
            Integer integer = map.get(i);
            if (integer == null) {
            } else if (integer > 0){
                nums1[k++] = i;
                map.put(i, --integer);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
