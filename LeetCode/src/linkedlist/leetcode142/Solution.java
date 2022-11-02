package linkedlist.leetcode142;

import linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * @author WanJie
 * @describe 哈希表
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * @since 2022/9/30 15:33
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
