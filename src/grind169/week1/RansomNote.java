package grind169.week1;

public class RansomNote {
    /*
     *  Problem: https://leetcode.com/problems/ransom-note/description/
     *
     *  Test Cases:
     *    ransomNote = "a", magazine = "b" -> false
     *    ransomNote = "ab", magazine = "aab" -> true
     */

    class Solution {
        // Time Complexity: O(ransomNote.length + magazine.length), Space Complexity: O(1)
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) return false;
            int[] charCnt = new int[26];
            for(char c : magazine.toCharArray()) {
                charCnt[c-'a']++;
            }
            for(char c : ransomNote.toCharArray()) {
                if (charCnt[c-'a']-- == 0)
                    return false;
            }
            return true;
        }
    }
}

