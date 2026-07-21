package com.javaup.multidimensional_array;

public class Number48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int row = matrix.length;// 行
        int col = matrix[0].length;// 列
        rotate(matrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;// 行
        int col = matrix[0].length;// 列
        // 转置：把基于对角线对称的元素交换位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 按列交换位置：i 列与 n - i - 1 列交换位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;
            }
        }
    }
}
