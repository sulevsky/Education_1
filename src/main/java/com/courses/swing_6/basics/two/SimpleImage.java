package com.courses.swing_6.basics.two;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Vovka on 01.06.2015.
 */
public class SimpleImage extends JPanel {
    private BufferedImage image;

    public SimpleImage() {
        try {
            File file = new File("src/org/swing/two/lizard.jpg");
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 10, 10, this);
    }
}
