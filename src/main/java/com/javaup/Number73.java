package com.javaup;

import java.util.Arrays;

public class Number73 {

    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowHasZero = false;
        for(int num : matrix[0]){
           if(num == 0){
               rowHasZero = true;
               break;
           }
        }
        boolean colHasZero = false;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(colHasZero){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if(rowHasZero){
            Arrays.fill(matrix[0],0);
        }
    }
}
