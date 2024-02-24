package grind169.week1;

public class BinarySearch {
    /*
     *  Problem: https://leetcode.com/problems/binary-search/description/
     *
     *  Test Cases:
     *    nums = [-1,0,3,5,9,12], target = 9 -> 4
     *    nums = [-1,0,3,5,9,12], target = 2 -> -1 (Not found)
     */

    class Solution {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
}

