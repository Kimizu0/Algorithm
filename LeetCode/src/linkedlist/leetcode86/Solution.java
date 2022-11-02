package linkedlist.leetcode86;

import linkedlist.ListNode;

/** 分隔链表
 * @author WanJie
 * @describe
 * 解法: 官解 https://leetcode.cn/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode-solution-7ade/
 * @since 2022/9/28 13:08
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // 小于x的新链表哑节点
        ListNode smallDumb = new ListNode(-1);
        // 小于x的新链表首节点
        ListNode smallHead = smallDumb;
        // 大于x的新链表哑节点
        ListNode largeDumb = new ListNode(-1);
        // 大于x的新链表首节点
        ListNode largeHead = largeDumb;

        while (head != null) {
            if (head.val < x) {
                smallDumb.next = head;
                smallDumb = smallDumb.next;
            } else {
                largeDumb.next = head;
                largeDumb = largeDumb.next;
            }
            head = head.next;
        }
        // 保存的原始引用，可能有问题，需要手动解除
        largeDumb.next = null;
        // 小链表尾接上大链表的头
        smallDumb.next = largeHead.next;
        return smallHead.next;
    }
}
