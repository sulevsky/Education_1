package com.courses.swing_6.basics.two;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class SimpleGraphicsTwo extends JPanel {

    @Override
    public void paintComponent(Graphics graphics){
        graphics.fillRect(0,0,this.getWidth(),this.getHeight());

        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        Color color = new Color(red,green,blue);
        graphics.setColor(color);
        graphics.fillOval(70,10,100,100);

    }
}
