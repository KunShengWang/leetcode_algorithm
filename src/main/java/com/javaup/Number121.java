package com.javaup;

public class Number121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            ans = Math.max(ans,price - minPrice);
            minPrice = Math.min(minPrice,price);
        }
        return ans;
    }
}
