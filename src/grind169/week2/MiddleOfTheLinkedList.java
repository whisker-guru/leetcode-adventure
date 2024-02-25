package grind169.week2;

public class MiddleOfTheLinkedList {
    /*
     *  Problem: https://leetcode.com/problems/middle-of-the-linked-list/description/
     *
     *  Test Cases:
     *    [1,2,3,4,5] -> [3,4,5]
     *    [1,2,3,4,5,6] -> [4,5,6]
     */

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head.next == null) return head;
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next !=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

