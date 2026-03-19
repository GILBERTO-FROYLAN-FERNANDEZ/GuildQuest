package Core;

import UI.QuestEventUI;
import ViewsAndTimelines.Page;

public class ArchivedCampaign implements CampaignState{
    Campaign campaign;
    private static final Page page = Page.getPage();

    public ArchivedCampaign(Campaign c) {
        campaign = c;
    }
    private void printArchiveError(){
        page.print("Sorry, you cannot modify an archived page. Please choose another option.\n");
    }

    public void archive(){
        page.print("Sorry, this is already archived. Please do something else.\n");
    };
    public void changeVisibility(){printArchiveError();};
    public void updateName(){printArchiveError();};
    public void addQuestEvent(){printArchiveError();};
    public void updateQuestEvent(){printArchiveError();};
    public void removeQuestEvent(){printArchiveError();};
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