package com.example.mylibrary;

//import java.util.Set;
//import java.util.TreeSet;

/**
 * Created by a591566 on 2017-02-15.
 */
class IdGenerator {
     private Integer idCounter = 0;

    Integer getUniqueId(){
        idCounter++;
        return idCounter;
    }
}
