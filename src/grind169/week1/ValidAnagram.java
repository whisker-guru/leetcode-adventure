package grind169.week1;

public class ValidAnagram {
    /*
     *  Problem: https://leetcode.com/problems/valid-anagram/description/
     *
     *  Test Cases:
     *    "anagram", "nagaram" -> true
     *    "zlap", "kcqx" -> false
     */

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] charCnt = new int[26];
            for (char c : s.toCharArray()) {
                charCnt[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                charCnt[c - 'a']--;
                if (charCnt[c-'a'] < 0)
                    return false;
            }
            return true;
        }
    }
}

