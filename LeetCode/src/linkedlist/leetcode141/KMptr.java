package linkedlist.leetcode141;

import linkedlist.ListNode;

/** 环形链表
 * @author WanJie
 * @describe 快慢指针
 * https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @since 2022/9/30 15:16
 */
public class KMptr {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        // 快慢指针初始化都在同一节点上，但本次为了让循环跑起来，故假想前面还有一个节点 dumb节点，则 slow 指针走1步到达 head，而 fast 指针走2步到达 head.next。
        // 当然使用 do while 循环可以直接都初始化在 head 节点上。

        // 慢指针一次一步
        ListNode slow = head;
        // 快指针一次两步
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow == fast,出现环
        return true;
    }

}
