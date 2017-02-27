package com.courses.swing_6.basics.fiveinnerclasses;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 13.06.2015.
 */
public class TestPanel extends JPanel {
    int x = 10; //Randomly picked numbers
    int y = 10;
    int moveStep = 5;
    @Override
    public void paintComponent(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillRect(20,30,40,40);

        Image image = new ImageIcon("src/org/swing/fiveinnerclasses/image_sample.jpg").
                getImage();
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.drawImage(image, x, y, this);
        graphics2D.drawString("Hey", 100, 100);
    }
    public void moveCat(){
        x+=moveStep;
        y+=moveStep;
    }
}
