package InventoryCommands;

import Core.Command;
import RPGDomain.Character;
import RPGDomain.Inventory;
import RPGDomain.Item;
import ViewsAndTimelines.Page;

public abstract class InventoryCommand implements Command {
    public static final Page page = Page.getPage();
    public Character character=null;
    public static int printAndQueryInventory(RPGDomain.Character character) {
        return printAndQueryInventory(character, "");
    }
    public static int printAndQueryInventory(Character character, String extraPrompt){
        Inventory inv = character.getInventory();
        if (inv.getItems().isEmpty()){
            page.print("Sorry, there are no items. Please exit.\n");
            return -1;
        }
        int i = 1;
        StringBuilder prompt = new StringBuilder("Choose an item " + extraPrompt + '\n');
        prompt.append("0 --- go back\n");
        for (Item item : inv.getItems()){
            prompt.append(i).append(" --- ").append(item.getName()).append('\n');
            ++i;
        }
        int input = -1;
        input = page.acceptIntUntil(prompt.toString(), i-1);
        page.nextScreen();
        return input-1;
    }

    @Override
    public void execute() {
        execute(character);
    }
    public void execute(Character c) {
        character = c;
        execute();
    }
}



