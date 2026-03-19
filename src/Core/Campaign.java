package Core;

import ViewsAndTimelines.Page;
import VisibilityAndSharing.PermissionLevel;
import VisibilityAndSharing.VisibilityType;

import java.security.Permission;
import java.util.*;

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
    private boolean archived;

    private CampaignState state;

    /**
     * Instantiates a new Campaign with default parameters.
     *
     * @param name        the name
     * @param owner       the owner
     */
    public Campaign(String name, User owner) {
        campaignId = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.visibility = VisibilityType.PRIVATE;
        this.questEvents = new ArrayList<QuestEvent>();
        this.sharedWith = new HashMap<User, PermissionLevel>();
        archived=false;
        state = new ActiveCampaign(this);
    }

    /**
     * Instantiates a new Campaign. PLEASE ASSIGN A USER AFTER USING THIS
     *
     * @param name the name
     */
    public Campaign(String name) {
        campaignId = UUID.randomUUID();
        this.name = name;
        this.owner = null; // MAKE SURE TO SET AFTERWARDS
        this.visibility = VisibilityType.PRIVATE;
        this.questEvents = new ArrayList<QuestEvent>();
        this.sharedWith = new HashMap<User, PermissionLevel>();
        archived=false;
        state = new ActiveCampaign(this);
    }

    /**
     * Add event.
     *
     * @param event the event
     */
// should normalize passing in either the QuestEvent or the UUID.
    public void addEvent(QuestEvent event){
        questEvents.add(event);
    }

    /**
     * Remove event.
     *
     * @param otherId the event id
     */
    public void removeEvent(UUID otherId){
        questEvents.removeIf(q -> q.getEventId() == otherId);
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

    public String getName() {
        return name;
    }
    public boolean getArchived() {
        return archived;
    }
    public VisibilityType getVisibility() {
        return visibility;
    }
    public List<QuestEvent> getQuestEvents(){
        return questEvents;
    }
    public User getOwner() {
        return owner;
    }
    public CampaignState getState(){return state;};

    public void setName(String name) {
        this.name = name;
    }
    public void setArchived(boolean archived) {
        this.archived = archived;
        if (archived){
            state = new ArchivedCampaign(this);
        } else state = new ActiveCampaign(this);
    }
    public void setVisibility(VisibilityType visibility) {
        this.visibility = visibility;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
