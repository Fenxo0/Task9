package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logic {
    public static List<Integer> process (List<Integer> list)
    {
        list = sort(list);
        return list;
    }

    static List<Integer> sort(List<Integer> rd) {
        int k = rd.get(0);
        List list = new ArrayList<>();
        for (int i = 1; i < rd.size() - 1; i++){
            if (rd.get(i).equals(k)) {
                for (int j = i - 1;j < rd.size() ; j++){
                    if (rd.get(j).equals(rd.get(i))) {
                        list.add(rd.get(j));
                        k = rd.get(j);
                    }
                    else {
                        k = rd.get(j);
                        break;
                    }
                }
            }
            else k = rd.get(i);

        }
        return list;
    }





}
