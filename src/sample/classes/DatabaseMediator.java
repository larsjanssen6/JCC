package sample.classes;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements IPersistency {

    //Sql queries

    String insert_drawing = "INSERT INTO Drawing(drawingname,name, object_value) VALUES (?, ?, ?)";
    String get_drawing = "SELECT object_value FROM drawing WHERE drawingname = ?";

    //Save the drawing to the database

    public void save(Drawing drawing) throws IOException, ClassNotFoundException, SQLException {
        String className = drawing.getClass().getName();
        PreparedStatement prep = getConnection().prepareStatement(insert_drawing);
        prep.setString(1, drawing.getName());
        prep.setString(2, className);
        prep.setObject(3, drawing);
        prep.executeUpdate();
        prep.close();
    }

    //Get a specific drawing from the database

    public Drawing init(String name) throws SQLException, ClassNotFoundException, IOException {
        PreparedStatement prep = getConnection().prepareStatement(get_drawing);
        prep.setString(1, name);
        ResultSet rs = prep.executeQuery();
        rs.next();
        byte[] buf = rs.getBytes(1);
        ObjectInputStream objectIn = null;

        if (buf != null) {
            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
        }

        Object deSerializedObject = objectIn.readObject();
        rs.close();
        prep.close();

        return (Drawing) deSerializedObject;
    }

    //Get a connection string

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("connection.properties");
        prop.load(in);
        in.close();

        String driver = prop.getProperty("jdbc.driver");
        String connectionURL = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");

        Class.forName(driver);

        return DriverManager.getConnection(connectionURL, username, password);
    }
}
