package com.javaup;

public class Number1456 {

    public static void main(String[] args) {
        int ans = maxVowels("abciiidef",3);
        System.out.println(ans);
    }

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int vowel = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
                vowel++;
            }
            int left = i -k + 1;
            if(left < 0){
                continue;
            }
            ans = Math.max(ans,vowel);
            char out = chars[left];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }
}
