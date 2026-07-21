package com.javaup.multidimensional_array;

import java.util.ArrayList;
import java.util.List;

public class Number54 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = spiralOrder(matrix);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;// 行
        int col = matrix[0].length;// 列
        List<Integer> ans = new ArrayList<>();
        int rowHigh = 0;
        int rowLow = row - 1;
        int colLeft = 0;
        int colRight = col - 1;
        while(true){
            // 上
            for (int i = colLeft; i <= colRight; i++) {
                ans.add(matrix[rowHigh][i]);
            }
            rowHigh++;
            if(rowHigh > rowLow){
                break;
            }
            // 右
            for (int i = rowHigh; i <= rowLow; i++) {
                ans.add(matrix[i][colRight]);
            }
            colRight--;
            if(colRight < colLeft){
                break;
            }
            // 下
            for (int i = colRight; i >= colLeft; i--) {
                ans.add(matrix[rowLow][i]);
            }
            rowLow--;
            if(rowLow < rowHigh){
                break;
            }
            // 左
            for (int i = rowLow; i >= rowHigh; i--) {
                ans.add(matrix[i][colLeft]);
            }
            colLeft++;
            if(colLeft > colRight){
                break;
            }
        }
        return ans;
    }
}
