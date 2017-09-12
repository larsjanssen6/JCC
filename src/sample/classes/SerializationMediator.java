package sample.classes;

import java.io.*;

public class SerializationMediator implements IPersistency{

    //Serialize drawing to file

    public void save(Drawing drawing) {
        try (
            OutputStream file = new FileOutputStream("items.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
        ){
            output.writeObject(drawing);
        }

        catch(IOException ex){
            System.out.println(ex);
        }
    }

    //Init drawing from file

    public Drawing init(String name) {
        try(
            InputStream file = new FileInputStream(name);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
        ){
            return (Drawing) input.readObject();
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
