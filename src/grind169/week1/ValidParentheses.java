package grind169.week1;

import java.util.Stack;

public class ValidParentheses {
    /*
     *  Problem: https://leetcode.com/problems/valid-parentheses/description/
     *  Most votes solution: https://leetcode.com/problems/valid-parentheses/solutions/3399077/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation
     *  Test Cases:
     *    "()" -> true
     *    "([{}])" -> true
     *    "(]" -> false
     *    "[()" -> false
     */

    class Solution {
        /*
         *  Time: O(n), Space: O(n), where n is the length of the input string.
         */
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((ch == ')' && top != '(') ||
                            (ch == ']' && top != '[') ||
                            (ch == '}' && top != '{')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
