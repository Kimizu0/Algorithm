package linkedlist.leetcode143;

import linkedlist.ListNode;

import java.util.ArrayList;

/**
 * 重排链表
 *
 * @author WanJie
 * @describe 线性表
 * https://leetcode.cn/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * @since 2022/10/1 18:46
 */
public class LinerList {

    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}