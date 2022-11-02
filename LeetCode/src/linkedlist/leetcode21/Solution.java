package linkedlist.leetcode21;

import linkedlist.ListNode;

/** 合并两个有序链表
 * @author WanJie
 * @describe
 * @since 2022/9/22 14:13
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode listNode = new Solution().mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
