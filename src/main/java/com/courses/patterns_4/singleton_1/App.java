package com.courses.patterns_4.singleton_1;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class App {
    public static void main(String[] args) {
        WebService service = WebService.getInstance();
        service.print();
    }
}
