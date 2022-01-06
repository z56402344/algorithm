package com.test.labuladong.queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;

    public MyStack() {

    }

    public void push(int x) {
        q.offer(x);
        top_elem = x;
    }

    public int pop() {
        int size = q.size();
        while(size > 2){
            q.offer(q.poll());
            size--;
        }
        top_elem = q.peek();
        q.offer(q.poll());
        return q.poll();
    }

    public int top() {
        return top_elem;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
