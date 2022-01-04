package com.test;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String tagStr = minWindow("fjdklsaxbca", "abc");
        System.out.println("tagStr="+tagStr);
    }

    public static String minWindow(String s, String t){
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, 1);
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
}
