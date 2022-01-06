package com.test.labuladong.arraylink;

import java.util.Arrays;
import java.util.PriorityQueue;

//二分查找 扩展题型
public class HorseRacing {

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] b = {1,10,4,11};

        int[] res = advantageCount(a, b);
        int size = res == null ? 0 : res.length;
        for (int i = 0; i < size; i++) {
            System.out.println(res[i]);
        }

    }

    public static int[] advantageCount(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length){
            return null;
        }
        int n = a.length;
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) ->{
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, b[i]});
        }

        Arrays.sort(a);
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while(!maxpq.isEmpty()){
            int[] value = maxpq.poll();
            int index = value[0];
            int maxvalue = value[1];
           if (maxvalue < a[right]){
               res[index] = a[right];
               right--;
           }else{
               res[index] = a[left];
               left++;
           }
        }
        return res;
    }

}
