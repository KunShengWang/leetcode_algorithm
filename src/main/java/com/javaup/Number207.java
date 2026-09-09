package com.javaup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number207 {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g,i -> new ArrayList<>());
        for (int[] arr : prerequisites) {
            g[arr[1]].add(arr[0]);
        }

        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(colors[i] == 0 && dfs(i,g,colors)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int x,List<Integer>[] g,int[] colors){
        colors[x] = 1;
        for (Integer y : g[x]) {
            if(colors[y] == 1 || colors[y] == 0 && dfs(y,g,colors)){
                return true;
            }
        }
        colors[x] = 2;
        return false;
    }
}
