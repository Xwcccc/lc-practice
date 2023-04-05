package LinkedList;

import java.util.Stack;

public class ReverList {
    /**
     * 思考一下中部元素反转过程：当前节点的next指向前面节点，然后当前节点下移，前面节点下移（这俩分别是前面保存的cur.next和cur）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head, af = null, prev = null;
        while(cur != null){
            af = cur.next;
            cur.next = prev;
            prev = cur;
            cur = af;
        }
        return prev;
    }

    /**
     * 递归做法：主要思想：假设后面一部分已经反转，现在往前一个元素，再令cur.next.next= cur，就是反转当前元素
     * 1.边界条件
     * 2.递归调用head.next
     * 3.具体返回
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 栈版本，其实就是遍历一遍，从后面开始组织，只是单向链表不支持从后面遍历，要用栈
     * 只是时空复杂度都是O(N)，不划算
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head, whead = new ListNode(), init = whead;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            whead.next = cur;
            whead = cur;
        }
        whead.next = null;
        return init.next;
    }
    public static void main(String[] args) {
        ListNode p4 = new ListNode(5,null);
        ListNode p3 = new ListNode(4,p4);
        ListNode p2 = new ListNode(3,p3);
        ListNode p1 = new ListNode(2,p2);
        ListNode head = new ListNode(1,p1);
        ReverList r = new ReverList();
        r.reverseList(head);
    }
}


