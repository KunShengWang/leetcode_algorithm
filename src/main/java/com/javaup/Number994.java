package com.javaup;

import java.util.ArrayList;
import java.util.List;

public class Number994 {

    private final int[][] DIRECTIONS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> rotting = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    rotting.add(new int[]{i,j});
                }
            }
        }

        while(fresh > 0 && !rotting.isEmpty()){
            ans++;
            List<int[]> temp = rotting;
            rotting = new ArrayList<>();
            for (int[] res : temp) {
                for (int[] direction : DIRECTIONS) {
                    int i = res[0] + direction[0];
                    int j = res[1] + direction[1];
                    if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
                        fresh--;
                        grid[i][j] = 2;
                        rotting.add(new int[]{i,j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : ans;
    }
}
