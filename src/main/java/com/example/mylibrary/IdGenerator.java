package com.example.mylibrary;

//import java.util.Set;
//import java.util.TreeSet;

/**
 * Created by a591566 on 2017-02-15.
 */
public class IdGenerator {
     private Integer idCounter = 1;

    Integer getUniqueId(){
        return idCounter++;
    }
}
