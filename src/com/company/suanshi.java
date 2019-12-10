package com.company;

import java.util.HashSet;
import java.util.Set;

public class suanshi {
    private Set<Character> set;
    {
        this.set = new HashSet<>();
    }
    public void test() {
        this.set.add('9');
        this.set.add('8');
        this.set.add('7');
        this.set.add('5');
        this.set.add('5');
        System.out.println(this.set.size());
    }

    public void solve(){
        for(int i = 10000; i < 99999; i++) {
            String s = Integer.toString(i);
            for(int p = 0; p < s.length(); p++) {
                this.set.add(s.charAt(p));
            }
            if(this.set.size() != 5) {
                this.set.clear();
                continue;
            }else{
                if(this.set.contains('0') || this.set.contains('5')) {
                    this.set.clear();
                    continue;
                }
                //System.out.println(i);
                int C = Integer.parseInt(String.valueOf(s.charAt(2)));
                int E = Integer.parseInt(String.valueOf(s.charAt(4)));
                int D = Integer.parseInt(String.valueOf(s.charAt(3)));
                int Z = 2 * D + C + 1 - 20;
                if(Z < 0 || this.set.contains((char)(Z + 48))) {
                    this.set.clear();
                    continue;
                }
                int A = Integer.parseInt(String.valueOf(s.charAt(0)));
                int B = Integer.parseInt(String.valueOf(s.charAt(1)));
                int X = A + 1;
                int Y = B + 2 - 10;
                //System.out.println((char)(X + 48) + "," + X);

                if(X > 9 || Y < 0) {
                    this.set.clear();
                    continue;
                }
                if(this.set.contains((char)(X+48)) || this.set.contains((char)(Y+48))) {
                    this.set.clear();
                    continue;
                }
                else {
                    if(X == Y || Y == Z || X == Z || X == 0 || X == 5 || Y == 0 || Y == 5 || Z == 0 || Z == 5) {
                        this.set.clear();
                        continue;
                    }
                    int A2 = D * 100 + 5 * 10;
                    int R = X * 10000 + Y * 1000 + Z * 100 + D * 10 + E;
                    if(i + 2 * A2 == R) {
                        System.out.println(i);
                        System.out.println(A2 + "," + R);
                        //System.out.println("===========");
                    }
                    this.set.clear();
                }
            }

        }
    }

    public static void main(String[] args) {
        suanshi s = new suanshi();
        s.solve();
    }

}
