package com.company;

public class qiongju_2 {
    public void search() {
        int res = 0;
        for(int i = 0; i < 255; i++) {
            String s = Integer.toBinaryString(i);
            int sum = 1, ct = 2;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '0') sum -= ct++;
                else if(s.charAt(j) == '1') sum += ct++;
            }
            if(sum == 9) {res++;System.out.println(s);}
        }
        System.out.print(res);
    }

    public static void main(String[] args) {
        qiongju_2 q2 = new qiongju_2();
        q2.search();
    }
}
