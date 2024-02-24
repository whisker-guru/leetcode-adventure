package grind169.week1;

public class LongestPalindrome {
    /*
     *  Problem: https://leetcode.com/problems/longest-palindrome/description/
     *
     *  Test Cases:
     *    s = "abccccdd" -> 7
     *    s = "aaaccc" -> 5
     */

    class Solution {
        // Time Complexity: O(n), Space Complexity: O(1)
        public int longestPalindrome(String s) {
            int[] charCnt = new int[128];
            for(char c : s.toCharArray()) {
                charCnt[c]++;
            }
            int oddCnt = 0;
            for(int cnt: charCnt) {
                if ((cnt&1) == 1) {
                    oddCnt++;
                }
            }
            return oddCnt > 0 ? s.length() - oddCnt + 1 : s.length();
        }
    }
}

