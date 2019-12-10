package com.company;

import java.util.Arrays;
//import static sun.swing.MenuItemLayoutHelper.max;

public class backpack_0_1 {
    private item[] items;
    private int result;
    private int maxweight;

    public backpack_0_1(int len, int maxweight, int[] weights, int[] values) {
        items = new item[len + 1];
        this.maxweight = maxweight;
        for(int i = 1; i <= len; i++) {
            if(weights[i - 1] <= maxweight) {
                item newitem = new item(weights[i - 1], values[i - 1], i);
                items[i] = newitem;
            }
        }
    }

    public int res() {
        return this.result;
    }

    public void solution() {
        int[][] dp = new int[this.items.length][maxweight + 1];
        //dp[i][j] = max{dp[i+1][j], dp[i+1][j-wi] + vi}
        int remaining = maxweight;

        for(int j = 1; j <= maxweight; j++) {
            for (int x = 1; x <= items.length - 1; x++) {
                item i = items[x];
                if(j >= i.weight) {
                    dp[i.number][j] = Math.max(dp[i.number - 1][j], dp[i.number - 1][j - i.weight] + i.value);
                    //System.out.println(Math.max(dp[i.number - 1][j], dp[i.number - 1][j - i.weight] + i.value));
                }else {
                    dp[i.number][j] = dp[i.number - 1][j];
                }
            }
        }
        //this.result = dp[this.items.length][maxweight];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
