package LinkedList;

public class DeleteReverNode {
    /**
     * 19. 删除链表的倒数第 N 个结点
     * 分析：由于涉及到链表后序遍历操作，一般来说是可以用栈解决，但是栈的空间复杂度高；所以采用第二种方法：一次遍历双指针法
     * 本题双指针的本质是通过计算总步长-目标倒数步长=从前到后步长，用多一个指针来获得这个步长差
     * 注意边界条件，就是步长刚好等于长度，即刚好删掉头结点head的情况，步长刚好为1的情况不是特殊情况
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vhead = new ListNode(0,head), cur = vhead, realcur = head;
        int j = 0, i = 0;
        while(j < n+1){
            j++;
            cur = cur.next;
        }
        if(cur == null){
            return head.next;
        }
        while(cur.next != null){
            cur = cur.next;
            realcur = realcur.next;
        }
        realcur.next = realcur.next.next;
        return head;
    }
}
