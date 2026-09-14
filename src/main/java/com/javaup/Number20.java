package com.javaup;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Number20 {

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 != 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>(){{
            put('(',')');
            put('[',']');
            put('{','}');
        }};
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(c != map.get(pop)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
