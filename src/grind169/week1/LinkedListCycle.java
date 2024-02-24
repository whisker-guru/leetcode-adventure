package grind169.week1;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    /*
     *  Problem: https://leetcode.com/problems/linked-list-cycle/description/
     *
     *  Test Cases:
     *    See the problem link
     *
     */

    class Solution {
        // Time Complexity: O(n), Space Complexity: O(1)
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }
            return false;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

