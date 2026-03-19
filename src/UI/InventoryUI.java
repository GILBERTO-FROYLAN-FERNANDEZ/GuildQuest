package UI;

import Core.Command;
import InventoryCommands.*;

import RPGDomain.Character;
import RPGDomain.Inventory;
import RPGDomain.Item;
import ViewsAndTimelines.Page;

public class InventoryUI {
    private static final InventoryCommand command_2 = new RemoveItemCommand();
    private static final InventoryCommand command_1 = new SelectInventoryCommand();
    private static final InventoryCommand command_3 = new AddItemsCommand();
    private static final InventoryCommand command_0 = new LeaveCommand();
    private static final String MANAGE_PROMPT = """ 
                                            1 --- See Inventory
                                            2 --- Throw Away Item(s)
                                            3 --- Add Item(s)
                                            0 --- exit
                                            """;
    private static final Page page = Page.getPage();

    public static InventoryCommand intToCommand(int i){
        switch (i) {
            case 0: return command_0;
            case 1: return command_1;
            case 2: return command_2;
            case 3: return command_3;
        }
        throw new Error("INVALID CHOICE, NO COMMAND BOUND");
    }

    public static void manageInventory(Character character) {

        int choice = -1;
        while (choice != 0) {
            choice = page.acceptIntUntil(MANAGE_PROMPT, 3);
            page.nextScreen();
            InventoryCommand command = intToCommand(choice);
            command.execute(character);
        }
    }
}
