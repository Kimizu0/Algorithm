package linkedlist.leetcode92;

import linkedlist.ListNode;

import java.text.DecimalFormat;

/** 反转链表 II
 * @author WanJie
 * @describe
 * https://leetcode.cn/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
 * @since 2022/9/28 15:39
 */
public class Solution {

    /**
     * 穿针引线 O(n) O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;

        // 从dumb节点出发 left-1 步到达left前的prev节点
        ListNode preNode = dumb;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }

        // 从prev节点出发 right-left+1 步到达right节点
        ListNode rightNode = preNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // right的后继节点，后续穿针引线
        ListNode succNode = rightNode.next;

        // left节点
        ListNode leftNode = preNode.next;

        // 切割指定节点链表
        preNode.next = null;
        rightNode.next = null;

        // 反转链表
        reverseList(leftNode);

        // 穿针引线
        preNode.next = rightNode;
        leftNode.next = succNode;

        return dumb.next;
    }

    /**
     * 反转链表
     */
    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
