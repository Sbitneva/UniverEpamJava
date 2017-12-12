package sbitneva.homeworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Main{
    public static void main(String ... args){
        List<String> v = new ArrayList<String>(){{
            add("one");
            add("two");
        }};

        for(String value : v){
            System.out.println(value);
        }
    }
}