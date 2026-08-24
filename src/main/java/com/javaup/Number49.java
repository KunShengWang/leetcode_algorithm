package com.javaup;

import java.util.*;

public class Number49 {

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[]{""});
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (List<String> list : res) {
            builder.append("[");
            for (String str : list) {
                builder.append(str).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]").append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<String> list = map.computeIfAbsent(sort(str), key -> new ArrayList<String>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
