package StackAndQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /**
     * Java的栈接口有实现函数，但是队列只有接口，只是可以用ArrayDeque或者LinkedList，都是泛型
     */
    private Queue<Integer> myqueue1 = new ArrayDeque<>();
    private Queue<Integer> myqueue2 = new ArrayDeque<>();

    public MyStack() {
    }

    public void push(int x) {
        myqueue2.add(x);
        while (!myqueue1.isEmpty()){
            myqueue2.add(myqueue1.poll());
        }
        while (!myqueue2.isEmpty()){
            myqueue1.add(myqueue2.poll());
        }
    }

    public int pop() {
        return myqueue1.poll();
    }

    public int top() {
        return myqueue1.peek();
    }

    public boolean empty() {
        return myqueue1.isEmpty() && myqueue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.empty());
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.pop());
    }
}
