package sample.classes;

import java.awt.*;
import java.io.File;

public class Image extends DrawingItem {

    private File file;
    private Point anchor;
    private Double width;
    private Double height;

    public Image(Point anchor, double width, double height, File file)
    {
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.file = file;
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

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "anchor X" + anchor.getX() + ", Y" + anchor.getY() +", file " + getFile() + "\n";
    }
}
