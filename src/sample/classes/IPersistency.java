package sample.classes;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IPersistency {
    void save(List<DrawingItem> items) throws IOException, ClassNotFoundException, SQLException;
    List<DrawingItem> init() throws SQLException, ClassNotFoundException, IOException;
}
