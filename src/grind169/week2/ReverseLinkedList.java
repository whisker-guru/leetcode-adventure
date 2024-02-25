package grind169.week2;

public class ReverseLinkedList {
    /*
     *  Problem: https://leetcode.com/problems/reverse-linked-list/description/
     *
     *  Test Cases:
     *    See the problem link
     */

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
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

