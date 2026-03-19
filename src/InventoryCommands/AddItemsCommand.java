package InventoryCommands;

import RPGDomain.Character;
import RPGDomain.Item;

public class AddItemsCommand extends InventoryCommand{
    public void execute(){
        String name;
        while (true){
            if (addItem(character) == null) break;
        }
    }
    public static Item addItem(Character character){
        int valid = page.acceptIntUntil("Are you sure you want to add an item?\n1 --- yes\n0 --- no\n", 1);
        if (valid == 0) return null;
        String name = page.acceptStrWithValidation("Enter a name for this item:\n");
        String desc = page.acceptStrWithValidation("Enter a description: \n");
        String rarity = page.acceptStrWithValidation("Enter a rarity: \n");
        Item newItem = new Item(name, desc, null);
        character.getInventory().getItems().add(newItem);
        page.nextScreen();
        return newItem;
    }
}
