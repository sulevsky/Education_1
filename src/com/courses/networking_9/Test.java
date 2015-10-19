package com.courses.networking_9;

import java.util.HashMap;

/**
 * Created by Vovka on 06.10.2015.
 */
public class Test {
    public HashMap<Short, String> holder = new HashMap<>();
    public static void main(String[] args) {
        Test test = new Test();
        test.addToHolder((short)1, "Hello");

        System.out.println(test.holder.get(1));
    }

    public void addToHolder(short key, String value){
        holder.put(key,value);
    }



    @Override
    public int hashCode() {
        return holder.hashCode();
    }
}
