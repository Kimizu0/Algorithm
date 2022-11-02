package recursion.leetcode203;

import recursion.ListNode;

/** 移除链表元素
 * @author WanJie
 * @describe 迭代
 * @since 2022/10/8 15:15
 */
public class Iteration {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode tmp = dummy;

        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }

}
