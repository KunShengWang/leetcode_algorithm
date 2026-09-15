package com.javaup;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number739 {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while(!st.isEmpty() && t > temperatures[st.peek()]){
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }

        return ans;
    }
}
