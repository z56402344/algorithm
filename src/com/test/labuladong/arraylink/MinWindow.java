package com.test.labuladong.arraylink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//labuladong page_4 滑动窗口
public class MinWindow {

    public static void main(String[] args) {
	// write your code here
//        String tagStr = minWindow("fdafa", "aa");
//        System.out.println("tagStr="+tagStr);

//        boolean isCheck = checkInclusion("ab", "fjdkladbfdk");
//        System.out.println("isCheck="+isCheck);

//        List<Integer> list = findAnagrams("cbaebabacd", "abc");
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            System.out.println(list.get(i));
//        }

        int len = lengthOfLongestSubstring("asdfghjkllk");
        System.out.println("len="+len);
    }

    //最小覆盖子串给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //注意：
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案
    public static String minWindow(String s, String t){
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    //给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
    //换句话说，s1 的排列之一是 s2 的 子串 。
    public static boolean checkInclusion(String s1, String s2){
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    //438. 找到字符串中所有字母异位词
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(right - left >= p.length()){
                if (valid == need.size()){
                    list.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return list;
    }

    //最⻓⽆重复⼦串
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while(window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            len = Integer.max(len, right - left);
        }
        return len;
    }
}
