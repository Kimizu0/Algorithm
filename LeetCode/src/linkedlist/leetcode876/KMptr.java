package linkedlist.leetcode876;

import linkedlist.ListNode;

import java.util.List;

/**
 * 链表的中间结点
 *
 * @author WanJie
 * @describe 快慢指针
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 * @since 2022/10/1 20:30
 */
public class KMptr {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 当fast在末尾的时候，slow一定在中点。
        while (fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
