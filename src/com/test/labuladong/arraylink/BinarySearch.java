package com.test.labuladong.arraylink;

import java.util.PriorityQueue;

//二分查找 扩展题型
public class BinarySearch {

    public static void main(String[] args) {
        int[] n = {5,7,7,8,8,10};

//        int mid = binarySearch(n,5);
//        System.out.println("mid="+mid);

        int left = left_bound(n, 8);
        int right = right_bound(n, 8);
        System.out.println("left="+left+", right="+right);

    }

    public static int bs(int[] n, int t){
        int left = 0, right = n.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (n[mid] == t){
                return mid;
            }else if (n[mid] < t){
                left = mid + 1;
            }else if (n[mid] > t){
                right = mid -1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] n, int t){
        int left = 0, right = n.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(n[mid] == t){
                return mid;
            }else if (n[mid] > t){
                right = mid - 1;
            }else if (n[mid] < t){
                left = mid + 1;
            }
        }
        return -1;
    }

    //寻找左侧边界的⼆分查找
    public static int left_bound(int[] n, int t){
        int left = 0, right = n.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(n[mid] == t){
                right = mid - 1;
            }else if (n[mid] > t){
                right = mid - 1;
            }else if (n[mid] < t){
                left = mid + 1;
            }
        }
        if (left >= n.length || n[left] != t){
            return -1;
        }
        return left;
    }

    //寻找右侧边界的⼆分查找
    public static int right_bound(int[] n, int t){
        int left = 0, right = n.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(n[mid] == t){
                left = mid + 1;
            }else if (n[mid] > t){
                right = mid - 1;
            }else if (n[mid] < t){
                left = mid + 1;
            }
        }
        if (right < 0 || n[right] != t){
            return -1;
        }
        return right;
    }



}
