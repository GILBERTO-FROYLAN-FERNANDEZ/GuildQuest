package RPGDomain;

import java.util.UUID;

public class Item {
    private UUID itemId;
    private String name;
    private String desc;
    private String rarity;
    public Item(String name, String desc, String rarity){
        this.name = name;
        this.desc = desc;
        this.rarity = rarity;
        itemId = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getRarity() {
        return rarity;
    }
}
