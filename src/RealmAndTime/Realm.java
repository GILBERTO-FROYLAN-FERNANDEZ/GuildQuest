package RealmAndTime;

import java.util.UUID;

/**
 * The type Realm.
 */
public class Realm {
    private UUID realmId;
    private String name;
    private String description;
    private int timeOffsetMinutes;

    /**
     * Instantiates a new Realm.
     *
     * @param name              the name
     * @param description       the description
     * @param timeOffestMinutes the time offest in minutes
     */
    public Realm(String name, String description, int timeOffestMinutes){
        this.name = name;
        this.description = description;
        this.timeOffsetMinutes = timeOffestMinutes;
        this.realmId = UUID.nameUUIDFromBytes(name.getBytes());
    }

    /**
     * Converts from world time to local time. Assume 60 minute hour, 24 hour day.
     *
     * @param worldTime the world time
     * @return the local time
     */
    public LocalTime convertFromWorldTime(WorldTime worldTime){
        long mins = worldTime.getMinutes();
        long hours = worldTime.getHours();
        long days = worldTime.toDays();
        mins += timeOffsetMinutes;
        if (mins > 59) {
            mins = mins % 60;
            hours++;
            if (hours > 23){
                hours = hours % 24;
                days++;
            }
        }
        return new LocalTime((int) mins, (int) hours, (int) days);
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Description: " + description + "; Offset: " + timeOffsetMinutes;
    }
}
