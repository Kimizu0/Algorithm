package recursion;

import java.util.Stack;

/** 从尾到头打印链表
 * @author WanJie
 * @describe 借助 Stack
 * @since 2022/10/10 21:51
 */
public class swordoffer06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

}
