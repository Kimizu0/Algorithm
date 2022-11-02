package recursion.leetcode203;

import recursion.ListNode;

/**
 * 移除链表元素
 *
 * @author WanJie
 * @describe 递归
 * @since 2022/10/8 14:28
 */
public class Recursion {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        // 从后往前替换
        return head.val == val ? head.next : head;
    }
}
