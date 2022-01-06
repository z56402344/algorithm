package com.test.labuladong.queuestack;

import java.util.Stack;

//二分查找 扩展题型
public class MyQueue {

    private Stack<Integer> stack1, stack2;

    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val){
        stack1.push(val);
    }

    public int pop(){
        peek();
        return stack2.pop();
    }

    public int peek(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
