package linkedlist.leetcode206;

import linkedlist.ListNode;

/**
 * @author WanJie
 * @describe 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * @since 2022/9/28 15:00
 */
public class Solution {

    /**
     * 迭代: O(n) O(1)
     */
    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> null
        // null <- 1 <- 2 <- 3 <- 4
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


/*    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dumb = new ListNode(-1);
        ListNode res = dumb;

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            dumb.next = stack.pop();
            dumb = dumb.next;
        }
        // 避免成环
        dumb.next = null;

        return res.next;
    }*/

}
