package grind169.week1;

public class MergeTwoSortedLists {
    /*
     *  Problem: https://leetcode.com/problems/merge-two-sorted-lists/description/
     *  Most votes solution:
     *  https://leetcode.com/problems/merge-two-sorted-lists/solutions/9715/java-1-ms-4-lines-codes-using-recursion
     *  Refer to the 'Comments' section below this solution, where the comparison between recursion and iteration is discussed.
     *
     *  Test Cases:
     *    [], [] -> []
     *    [1,2,4], [1,3,4] -> [1,1,2,3,4,4]
     *    [1], [] -> [1]
     *
     */

    class IterativeSolution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode();
            ListNode curr = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
            ListNode restNode = list1 == null ? list2 : list1;
            while (restNode != null) {
                curr.next = restNode;
                restNode = restNode.next;
                curr = curr.next;
            }
            return dummyHead.next;
        }
    }

    class RecursiveSolution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next =  mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    class ListNode {
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
