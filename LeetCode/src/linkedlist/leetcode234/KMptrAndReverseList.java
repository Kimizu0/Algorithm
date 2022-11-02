package linkedlist.leetcode234;

import linkedlist.ListNode;

/**
 * 回文链表
 *
 * @author WanJie
 * @describe 快慢指针 + 反转链表
 * https://leetcode.cn/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @since 2022/10/2 16:28
 */
public class KMptrAndReverseList {

    public boolean isPalindrome(ListNode head) {

        // 找到前半段最后一个节点
        ListNode endOfFirstHalf = findEndOfFirstHalf(head);
        // 反转后半部分链表
        ListNode startOfSecondHalf = reverseList(endOfFirstHalf.next);

        boolean res = true;
        ListNode p1 = head;
        ListNode p2 = startOfSecondHalf;

        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 把后半部分反转回来，虽然不反转回来也行，但大多希望使用该函数后不影响原来的链表
        ListNode originPos = reverseList(startOfSecondHalf);
        endOfFirstHalf.next = originPos;
        return res;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
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
     * 找到中间节点，偶数节点中的第一个
     *
     * @param head
     * @return
     */
    private ListNode findEndOfFirstHalf(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


}
