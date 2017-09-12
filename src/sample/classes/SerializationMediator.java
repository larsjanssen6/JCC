package sample.classes;

import java.io.*;
import java.util.List;

public class SerializationMediator implements IPersistency{

    @Override
    public void save(List<DrawingItem> items) {
        try (
            OutputStream file = new FileOutputStream("items.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
        ){
            output.writeObject(items);
        }

        catch(IOException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<DrawingItem> init() {
        try(
            InputStream file = new FileInputStream("items.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
        ){
            //deserialize the List
            return (List<DrawingItem>)input.readObject();
        }
        catch(ClassNotFoundException ex){
            System.out.print("Cannot perform input. Class not found.");
        }
        catch(IOException xex){
            System.out.print("Cannot perform output.");
        }

        return null;
    }
}
