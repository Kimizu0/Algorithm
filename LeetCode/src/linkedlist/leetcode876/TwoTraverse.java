package linkedlist.leetcode876;

import linkedlist.ListNode;

/**
 * 链表的中间结点
 *
 * @author WanJie
 * @describe 两次遍历
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 * @since 2022/10/1 20:30
 */
public class TwoTraverse {

    public ListNode middleNode(ListNode head) {
        int t = 0;
        ListNode curr = head;
        while (curr != null) {
            t++;
            curr = curr.next;
        }
        int k = 0;
        curr = head;
        while (k < t / 2) {
            ++k;
            curr = curr.next;
        }
        return curr;
    }

}
