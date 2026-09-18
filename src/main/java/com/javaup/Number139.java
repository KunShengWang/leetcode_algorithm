package com.javaup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number139 {

    public static void main(String[] args) {

    }

    /**
     * f[i] 表示：字符串 s 的前 i 个字符能不能被字典中的单词完整拆分出来
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen,word.length());
        }
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= Math.max(i - maxLen,0); j--){
                if(f[j] && words.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
