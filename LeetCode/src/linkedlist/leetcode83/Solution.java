package linkedlist.leetcode83;

import linkedlist.ListNode;

/** 删除排序链表中的重复元素
 * @author WanJie
 * @describe
 * 解法: 参考 leetcode82 递归
 * @since 2022/9/26 19:42
 */
public class Solution {

    /**
     * 删除以head为开头的重复节点(保留一个重复节点)
     * @return 去重链表首节点
     */
    public ListNode deleteDuplicates(ListNode head) {

        // 空节点或单节点直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 第一个节点与第二个节点不同，则第一个节点保留，以第二个节点为head递归
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            // 第一个节点与第二个相同，则第一个节点依然保留，向后遍历寻找不同的节点，然后以这个不同的节点为head递归
            ListNode move = head.next;
            while (move!=null && move.val == head.val) {
                move = move.next;
            }
            // 因为重复节点必须出现一次，就让head.next接起就好了
            head.next = deleteDuplicates(move);
        }
        // head即为去重结果
        return head;
    }
}
