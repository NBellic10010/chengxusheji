package com.company;
import java.util.*;

public class consecutivefee {
    private Map<Integer, List<List<Integer>>> res;
    {
        res = new HashMap<>();
        //List<Integer> ini = asList(1);
        res.put(1, Arrays.asList(Arrays.asList(1)));
    }

    public int solution(int m, int[] n) {
        boolean continuous = false;
        int cur = 2;
        while(true) {
            for(Object key: res.keySet()) {
                int keyvalue = (int)key;
                for(int i: n) {
                    if(cur - keyvalue == i) {
                        for(List<Integer> temp: res.get(keyvalue)) {
                            List<Integer> toadd = new ArrayList<>();
                            for(int j: temp) toadd.add(j);
                            temp.add(i);
                        }
                        continuous = true;
                    }
                }
            }
            if(!continuous) break;
            continuous = false;
            ++cur;
        }
        return res.size();
    }
}
