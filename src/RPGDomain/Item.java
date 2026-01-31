package RPGDomain;

import java.util.UUID;

public abstract class Item {
    private UUID itemId;
    private String name;
    private String desc;
    private String rarity;
    Item(String name, String desc, String rarity){
        this.name = name;
        this.desc = desc;
        this.rarity = rarity;
        itemId = UUID.nameUUIDFromBytes(name.getBytes());
    }
}
