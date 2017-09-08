package sample.classes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends DrawingItem {

    private Point[] vertices;
    private double width;
    private double height;
    private double weight;

    public Polygon(Point[] points, double width, double height, double weight)
    {
        vertices = new Point[10];
        this.vertices = points;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public Point getAnchor() {
        return vertices[0];
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

    public Point[] getVertices()
    {
        return vertices;
    }

    @Override
    public String toString() {
        return "anchor X" + getAnchor().getX() + ", Y" + getAnchor().getY() + ", Weight " + getWeight() + "\n";
    }
}
