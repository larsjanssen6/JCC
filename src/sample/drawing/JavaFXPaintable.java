package sample.drawing;

import javafx.scene.image.Image;
import sample.classes.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import sample.classes.Polygon;

import java.awt.*;

public class JavaFXPaintable implements IPaintable {
    private final GraphicsContext gc;

    public JavaFXPaintable(Canvas canvas) {
        gc = canvas.getGraphicsContext2D();

    }

    @Override
    public void paint(Oval oval) {
        gc.fillOval(oval.getAnchor().getX(),oval.getAnchor().getY(),oval.getWidth(),oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon) {
        int i = polygon.getVertices().length;
        double[] X = new double[i];
        double[] Y =  new double[i];
        i = 0;
        for (Point p:polygon.getVertices())
        {
            X[i] = p.getX();
            Y[i] = p.getY();
            i++;
        }

        gc.fillPolygon(X,Y,polygon.getVertices().length);
    }

    @Override
    public void paint(PaintedText text) {
        gc.fillText(text.getContent(),text.getAnchor().getX(),text.getAnchor().getY());
    }

    @Override
    public void paint(sample.classes.Image image) {
        gc.drawImage(new Image(String.valueOf(image.getFile())),image.getAnchor().getX(), image.getAnchor().getY());
    }
}
