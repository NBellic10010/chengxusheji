package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //permutation_recursive p = new permutation_recursive(new int[]{1,3,2,4,5});
        //p.f(0);
        qiongju q = new qiongju();
        List<String> result = q.letterCombinations_recursive("234");
        for(String s: result) {
            System.out.print(s + "1");
        }
    }
}
