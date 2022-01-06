package com.test.labuladong.arraylink;

import com.test.labuladong.bean.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

//二分查找 扩展题型
public class Array {

    public static void main(String[] args) {

        removeDuplicates();

    }



    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    //删除有序数组中的重复项（简单）
    public static void removeDuplicates(){
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int size = removeDuplicates(a);
        for (int i = 0; i < size; i++) {
            System.out.println(a[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int slow = 0, fast = 0;
        while(fast < len){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
    //删除排序链表中的重复元素
    public static void deleteDuplicates() {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)return null;
        ListNode slow = head, fast = head;
        while(fast != null){
            if (fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    //https://leetcode-cn.com/problems/remove-element/
    //移除元素
    public static int removeElement(int[] nums, int val) {
        if (nums ==  null || nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //https://leetcode-cn.com/problems/move-zeroes/
    //283. 移动零
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
