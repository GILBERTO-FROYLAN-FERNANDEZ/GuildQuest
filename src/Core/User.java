package Core;

import java.util.*;
import java.util.stream.IntStream;

import ViewsAndTimelines.Page;
import RPGDomain.Character;

public class User {
    private final static Map<String, User> allUsers = new HashMap<>();

    private UUID userId;
    private String username;
    private List<Campaign> campaigns;
    private List<RPGDomain.Character> characters;
    private UserSettings settings;

    private static Page page = new Page();
    // add GUI stuff

    public static User createUser(String username){
        User user =  new User(username);
        allUsers.put(username, user);
        return user;
    }

    public void addCharacter(Character character){
        characters.add(character);
    }
    public void addCampaign(Campaign campaign){
        campaigns.add(campaign);
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public String getUsername(){
        return username;
    }
    public void removeCampaign(Campaign c){
        campaigns.remove(c);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    private User(String username){
        userId = UUID.randomUUID();
        this.username = username;

        campaigns = new ArrayList<>();
        characters = new ArrayList<>();

        settings = new UserSettings(null, null ,null);
    }


}
