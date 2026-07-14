package com.javaup.sliding_window;

public class Number1456 {

    public static void main(String[] args) {
        int ans = maxVowels("abciiidef",3);
        System.out.println(ans);
    }

    public static int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
        }
        int ans = vowelCount;
        for (int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
            if(isVowel(s.charAt(i - k))){
                vowelCount--;
            }
            ans = Math.max(ans,vowelCount);
        }
        return ans;
    }

    private static boolean isVowel(char s){
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }
}
