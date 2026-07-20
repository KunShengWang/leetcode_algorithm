package com.javaup.multidimensional_array;

import java.util.Arrays;

public class Number73 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        int m = matrix.length;// 一行长度
        int n = matrix[0].length;// 一列长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;// 一行长度
        int n = matrix[0].length;// 一列长度

        // 看第一行是否有 0 元素
        boolean firstRowHasZero = false;
        for (int num : matrix[0]) {
            if(num == 0){
                firstRowHasZero = true;
                break;
            }
        }

        // 看第一列是否有 0 元素
        boolean firstColHasZero = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                firstColHasZero = true;
                break;
            }
        }

        // 找除了第一行、第一列之外的 0 元素，然后把对应的第一行、第一列的对应位置设为 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 根据第一行、第一列的 0 元素把对应的行和列置为 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstColHasZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if(firstRowHasZero){
            Arrays.fill(matrix[0],0);
        }
    }
}
