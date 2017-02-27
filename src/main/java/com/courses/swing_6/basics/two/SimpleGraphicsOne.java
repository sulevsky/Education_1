package com.courses.swing_6.basics.two;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class SimpleGraphicsOne extends JPanel {
    @Override
    public void paintComponent(Graphics graphics){
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(20,39,80, 90);
        graphics.setColor(Color.GREEN);
        graphics.fillOval(70,80,80, 90);

    }
}
