package InventoryCommands;

public class RemoveItemCommand extends InventoryCommand{
    @Override
    public void execute(){
        int valid = page.acceptIntUntil("Are you sure you want to remove an item?\n1 --- yes\n0 --- no\n", 1);
        if (valid == 0) return;
        int choice = InventoryCommand.printAndQueryInventory(character, "to throw away");
        if (choice == -1) return;
        boolean res = character.getInventory().getItems().remove(
                character.getInventory().getItems().get(choice)
        );
        if (res == false) page.print("ERROR: ITEM WAS NOT REMOVED");
    }

}
