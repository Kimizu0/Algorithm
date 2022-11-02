package linkedlist.leetcode234;

import linkedlist.ListNode;

import java.util.ArrayList;

/** 回文链表
 * @author WanJie
 * @describe 双指针
 * https://leetcode.cn/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @since 2022/10/2 15:57
 */
public class DoublePtr {

    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        ArrayList<ListNode> list = new ArrayList<>();

        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int i = 0;
        int j = list.size()-1;

        while (i < j) {
            if (list.get(i).val != list.get(j).val) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
