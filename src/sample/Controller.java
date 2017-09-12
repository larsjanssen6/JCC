package sample;

import javafx.fxml.FXML;
import sample.classes.*;
import sample.drawing.JavaFXPaintable;
import javafx.scene.canvas.Canvas;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

public class Controller {
    private Drawing drawing;

    private IPaintable paint;

    @FXML
    private Canvas canvas;

    SerializationMediator serialization;

    DatabaseMediator database;


    public Controller()
    {
        serialization = new SerializationMediator();
        database = new DatabaseMediator();

        drawing = new Drawing();
        drawing.setName("Tekening");
    }

    @FXML
    public void btnOval() throws SQLException, IOException, ClassNotFoundException {
        Oval oval = new Oval(new Point(10, 10), 100, 100, 10, Color.BLACK);
        drawing.addItem(oval);
        painting();
    }

    @FXML
    public void btnLoadFromFile()
    {
        for(DrawingItem item: serialization.init("items.ser").getItems()) {
            drawing.addItem(item);
        }

        painting();
    }

    @FXML
    public void btnImage()
    {
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
        painting();
    }

    @FXML
    public void btnSaveToDb() throws SQLException, IOException, ClassNotFoundException {

        database.save(drawing);
    }

    @FXML
    public void btnLoadFromDb() throws SQLException, ClassNotFoundException, IOException {
        for(DrawingItem item: database.init("Tekening").getItems()) {
            drawing.addItem(item);
        }

        painting();
    }

    @FXML
    public void btnSaveToFile()
    {
        serialization.save(drawing);
    }

    @FXML
    public void btnRemoveFile()
    {
        serialization.save(new Drawing());
    }

    @FXML
    public void btnPaintedText()
    {
        PaintedText text = new PaintedText("Hallo", "ARIAL", new Point(150, 100), 100, 100);
        drawing.addItem(text);

        painting();
    }

    public void painting()
    {
        this.paint = new JavaFXPaintable(this.canvas);
        drawing.paintUsing(paint);
    }
}
