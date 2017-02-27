package com.courses.swing_6.basics.sixsimpleanimation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 13.06.2015.
 */
public class BallPanel extends JPanel {
    BallPosition ballPosition = new BallPosition();

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,this.getWidth(),this.getHeight());

        graphics.setColor(Color.green);
        graphics.fillOval(ballPosition.getLeft(), ballPosition.getTop(), ballPosition.getWidth(), ballPosition.getHeight());
    }

    public void setBallPosition(BallPosition position) {
        this.ballPosition = position;
    }

    public void moveBall(){
        ballPosition = ballPosition.getNextPositionWithBorders(this.getWidth(),this.getHeight());
    }
}
