package com.javaup.array_manipulation_and_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int[] res : ans) {
            builder.append("[");
            for (int re : res) {
                builder.append(re).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static int[][] merge(int[][] intervals) {
        // 首先对这个二维数组按第一个位置的元素进行排序
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int m = ans.size();
            if(m > 0 && interval[0] <= ans.get(m - 1)[1]){
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1],interval[1]);
            }else{
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
