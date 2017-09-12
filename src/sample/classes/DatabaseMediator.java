package sample.classes;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseMediator {

    public void save(List<DrawingItem> items) throws IOException, ClassNotFoundException, SQLException {
        PreparedStatement ps=null;
        Properties prop = new Properties();
        InputStream in = new FileInputStream("connection.properties");
        prop.load(in);
        in.close();

        String driver = prop.getProperty("jdbc.driver");
        String connectionURL = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");

        Class.forName(driver);
        Connection con = DriverManager.getConnection(connectionURL, username, password);

        for (DrawingItem item: items) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(item);
            oos.flush();
            oos.close();
            bos.close();

            byte[] data = bos.toByteArray();

            String sql="insert into javaobject (javaObject) values(?)";
            ps= con.prepareStatement(sql);
            ps.setObject(1, data);
            ps.executeUpdate();
        }

    }

    public List<DrawingItem> init() throws SQLException, ClassNotFoundException, IOException {

        Properties prop = new Properties();
        InputStream in = new FileInputStream("connection.properties");
        prop.load(in);
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=null;

        String driver = prop.getProperty("jdbc.driver");
        String connectionURL = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");


        Class.forName(driver);
        Connection conn= DriverManager.getConnection(connectionURL, username, password);;

        sql="select * from javaobject";

        ps=conn.prepareStatement(sql);

        rs=ps.executeQuery();

        if(rs.next())
        {
            ByteArrayInputStream bais;

            ObjectInputStream ins;

            try {

                List items = new ArrayList();

                bais = new ByteArrayInputStream(rs.getBytes("javaObject"));

                ins = new ObjectInputStream(bais);

                Object object = ins.readObject();

                while (object != null) {
                    items.add((DrawingItem) object);
                    object = ins.readObject();

                }

                return items;
            }
            catch (Exception e) {

                e.printStackTrace();
            }
        }

        return null;
    }
}
