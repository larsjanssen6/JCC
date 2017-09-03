package sample.classes;

import java.awt.*;

public class Oval extends DrawingItem {

    private Point anchor;
    private double width;
    private double height;
    private double weight;
    
    public Oval(Point anchor, double width, double height, double weight, Color color)
    {
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public Point getAnchor() {

        return anchor;
    }

    @Override
    public double getWidth() {

        return width;
    }

    @Override
    public double getHeight() {

        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "anchor X" + anchor.getX() + ", Y" + anchor.getY() +", Color " + getColor() +  ", Width " + getWidth() + ", Height " + getHeight() + ", Weight " + getWeight() + "\n";
    }
}
