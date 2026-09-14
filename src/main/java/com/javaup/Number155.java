package com.javaup;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number155 {

    public static void main(String[] args) {

    }

    static class MinStack {

        private final Deque<int[]> stack = new ArrayDeque<>();

        public MinStack() {
            stack.push(new int[]{0,Integer.MAX_VALUE});
        }

        public void push(int value) {
            stack.push(new int[]{value,Math.min(getMin(),value)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
