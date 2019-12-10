package com.company;

public class knight_walking {
    private int n;
    private boolean[][] world;

    public knight_walking(int n, int knight_x, int knight_y) {
        this.n = n;
        this.world = new boolean[n][n];
        for(int i = 0; i < this.world.length; i++) {
            for(int j = 0; j < this.world[0].length; j++) {
                world[i][j] = false;
            }
        }
        world[knight_x][knight_y] = true;
    }

    public boolean outofbound(int x) {
        if(x < 0) return true;
        else return x > n ? true : false;
    }

    public boolean walk(int x, int y) {
        boolean success = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!this.world[i][j]) success = false;
            }
        }

        if((outofbound(x) || outofbound(y)) && !success) return false;
        else this.world[x][y] = true;
        if(!walk(x + 2, y + 1)) this.world[x + 2][y + 1] = false;
        walk(x + 1, y + 2);
        walk(x - 1, y + 2);
        walk(x - 2, y + 1);
        walk(x - 2, y - 1);
        walk(x - 1, y - 2);
        walk(x + 1, y - 2);
        walk(x + 2, y - 1);
        if(success) return true;
        else return false;
    }
}
