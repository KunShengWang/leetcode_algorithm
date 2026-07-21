package com.javaup.multidimensional_array;

public class Number240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}};
        boolean ans = searchMatrix(matrix,20);
        System.out.println(ans);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;// 行
        int col = matrix[0].length;// 列
        int i = 0;
        int j = col - 1;
        while(j>= 0 && i < row){
            // 找到目标值
           if(matrix[i][j] == target){
               return true;
           } else if (matrix[i][j] < target) {
               j--;
           } else {
               i++;
           }
        }
        return false;
    }
}
