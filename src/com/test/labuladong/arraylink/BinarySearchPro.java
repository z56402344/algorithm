package com.test.labuladong.arraylink;

//二分查找
public class BinarySearchPro {

    public static void main(String[] args) {
        int[] n = {3,6,7,11};
        int[] m = {1,2,3,4,5,6,7,8,9,10};
        int left = 0;
//        left = minEatingSpeed(n, 8);

        left = shipWithinDays(m, 5);
        System.out.println("left="+left);
    }

    //https://leetcode-cn.com/problems/koko-eating-bananas/
    //875. 爱吃香蕉的珂珂
    public static int minEatingSpeed(int[] piles, int H){
        if (piles.length == 0) return -1;
        int left = 1;
        int right = 10 * 9 + 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= H){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static int f(int[] piles, int mid){
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / mid;
            if (piles[i] % mid > 0){
                hour++;
            }
        }
        return hour;
    }

    //https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/submissions/
    //1011. 在 D 天内送达包裹的能力
    public static int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 0;
        //算出最小装载量和最大装载量
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        //
        while (left < right){
            int mid = left + (right - left) / 2;
            if (f2(weights, mid) == days){
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            }else if (f2(weights, mid) > days){
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }else if (f2(weights, mid) < days){
                // 需要让 f(x) 的返回值大一些
                right = mid;
            }
        }
        return left;
    }

    //x=当前装在容量
    public static int f2(int[] weights, int x){
        int day = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length){
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            day++;
        }
        return day;
    }

}
