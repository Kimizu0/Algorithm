package linkedlist.leetcode876;

import linkedlist.ListNode;

/**
 * 链表的中间结点
 *
 * @author WanJie
 * @describe 线性表
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * @since 2022/10/1 20:30
 */
public class LinerList {

    public ListNode middleNode(ListNode head) {
        int t = 0;
        ListNode[] list = new ListNode[100];
        while (head != null) {
            list[t++] = head;
            head = head.next;
        }
        return list[t / 2];
    }

}
