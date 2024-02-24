package grind169.week1;

public class ClimbingStairs {
    /*
     *  Problem: https://leetcode.com/problems/climbing-stairs/description/
     *
     *  Test Cases:
     *    n = 1 -> 1
     *    n = 2 -> 2
     *    n = 3 -> 3
     */

    class Solution {
        // Time Complexity: O(n), Space Complexity: O(n)
        public int climbStairs(int n) {
            int[] mem = new int[n+1];
            return climbStairs(n, mem);
        }
        public int climbStairs(int n, int[] mem) {
            if (n <= 2) return n;
            if (mem[n] != 0) return mem[n];
            mem[n] = climbStairs(n-1, mem) + climbStairs(n-2, mem);
            return mem[n];
        }
    }
}

