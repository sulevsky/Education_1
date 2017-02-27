package com.courses.swing_6.basics.two;

import javax.swing.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class SimpleTwo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        //1
//        SimpleGraphicsOne drawPanel = new SimpleGraphicsOne();
//        jFrame.getContentPane().add(drawPanel);

        //2
//        SimpleGraphicsTwo drawPanelWithRandomColor = new SimpleGraphicsTwo();
//        jFrame.getContentPane().add(drawPanelWithRandomColor);

        //3 overlayed by image
//        SimpleImage simpleImage = new SimpleImage();
//        jFrame.getContentPane().add(simpleImage);

        //4
        SimpleGraphics2DOne simpleGraphics2DOne = new SimpleGraphics2DOne();
        jFrame.getContentPane().add(simpleGraphics2DOne);


        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    //single threaded
}

