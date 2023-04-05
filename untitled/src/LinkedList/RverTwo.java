package LinkedList;

public class RverTwo {
    /**
     * 24. 两两交换链表中的节点
     * 相邻元素交换，注意区分是相邻的两两都要换，还是不可重复的两两交换，本题时候后者
     * 1.边界情况
     *2.建立虚拟头结点方便查找后面元素——如果后面只剩一个元素，那就直接返回；
     * 如果还有两个元素那就交换，注意节点交换的时候后边元素要指向之前end的next，注意这个一个元素和两个元素的判断
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mark = head.next, vhead = new ListNode(0,head), start = null, end = null, temp = null;
        while(vhead.next != null){
            start = vhead.next;
            if(vhead.next.next != null){
                end = vhead.next.next;

                temp = end.next;
                vhead.next = end;
                start.next = temp;
                vhead.next.next = start;
                System.out.println(vhead.next.val+","+vhead.next.next.val);
                vhead = vhead.next.next;
            }else {
                return mark;
            }
        }
        System.out.println(mark.val);
        return mark;
    }

    public static void main(String[] args) {
       // ListNode p3 = new ListNode(4,null);
        ListNode p2 = new ListNode(3,null);
        ListNode p1 = new ListNode(2,p2);
        ListNode head = new ListNode(1,p1);
        RverTwo r = new RverTwo();
        r.swapPairs(head);
    }
}
