package RPGDomain;

import Core.Campaign;
import ViewsAndTimelines.Page;

import java.util.List;
import java.util.UUID;


/**
 * Playable Entity
 */
public class Character {
    private UUID characterId;
    private String name;
    private String characterClass;
    private int level;
    private Inventory inventory;

    /**
     * Instantiates a new Character.
     *
     * @param name           the name
     * @param characterClass the character class
     */
    public Character(String name, String characterClass){
        this.name = name;
        this.characterClass = characterClass;
        this.inventory = new Inventory();
        this.level = 0;
        this.characterId = UUID.nameUUIDFromBytes(name.getBytes());
    }

    /**
     * Increment Level
     */
    public void levelUp(){
        level += 1;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void giveItem(Item item){
        inventory.addItem(item);
    }
    public void takeItem(Item item){
        inventory.removeItem(item);
    }

}
