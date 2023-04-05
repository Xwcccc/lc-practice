package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * MaxWindows中的单调队列实现，针对一道题的
 */
public class MyMovingQueue {
    Deque<int[]> deque = new LinkedList<>();

    public void add(int[] x){
        while (!deque.isEmpty() && deque.getLast()[0] < x[0]){
            deque.removeLast();
        }
        deque.add(x);
    }

    public void poll(int val){
        if(!deque.isEmpty() && deque.peek()[1] == val){
            deque.poll();
        }
    }

    public int[] peek(){
        return deque.peek();
    }
}
