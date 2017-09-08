package sample;

import javafx.fxml.FXML;
import sample.classes.Drawing;
import sample.classes.Oval;
import sample.classes.IPaintable;
import sample.drawing.JavaFXPaintable;
import javafx.scene.canvas.Canvas;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Controller {
    private Drawing drawing;

    private IPaintable paint;

    @FXML
    private Canvas canvas;

    @FXML
    private Panel asdf;
    // een variabele button circle aanmaken en de method hernoemen. Bv tekenen.

    public Controller()
    {
        drawing = new Drawing();
        drawing.setName("Tekening");
    }

    @FXML
    public void btnOval()
    {
        drawing.addItem(new Oval(new Point(10, 10), 100, 100, 10, Color.BLACK));
        painting();
    }

    @FXML
    public void btnImage()
    {

        File createdFile = null;
        try {
            createdFile = File.createTempFile("file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sample.classes.Image image = new sample.classes.Image(new Point(10, 10), 30, 30, new File("sample/classes/loremFile.png"));
        drawing.addItem(image);
        painting();
    }

    @FXML
    public void btnPolygon()
    {
        Point[] points = {new Point(300, 240), new Point(150, 100), new Point(200, 300),new Point(247, 145)};
        sample.classes.Polygon pol = new sample.classes.Polygon(points, 10, 10, 10);

        drawing.addItem(pol);

        System.out.println("jow");
        this.paint = new JavaFXPaintable(this.canvas);
        drawing.paintUsing(paint);
    }

    @FXML
    public void btnPaintedText()
    {
        System.out.println("oval!");
    }

    public void painting()
    {
        this.paint = new JavaFXPaintable(this.canvas);
        drawing.paintUsing(paint);
    }
}
