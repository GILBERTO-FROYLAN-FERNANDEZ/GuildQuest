package Core;

import UI.QuestEventUI;
import ViewsAndTimelines.Page;
import VisibilityAndSharing.VisibilityType;

public class ActiveCampaign implements CampaignState{
    Campaign campaign;
    private static final Page page = Page.getPage();

    public ActiveCampaign(Campaign c) {
        campaign = c;
    }

    public void archive(){
        campaign.setArchived(true);
        page.print("Archived\n");
    };
    public void changeVisibility(){
        VisibilityType opposite = (campaign.getVisibility() == VisibilityType.PRIVATE) ?
                VisibilityType.PUBLIC :VisibilityType.PRIVATE;
        String prompt = """
                Campaign is currently %s
                Would you like to change it to %s ?
                
                1 --- yes
                2 --- no
                0 --- exit
                """.formatted(campaign.getVisibility(), opposite);
        int choice = page.acceptIntUntil(prompt, 2);
        switch (choice) {
            case 2:
            case 0: return;
            case 1: campaign.setVisibility(opposite); break;
        }
    };
    public void updateName(){
        String newName = page.acceptStrWithValidation("Please choose a new name: ");
        if (newName != null)  campaign.setName(newName);
        page.print("new name set\n");
    };
    public void addQuestEvent(){
        QuestEvent qe = QuestEventUI.createQuestEvent(campaign);
        if (qe != null) campaign.addEvent(qe);
    };
    public void updateQuestEvent(){
        page.nextScreen();
        QuestEventUI.updateQuestEvent(campaign);
    };
    public void removeQuestEvent(){
        page.nextScreen();
        QuestEventUI.removeQuestEvent(campaign);
    };
    public void viewCampaign(){
        String display = """
                Name: %s
                Owner: %s
                Visibility: %s
                QuestEvents:
                %s
                """.formatted(campaign.getName(),
                campaign.getOwner().getUsername(),
                campaign.getVisibility().toString(),
                QuestEventUI.timelineString(campaign)
        );
        page.print(display);
    };
}

