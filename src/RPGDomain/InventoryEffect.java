package RPGDomain;

/**
 * The type Inventory effect.
 */
public class InventoryEffect {
    private Item item;
    private int quantity;
    private EffectType effectType;

    /**
     * Manipulates the Inventory in different ways
     *
     * @param item       the item
     * @param quantity   the quantity
     * @param effectType the effect type
     */
    InventoryEffect(Item item, int quantity, EffectType effectType){
        this.item = item;
        this.quantity = quantity;
        this.effectType = effectType;
    }

    /**
     * Manipulates the inventory of a character
     *
     * @param character the character
     */
    public void apply(Character character){
        if (effectType==EffectType.GRANT){
            // add method
            for (int i = 0; i < quantity; ++i){
                character.giveItem(item);
            }
        } else{
            for (int i = 0; i < quantity; ++i){
                character.takeItem(item);
            }
        }
    }
}
