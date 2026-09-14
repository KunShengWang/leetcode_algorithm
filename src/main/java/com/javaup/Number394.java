package com.javaup;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number394 {

    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        int num = 0;
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(res);
                num = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                int repeat = numStack.pop();
                StringBuilder pre = strStack.pop();
                pre.append(res.toString().repeat(repeat));
                res = pre;
            }else{
                res.append(c);
            }
        }

        return res.toString();
    }
}
