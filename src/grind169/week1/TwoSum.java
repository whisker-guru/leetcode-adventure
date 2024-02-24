package grind169.week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     *  Problem: https://leetcode.com/problems/two-sum/description/
     *
     *  Test Cases:
     *    [1,2,3], 4 -> [0,2]
     *    [3,3], 6 -> [0,1]
     */

    class OnePassHashSolution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numIndexMap = new HashMap<>();
            for(int i=0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (numIndexMap.containsKey(complement)) {
                    return new int[]{numIndexMap.get(complement), i};
                }
                numIndexMap.put(nums[i], i);
            }
            return new int[]{};
        }
    }

    class TwoPassHashSolution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numIndexMap = new HashMap<>();
            for(int i=0; i < nums.length; i++) {
                numIndexMap.put(nums[i], i);
            }
            for(int i=0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (numIndexMap.get(complement) != null && numIndexMap.get(complement) != i) {
                    return new int[]{i, numIndexMap.get(complement)};
                }
            }
            return new int[]{};
        }
    }
}

