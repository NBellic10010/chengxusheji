package com.company;

public class LCS {
    private int[][] C;
    public int solve(int[] X, int[] Y) {
        int len1 = X.length;
        int len2 = Y.length;
        this.C = new int[len1 + 1][len2 + 1];
        this.C[0][0] = 0;
        int M = 0;
        for(int j = 0; j < len1; j++) {
            if(X[j] == Y[0]) {
                M = 1;
            }
            this.C[j + 1][1] = M;
        }
        M = 0;
        for(int i = 0; i < len2; i++) {
            if(X[0] == Y[i]) {
                M = 1;
            }
            this.C[1][i + 1] = M;
        }

        for(int i = 1; i < len1; i++) {
            for(int j = 1; j < len2; j++) {
                if(X[i] == Y[j]) this.C[i + 1][j + 1] = this.C[i][j] + 1;
                else this.C[i + 1][j + 1] = Math.max(this.C[i][j + 1], this.C[i + 1][j]);
            }
        }

        return this.C[len1][len2];
    }

    public static void main(String[] args) {
        LCS L = new LCS();
        int result = L.solve(new int[]{1,3,4,5,6,7,7,8}, new int[]{3,5,7,4,8,6,7,8,2});
        System.out.print(result);
    }
}
