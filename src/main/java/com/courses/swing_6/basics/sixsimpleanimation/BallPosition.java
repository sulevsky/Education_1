package com.courses.swing_6.basics.sixsimpleanimation;

/**
 * Created by Vovka on 13.06.2015.
 */
public class BallPosition {
    private int left;
    private int top;
    private int width;
    private int height;
    private int speedX;
    private int speedY;
//    TODO implement is bounce

    public BallPosition() {
        left = 10;
        top = 10;
        width = 20;
        height = 20;
        speedX = 5;
        speedY = 5;

    }

    public BallPosition getNextPosition() {
        BallPosition result = new BallPosition();
        result.setLeft(this.getLeft() + this.getSpeedX());
        result.setTop(this.top + this.getSpeedY());
        result.setWidth(this.getWidth());
        result.setHeight(this.getHeight());
        result.setSpeedX(this.getSpeedX());
        result.setSpeedY(this.getSpeedY());
        return result;
    }

    public BallPosition getNextPositionWithBorders(int maxWidth, int maxHeight) {
        BallPosition result = new BallPosition();
        //horizontal
        int newRight = left + speedX + width;
        if (newRight > maxWidth) {
            speedX *= -1;
        }
        int newLeft = left + speedX;
        if (newLeft < 0) {
            speedX *= -1;
        }
        //vertical
        int newBottom = top + speedY + height;
        if (newBottom > maxHeight) {
            speedY *= -1;
        }
        int newTop = top + speedY;
        if (newTop < 0) {
            speedY *= -1;
        }
        result.setLeft(this.getLeft() + this.getSpeedX());
        result.setTop(this.top + this.getSpeedY());
        result.setWidth(this.getWidth());
        result.setHeight(this.getHeight());
        result.setSpeedX(this.getSpeedX());
        result.setSpeedY(this.getSpeedY());
        return result;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
