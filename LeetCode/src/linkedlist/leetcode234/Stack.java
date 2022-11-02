package linkedlist.leetcode234;

import linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 回文链表
 *
 * @author WanJie
 * @describe 栈
 * https://leetcode.cn/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/2 15:45
 */
public class Stack {

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
