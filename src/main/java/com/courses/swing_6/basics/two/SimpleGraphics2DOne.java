package com.courses.swing_6.basics.two;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class SimpleGraphics2DOne extends JPanel {
    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        GradientPaint gradientPaint = new GradientPaint(70,70,Color.BLUE,150,150, Color.PINK);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillOval(70,70,100,100);
    }

}
