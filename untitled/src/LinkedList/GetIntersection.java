package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.07. 链表相交
 */
public class GetIntersection {
    /**
     * hash做法
     * 题解：由于要找到两个链表相交的节点，就是说在两个集合中找到第一个相同的，即在BList中找到第一个与AList元素相同的元素；
     * Hash集合就是利用存储值计算出键值，有不可替代性，适合等值查询（虽然可能出现键值相等的情况，但是这种情况只能用桶来讨论，本题不涉及）
     * 思路：将AList中的元素逐个加到Hash集合中，再遍历BList的元素，逐个判断有没有出现在哈希集合里。
     * 时间复杂度：O(M+N),空间复杂度O(M)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(curA != null){
            nodeSet.add(curA);
            curA = curA.next;
        }
        while (curB != null){
            if(nodeSet.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    /**
     * 分析：找到这种长短不一共同遍历的特性，交叉循环一遍最后会回到相等的地方
     * 时间复杂度O(M+N),空间复杂度O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA!=pB){
            pA = pA==null ? headB : pA.next;
            pB = pB==null ? headA : pB.next;
        }
        return pA;
    }
}
