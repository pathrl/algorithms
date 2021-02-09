package com.algorithms.POO;

public class Robot {

    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y, int repetition) {
        this.x += repetition * x;
        this.y += repetition * y;
    }
}
