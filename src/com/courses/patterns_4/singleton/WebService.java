package com.courses.patterns_4.singleton;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class WebService {

    private static WebService service =
            new WebService();
    private WebService(){

    }

    public static WebService getInstance(){
        return service;
    }

    public void print() {
        System.out.println("Service");
    }
}
