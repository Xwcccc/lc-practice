package LinkedList;

public class DeleteNode {
    /**
     * 203. 移除链表元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 分析：
     * 1.首先考虑普遍情况，用条件node.next!=null遍历除了最后一个元素的所有元素——分情况，一是不匹配保留元素，记录当前node为prev，当前node为下一个node；
     * 二是头元素匹配，就转移头元素和当前node，prev不变；三是链内元素匹配，prev不变，prev指向cur的下一个
     * 2.再考虑最后一个元素，判断其值，若是匹配则看有无prev，将prev指向null，没有prev就将返回空；（不能直接将cur置为空）
     * 3.边界问题：一开始node.next!=null就不成立，原因是node为空，即输入链表为空
     * 注意！！！如果节点为null就表示没有开辟内存空间/指向了一个没有开辟空间的null值，还访问会出现内存错误；
     * 相对而言，如果一个节点曾经开辟过内存空间(就是说曾经有过值)，就不会再被赋予null，因为他的内存空间会到程序结束才回收
     * 优化：
     * 1.避免讨论头结点，就在链表前放多一个节点，从他下一个开始讨论；
     * 2.为了避免记录prev，可以不遍历当前节点，而是遍历当前节点的next节点，这样删除就简化为temp.next = temp.next.next
     * 3.删除元素只要改变前一个值的指针即可，不用操作被删除元素
     * @param head
     * @param val
     * @return
     */
        public ListNode removeElements(ListNode head, int val) {
            ListNode cur = head, target = null, prev = null;
            if(head == null){
                return null;
            }
            while(cur.next != null){
                if(cur.val == val){
                    if(cur == head){
                        head = cur.next;
                        cur = head;
                    }else{
                        prev.next = cur.next;
                        cur = prev.next;
                    }
                }else{
                    prev = cur;
                    cur = cur.next;
                }
            }
            if(cur.val == val){
                if(prev != null){
                    prev.next = null;
                }else {
                    return null;
                    //cur = null没有用！看注意事项
                }
            }
            return head;
        }

    /**
     * 递归写法
     * 时间空间复杂度都是o(n)，空间复杂度是由递归栈得来的
     * 主要组成：
     * 1.边界条件
     * 2.逐层向下递归
     * 3.从最下层开始每层的返回判断
     * 分析本题：首先边界条件为null；head逐层递归，逐个压栈，最先入栈的最晚弹出（这是为了缩小判断范围）；
     * 最后从栈顶开始，根据边界条件和返回条件判断——逐个弹出，若为空则返回空，若匹配成功则返回下一个即空，若匹配失败则返回弹出值
     * 时空复杂度都为O(N)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
            if(head == null){
                return null;
            }
            removeElements2(head.next,val);
            return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        //LinkedList.ListNode p6 = new LinkedList.ListNode(6,null);
        //LinkedList.ListNode p5 = new LinkedList.ListNode(5,p6);
        //LinkedList.ListNode p4 = new LinkedList.ListNode(4,p5);
        ListNode p3 = new ListNode(7,null);
        ListNode p2 = new ListNode(7,p3);
        ListNode p1 = new ListNode(7,p2);
        ListNode head = new ListNode(7,p1);
        int val = 7;
        DeleteNode d = new DeleteNode();
        d.removeElements(head,val);
    }
}

