package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number54 {

    public static void main(String[] args) {
        List<Integer> ans = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for (Integer num : ans) {
            System.out.println(num);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row - 1;
        int left = 0;
        int right = col - 1;

        List<Integer> ans = new ArrayList<>();

        while(true){
            // 右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[low][i]);
            }
            low++;
            if(low > high){
                break;
            }

            // 下
            for (int i = low; i <= high; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(right < left){
                break;
            }

            // 左
            for (int i = right; i >= left; i--) {
                ans.add(matrix[high][i]);
            }
            high--;
            if(high < low){
                break;
            }

            // 上
            for (int i = high; i >= low; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }

        return ans;
    }
}
