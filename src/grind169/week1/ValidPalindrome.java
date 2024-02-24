package grind169.week1;

public class ValidPalindrome {
    /*
     *  Problem: https://leetcode.com/problems/valid-palindrome/description/
     *
     *  Test Cases:
     *    "A man, a plan, a canal: Panama" -> true
     *    "race a car" -> false
     *    " " -> true
     */

    class Solution {
        public boolean isPalindrome(String s) {
            char[] charArr = s.toLowerCase().toCharArray();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (!Character.isLetterOrDigit(charArr[start])) {
                    start++;
                    continue;
                }
                if (!Character.isLetterOrDigit(charArr[end])) {
                    end--;
                    continue;
                }
                if (charArr[start] != charArr[end]) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}

