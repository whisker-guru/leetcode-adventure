package grind169.week2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /*
     *  Problem: https://leetcode.com/problems/contains-duplicate/description/
     *  Solution Explanation:
     *    https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly
     *  Test Cases:
     *    [1,2,3,1] -> true
     *    [1,2,3,4] -> false
     */

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}

