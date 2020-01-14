package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class best_expression {
    //private int C[][];
    private Map<Integer, List<List<Integer>>> result;
    {
        result = new HashMap<>();
    }
    public void solve(int[] A) {
        for(int i: A) {
            List<Integer> l = new ArrayList<>();
            l.add(i);

        }

        for(int i = 1; i <= 40; i++) {
            for(int x: A) {
                for(int key: result.keySet()) {
                    if(key + x == i) {
                        for(List<Integer> temp: result.get(key)) {
                            List<Integer> newlist = new ArrayList<>();
                            for(int n: temp) newlist.add(n);
                            newlist.add(x);
                            List<List<Integer>> value = result.get(i);
                            value.add(newlist);
                        }
                    }
                }
            }
        }

        for(List<Integer> l: result.get(40)) {
            System.out.print("{");
            for(int p: l) {
                System.out.print(p + " ");
            }
            System.out.print("}");
        }
    }
}
