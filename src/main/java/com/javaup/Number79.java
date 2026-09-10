package com.javaup;

public class Number79 {

    private final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int[] cnt = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                cnt[c]++;
            }
        }

        char[] w = word.toCharArray();
        int[] wordCnt = new int[128];
        for (char c : w) {
            if(++wordCnt[c] > cnt[c]){
                return false;
            }
        }

        if(cnt[w[w.length - 1]] > cnt[w[0]]){
            w = new StringBuilder(word).reverse().toString().toCharArray();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(i,j,0,board,w)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i,int j,int k,char[][] board,char[] word){
        if (board[i][j] != word[k]) { // 匹配失败
            return false;
        }
        if (k == word.length - 1) { // 匹配成功！
            return true;
        }

        board[i][j] = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true; // 搜到了！
            }
        }
        board[i][j] = word[k]; // 恢复现场
        return false; // 没搜到
    }
}
