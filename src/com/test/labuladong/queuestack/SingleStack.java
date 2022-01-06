package com.test.labuladong.queuestack;

import java.util.*;

//单调栈结构解决三道算法题
public class SingleStack {
    //public Stack extends Vector
    //因为集成自Vector，所以Stack类是同步的，效率不高。官方一般建议这样使用ArrayDeque代替Stack


    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        nextGreaterElement2(nums1, nums2);
    }
    //
    private Stack<Integer> stack = new Stack<>();
    //https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
    //496. 下一个更大元素 I 暴力解法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int temp = -1;
        for (int i = 0; i < nums1.length; i++) {
            int k = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    k = j;
                }
            }
            for (int j = k; j < nums2.length; j++) {
               if (nums1[i] < nums2[j]){
                   temp = nums2[j];
                   break;
               }
            }
            res[i] = temp;
            temp = -1;
        }
        return res;
    }

    //https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
    //496. 下一个更大元素 I 单调压栈解法
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    //https://leetcode-cn.com/problems/next-greater-element-ii/
    //503. 下一个更大元素 II 环形
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    //https://leetcode-cn.com/problems/daily-temperatures/
    //739. 每日温度
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

}
