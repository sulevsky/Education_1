package com.courses.spring_17.hello;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by VSulevskiy on 05.10.2015.
 */
//@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(method= RequestMethod.GET, value = "/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}
