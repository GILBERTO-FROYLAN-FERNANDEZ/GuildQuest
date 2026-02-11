package UI;

import Core.Campaign;
import Core.QuestEvent;
import Core.User;

import ViewsAndTimelines.Page;
import VisibilityAndSharing.VisibilityType;

/**
 * The type Campaign ui.
 */
public class CampaignUI {
    private static final Page page = new Page();

    /**
     * UI to create a Campaign.
     *
     * @param user the user
     * @return the campaign
     */
    public static Campaign createCampaign(User user){
        page.nextScreen();
        String name = page.acceptStrWithValidation("Please name your campaign: ");
        // TODO: remove duplicates
        return new Campaign(name, user);
    }

    /**
     * Choose a campaign
     *
     * @param user the user
     * @return the campaign
     */
    public static Campaign chooseCampaign(User user){
        // assume we include archived values
        return chooseCampaign(user, true);
    }

    /**
     * Choose a campaign
     *
     * @param user            the user
     * @param includeArchived whether to include archived campaigns
     * @return the campaign chosen
     */
    public static Campaign chooseCampaign(User user, boolean includeArchived){
        StringBuilder prompt = new StringBuilder("Please choose a Campaign\n");
        Campaign choice = null;
        int i = 1;
        if (user.getCampaigns().isEmpty()){
            page.print("Sorry, there are no campaigns, please choose something else\n");
            return null;
        }
        for (Campaign c : user.getCampaigns()){
            prompt.append(i).append(" --- ").append(c.getName()).append('\n');
            ++i;
        }
        prompt.append("0 -- exit\n");
        int input = -1;
        while (input == -1){
            input = page.acceptIntUntil(prompt.toString(), i-1);
            if ( !includeArchived && input != 0 && user.getCampaigns().get(input-1).getArchived() == true){
                page.nextScreen();
                page.print("Please choose something not actively archived");
            } else break;
        }


        page.nextScreen();
        if (input == 0) return null;
        else return user.getCampaigns().get(input-1);
    }

    /**
     * UI to select from a bunch of options to update a campaign and its quest elements.
     *
     * @param user the user
     */
    public static void updateCampaign(User user){
        Campaign c = chooseCampaign(user);
        if (c == null){
            return;
        }
        String prompt = """
                Please edit this campaign: %s
                1 --- Update Name
                2 --- Set visibility
                3 --- Share With Another User (unimplemented)
                
                4 --- Add QuestEvent
                5 --- Update QuestEvent
                6 --- Remove QuestEvent
                
                7 ---- Archive
                0 --- exit
                """;
        int choice=1;
        while (choice != 0){
            choice = page.acceptIntUntil(Page.dynamicPrompt(prompt, c.getName()), 7);
            page.nextScreen();
            switch (choice) {
                case 0 -> page.print("leaving\n");
                case 1-> updateName(c);
                case 2-> visibilityUI(c);
                case 3-> shareWithOther(user);
                case 4-> addQuestEvent(c);
                case 5-> updateQuestEvent(c);
                case 6-> removeQuestEvent(c);
                case 7-> archiveCampaign(c);
            }
        }

    }
    /**
     * UI to update the campaign name
     *
     * @param c the campaign
     */
    private static void updateName(Campaign c){
        String newName = page.acceptStrWithValidation("Please choose a new name: ");
        if (newName != null)  c.setName(newName);
        page.print("new name set\n");
    }
    /**
     * Change visibility of a campaign between public and private
     *
     * @param c The Campaign
     */
    private static void visibilityUI(Campaign c){
        VisibilityType opposite = (c.getVisibility() == VisibilityType.PRIVATE) ?
                VisibilityType.PUBLIC :VisibilityType.PRIVATE;
        String prompt = """
                Campaign is currently %s
                Would you like to change it to %s ?
                
                1 --- yes
                2 --- no
                0 --- exit
                """.formatted(c.getVisibility(), opposite);
        int choice = page.acceptIntUntil(prompt, 2);
        switch (choice) {
            case 2:
            case 0: return;
            case 1: c.setVisibility(opposite); break;
        }
    }
    /**
     * Archives a campaign.
     *
     * @param c The Campaign
     */
    private static void archiveCampaign(Campaign c){

        if (c.getArchived() == true){
            page.print("Sorry, this is already archived\n");
        } else{
            c.setArchived(true);
            page.print("Archived\n");
        }
    }
    /**
     * Shares a campaign with another user. Unimplemented
     *
     * @param user the user
     */
    private static void shareWithOther(User user){page.print("unimplemented\n");}
    /**
     * Opens UI to a QuestEvent for this campaign.
     *
     * @param c The Campaign
     */
    private static void addQuestEvent(Campaign c){
        QuestEvent qe = QuestEventUI.createQuestEvent(c);
        if (qe != null) c.addEvent(qe);
    }
    /**
     * Updates a QuestEvent within a given campaign.
     *
     * @param c The Campaign
     */
    private static void updateQuestEvent(Campaign c){
        page.nextScreen();
        QuestEventUI.updateQuestEvent(c);
    }
    /**
     * removes a questEvent from given campaign.
     *
     * @param c The Campaign
     */
    private static void removeQuestEvent(Campaign c){
        page.nextScreen();
        QuestEventUI.removeQuestEvent(c);
    }
    /**
     * View the name, owner, visibility, and questevents of a given campaign
     *
     * @param c The Campaign
     */
    public static void viewCampaign(Campaign c){
        String display = """
                Name: %s
                Owner: %s
                Visibility: %s
                QuestEvents:
                %s
                """.formatted(c.getName(),
                        c.getOwner().getUsername(),
                        c.getVisibility().toString(),
                        QuestEventUI.timelineString(c)
                );
        page.print(display);
    }
}
