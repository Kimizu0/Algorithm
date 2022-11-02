package linkedlist.leetcode143;

import linkedlist.ListNode;

/**
 * @author WanJie
 * @describe
 * @since 2022/10/1 21:16
 */
public class MidAndReverseAndMerge {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode midNode = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        midNode.next = null;

         l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 将两个链表合并，插l1的缝隙
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1, ListNode l2) {
        // 插缝合并，无论奇数个还是偶数个节点，按中点拆分后，l1始终比l2长
        // 画图理解
        ListNode l1Next;
        ListNode l2Next;

        while (l1 != null && l2 != null) {

            l1Next = l1.next;
            l2Next = l2.next;

            l1.next = l2;
            l1 = l1Next;

            l2.next = l1;
            l2 = l2Next;
        }
    }

    /**
     * 将链表反转，并返回反转后的链表头部
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        // 迭代法
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 返回链表的中间节点
     * @param head
     * @return
     */
    private ListNode getMidNode(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
