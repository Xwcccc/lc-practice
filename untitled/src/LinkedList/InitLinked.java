package LinkedList;

import java.util.Stack;

/**
 * 分析：
 * 1.初始化节点和链表的问题：节点的初始化可以不赋予任何初始值，但空链表的定义是只含有头结点，大小为0，所以需要初始化size=0和头结点.val=0
 * 2.由于遍历都是从头结点开始，但索引却从头结点下一个元素开始，所以遍历的时候要比计划多一个元素，另外，第index个索引指的是index号元素，index还是从0开始的
 * 记得增删元素都要修改size，还有可能随时改变第一个元素，与头结点无关。总而言之，在关注局部节点的同时也要关注整体链表
 * 当index<0时按头结点后元素插入，可以通过Math.max(0,index)处理
 */
class LinkedList {
    int size;
    LinkedNode head;

    public LinkedList(){
        size = 0;
        head = new LinkedNode(0);
    }

    public int get(int index) {
        int count = 0;
        LinkedNode record = head;
        if(index >= size || index < 0){
            return -1;
        }
        while (count <= index){
            record = record.next;
            count++;
        }
        return record.val;
    }

    public void addAtHead(int val) {
        LinkedNode newnode = new LinkedNode(val,head.next);
        head.next = newnode;
        size++;
    }

    public void addAtTail(int val) {
        int count = 0;
        LinkedNode record = head;
        LinkedNode node = new LinkedNode(val);
        if(this.size == 0){
            head.next = node;
        }else{
            while(count != size){
                record = record.next;
                count++;
            }
            record.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        int count = 0;
        LinkedNode inter = head;
        LinkedNode node = new LinkedNode(val);
        index = Math.max(0,index);
        while(count != index){
            inter = inter.next;
            count++;
        }
        node.next = inter.next;
        inter.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        int count = 0;
        LinkedNode inter = this.head;
        if(index >= 0 && index < size){
            while(count != index){
                inter = inter.next;
                count++;
            }
            inter.next =  inter.next.next;
            size--;
        }
    }
}

class LinkedNode{
    int val;
    LinkedNode next;

    public LinkedNode(int val, LinkedNode next){
        this.val = val;
        this.next = next;
    }
    public LinkedNode(int val){
        this.val = val;
    }
    public LinkedNode(){
    }
}
