package com.example.mylibrary;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by a591566 on 2017-02-15.
 */
class IdGenerator {
    Set<Integer> usedIDs = new TreeSet<Integer>();

    Integer getUniqueId(){
        int a = 1;
        while (this.usedIDs.contains(a)){
            a++;
        }
        usedIDs.add(a);
        return a;
    }
}
