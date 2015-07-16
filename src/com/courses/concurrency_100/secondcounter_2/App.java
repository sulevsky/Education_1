package com.courses.concurrency_100.secondcounter_2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SecondCounterLookup counterLookup = new SecondCounterLookup();
        frame.getContentPane().add(counterLookup);
        frame.setSize(300,300);
        frame.setVisible(true);
        counterLookup.runClock();
    }
}
