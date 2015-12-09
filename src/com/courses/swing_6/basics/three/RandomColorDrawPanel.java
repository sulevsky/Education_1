package com.courses.swing_6.basics.three;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class RandomColorDrawPanel extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        Color color = new Color(r, g, b);

        int xStart = (int) (Math.random() * 100);
        int yStart = (int) (Math.random() * 100);
        int size = (int) (Math.random() * 100);

        graphics2D.setColor(color);
        graphics2D.fillOval(xStart, yStart, size, size);
    }
}
