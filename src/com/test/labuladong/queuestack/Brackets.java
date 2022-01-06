package com.test.labuladong.queuestack;

import java.util.Stack;

//一文秒杀三道括号题目
public class Brackets {

    //https://leetcode-cn.com/problems/valid-parentheses/
    //20. 有效的括号
    Stack<Character> left = new Stack<>();
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)return false;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                left.push(c);
            }else{
                if (!left.isEmpty() && leftof(c) == left.peek()){
                    left.pop();
                }else{
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    public char leftof(char c){
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }

    //https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
    //1541. 平衡括号字符串的最少插入次数 ())
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                need += 2;
                if (need % 2 == 1){
                    //need是奇数，需要插入一次右括号
                    res++;
                    //有括号的需求填平一次
                    need--;
                }
            }

            if (c == ')'){
                need--;
                if (need == -1){
                    //需要插入一个左括号
                    res++;
                    //对有括号的需求变成1
                    need = 1;
                }
            }
        }
        return res + need;
    }

    //类似于1541，单是这个算法是 左右括号绝对相等时的最小操作次数计算方法
    //https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
    //921. 使括号有效的最少添加
    public int minAddToMakeValid(String s) {
        int res = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
               need++;
            }
            if (c == ')'){
                need--;
                if (need == -1){
                    need = 0;
                    res++;
                }
            }
        }
        return res + need;
    }
}
