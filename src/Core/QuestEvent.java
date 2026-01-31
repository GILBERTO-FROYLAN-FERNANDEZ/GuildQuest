package Core;

import RPGDomain.Character;
import RPGDomain.InventoryEffect;
import RealmAndTime.Realm;
import RealmAndTime.WorldTime;

import java.util.List;
import java.util.UUID;

/**
 * The type Quest event.
 */
public class QuestEvent {
    private UUID eventId;
    private String title;
    private WorldTime startTime;
    private WorldTime endTime;
    private Realm realm;
    private List<Character> participants;
    private List<InventoryEffect> inventoryEffects;
    private List<User> sharedWith;

    /**
     * Instantiates a new Quest event.
     *
     * @param eventId          the event id
     * @param title            the title
     * @param startTime        the start time
     * @param realm            the realm
     * @param participants     the participants
     * @param inventoryEffects the inventory effects
     * @param sharedWith       the shared with
     */
    public QuestEvent(UUID eventId, String title, WorldTime startTime, Realm realm, List<Character> participants, List<InventoryEffect> inventoryEffects, List<User> sharedWith) {
        this.eventId = eventId;
        this.title = title;
        this.startTime = startTime;
        this.realm = realm;
        this.participants = participants;
        this.inventoryEffects = inventoryEffects;
        this.sharedWith = sharedWith;
    }

    /**
     * Update times.
     *
     * @param WorldTime start the start
     * @param WorldTime end   the end
     */
    public void updateTimes(WorldTime start, WorldTime end){
        // Unsure of what this does
    }

    /**
     * Update realm.
     *
     * @param realm the realm
     */
    public void updateRealm(Realm realm){
        this.realm = realm;
    }

    /**
     * Add participant.
     *
     * @param character the character
     */
    public void addParticipant(Character character){
        participants.add(character);
    }
}
