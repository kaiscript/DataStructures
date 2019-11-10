package Algorithms.leetcode.linkedList;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 不考虑增加节点的情况下。快指针先走N，慢指针走L-N-1步，慢指针则可到达删除节点的前节点。
     * 由于头结点前面引入了虚拟节点，故快指针必须走N+1步
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟节点,避免n+1大于链表数量的情形
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
