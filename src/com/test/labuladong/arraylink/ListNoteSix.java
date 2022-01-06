package com.test.labuladong.arraylink;

import com.test.labuladong.bean.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

//⼀⽂搞懂单链表的六⼤解题套路
public class ListNoteSix {

    public static void main(String[] args) {

    }

    //https://leetcode-cn.com/problems/merge-two-sorted-lists/
    //21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dump = new ListNode(-1), p = dump;
        while(list1 != null && list2 != null){
            if (list1.val > list2.val){
                p.next = list2;
                list2 = list2.next;
            }else{
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1 != null){
            p.next = list1;
        }

        if (list2 != null){
            p.next = list2;
        }
        return dump.next;
    }

    //https://leetcode-cn.com/problems/merge-k-sorted-lists/
    //23. 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)return null;
        ListNode dump = new ListNode(-1) , p = dump;
        //优先级队列，最⼩堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null){
                pq.offer(head);
            }
        }
        while (!pq.isEmpty()){
           ListNode node = pq.poll();
           p.next = node;
           if (node.next != null){
               pq.offer(node.next);
           }
           p = p.next;
        }
        return dump.next;
    }

    //https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
    //19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode res = findListNode(dump, n+1);
        res.next = res.next.next;
        return dump.next;
    }

    public ListNode findListNode(ListNode head, int n){
        if (head == null)return null;
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //https://leetcode-cn.com/problems/linked-list-cycle/
    //141. 环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null)return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast.val == slow.val){
                return true;
            }
        }
        return false;
    }

    //https://leetcode-cn.com/problems/linked-list-cycle-ii/
    //142. 环形链表 II
    public ListNode detectCycle(ListNode head) {
        if (head == null)return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
    //876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        if (head == null)return  null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
    //160. 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }

            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;
    }

    //https://leetcode-cn.com/problems/reverse-linked-list-ii/
    //92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dump.next;
    }
}
