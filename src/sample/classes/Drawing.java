package sample.classes;

import java.util.ArrayList;
import java.util.List;

public class Drawing  {

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
}
