package Core;

public interface CampaignState {
    void archive();
    void changeVisibility();
    void updateName();
    void addQuestEvent();
    void updateQuestEvent();
    void removeQuestEvent();
    void viewCampaign();
}
