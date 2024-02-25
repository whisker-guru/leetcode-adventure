package grind169.week2;

public class AddBinary {
    /*
     *  Problem: https://leetcode.com/problems/add-binary/description/
     *  Solution Explanation:
     *    https://leetcode.com/problems/add-binary/solutions/1679423/well-detailed-explaination-java-c-python-easy-for-mind-to-accept-it
     *
     *  Test Cases:
     *    a = "1010", b = "1011" -> "10101"
     */

    class Solution {
        // Time Complexity: O(max(a.length, b.length)), Space Complexity: O(max(a.length, b.length))
        public String addBinary(String a, String b) {
            char[] result = new char[Math.max(a.length(), b.length())+1];
            int rIdx = result.length - 1;
            int aIdx = a.length() - 1;
            int bIdx = b.length() - 1;
            int carry = 0;
            while(aIdx >= 0 || bIdx >= 0) {
                int sum = carry;
                if (aIdx >= 0) sum += a.charAt(aIdx) - '0';
                if (bIdx >= 0) sum += b.charAt(bIdx) - '0';
                result[rIdx] = (sum % 2 == 1) ? '1' : '0';
                carry = sum / 2;
                aIdx--;
                bIdx--;
                rIdx--;
            }
            result[rIdx] = (carry > 0) ? '1' : '0';
            return carry > 0 ? new String(result) : new String(result, 1, result.length-1);
        }
    }

    class StringBuilderSolution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int carry = 0;
            int aIdx = a.length() - 1;
            int bIdx = b.length() - 1;

            while (aIdx >= 0 || bIdx >= 0 || carry > 0) {
                int sum = carry;
                if (aIdx >= 0) sum += a.charAt(aIdx--) - '0';
                if (bIdx >= 0) sum += b.charAt(bIdx--) - '0';
                result.append(sum % 2);
                carry = sum / 2;
            }

            return result.reverse().toString();
        }
    }
}

