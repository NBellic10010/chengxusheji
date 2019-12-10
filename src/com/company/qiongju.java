package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qiongju {
    Map<Character, String> map = new HashMap<>();

    public qiongju() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> res = new HashMap<>();
        List<String> result = new ArrayList<>();
        List<String> ini = new ArrayList<>();
        ini.add("");
        res.put(0, ini);
        for (int i = 1; i <= digits.length(); i++) {
            //System.out.print(res.get(0));
            List<String> newlist = new ArrayList<>();
            for (String s : res.get(i - 1)) {
                String cab = map.get(digits.charAt(i - 1));
                for (int p = 0; p < cab.length(); p++) {
                    newlist.add(s + cab.charAt(p));
                }
            }
            res.put(i, newlist);
        }
        for (String s : res.get(digits.length())) {
            result.add(s);
        }

        return result;
    }

    private List<String> add(List<String> result, String digits, int n) {
        String temp = this.map.get(digits.charAt(n));
        List<String> newlist = new ArrayList<>();
        for (String i : result) {
            for (int x = 0; x < temp.length(); x++) {
                newlist.add(i + temp.charAt(x));
            }
        }
        //result.clear();

        return newlist;
    }

    private List<String> search_recursive(List<String> result, String digits, int n) {
        if (n == digits.length() - 1) {
            return add(result, digits, n);
        } else {
            result = search_recursive(result, digits, n + 1);
            return add(result, digits, n);
        }
    }

    public List<String> letterCombinations_recursive(String digits) {
        List<String> result = new ArrayList<>();
        result.add("");
        result = search_recursive(result, digits, 0);
        return result;
    }
}

