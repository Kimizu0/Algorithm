package linkedlist.leetcode138;

import linkedlist.Node;

import java.util.HashMap;

/** 复制带随机指针的链表
 * @author WanJie
 * @describe 两次遍历
 * https://leetcode.cn/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @since 2022/9/29 20:30
 */
public class TwoTraverse {

    HashMap<Node,Node> nodeCache =  new HashMap<>();

    public Node copyRandomList(Node head) {
       Node curr = head;
       while (curr !=null) {
           Node currNew = new Node(curr.val);
           nodeCache.put(curr, currNew);
           curr = curr.next;
       }

       curr = head;
       while (curr != null) {
           nodeCache.get(curr).next = nodeCache.get(curr.next);
           nodeCache.get(curr).random = nodeCache.get(curr.random);
            curr = curr.next;
       }
       return nodeCache.get(head);
    }

}
