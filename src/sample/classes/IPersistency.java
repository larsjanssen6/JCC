package sample.classes;

import java.io.IOException;
import java.sql.SQLException;

public interface IPersistency {
    void save(Drawing drawing) throws IOException, ClassNotFoundException, SQLException;
    Drawing init(String name) throws SQLException, ClassNotFoundException, IOException;
}
