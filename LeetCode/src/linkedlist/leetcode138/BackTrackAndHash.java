package linkedlist.leetcode138;

import linkedlist.Node;

import java.util.HashMap;

/** 复制带随机指针的链表
 * @author WanJie
 * @describe 回溯+哈希
 * https://leetcode.cn/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @since 2022/9/29 20:05
 */
public class BackTrackAndHash {
    HashMap<Node, Node> nodeCache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        while (!nodeCache.containsKey(head)) {
            Node headNew = new Node(head.val);
            nodeCache.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return nodeCache.get(head);
    }
}
