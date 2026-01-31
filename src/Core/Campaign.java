package Core;

import VisibilityAndSharing.PermissionLevel;
import VisibilityAndSharing.VisibilityType;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The type Campaign.
 */
public class Campaign {
    private UUID campaignId;
    private String name;
    private User owner;
    private VisibilityType visibility;
    private List<QuestEvent> questEvents;
    private Map<User, PermissionLevel> sharedWith;

    /**
     * Instantiates a new Campaign.
     *
     * @param campaignId  the campaign id
     * @param name        the name
     * @param owner       the owner
     * @param visibility  the visibility
     * @param questEvents the quest events
     * @param sharedWith  the shared with
     */
    public Campaign(UUID campaignId, String name, User owner, VisibilityType visibility, List<QuestEvent> questEvents, Map<User, PermissionLevel> sharedWith) {
        this.campaignId = campaignId;
        this.name = name;
        this.owner = owner;
        this.visibility = visibility;
        this.questEvents = questEvents;
        this.sharedWith = sharedWith;
    }


    /**
     * Add event.
     *
     * @param event the event
     */
// should normalize passing in either the QuestEvent or the UUID.
    public void addEvent(QuestEvent event){
        // requires lookup for master UUID list
        // Better to pass in Event but oh well.
//        QuestEvent newQuest = null; // masterUUID.lookup(eventID);
        questEvents.add(event);
    }

    /**
     * Remove event.
     *
     * @param eventId the event id
     */
    public void removeEvent(UUID eventId){
        // requires lookup for master UUID list, the
        // Better to pass in Event but oh well.
        QuestEvent toRemove = null; // masterUUID.lookup(eventID);
        questEvents.remove(toRemove);
    }

    /**
     * Replace existing Event with one UUID with new event
     *
     * @param event the new event
     */
    public void updateEvent(QuestEvent event){
        questEvents.remove(event);
        questEvents.add(event);
    }

    /**
     * Sets visibility.
     *
     * @param visibility the visibility
     */
    public void setVisibility(VisibilityType visibility) {
        this.visibility = visibility;
    }
}
