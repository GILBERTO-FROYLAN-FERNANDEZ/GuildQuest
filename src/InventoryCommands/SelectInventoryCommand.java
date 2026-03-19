package InventoryCommands;

import RPGDomain.Item;

public class SelectInventoryCommand extends InventoryCommand{
    public void execute(){
        int choice = printAndQueryInventory(character, "to see more options");
        if (choice == -1) return;
        else displayItem(character.getInventory().getItems().get(choice));
    }
    private static void displayItem(Item item){
        page.print(item.getName() + " --- " + item.getDesc() + " " + item.getRarity() + '\n');
    }
}