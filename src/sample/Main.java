package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.classes.*;
import sample.classes.Image;
import sample.classes.Polygon;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {

//
//        //Create drawing
//        Drawing drawing = new Drawing();
//        drawing.setName("Figuren");
//        System.out.println("Tekening naam: " + drawing.getName() + "\n");
//
//        //Add items to drawing
//
//        //Add oval
//        drawing.addItem(new Oval(new Point(10, 10), 10, 10, 10, Color.BLACK));
//
//        DrawingItem item1 = drawing.getItem(0);
//        System.out.println("Oval:");
//        System.out.println(item1.toString());
//
//
//        //Add image
//        drawing.addItem(new Image(new Point(10, 10),10, 10, new File("loremFile.png")));
//
//        DrawingItem item2 = drawing.getItem(1);
//        System.out.println("Image:");
//        System.out.println(item2.toString());
//
//        //Add polygon
//        List<Point> points = new ArrayList<Point>();
//        points.add(new Point(10, 10));
//        points.add(new Point(20, 20));
//
//        drawing.addItem(new Polygon(points, 10, 10, 10));
//
//        DrawingItem item3 = drawing.getItem(2);
//        System.out.println("Polygon:");
//        System.out.println(item3.toString());
//
//        //Add painted text
//        drawing.addItem(new PaintedText("Een titel", "Arial", new Point(12, 13), 12, 13));
//
//        DrawingItem item4 = drawing.getItem(3);
//        System.out.println("Painted text:");
//        System.out.println(item4.toString());
//
//        //Sorteer items
//
//        System.out.println("Sorteer items \n");
//        drawing.getItems().sort(DrawingItem.drawingItemComparator);
//
//        for (DrawingItem s : drawing.getItems())
//            System.out.println(s.toString());
//
//        //Delete items
//
//        int total = drawing.getItems().size();
//        System.out.println("Verwijder " + total + " items. \n");
//
//        drawing.deleteItem(item1);
//        drawing.deleteItem(item2);
//        drawing.deleteItem(item3);
//        drawing.deleteItem(item4);
//
//        total = drawing.getItems().size();
//        System.out.println("Er zijn nu " + total + " items allen items zijn verwijderd.");
        launch(args);
    }
}
