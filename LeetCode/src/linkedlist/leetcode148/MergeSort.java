package linkedlist.leetcode148;

import linkedlist.ListNode;

/** 排序链表
 * @author WanJie
 * @describe https://leetcode.cn/problems/sort-list/solution/by-nuo-nuo-zi-4-xrok/
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * @since 2022/10/2 13:30
 */
public class MergeSort {

    public ListNode sortList(ListNode head) {
        // 递归 归并
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        // 只有一个节点，无需排序
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中间节点
        ListNode mid = findMiddle(head);

        // 存储左链表 head
        ListNode next = mid.next;

        // 断开链表
        mid.next = null;

        // 递归拆分,返回排序后的头节点
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        // 返回合并后的头节点
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dumb = new ListNode(-1);
        ListNode curr = dumb;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }

        return dumb.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        // fast = head.next 偶数节点则是中间两个节点的第一个
        // fast = head 偶数节点则是中间节点的第二个
        // 奇数节点不影响
        // **本题是取第一个**
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
