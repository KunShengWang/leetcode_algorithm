package com.javaup.hash;

import java.util.*;

public class Number49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        List<List<String>> res = groupAnagrams(strs);
        for (List<String> stringList : res) {
            for (String str : stringList) {
                System.out.println(str + " ");
            }
            System.out.println("\n");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            map.computeIfAbsent(sort(str),k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
