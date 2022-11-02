package linkedlist.leetcode141;

import linkedlist.ListNode;

import java.util.HashSet;

/** 环形链表 II
 * @author WanJie
 * @describe 哈希表
 * https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @since 2022/9/30 14:51
 */
public class Hash {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
