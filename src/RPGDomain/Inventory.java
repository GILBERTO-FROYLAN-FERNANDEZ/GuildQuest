package RPGDomain;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    void addItem(Item item){
        items.add(item);
    }
    void removeItem(Item item){
        // may want to double-check for equality checks
        items.remove(item);
    }
    Inventory(){
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
}
