package grind169.week2;

import java.util.HashMap;

public class MajorityElement {
    /*
     *  Problem: https://leetcode.com/problems/majority-element/description/
     *  Solution Explanation:
     *      https://leetcode.com/problems/majority-element/solutions/3676530/3-method-s-beats-100-c-java-python-beginner-friendly
     *
     *  Test Cases:
     *    [3,2,3] -> 3
     *    [2,2,1,1,1,2,2] -> 2
     */

    class Solution {
        // Moore Voting Algorithm
        // Time Complexity: O(n), Space Complexity: O(1)
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                if (num == candidate)
                    count++;
                else
                    count--;
            }
            return candidate;
        }
    }

    class IntuitiveSolution {
        // Time Complexity: O(n), Space Complexity: O(n)
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> numCnt = new HashMap<>();
            for(int num : nums) {
                numCnt.put(num, numCnt.getOrDefault(num, 0)+1);
            }
            int maxCnt = 0;
            int ret = 0;
            for(Integer key : numCnt.keySet()) {
                int val = numCnt.get(key);
                if (val > maxCnt) {
                    maxCnt = val;
                    ret = key;
                }
            }
            return ret;
        }
    }
}

