package StackAndQueue;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack_begin = new Stack<>();
    private Stack<Integer> stack_end = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stack_end.isEmpty()){
            stack_begin.push(stack_end.pop());
        }
        stack_begin.push(x);
    }

    public int pop() {
        int temp = 0;
        while (!stack_begin.isEmpty()){
            temp = stack_begin.pop();
            stack_end.push(temp);
        }
        return stack_end.pop();
    }

    public int peek() {
        int result = this.pop();
        stack_end.push(result);
        return result;
    }

    public boolean empty() {
        boolean isEmpty = stack_begin.isEmpty() && stack_end.isEmpty();
        return isEmpty;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());;
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.pop());;
        myQueue.push(3);
        System.out.println(myQueue.peek());;
    }
}
