package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DeleteCycle {
    /**
     * 用Hash主要是注意边界：比如无环的时候结尾是指向null的，以及链表为空的时候
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if(head == null){
            return null;
        }
        Set<ListNode> hashset = new HashSet<ListNode>();
        ListNode cur = head;
        while(!hashset.contains(cur)){
            hashset.add(cur);
            if(cur.next == null){
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }
    /**
     * 像这种找公共点、找环的起始点、找倒数第几个元素，都可以用双指针法
     * 本题分析：利用双指针选择不同的步长，利用步长之间的速度关系和首次相遇的距离关系构建方程表达式，
     * 最终得出结论：从起始点到环起点的长度，就是相遇点到入环点的长度
     * 用curB != curA条件会导致curB的初始条件难以正确的确定，所以不用这个条件了，用curB！=null也一样，只不过curB != curA条作其中的判断条件
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curA = head, curB = head;
        while (curB != null){
            if(curB.next == null){
                return null;
            }
            curA = curA.next;
            curB = curB.next.next;
            if(curB != curA){
                curB = head;
                while (curA != curB){
                    if(curA.next == null){
                        return null;
                    }
                    curA = curA.next;
                    curB = curB.next;
                }
                return curA;
            }
        }
        return null;
    }
}
