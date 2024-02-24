package grind169.week1;

public class FirstBadVersion {
    /*
     *  Problem: https://leetcode.com/problems/first-bad-version/description/
     *
     *  Test Cases:
     *    n = 5, if bad = 4 -> 4
     */
    public class Solution {
        // Time Complexity: O(logN), Space Complexity: O(1)
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (isBadVersion(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start; // Due to the constraints: 1 <= bad <= n <= 231 - 1
        }
        // Not real method
        boolean isBadVersion(int version) { return false; }
    }

    public class BeforeOptimizeSolution {
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            while (start <= end) {
                int mid = start + (end-start)/2;
                if (isBadVersion(mid)) {
                    if(!isBadVersion(mid-1))
                        return mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
        // Not real method
        boolean isBadVersion(int version) { return false; }
    }
}

