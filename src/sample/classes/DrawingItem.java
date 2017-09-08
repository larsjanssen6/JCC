package sample.classes;

import java.awt.*;
import java.util.Comparator;

public abstract class DrawingItem {

    public Color color;
    public abstract Point getAnchor();
    public abstract double getWidth();
    public abstract double getHeight();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paintUsing(IPaintable paintable)
    {

    }

    public static Comparator<DrawingItem> drawingItemComparator = Comparator.comparingDouble(o -> o.getAnchor().getX());
}
