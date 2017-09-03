package sample.classes;

import java.awt.*;

public class PaintedText extends DrawingItem {

    private String content;
    private String fontName;
    private Point anchor;
    private double width;
    private double height;

    public PaintedText(String content, String fontName, Point anchor, double width, double height)
    {
        this.content = content;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
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

    public String getContent() {
        return content;
    }

    public String getFontName() {
        return fontName;
    }

    @Override
    public String toString() {
        return "anchor X" + getAnchor().getX() + ", Y" + getAnchor().getY() +", content " + getContent() + ", fontName " + getFontName() + "\n";
    }
}
