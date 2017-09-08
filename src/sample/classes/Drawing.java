package sample.classes;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

    private String name;
    private List<DrawingItem> items;

    public Drawing()
    {
        items = new ArrayList<DrawingItem>();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addItem(DrawingItem item)
    {
        this.items.add(item);
    }

    public DrawingItem getItem(int index)
    {
        return items.get(index);
    }

    public List<DrawingItem> getItems()
    {
        return items;
    }

    public void deleteItem(DrawingItem item)
    {
        this.items.remove(item);
    }

    public void paintUsing(IPaintable paintable)
    {
        for (DrawingItem t: this.items) {
            if (t instanceof PaintedText){paintable.paint((PaintedText) t);}
            if (t instanceof Image){paintable.paint((Image) t);}
            if (t instanceof Oval){paintable.paint((Oval) t);}
            if (t instanceof Polygon) {paintable.paint((Polygon) t);}
        }
    }
}
