package linkedlist.leetcode82;

import linkedlist.ListNode;

/** 删除排序链表中的重复元素 II
 * @author WanJie
 * @describe 递归
 * 解法: https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solution/fu-xue-ming-zhu-di-gui-die-dai-yi-pian-t-wy0h/
 * @since 2022/9/26 14:33
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            // 第一个节点必须保留、第二个节点递归比较
            head.next = deleteDuplicates(head.next);
        } else {
            // 重复节点、向后遍历，直到不重复为止，返回不重复的节点
            ListNode move = head.next;
            while (move != null && head.val == move.val) {
                move = move.next;
            }
            // 再以不重复节点开始向后判断
            return deleteDuplicates(move);
        }
        return head;
    }
}
