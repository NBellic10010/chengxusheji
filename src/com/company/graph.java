package com.company;

public class graph {
    private int[][] g;
    private String result;
    {
        this.g = new int[][] {
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0 ,1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };
        this.result = "";
    }

    public void solve(int n, int p, String res) {
        if(p == n) {
            //System.out.println(n);
            res += Integer.toString(n);
            System.out.println(res + "\n");
            return;
        }
        for(int i = p; i <= n; i++) {
            if(this.g[p][i] == 1) {
                    //System.out.print(i + " ---> ");
                    res += (p + "--->");
                    solve(n, i, res);
                    //remove
                    res = res.substring(0, (res.length() - (i + "--->").length()));
                }

        }
    }

    public static void main(String[] args) {
        graph g = new graph();
        g.solve(9, 0, "");
    }

}
