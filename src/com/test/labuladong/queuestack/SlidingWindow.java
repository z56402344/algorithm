package com.test.labuladong.queuestack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {

    public static class MonotonicQueue{
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n){
            while (!q.isEmpty() && q.getLast() < n){
                q.pollLast();
            }
            q.addLast(n);
        }

        public int max(){
            return q.getFirst();
        }

        public void pop(int n){
            if (n == q.getFirst()){
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1){
                queue.push(nums[i]);
            }else{
                queue.push(nums[i]);
                list.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
