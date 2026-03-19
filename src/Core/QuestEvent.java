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
    public QuestEvent(String title, WorldTime startTime, Realm realm, List<Character> participants, List<InventoryEffect> inventoryEffects, List<User> sharedWith) {
        eventId = UUID.randomUUID();
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
    public void updateTimes(WorldTime start, WorldTime end) throws IllegalArgumentException{
        if (end != null && ( start.compareTo(end) > 0)){
            throw new IllegalArgumentException("Start time is greater than end");
        }
        startTime = start;
        endTime = end;
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
        if (participants.contains(character)) return;
        participants.add(character);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public UUID getEventId() {
        return eventId;
    }

    public List<Character> getParticipants() {
        return participants;
    }

    public WorldTime getEndTime() {
        return endTime;
    }

    public void setEndTime(WorldTime endTime) {
        this.endTime = endTime;
    }

    public WorldTime getStartTime() {
        return startTime;
    }

    public void setStartTime(WorldTime startTime) {
        this.startTime = startTime;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}
